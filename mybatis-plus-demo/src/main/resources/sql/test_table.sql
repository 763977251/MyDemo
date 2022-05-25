/*
MySQL Backup
Database: mybatis_plus_demo
Backup Time: 2022-05-25 08:50:55
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mybatis_plus_demo`.`test_table`;
CREATE TABLE `test_table` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除  0未删除  1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='测试表';
BEGIN;
LOCK TABLES `mybatis_plus_demo`.`test_table` WRITE;
DELETE FROM `mybatis_plus_demo`.`test_table`;
INSERT INTO `mybatis_plus_demo`.`test_table` (`id`,`code`,`name`,`create_time`,`is_deleted`) VALUES (1, '0', '234', NULL, 0),(2, '2', '23412', NULL, 0),(3, '3', '23412', NULL, 0),(4, '4', '122', NULL, 0),(5, '5', '234', NULL, 0),(6, '6', '2341', NULL, 0),(10, '1', '23412', NULL, 0);
UNLOCK TABLES;
COMMIT;
