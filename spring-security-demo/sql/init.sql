/*
MySQL Backup
Database: spring_security
Backup Time: 2021-10-29 09:26:12
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `spring_security`.`sys_permission`;
DROP TABLE IF EXISTS `spring_security`.`sys_request_path`;
DROP TABLE IF EXISTS `spring_security`.`sys_request_path_permission_relation`;
DROP TABLE IF EXISTS `spring_security`.`sys_role`;
DROP TABLE IF EXISTS `spring_security`.`sys_role_permission_relation`;
DROP TABLE IF EXISTS `spring_security`.`sys_user`;
DROP TABLE IF EXISTS `spring_security`.`sys_user_role_relation`;
CREATE TABLE `sys_permission` (
                                  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                  `permission_code` varchar(32) DEFAULT NULL COMMENT '权限code',
                                  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';
CREATE TABLE `sys_request_path` (
                                    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                    `url` varchar(64) NOT NULL COMMENT '请求路径',
                                    `description` varchar(128) DEFAULT NULL COMMENT '路径描述',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='请求路径';
CREATE TABLE `sys_request_path_permission_relation` (
                                                        `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                                        `url_id` int DEFAULT NULL COMMENT '请求路径id',
                                                        `permission_id` int DEFAULT NULL COMMENT '权限id',
                                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='路径权限关联表';
CREATE TABLE `sys_role` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
                            `role_description` varchar(64) DEFAULT NULL COMMENT '角色说明',
                            `role_code` varchar(16) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色表';
CREATE TABLE `sys_role_permission_relation` (
                                                `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                                `role_id` int DEFAULT NULL COMMENT '角色id',
                                                `permission_id` int DEFAULT NULL COMMENT '权限id',
                                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-权限关联关系表';
CREATE TABLE `sys_user` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `account` varchar(32) NOT NULL COMMENT '账号',
                            `user_name` varchar(32) NOT NULL COMMENT '用户名',
                            `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
                            `last_login_time` datetime DEFAULT NULL COMMENT '上一次登录时间',
                            `enabled` tinyint(1) DEFAULT '1' COMMENT '账号是否可用。默认为1（可用）',
                            `account_non_expired` tinyint(1) DEFAULT '1' COMMENT '是否过期。默认为1（没有过期）',
                            `account_non_locked` tinyint(1) DEFAULT '1' COMMENT '账号是否锁定。默认为1（没有锁定）',
                            `credentials_non_expired` tinyint(1) DEFAULT '1' COMMENT '证书（密码）是否过期。默认为1（没有过期）',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `create_user` int DEFAULT NULL COMMENT '创建人',
                            `update_user` int DEFAULT NULL COMMENT '修改人',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
CREATE TABLE `sys_user_role_relation` (
                                          `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                          `user_id` int DEFAULT NULL COMMENT '用户id',
                                          `role_id` int DEFAULT NULL COMMENT '角色id',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关联关系表';
BEGIN;
LOCK TABLES `spring_security`.`sys_permission` WRITE;
DELETE FROM `spring_security`.`sys_permission`;
INSERT INTO `spring_security`.`sys_permission` (`id`,`permission_code`,`permission_name`) VALUES (1, 'create_user', '创建用户'),(2, 'query_user', '查看用户'),(3, 'delete_user', '删除用户'),(4, 'modify_user', '修改用户');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_request_path` WRITE;
DELETE FROM `spring_security`.`sys_request_path`;
INSERT INTO `spring_security`.`sys_request_path` (`id`,`url`,`description`) VALUES (1, '/getUser', '查询用户');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_request_path_permission_relation` WRITE;
DELETE FROM `spring_security`.`sys_request_path_permission_relation`;
INSERT INTO `spring_security`.`sys_request_path_permission_relation` (`id`,`url_id`,`permission_id`) VALUES (1, 1, 2);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_role` WRITE;
DELETE FROM `spring_security`.`sys_role`;
INSERT INTO `spring_security`.`sys_role` (`id`,`role_name`,`role_description`,`role_code`) VALUES (1, '管理员', '管理员，拥有所有权限', 'admin'),(2, '普通用户', '普通用户，拥有部分权限', 'user');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_role_permission_relation` WRITE;
DELETE FROM `spring_security`.`sys_role_permission_relation`;
INSERT INTO `spring_security`.`sys_role_permission_relation` (`id`,`role_id`,`permission_id`) VALUES (1, 1, 1),(2, 1, 2),(3, 1, 3),(4, 1, 4),(5, 2, 1),(6, 2, 2);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_user` WRITE;
DELETE FROM `spring_security`.`sys_user`;
INSERT INTO `spring_security`.`sys_user` (`id`,`account`,`user_name`,`password`,`last_login_time`,`enabled`,`account_non_expired`,`account_non_locked`,`credentials_non_expired`,`create_time`,`update_time`,`create_user`,`update_user`) VALUES (1, 'user1', '用户1', '$2a$10$47lsFAUlWixWG17Ca3M/r.EPJVIb7Tv26ZaxhzqN65nXVcAhHQM4i', '2019-09-04 20:25:36', 1, 1, 1, 1, '2019-08-29 06:28:36', '2019-09-04 20:25:36', 1, 1),(2, 'user2', '用户2', '$2a$10$uSLAeON6HWrPbPCtyqPRj.hvZfeM.tiVDZm24/gRqm4opVze1cVvC', '2019-09-05 00:07:12', 1, 1, 1, 1, '2019-08-29 06:29:24', '2019-09-05 00:07:12', 1, 2);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `spring_security`.`sys_user_role_relation` WRITE;
DELETE FROM `spring_security`.`sys_user_role_relation`;
INSERT INTO `spring_security`.`sys_user_role_relation` (`id`,`user_id`,`role_id`) VALUES (1, 1, 1),(2, 2, 2);
UNLOCK TABLES;
COMMIT;
