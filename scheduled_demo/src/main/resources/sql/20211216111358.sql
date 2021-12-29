/*
MySQL Backup
Database: scheduled_demo
Backup Time: 2021-12-16 11:13:58
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `shedlock`;
CREATE TABLE `shedlock` (
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lock_until` timestamp(3) NULL DEFAULT NULL,
  `locked_at` timestamp(3) NULL DEFAULT NULL,
  `locked_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='shedlock分布式定时任务表';
BEGIN;
LOCK TABLES `shedlock` WRITE;
DELETE FROM `shedlock`;
UNLOCK TABLES;
COMMIT;
