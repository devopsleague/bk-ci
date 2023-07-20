<!-- BEGIN MUNGE: GENERATED_TOC -->
- [v2.0.0-beta.21](#v200-beta21)
   - [Changelog since v2.0.0-beta.20](#changelog-since-v200-beta20)

<!-- END MUNGE: GENERATED_TOC -->



<!-- NEW RELEASE NOTES ENTRY -->
# v2.0.0-beta.21
## Changelog since v2.0.0-beta.20
#### 新增
- [新增] 部署时默认不再部署插件 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9154)
- [新增] store文本溢出、空状态规范落地 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8774)
- [新增] dispatch消息重复消费时的幂等兼容 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9146)
- [新增] ci套餐 出包bug修复 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9115)
- [新增] 优化第三方构建机Docker启动脚本 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9133)
- [新增] 包含动态跳过插件任务的Job的调度逻辑优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9101)
- [新增] 优化GIT PUSH事件触发判定逻辑 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8978)

#### 优化
- [优化] 蓝盾国际化信息补充及优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9074)
- [优化] 模板编辑页针对大模板校验提速 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9118)
- [优化] 拉取插件包时制品库网关增加缓存 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9111)

#### 修复
- [修复] rbac问题修复 [链接](http://github.com/TencentBlueKing/bk-ci/issues/8975)
- [修复] svn保存代码库校验用户名密码接口调用错误 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9132)
- [修复] 人工审核插件刷新变量替换推送问题 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9129)
- [修复] 权限迁移子流水线跨项目调用优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9086)
- [修复] 权限迁移策略对比查询流水线优化 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9130)
- [修复] 流水线组A的执行者,查看组A下流水线的日志提示无权限 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9122)
- [修复] 修复日志状态同时写入状态出现的死锁问题 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9102)
- [修复] 重试流水线后回写git的MR评论没有更新 [链接](http://github.com/TencentBlueKing/bk-ci/issues/9073)
