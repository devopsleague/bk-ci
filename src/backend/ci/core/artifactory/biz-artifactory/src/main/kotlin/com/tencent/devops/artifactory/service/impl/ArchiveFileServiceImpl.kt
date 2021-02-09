/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.devops.artifactory.service.impl

import com.tencent.devops.artifactory.dao.FileDao
import com.tencent.devops.artifactory.pojo.enums.FileChannelTypeEnum
import com.tencent.devops.artifactory.pojo.enums.FileTypeEnum
import com.tencent.devops.artifactory.service.ArchiveFileService
import com.tencent.devops.artifactory.util.DefaultPathUtils
import com.tencent.devops.common.auth.api.AuthPermission
import com.tencent.devops.common.auth.api.AuthPermissionApi
import com.tencent.devops.common.auth.api.AuthResourceType
import com.tencent.devops.common.auth.code.PipelineAuthServiceCode
import com.tencent.devops.common.client.Client
import com.tencent.devops.common.service.config.CommonConfig
import com.tencent.devops.process.api.service.ServicePipelineResource
import org.glassfish.jersey.media.multipart.FormDataContentDisposition
import org.jooq.DSLContext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.io.InputStream
import java.net.URLDecoder
import java.nio.charset.Charset

abstract class ArchiveFileServiceImpl : ArchiveFileService {

    @Autowired
    lateinit var fileDao: FileDao

    @Autowired
    lateinit var pipelineAuthServiceCode: PipelineAuthServiceCode

    @Autowired
    lateinit var authPermissionApi: AuthPermissionApi

    @Autowired
    lateinit var commonConfig: CommonConfig

    @Autowired
    lateinit var client: Client

    @Autowired
    lateinit var dslContext: DSLContext

    protected val fileSeparator: String = System.getProperty("file.separator")

    override fun uploadFile(
        userId: String,
        inputStream: InputStream,
        disposition: FormDataContentDisposition,
        projectId: String?,
        filePath: String?,
        fileType: FileTypeEnum?,
        props: Map<String, String?>?,
        fileChannelType: FileChannelTypeEnum
    ): String {
        logger.info("uploadFile, userId: $userId, projectId: $projectId, filePath: $filePath, fileType: $fileType, props: $props, fileChannelType: $fileChannelType")
        logger.info("the upload file info is:$disposition")
        val fileName = String(disposition.fileName.toByteArray(Charset.forName("ISO8859-1")), Charset.forName("UTF-8"))
        val file = DefaultPathUtils.randomFile(fileName)
        file.outputStream().use { inputStream.copyTo(it) }
        return try {
            uploadFile(
                userId = userId,
                projectId = projectId,
                file = file,
                filePath = filePath,
                fileName = fileName,
                fileType = fileType,
                props = props,
                fileChannelType = fileChannelType
            )
        } finally {
            file.delete()
        }
    }

    override fun archiveFile(
        userId: String,
        projectId: String,
        pipelineId: String,
        buildId: String,
        fileType: FileTypeEnum,
        customFilePath: String?,
        inputStream: InputStream,
        disposition: FormDataContentDisposition,
        fileChannelType: FileChannelTypeEnum
    ): String {
        logger.info("archiveFile, userId: $userId, projectId: $projectId, pipelineId: $pipelineId, buildId: $buildId, fileType: $fileType, customFilePath: $customFilePath, fileChannelType: $fileChannelType")
        val path = generateDestPath(fileType, projectId, customFilePath, pipelineId, buildId)
        val destPath = path + fileSeparator + disposition.fileName
        val pipelineName = client.get(ServicePipelineResource::class).getPipelineNameByIds(projectId, setOf(pipelineId)).data!![pipelineId] ?: ""
        val buildNum = client.get(ServicePipelineResource::class).getBuildNoByBuildIds(setOf(buildId)).data!![buildId] ?: ""
        val props: Map<String, String?>? = mapOf(
            "pipelineId" to pipelineId,
            "pipelineName" to pipelineName,
            "buildId" to buildId,
            "buildNum" to buildNum
        )
        return uploadFile(
            userId = userId,
            projectId = projectId,
            inputStream = inputStream,
            disposition = disposition,
            filePath = destPath,
            fileType = fileType,
            props = props,
            fileChannelType = fileChannelType
        )
    }

    override fun validateUserDownloadFilePermission(userId: String, filePath: String): Boolean {
        logger.info("validateUserDownloadFilePermission, userId: =$userId, filePath: $filePath")
        val realFilePath = URLDecoder.decode(filePath, "UTF-8")
        val realFilePathParts = realFilePath.split(fileSeparator)
        // 兼容用户路径里面带多个/的情况，先把路径里的文件类型、项目代码和流水线ID放到集合里
        var num = 0
        val dataList = mutableListOf<String>()
        realFilePathParts.forEach {
            if (num == 3) {
                return@forEach
            }
            if (it.isNotBlank()) {
                dataList.add(it)
                num++
            }
        }
        logger.info("validateUserDownloadFilePermission|userId=$userId|filePath=$filePath|realFilePathParts=$realFilePathParts")
        val fileType = dataList[0]
        var flag = true
        val validateFileTypeList = listOf(
            FileTypeEnum.BK_CUSTOM.fileType,
            FileTypeEnum.BK_ARCHIVE.fileType,
            FileTypeEnum.BK_REPORT.fileType
        )
        // 校验用户是否有下载流水线文件的权限
        if (validateFileTypeList.contains(fileType)) {
            flag = authPermissionApi.validateUserResourcePermission(
                user = userId,
                serviceCode = pipelineAuthServiceCode,
                resourceType = AuthResourceType.PIPELINE_DEFAULT,
                projectCode = dataList[1],
                resourceCode = dataList[2],
                permission = AuthPermission.DOWNLOAD
            )
        }
        logger.info("validateUserDownloadFilePermission, result: $flag")
        return flag
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ArchiveFileServiceImpl::class.java)
    }
}
