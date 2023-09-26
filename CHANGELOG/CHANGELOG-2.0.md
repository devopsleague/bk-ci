<!-- BEGIN MUNGE: GENERATED_TOC -->
- [v2.0.0-beta.35](#v200-beta35)
   - [Changelog since v2.0.0-beta.34](#changelog-since-v200-beta34)

- [v2.0.0-beta.28](#v200-beta28)
   - [Changelog since v2.0.0-beta.27](#changelog-since-v200-beta27)

<!-- END MUNGE: GENERATED_TOC -->



<!-- NEW RELEASE NOTES ENTRY -->
# v2.0.0-beta.35
## Changelog since v2.0.0-beta.34
#### 新增
- [新增] 新增tencent Git Oauth 授权模式 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8845)
- [新增] 完善权限申请单内容 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9394)
- [新增] 权限入口优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9390)
- [新增] 项目下的内置用户组，除了管理员组，其他组可删除 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9389)
- [新增] 迁移新版权限中心优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9306)
- [新增] 修复macos的jdk [链接](http://github.com/TencentBlueKing/bk-ci/issues/9362)
- [新增] 人工审核插件支持审核提醒 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8998)
- [新增] 屏蔽公共构建机登录调试入口 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9349)
- [新增] TGit 触发器功能对齐内网工蜂 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9215)
- [新增] Github 代码库支持获取gitProjectId [链接](http://github.com/TencentBlueKing/bk-ci/issues/9329)
- [新增] JOOQ监听器检测SQL [链接](http://github.com/TencentBlueKing/bk-ci/issues/9015)
- [新增] 对接RBAC权限优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9149)
- [新增] doc：独立部署蓝盾指引文档 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9235)
- [新增] [OP需求]项目设置支持配置云研发管理员列表 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9324)
- [新增] 每天定时生成Gradle缓存 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9319)
- [新增] 国密处理一期 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9262)
- [新增] 蓝盾国际化优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8975)
- [新增] github支持读取私有仓库文件内容 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9218)
- [新增] 插件国际化问题优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9274)
- [新增] build_msg需要根据事件触发场景细化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8831)
- [新增] 插件日志规范 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9022)

#### 优化
- [优化] metrics部分接口性能优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9147)
- [优化] 研发商店工作台插件管理优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9359)
- [优化] 创建项目时支持设置把该项目的数据落到指定DB TencentBlueKing [链接](http://github.com/TencentBlueKing/bk-ci/issues/9140)
- [优化] 插件环境信息查询接口性能优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9322)
- [优化] 优化研发商店可信指标管理 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9204)
- [优化] 插件统计数据来源切换至从metrics获取 TencentBlueKing [链接](http://github.com/TencentBlueKing/bk-ci/issues/9281)
- [优化] 删除私有构建集群 Agent多余描述 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9209)

#### 修复
- [修复] 获取红线拦截记录接口漏掉了拦截列表的数据 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9405)
- [修复] 修复权限迁移bug [链接](http://github.com/TencentBlueKing/bk-ci/issues/9400)
- [修复] 选择插件历史版本修复升级后再取消版本校验优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9380)
- [修复] 构建触发待审核长时间占用QUEUE_COUNT [链接](http://github.com/TencentBlueKing/bk-ci/issues/8275)
- [修复] 蓝盾v2.0.0问题修复 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9343)
- [修复] 权限事务一致性优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9290)
- [修复] 模板实例化携带设置时参数不全 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9331)
- [修复] 开源版插件包重新上传时也需重新解析国际化信息 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9326)
- [修复] 构建详情页接口返回数据过滤调了插件值为空字符串的参数 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9315)
- [修复] 插件入参在开启PAC后支持凭据替换 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9310)
- [修复] 归档报告时，pdf类型的入口文件无法显示 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9250)
- [修复] 定时触发插件触发异常 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9237)
- [修复] 流水线buildMsg信息保存失败 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9213)
# v2.0.0-beta.28
## Changelog since v2.0.0-beta.27
#### 新增
- [新增] 蓝盾国际化优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8975)
- [新增] 使用v4_app_pipeline_upload和v4_app_pipeline_copy接口时，部分设置参数缺失 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9308)

#### 优化
- [优化] 优化标签组/标签重名时的报错提示 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9312)
