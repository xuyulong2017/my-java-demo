# spring-boot-shiro-demo

#### 项目介绍:
SpringBoot整合Shiro示例实现动态权限加载更新+Session共享+单点登录(数据库中测试号的密码进行了加密,密码皆为123456)


相关文章请移步到:https://juejin.im/post/5d087d605188256de9779e64

MyBatis-Plus版本: 3.1.0

SpringBoot版本:2.1.5

JDK版本:1.8

Shiro版本:1.4

Shiro-redis插件版本:3.1.0

#### 数据结构(SQL脚本在项目中):
表结构:
``` sql
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `sys_role` (
  `role_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐值',
  `state` varchar(50) DEFAULT NULL COMMENT '状态:NORMAL正常  PROHIBIT禁用',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

CREATE TABLE `sys_role_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色与权限关系表';

CREATE TABLE `sys_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户与角色关系表';
```
表数据:
``` sql
INSERT INTO `sys_user` VALUES (1, 'admin', 'a1bb09ad5dea12e0f94762cb116c447e80c784d8aa2c6625263f7f3436cdd583', 'RvP3UID2n30Q2sycZYvH', 'NORMAL');
INSERT INTO `sys_user` VALUES (2, 'user', '376eb5d2698c804ee83594fe8b0217f03ad138a046f7fa42b44c232c2e5e2b38', 'OVlrD37bDUKNcFRB10qG', 'NORMAL');
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
INSERT INTO `sys_menu` VALUES (1, '查看用户列表', 'sys:user:info');
INSERT INTO `sys_menu` VALUES (2, '查看角色列表', 'sys:role:info');
INSERT INTO `sys_menu` VALUES (3, '查看权限列表', 'sys:menu:info');
INSERT INTO `sys_menu` VALUES (4, '查看所有数据', 'sys:info:all');
INSERT INTO `sys_role` VALUES (1, 'ADMIN');
INSERT INTO `sys_role` VALUES (2, 'USER');
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 3);
INSERT INTO `sys_role_menu` VALUES (4, 2, 1);
```
