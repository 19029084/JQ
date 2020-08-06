/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : JQ

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 28/07/2020 02:53:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

drop database IF EXISTS JQ;

create database IF NOT EXISTS JQ;

USE JQ;

-- ----------------------------
-- Table structure for Config
-- ----------------------------
DROP TABLE IF EXISTS `Config`;
CREATE TABLE `Config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ParentID` int(11) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for ConfigWidget
-- ----------------------------
DROP TABLE IF EXISTS `ConfigWidget`;
CREATE TABLE `ConfigWidget` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ConfigID` int(11) NOT NULL,
  `WidgetID` int(11) NOT NULL,
  `SortKey` int(11) NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=477 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for Employee
-- ----------------------------
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPID` varchar(255) NOT NULL,
  `EMPNAME` varchar(255) NOT NULL,
  `ENABLE` tinyint(1) DEFAULT NULL,
  `VALID` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for Module
-- ----------------------------
DROP TABLE IF EXISTS `Module`;
CREATE TABLE `Module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PARENTID` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `URLID` int(11) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  `ICON` varchar(255) DEFAULT NULL,
  `SortKey` varchar(16) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for ModuleConfig
-- ----------------------------
DROP TABLE IF EXISTS `ModuleConfig`;
CREATE TABLE `ModuleConfig` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PropertyID` int(11) NOT NULL,
  `ConfigID` int(11) NOT NULL,
  `ModuleID` int(11) NOT NULL,
  `SortKey` int(11) NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for ModuleData
-- ----------------------------
DROP TABLE IF EXISTS `ModuleData`;
CREATE TABLE `ModuleData` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FieldID` int(11) NOT NULL,
  `PropertyID` int(11) NOT NULL,
  `RowId` int(11) NOT NULL,
  `ParentId` int(11) NOT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Population
-- ----------------------------
DROP TABLE IF EXISTS `Population`;
CREATE TABLE `Population` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for Property
-- ----------------------------
DROP TABLE IF EXISTS `Property`;
CREATE TABLE `Property` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `type_id` varchar(255) NOT NULL,
  `VALUE` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `SortKey` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for PropertyOption
-- ----------------------------
DROP TABLE IF EXISTS `PropertyOption`;
CREATE TABLE `PropertyOption` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PropertyId` int(11) NOT NULL,
  `ParentId` int(11) NOT NULL,
  `VALUE` varchar(255) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `SortKey` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for PropertyType
-- ----------------------------
DROP TABLE IF EXISTS `PropertyType`;
CREATE TABLE `PropertyType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `valid` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for Role
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `ROLES` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url_id` varchar(200) NOT NULL,
  `parentid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_url`;
CREATE TABLE `sys_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_url_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_url_permission`;
CREATE TABLE `sys_url_permission` (
  `id` int(11) DEFAULT NULL,
  `url_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `dept_code` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `user_id` int(11) DEFAULT NULL,
     `role_id` int(11) DEFAULT NULL,
     PRIMARY KEY (`id`),
     UNIQUE KEY `sys_user_role_id_uindex` (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user`(id,username,password,nickname) VALUES (1, 'admin', '$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuK', 'admin');
insert into sys_role(id,name) values (1, 'ROLE_ADMIN');
insert into sys_role(id,name) values (2, 'ROLE_USER');
insert into sys_user_role(id,user_id,role_id) values (1, 1, 1);
insert into sys_role_permission(role_id,permission_id) values(1,43);
insert into sys_role_permission(role_id,permission_id) values(1,44);
insert into sys_role_permission(role_id,permission_id) values(1,45);
insert into sys_role_permission(role_id,permission_id) values(1,46);
insert into sys_role_permission(role_id,permission_id) values(1,47);
insert into sys_role_permission(role_id,permission_id) values(1,48);
insert into sys_role_permission(role_id,permission_id) values(1,49);
insert into sys_role_permission(role_id,permission_id) values(1,50);
insert into sys_role_permission(role_id,permission_id) values(1,59);
insert into sys_role_permission(role_id,permission_id) values(1,60);
insert into sys_role_permission(role_id,permission_id) values(1,61);
insert into sys_role_permission(role_id,permission_id) values(1,62);
insert into sys_role_permission(role_id,permission_id) values(1,69);
insert into sys_role_permission(role_id,permission_id) values(1,70);
insert into sys_role_permission(role_id,permission_id) values(1,71);
insert into sys_role_permission(role_id,permission_id) values(1,72);
insert into sys_role_permission(role_id,permission_id) values(1,73);
COMMIT;

-- ----------------------------
-- Table structure for WhiteList
-- ----------------------------
DROP TABLE IF EXISTS `WhiteList`;
CREATE TABLE `WhiteList` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(255) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for Widget
-- ----------------------------
DROP TABLE IF EXISTS `Widget`;
CREATE TABLE `Widget` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `ParentID` int(11) DEFAULT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `ConfigID` int(11) DEFAULT NULL,
  `WidgetID` int(11) DEFAULT NULL,
  `PropertyID` int(11) DEFAULT NULL,
  `Required` tinyint(1) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `Searchable` tinyint(1) NOT NULL,
  `Shareable` tinyint(1) NOT NULL,
  `DataSource` int(11) NOT NULL,
  `Value` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for WidgetProperty
-- ----------------------------
DROP TABLE IF EXISTS `WidgetProperty`;
CREATE TABLE `WidgetProperty` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `WidgetID` int(11) DEFAULT NULL,
  `PropertyID` int(11) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
