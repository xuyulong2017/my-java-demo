# spring-boot-mp-demo

#### 项目介绍
SpringBoot整合MyBatis-Plus3.1示例

相关文章请移步到:https://juejin.im/post/5cfa6e465188254ee433bc69

MyBatis-Plus版本: 3.1.0

SpringBoot版本:2.1.5

JDK版本:1.8

#### 表结构
``` sql
CREATE TABLE `user_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `skill` varchar(32) DEFAULT NULL COMMENT '技能',
  `evaluate` varchar(64) DEFAULT NULL COMMENT '评价',
  `fraction` bigint(11) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';
``` 


#### 表数据
``` sql
INSERT INTO `user_info` VALUES (1, '小明', 20, '画画', '该学生在画画方面有一定天赋', 89);
INSERT INTO `user_info` VALUES (2, '小兰', 19, '游戏', '近期该学生由于游戏的原因导致分数降低了', 64);
INSERT INTO `user_info` VALUES (3, '张张', 18, '英语', '近期该学生参加英语比赛获得二等奖', 90);
INSERT INTO `user_info` VALUES (4, '大黄', 20, '体育', '该学生近期由于参加篮球比赛,导致脚伤', 76);
INSERT INTO `user_info` VALUES (5, '大白', 17, '绘画', '该学生参加美术大赛获得三等奖', 77);
INSERT INTO `user_info` VALUES (7, '小龙', 18, 'JAVA', '该学生是一个在改BUG的码农', 59);
INSERT INTO `user_info` VALUES (9, 'Sans', 18, '睡觉', 'Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子', 60);
INSERT INTO `user_info` VALUES (10, 'papyrus', 18, 'JAVA', 'Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子', 58);
INSERT INTO `user_info` VALUES (11, '删除数据1', 3, '画肖像', NULL, 61);
INSERT INTO `user_info` VALUES (12, '删除数据2', 3, NULL, NULL, 61);
INSERT INTO `user_info` VALUES (13, '删除数据3', 3, NULL, NULL, 61);
INSERT INTO `user_info` VALUES (14, '删除数据4', 5, '删除', NULL, 10);
INSERT INTO `user_info` VALUES (15, '删除数据5', 6, '删除', NULL, 10);
``` 






