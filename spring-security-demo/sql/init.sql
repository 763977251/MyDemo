/*
Navicat MySQL Data Transfer

Source Server : localhost_admin@admin
Source Server Version : 50725
Source Host : localhost:3306
Source Database : spring_security

Target Server Type : MYSQL
Target Server Version : 50725
File Encoding : 65001

*/

SET
FOREIGN_KEY_CHECKS=0;

-- Table structure for sys_permission

DROP TABLE IF EXISTS sys_permission;
CREATE TABLE sys_permission
(
    id              int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    permission_code varchar(32) DEFAULT NULL COMMENT '权限code',
    permission_name varchar(32) DEFAULT NULL COMMENT '权限名',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- Records of sys_permission

INSERT INTO sys_permission
VALUES ('1', 'create_user', '创建用户');
INSERT INTO sys_permission
VALUES ('2', 'query_user', '查看用户');
INSERT INTO sys_permission
VALUES ('3', 'delete_user', '删除用户');
INSERT INTO sys_permission
VALUES ('4', 'modify_user', '修改用户');

-- Table structure for sys_request_path

DROP TABLE IF EXISTS sys_request_path;
CREATE TABLE sys_request_path
(
    id          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    url         varchar(64) NOT NULL COMMENT '请求路径',
    description varchar(128) DEFAULT NULL COMMENT '路径描述',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='请求路径';

-- Records of sys_request_path

INSERT INTO sys_request_path
VALUES ('1', '/getUser', '查询用户');

-- Table structure for sys_request_path_permission_relation

DROP TABLE IF EXISTS sys_request_path_permission_relation;
CREATE TABLE sys_request_path_permission_relation
(
    id            int(11) DEFAULT NULL COMMENT '主键id',
    url_id        int(11) DEFAULT NULL COMMENT '请求路径id',
    permission_id int(11) DEFAULT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='路径权限关联表';

-- Records of sys_request_path_permission_relation

INSERT INTO sys_request_path_permission_relation
VALUES (null, '1', '2');

-- Table structure for sys_role

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id               int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    role_name        varchar(32) DEFAULT NULL COMMENT '角色名',
    role_description varchar(64) DEFAULT NULL COMMENT '角色说明',
    role_code        varchar(16) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

-- Records of sys_role

INSERT INTO sys_role
VALUES ('1', '管理员', '管理员，拥有所有权限', 'admin');
INSERT INTO sys_role
VALUES ('2', '普通用户', '普通用户，拥有部分权限', 'user');

-- Table structure for sys_role_permission_relation

DROP TABLE IF EXISTS sys_role_permission_relation;
CREATE TABLE sys_role_permission_relation
(
    id            int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    role_id       int(11) DEFAULT NULL COMMENT '角色id',
    permission_id int(11) DEFAULT NULL COMMENT '权限id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='角色-权限关联关系表';

-- Records of sys_role_permission_relation

INSERT INTO sys_role_permission_relation
VALUES ('1', '1', '1');
INSERT INTO sys_role_permission_relation
VALUES ('2', '1', '2');
INSERT INTO sys_role_permission_relation
VALUES ('3', '1', '3');
INSERT INTO sys_role_permission_relation
VALUES ('4', '1', '4');
INSERT INTO sys_role_permission_relation
VALUES ('5', '2', '1');
INSERT INTO sys_role_permission_relation
VALUES ('6', '2', '2');

-- Table structure for sys_user

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id                      int(11) NOT NULL AUTO_INCREMENT,
    account                 varchar(32) NOT NULL COMMENT '账号',
    user_name               varchar(32) NOT NULL COMMENT '用户名',
    password                varchar(64) DEFAULT NULL COMMENT '用户密码',
    last_login_time         datetime    DEFAULT NULL COMMENT '上一次登录时间',
    enabled                 tinyint(1) DEFAULT '1' COMMENT '账号是否可用。默认为1（可用）',
    account_non_expired     tinyint(1) DEFAULT '1' COMMENT '是否过期。默认为1（没有过期）',
    account_non_locked      tinyint(1) DEFAULT '1' COMMENT '账号是否锁定。默认为1（没有锁定）',
    credentials_non_expired tinyint(1) DEFAULT '1' COMMENT '证书（密码）是否过期。默认为1（没有过期）',
    create_time             datetime    DEFAULT NULL COMMENT '创建时间',
    update_time             datetime    DEFAULT NULL COMMENT '修改时间',
    create_user             int(11) DEFAULT NULL COMMENT '创建人',
    update_user             int(11) DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- Records of sys_user

INSERT INTO sys_user
VALUES ('1', 'user1', '用户1', '$2a$10$47lsFAUlWixWG17Ca3M/r.EPJVIb7Tv26ZaxhzqN65nXVcAhHQM4i', '2019-09-04 20:25:36', '1',
        '1', '1', '1', '2019-08-29 06:28:36', '2019-09-04 20:25:36', '1', '1');
INSERT INTO sys_user
VALUES ('2', 'user2', '用户2', '$2a$10$uSLAeON6HWrPbPCtyqPRj.hvZfeM.tiVDZm24/gRqm4opVze1cVvC', '2019-09-05 00:07:12', '1',
        '1', '1', '1', '2019-08-29 06:29:24', '2019-09-05 00:07:12', '1', '2');

-- Table structure for sys_user_role_relation

DROP TABLE IF EXISTS sys_user_role_relation;
CREATE TABLE sys_user_role_relation
(
    id      int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    user_id int(11) DEFAULT NULL COMMENT '用户id',
    role_id int(11) DEFAULT NULL COMMENT '角色id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联关系表';

-- Records of sys_user_role_relation

INSERT INTO sys_user_role_relation
VALUES ('1', '1', '1');
INSERT INTO sys_user_role_relation
VALUES ('2', '2', '2');