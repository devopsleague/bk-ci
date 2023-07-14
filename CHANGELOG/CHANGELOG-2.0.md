<!-- BEGIN MUNGE: GENERATED_TOC -->
- [v2.0.0-beta.20](#v200-beta20)
   - [Changelog since v2.0.0-beta.19](#changelog-since-v200-beta19)

<!-- END MUNGE: GENERATED_TOC -->



<!-- NEW RELEASE NOTES ENTRY -->
# v2.0.0-beta.20
## Changelog since v2.0.0-beta.19
#### 新增
- [新增] 蓝盾国际化优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8975)
- [新增] 第三方构建机容器化环境支持登录调试 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8915)
- [新增] 蓝盾对接审计中心回调接口 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9068)
- [新增] 网关强制路由区分codecc [链接](http://github.com/TencentBlueKing/bk-ci/issues/9081)
- [新增] 新增arm64的JDK [链接](http://github.com/TencentBlueKing/bk-ci/issues/9063)
- [新增] bitnami的influxdb-relay修复 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9060)
- [新增] 支持开通蓝盾项目权限的同时开通对应的监控空间权限 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8935)
- [新增] 构建详情页问题优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8955)
- [新增] 支持global.imageRegistry [链接](http://github.com/TencentBlueKing/bk-ci/issues/9049)
- [新增] 日志每1GB就切割 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9048)
- [新增] 蓝盾对接权限中心RBAC优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8941)
- [新增] Rbac权限中心对接codecc迁移接口 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9001)
- [新增] websocket支持desktop路径 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9035)
- [新增] 去除agent对bktag变量依赖 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9024)
- [新增] github插件下载加速 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8938)
- [新增] 优化GIT PUSH事件触发判定逻辑 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8978)
- [新增] Goagent新增下线能力 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8893)

#### 优化
- [优化] monitoring服务的查询插件监控统计数据接口性能优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9059)
- [优化] 蓝盾国际化信息优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8982)

#### 修复
- [修复] 权限迁移子流水线跨项目调用优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9086)
- [修复] linux操作系统cpu架构为aarch64应该使用arm64的node包执行node插件 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9070)
- [修复] 权限迁移策略对比优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9066)
- [修复] 【蓝盾新版权限】取消权限申请后，申请其他操作权限跳转页面筛选选择的用户组会一直复用上一次的 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9077)
- [修复] metrics平均耗时统计错误 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8971)
- [修复] 当stage配置了fastkill时取消后第二次重试后构建可能异常 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9053)
- [修复] 关联代码库，添加一个仓库接口报错后页面一直出来loading状态 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9046)
