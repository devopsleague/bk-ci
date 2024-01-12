package com.tencent.devops.auth.api.service

import com.tencent.devops.common.api.auth.AUTH_HEADER_DEVOPS_BK_TOKEN
import com.tencent.devops.common.api.auth.AUTH_HEADER_USER_ID
import com.tencent.devops.common.api.pojo.Result
import com.tencent.devops.common.auth.api.AuthResourceType
import com.tencent.devops.common.auth.api.pojo.BkAuthGroup
import com.tencent.devops.common.auth.api.pojo.BkAuthGroupAndUserList
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.HeaderParam
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Tag(name = "AUTH_SERVICE_RESOURCE", description = "权限--资源相关接口")
@Path("/open/service/auth/resource/member")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface ServiceResourceMemberResource {

    /**
     * @param resourceType 是个枚举类型详见 AuthResourceType
     * @see AuthResourceType
     */
    @GET
    @Path("/{projectCode}/getResourceGroupUsers")
    @Operation(summary = "获取特定资源下用户组成员")
    fun getResourceGroupMembers(
        @HeaderParam(AUTH_HEADER_DEVOPS_BK_TOKEN)
        @Parameter(description = "认证token", required = true)
        token: String,
        @PathParam("projectCode")
        @Parameter(description = "项目Code", required = true)
        projectCode: String,
        @QueryParam("resourceType")
        @Parameter(description = "资源类型", required = false)
        resourceType: String,
        @QueryParam("resourceCode")
        @Parameter(description = "资源code", required = false)
        resourceCode: String,
        @QueryParam("group")
        @Parameter(description = "资源用户组类型", required = false)
        group: BkAuthGroup? = null
    ): Result<List<String>>

    @GET
    @Path("/{projectCode}/getResourceUsers")
    @Operation(summary = "拉取资源下所有成员，并按项目角色组分组成员信息返回")
    fun getResourceGroupAndMembers(
        @HeaderParam(AUTH_HEADER_DEVOPS_BK_TOKEN)
        @Parameter(description = "认证token", required = true)
        token: String,
        @PathParam("projectCode")
        @Parameter(description = "项目Code", required = true)
        projectCode: String,
        @QueryParam("resourceType")
        @Parameter(description = "资源类型", required = false)
        resourceType: String,
        @QueryParam("resourceCode")
        @Parameter(description = "资源code", required = false)
        resourceCode: String
    ): Result<List<BkAuthGroupAndUserList>>

    @POST
    @Path("/{projectCode}/batchAddResourceGroupMembers/{groupId}")
    @Operation(summary = "根据组ID往项目下加人")
    fun batchAddResourceGroupMembers(
        @HeaderParam(AUTH_HEADER_DEVOPS_BK_TOKEN)
        @Parameter(description = "认证token", required = true)
        token: String,
        @Parameter(description = "用户名", required = true)
        @HeaderParam(AUTH_HEADER_USER_ID)
        userId: String,
        @PathParam("projectCode")
        @Parameter(description = "项目Code", required = true)
        projectCode: String,
        @Parameter(description = "用户组IO", required = true)
        @PathParam("groupId")
        groupId: Int,
        @Parameter(description = "添加用户集合", required = true)
        members: List<String>
    ): Result<Boolean>
}
