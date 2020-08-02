-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: JQ
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `JQ`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `JQ` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `JQ`;

--
-- Table structure for table `Config`
--

DROP TABLE IF EXISTS `Config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Config` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ParentID` int DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Config`
--

LOCK TABLES `Config` WRITE;
/*!40000 ALTER TABLE `Config` DISABLE KEYS */;
INSERT INTO `Config` VALUES (39,0,'名人信息',NULL,1),(40,0,'模板配置',NULL,1),(41,0,'3b7b05c4-db17-4436-b2a9-de6bedb1f1f1',NULL,1),(42,0,'17869d11-b9db-4784-a0e0-5c97ad5d1e92',NULL,1),(43,0,'e3e7c76b-7e20-4c4f-8002-e5a94a8293c5',NULL,1),(44,0,'数据项配置',NULL,1),(45,0,'字典配置',NULL,1),(46,0,'895ca419-e895-4691-8a95-db1d0d05c206',NULL,1),(47,0,'4073eea7-b842-4181-b63d-a6d762f3f216',NULL,1),(48,0,'菜单配置',NULL,1),(49,0,'子菜单配置',NULL,1),(50,0,'a68eaa1f-ab91-4cde-ab55-15b5a118ac90',NULL,1),(51,0,'1018f30c-6072-4fe2-b6c8-84d23d0c18a8',NULL,1);
/*!40000 ALTER TABLE `Config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ConfigWidget`
--

DROP TABLE IF EXISTS `ConfigWidget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ConfigWidget` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ConfigID` int NOT NULL,
  `WidgetID` int NOT NULL,
  `SortKey` int NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=567 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ConfigWidget`
--

LOCK TABLES `ConfigWidget` WRITE;
/*!40000 ALTER TABLE `ConfigWidget` DISABLE KEYS */;
INSERT INTO `ConfigWidget` VALUES (477,39,193,1,1),(478,39,194,2,1),(479,39,195,3,1),(480,39,196,4,1),(481,39,197,5,1),(482,39,198,6,1),(483,39,199,7,1),(484,39,200,8,1),(485,39,201,9,1),(486,39,202,10,1),(487,39,203,11,1),(488,39,204,12,1),(489,39,205,13,1),(490,40,206,1,1),(491,40,207,2,1),(492,40,208,3,1),(493,40,203,4,1),(494,40,204,5,1),(495,41,209,1,1),(496,41,210,2,1),(497,41,211,3,1),(498,41,212,4,1),(499,41,213,5,1),(500,41,204,6,1),(501,41,203,7,1),(502,41,214,8,1),(503,41,215,9,1),(504,42,216,1,1),(505,42,217,2,1),(506,42,204,3,1),(507,42,218,4,1),(508,42,215,5,1),(509,43,213,1,1),(510,43,204,2,1),(511,43,203,3,1),(512,43,215,4,1),(513,44,219,1,1),(514,44,220,2,1),(515,44,221,3,1),(516,44,203,4,1),(517,44,204,5,1),(518,45,222,1,1),(519,45,220,2,1),(520,45,221,3,1),(521,45,223,4,1),(522,45,224,5,1),(523,45,225,6,1),(524,45,214,7,1),(525,45,203,8,1),(526,45,204,9,1),(527,46,226,1,1),(528,46,204,2,1),(529,46,203,3,1),(530,46,214,4,1),(531,46,215,5,1),(532,47,227,1,1),(533,47,228,2,1),(534,47,229,3,1),(535,47,230,4,1),(536,47,231,5,1),(537,47,232,6,1),(538,47,214,7,1),(539,47,215,8,1),(540,48,233,1,1),(541,48,206,2,1),(542,48,234,3,1),(543,48,221,4,1),(544,48,235,5,1),(545,48,214,6,1),(546,48,215,7,1),(547,49,233,1,1),(548,49,206,2,1),(549,49,234,3,1),(550,49,221,4,1),(551,49,235,5,1),(552,49,214,6,1),(553,50,236,1,1),(554,50,228,2,1),(555,50,229,3,1),(556,50,230,4,1),(557,50,237,5,1),(558,50,238,6,1),(559,50,214,7,1),(560,50,215,8,1),(561,51,239,1,1),(562,51,240,2,1),(563,51,204,3,1),(564,51,203,4,1),(565,51,214,5,1),(566,51,215,6,1);
/*!40000 ALTER TABLE `ConfigWidget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EMPID` varchar(255) NOT NULL,
  `EMPNAME` varchar(255) NOT NULL,
  `ENABLE` tinyint(1) DEFAULT NULL,
  `VALID` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Module`
--

DROP TABLE IF EXISTS `Module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Module` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PARENTID` int NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `URLID` int DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  `ICON` varchar(255) DEFAULT NULL,
  `SortKey` varchar(16) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Module`
--

LOCK TABLES `Module` WRITE;
/*!40000 ALTER TABLE `Module` DISABLE KEYS */;
INSERT INTO `Module` VALUES (44,0,'名人管理',43,1,'','','1'),(45,0,'模板管理',44,1,'','','2'),(46,0,'权限管理',45,1,'','','3'),(47,46,'员工管理',46,1,'','','1'),(48,46,'部门管理',47,1,'','','2'),(49,46,'角色管理',48,1,'','','3'),(50,0,'系统管理',49,1,'','','4'),(51,50,'字典管理',50,1,'','','1'),(52,51,'数据项管理',51,1,'','','1'),(53,50,'系统白名单',52,1,'','','2'),(54,50,'打印设置',53,1,'','','3'),(55,50,'菜单管理',54,1,'','','4'),(56,0,'AI机器人管理',55,1,'','','5'),(57,56,'机器人管理',56,1,'','','1'),(58,56,'指令管理',57,1,'','','2'),(59,0,'巡查上报-待处理',58,1,'','','6');
/*!40000 ALTER TABLE `Module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ModuleConfig`
--

DROP TABLE IF EXISTS `ModuleConfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ModuleConfig` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PropertyID` int NOT NULL,
  `ConfigID` int NOT NULL,
  `ModuleID` int NOT NULL,
  `SortKey` int NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ModuleConfig`
--

LOCK TABLES `ModuleConfig` WRITE;
/*!40000 ALTER TABLE `ModuleConfig` DISABLE KEYS */;
INSERT INTO `ModuleConfig` VALUES (39,-1,39,44,-1,1),(40,-1,40,45,-1,1),(41,-1,41,47,-1,1),(42,-1,42,48,-1,1),(43,-1,43,49,-1,1),(44,-1,44,52,-1,1),(45,-1,45,51,-1,1),(46,-1,46,53,-1,1),(47,-1,47,54,-1,1),(48,-1,48,55,-1,1),(49,-1,49,55,-1,1),(50,-1,50,57,-1,1),(51,-1,51,58,-1,1);
/*!40000 ALTER TABLE `ModuleConfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ModuleData`
--

DROP TABLE IF EXISTS `ModuleData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ModuleData` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FieldID` int NOT NULL,
  `PropertyID` int NOT NULL,
  `RowId` int NOT NULL,
  `ParentId` int NOT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1289 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ModuleData`
--

LOCK TABLES `ModuleData` WRITE;
/*!40000 ALTER TABLE `ModuleData` DISABLE KEYS */;
INSERT INTO `ModuleData` VALUES (1014,477,193,1,0,'1'),(1015,478,194,1,0,''),(1016,479,195,1,0,''),(1017,480,196,1,0,''),(1018,481,197,1,0,'张三'),(1019,482,198,1,0,'象山村张三宅'),(1020,483,199,1,0,'12345678910'),(1021,484,200,1,0,'世界级名人'),(1022,486,202,1,0,''),(1023,489,205,1,0,''),(1024,485,201,1,0,''),(1025,488,204,1,0,''),(1026,487,203,1,0,''),(1027,543,221,44,0,''),(1028,542,234,44,0,''),(1029,546,215,44,0,''),(1030,545,214,44,0,''),(1031,540,233,44,0,'名人管理'),(1032,541,206,44,0,'名人信息'),(1033,544,235,44,0,'4696bbae-4dac-478d-82ef-8a5a8ff8d3a7'),(1034,543,221,45,0,''),(1035,542,234,45,0,''),(1036,546,215,45,0,''),(1037,545,214,45,0,''),(1038,540,233,45,0,'模板管理'),(1039,541,206,45,0,'模板配置'),(1040,544,235,45,0,'/template'),(1041,543,221,46,0,''),(1042,542,234,46,0,''),(1043,546,215,46,0,''),(1044,545,214,46,0,''),(1045,540,233,46,0,'权限管理'),(1046,541,206,46,0,''),(1047,544,235,46,0,'cd7540c1-fad1-43b7-b6d4-c3a3ee3daeb7'),(1048,543,221,47,46,''),(1049,542,234,47,46,''),(1050,546,215,47,46,''),(1051,545,214,47,46,''),(1052,540,233,47,46,'员工管理'),(1053,541,206,47,46,'3b7b05c4-db17-4436-b2a9-de6bedb1f1f1'),(1054,544,235,47,46,'/staff'),(1055,543,221,48,46,''),(1056,542,234,48,46,''),(1057,546,215,48,46,''),(1058,545,214,48,46,''),(1059,540,233,48,46,'部门管理'),(1060,541,206,48,46,'17869d11-b9db-4784-a0e0-5c97ad5d1e92'),(1061,544,235,48,46,'/branch'),(1062,543,221,49,46,''),(1063,542,234,49,46,''),(1064,546,215,49,46,''),(1065,545,214,49,46,''),(1066,540,233,49,46,'角色管理'),(1067,541,206,49,46,'e3e7c76b-7e20-4c4f-8002-e5a94a8293c5'),(1068,544,235,49,46,'/role'),(1069,543,221,50,0,''),(1070,542,234,50,0,''),(1071,546,215,50,0,''),(1072,545,214,50,0,''),(1073,540,233,50,0,'系统管理'),(1074,541,206,50,0,''),(1075,544,235,50,0,'6226d5a9-d1a6-4f30-b108-377215ad6e4c'),(1076,543,221,51,50,''),(1077,542,234,51,50,''),(1078,546,215,51,50,''),(1079,545,214,51,50,''),(1080,540,233,51,50,'字典管理'),(1081,541,206,51,50,'字典配置'),(1082,544,235,51,50,'/widget'),(1083,543,221,52,51,''),(1084,542,234,52,51,''),(1085,546,215,52,51,''),(1086,545,214,52,51,''),(1087,540,233,52,51,'数据项管理'),(1088,541,206,52,51,'数据项配置'),(1089,544,235,52,51,'/option'),(1090,543,221,53,50,''),(1091,542,234,53,50,''),(1092,546,215,53,50,''),(1093,545,214,53,50,''),(1094,540,233,53,50,'系统白名单'),(1095,541,206,53,50,'895ca419-e895-4691-8a95-db1d0d05c206'),(1096,544,235,53,50,'/whitelist'),(1097,543,221,54,50,''),(1098,542,234,54,50,''),(1099,546,215,54,50,''),(1100,545,214,54,50,''),(1101,540,233,54,50,'打印设置'),(1102,541,206,54,50,'4073eea7-b842-4181-b63d-a6d762f3f216'),(1103,544,235,54,50,'/print'),(1104,543,221,55,50,''),(1105,542,234,55,50,''),(1106,546,215,55,50,''),(1107,545,214,55,50,''),(1108,540,233,55,50,'菜单管理'),(1109,541,206,55,50,'菜单配置'),(1110,544,235,55,50,'/modules'),(1111,543,221,56,0,''),(1112,542,234,56,0,''),(1113,546,215,56,0,''),(1114,545,214,56,0,''),(1115,540,233,56,0,'AI机器人管理'),(1116,541,206,56,0,''),(1117,544,235,56,0,'548675cb-188a-4c6f-b093-25fc8d30805d'),(1118,543,221,57,56,''),(1119,542,234,57,56,''),(1120,546,215,57,56,''),(1121,545,214,57,56,''),(1122,540,233,57,56,'机器人管理'),(1123,541,206,57,56,'a68eaa1f-ab91-4cde-ab55-15b5a118ac90'),(1124,544,235,57,56,'/robot'),(1125,543,221,58,56,''),(1126,542,234,58,56,''),(1127,546,215,58,56,''),(1128,545,214,58,56,''),(1129,540,233,58,56,'指令管理'),(1130,541,206,58,56,'1018f30c-6072-4fe2-b6c8-84d23d0c18a8'),(1131,544,235,58,56,'/command'),(1132,543,221,59,0,''),(1133,542,234,59,0,''),(1134,546,215,59,0,''),(1135,545,214,59,0,''),(1136,540,233,59,0,'巡查上报-待处理'),(1137,541,206,59,0,''),(1138,544,235,59,0,'a3e288b1-ab7a-4fd3-bd22-dc75579ab769'),(1139,493,203,39,0,''),(1140,490,206,39,0,'39'),(1141,492,208,39,0,''),(1142,494,204,39,0,''),(1143,491,207,39,0,'名人信息'),(1144,493,203,40,0,''),(1145,490,206,40,0,'40'),(1146,492,208,40,0,''),(1147,494,204,40,0,''),(1148,491,207,40,0,'模板配置'),(1149,520,221,0,0,''),(1150,521,223,0,0,''),(1151,525,203,0,0,''),(1152,519,220,0,0,''),(1153,518,222,0,0,'序号'),(1154,524,214,0,0,''),(1155,522,224,0,0,''),(1156,526,204,0,0,''),(1157,523,225,0,0,''),(1158,520,221,0,0,''),(1159,521,223,0,0,''),(1160,525,203,0,0,''),(1161,519,220,0,0,''),(1162,518,222,0,0,'城镇'),(1163,524,214,0,0,''),(1164,522,224,0,0,''),(1165,526,204,0,0,''),(1166,523,225,0,0,''),(1167,520,221,0,0,''),(1168,521,223,0,0,''),(1169,525,203,0,0,''),(1170,519,220,0,0,''),(1171,518,222,0,0,'行政村'),(1172,524,214,0,0,''),(1173,522,224,0,0,''),(1174,526,204,0,0,''),(1175,523,225,0,0,''),(1176,520,221,0,0,''),(1177,521,223,0,0,''),(1178,525,203,0,0,''),(1179,519,220,0,0,''),(1180,518,222,0,0,'自然村'),(1181,524,214,0,0,''),(1182,522,224,0,0,''),(1183,526,204,0,0,''),(1184,523,225,0,0,''),(1185,520,221,0,0,''),(1186,521,223,0,0,''),(1187,525,203,0,0,''),(1188,519,220,0,0,''),(1189,518,222,0,0,'名人类型'),(1190,524,214,0,0,''),(1191,522,224,0,0,''),(1192,526,204,0,0,''),(1193,523,225,0,0,''),(1194,520,221,0,0,''),(1195,521,223,0,0,''),(1196,525,203,0,0,''),(1197,519,220,0,0,''),(1198,518,222,0,0,'更新人'),(1199,524,214,0,0,''),(1200,522,224,0,0,''),(1201,526,204,0,0,''),(1202,523,225,0,0,''),(1203,520,221,0,0,''),(1204,521,223,0,0,''),(1205,525,203,0,0,''),(1206,519,220,0,0,''),(1207,518,222,0,0,'更新时间'),(1208,524,214,0,0,''),(1209,522,224,0,0,''),(1210,526,204,0,0,''),(1211,523,225,0,0,''),(1212,520,221,0,0,''),(1213,521,223,0,0,''),(1214,525,203,0,0,''),(1215,519,220,0,0,''),(1216,518,222,0,0,'状态'),(1217,524,214,0,0,''),(1218,522,224,0,0,''),(1219,526,204,0,0,''),(1220,523,225,0,0,''),(1221,520,221,0,0,''),(1222,521,223,0,0,''),(1223,525,203,0,0,''),(1224,519,220,0,0,''),(1225,518,222,0,0,'更新人'),(1226,524,214,0,0,''),(1227,522,224,0,0,''),(1228,526,204,0,0,''),(1229,523,225,0,0,''),(1230,520,221,0,0,''),(1231,521,223,0,0,''),(1232,525,203,0,0,''),(1233,519,220,0,0,''),(1234,518,222,0,0,'更新时间'),(1235,524,214,0,0,''),(1236,522,224,0,0,''),(1237,526,204,0,0,''),(1238,523,225,0,0,''),(1239,515,221,0,0,''),(1240,516,203,0,0,''),(1241,514,220,0,0,''),(1242,513,219,0,0,'{人员基本信息}.{         村         组每户人员基本情况}.{城镇}.{城镇}'),(1243,517,204,0,0,''),(1244,515,221,0,0,''),(1245,516,203,0,0,''),(1246,514,220,0,0,''),(1247,513,219,0,0,'{人员基本信息}.{         村         组每户人员基本情况}.{行政村}.{行政村}'),(1248,517,204,0,0,''),(1249,515,221,0,0,''),(1250,516,203,0,0,''),(1251,514,220,0,0,''),(1252,513,219,0,0,'{人员基本信息}.{         村         组每户人员基本情况}.{自然村}.{自然村}'),(1253,517,204,0,0,''),(1254,515,221,0,0,''),(1255,516,203,0,0,''),(1256,514,220,0,0,''),(1257,513,219,0,0,'世界级名人'),(1258,517,204,0,0,''),(1259,515,221,0,0,''),(1260,516,203,0,0,''),(1261,514,220,0,0,''),(1262,513,219,0,0,'国家级名人'),(1263,517,204,0,0,''),(1264,515,221,0,0,''),(1265,516,203,0,0,''),(1266,514,220,0,0,''),(1267,513,219,0,0,'省级名人'),(1268,517,204,0,0,''),(1269,515,221,0,0,''),(1270,516,203,0,0,''),(1271,514,220,0,0,''),(1272,513,219,0,0,'市级名人'),(1273,517,204,0,0,''),(1274,515,221,0,0,''),(1275,516,203,0,0,''),(1276,514,220,0,0,''),(1277,513,219,0,0,'县级名人'),(1278,517,204,0,0,''),(1279,515,221,0,0,''),(1280,516,203,0,0,''),(1281,514,220,0,0,''),(1282,513,219,0,0,'启用'),(1283,517,204,0,0,''),(1284,515,221,0,0,''),(1285,516,203,0,0,''),(1286,514,220,0,0,''),(1287,513,219,0,0,'禁用'),(1288,517,204,0,0,'');
/*!40000 ALTER TABLE `ModuleData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Population`
--

DROP TABLE IF EXISTS `Population`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Population` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PID` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Population`
--

LOCK TABLES `Population` WRITE;
/*!40000 ALTER TABLE `Population` DISABLE KEYS */;
/*!40000 ALTER TABLE `Population` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Property`
--

DROP TABLE IF EXISTS `Property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Property` (
  `ID` int NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Property`
--

LOCK TABLES `Property` WRITE;
/*!40000 ALTER TABLE `Property` DISABLE KEYS */;
/*!40000 ALTER TABLE `Property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PropertyOption`
--

DROP TABLE IF EXISTS `PropertyOption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PropertyOption` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PropertyId` int NOT NULL,
  `ParentId` int NOT NULL,
  `VALUE` varchar(255) NOT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `SortKey` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PropertyOption`
--

LOCK TABLES `PropertyOption` WRITE;
/*!40000 ALTER TABLE `PropertyOption` DISABLE KEYS */;
/*!40000 ALTER TABLE `PropertyOption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PropertyType`
--

DROP TABLE IF EXISTS `PropertyType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PropertyType` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `valid` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PropertyType`
--

LOCK TABLES `PropertyType` WRITE;
/*!40000 ALTER TABLE `PropertyType` DISABLE KEYS */;
/*!40000 ALTER TABLE `PropertyType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `ROLES` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WhiteList`
--

DROP TABLE IF EXISTS `WhiteList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WhiteList` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `IP` varchar(255) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WhiteList`
--

LOCK TABLES `WhiteList` WRITE;
/*!40000 ALTER TABLE `WhiteList` DISABLE KEYS */;
/*!40000 ALTER TABLE `WhiteList` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Widget`
--

DROP TABLE IF EXISTS `Widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Widget` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `ParentID` int DEFAULT NULL,
  `ModuleID` int DEFAULT NULL,
  `ConfigID` int DEFAULT NULL,
  `WidgetID` int DEFAULT NULL,
  `PropertyID` int DEFAULT NULL,
  `Required` tinyint(1) NOT NULL,
  `Visiable` tinyint(1) NOT NULL,
  `Searchable` tinyint(1) NOT NULL,
  `Shareable` tinyint(1) NOT NULL,
  `DataSource` int NOT NULL,
  `Value` varchar(255) DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Widget`
--

LOCK TABLES `Widget` WRITE;
/*!40000 ALTER TABLE `Widget` DISABLE KEYS */;
INSERT INTO `Widget` VALUES (193,'序号',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(194,'所属城镇',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(195,'所属行政村',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(196,'所属自然村',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(197,'名人姓名',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(198,'出生地址',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(199,'联系电话',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(200,'名人类型',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(201,'安葬地址',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(202,'简介',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(203,'更新人',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(204,'更新时间',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(205,'状态',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(206,'模板编号',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(207,'模板标题',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(208,'选项数量',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(209,'员工账号',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(210,'员工姓名',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(211,'部门',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(212,'角色数量',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(213,'角色名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(214,'可用性状态',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(215,'操作',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(216,'部门名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(217,'员工数量',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(218,'上次调度时间',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(219,'数据项名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(220,'编码',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(221,'排序',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(222,'字典名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(223,'数据值数量',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(224,'描述',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(225,'引用数量',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(226,'IP名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(227,'备注名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(228,'设备品牌',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(229,'设备号码',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(230,'设备密钥',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(231,'打印纸款',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(232,'连接状态',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(233,'菜单名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(234,'图标',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(235,'URL',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(236,'设备名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(237,'设备类型',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(238,'链接状态',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(239,'指令名称',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1),(240,'指令编码',NULL,NULL,-1,-1,-1,-1,1,1,1,1,NULL,1);
/*!40000 ALTER TABLE `Widget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WidgetProperty`
--

DROP TABLE IF EXISTS `WidgetProperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WidgetProperty` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `WidgetID` int DEFAULT NULL,
  `PropertyID` int DEFAULT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WidgetProperty`
--

LOCK TABLES `WidgetProperty` WRITE;
/*!40000 ALTER TABLE `WidgetProperty` DISABLE KEYS */;
/*!40000 ALTER TABLE `WidgetProperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_access_token`
--

DROP TABLE IF EXISTS `oauth_access_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_token`
--

LOCK TABLES `oauth_access_token` WRITE;
/*!40000 ALTER TABLE `oauth_access_token` DISABLE KEYS */;
INSERT INTO `oauth_access_token` VALUES ('2020-08-01 08:49:02','75073f7814737fbf69f1e471368e274b',_binary '�\�\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken��6$�\�\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6�Z\�\�\�\0\0xpsr\0java.util.Datehj�KYt\0\0xpw\0\0s�\��\�xsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\�Gc�\�ɷ\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\�\ncT\�^\0L\0valueq\0~\0xpt\0LNELvYJxmqVHgJ0zBGnfqjHQCbcsq\0~\0	w\0\0tC��\�xsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxt\0bearert\0cVv_ZYWLBE7BXvzdctP4WH3xflA','924a2e27f4ee687e0a198b89c77ce6c9','admin','webapp',_binary '�\�\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication�@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0\0w\0\0\0\0xq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUrit\0Ljava/lang/String;L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>�qi�\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0webappsr\0%java.util.Collections$UnmodifiableMap\��t\�B\0L\0mq\0~\0xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xq\0~\0	sr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0\0w\0\0\0\0xq\0~\0*sr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0q\0~\0\Zq\0~\0q\0~\0x\0psr\02org.springframework.security.core.userdetails.User\0\0\0\0\0\0\0Z\0accountNonExpiredZ\0accountNonLockedZ\0credentialsNonExpiredZ\0enabledL\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0sr\0java.util.TreeSetݘP��\�[\0\0xpsr\0Forg.springframework.security.core.userdetails.User$AuthorityComparator\0\0\0\0\0\0\0\0xpw\0\0\0\0xpt\0admin','880ed519a439e06f714b8262480ed45e');
/*!40000 ALTER TABLE `oauth_access_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_refresh_token`
--

DROP TABLE IF EXISTS `oauth_refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oauth_refresh_token` (
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_refresh_token`
--

LOCK TABLES `oauth_refresh_token` WRITE;
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
INSERT INTO `oauth_refresh_token` VALUES ('2020-08-01 08:49:02','880ed519a439e06f714b8262480ed45e',_binary '�\�\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\�Gc�\�ɷ\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\�\ncT\�^\0L\0valuet\0Ljava/lang/String;xpt\0LNELvYJxmqVHgJ0zBGnfqjHQCbcsr\0java.util.Datehj�KYt\0\0xpw\0\0tC��\�x',_binary '�\�\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication�@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0\0w\0\0\0\0xq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUrit\0Ljava/lang/String;L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>�qi�\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0webappsr\0%java.util.Collections$UnmodifiableMap\��t\�B\0L\0mq\0~\0xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xq\0~\0	sr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0\0w\0\0\0\0xq\0~\0*sr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0q\0~\0\Zq\0~\0q\0~\0x\0psr\02org.springframework.security.core.userdetails.User\0\0\0\0\0\0\0Z\0accountNonExpiredZ\0accountNonLockedZ\0credentialsNonExpiredZ\0enabledL\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0sr\0java.util.TreeSetݘP��\�[\0\0xpsr\0Forg.springframework.security.core.userdetails.User$AuthorityComparator\0\0\0\0\0\0\0\0xpw\0\0\0\0xpt\0admin');
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_department`
--

DROP TABLE IF EXISTS `sys_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `parentid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_department`
--

LOCK TABLES `sys_department` WRITE;
/*!40000 ALTER TABLE `sys_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url_id` varchar(200) NOT NULL,
  `parentid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (43,'名人管理','43',0),(44,'模板管理','44',0),(45,'权限管理','45',0),(46,'员工管理','46',45),(47,'部门管理','47',45),(48,'角色管理','48',45),(49,'系统管理','49',0),(50,'字典管理','50',49),(51,'数据项管理','51',50),(52,'系统白名单','52',49),(53,'打印设置','53',49),(54,'菜单管理','54',49),(55,'AI机器人管理','55',0),(56,'机器人管理','56',55),(57,'指令管理','57',55),(58,'巡查上报-待处理','58',0);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ROLE_ADMIN',NULL,NULL,NULL),(2,'ROLE_USER',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (13,1,43),(14,1,44),(15,1,45),(16,1,46),(17,1,47),(18,1,48),(19,1,49),(20,1,50),(21,1,59),(22,1,60),(23,1,61),(24,1,62),(25,1,69),(26,1,70),(27,1,71),(28,1,72),(29,1,73);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_url`
--

DROP TABLE IF EXISTS `sys_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_url` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_url`
--

LOCK TABLES `sys_url` WRITE;
/*!40000 ALTER TABLE `sys_url` DISABLE KEYS */;
INSERT INTO `sys_url` VALUES (43,'4696bbae-4dac-478d-82ef-8a5a8ff8d3a7',NULL),(44,'/template',NULL),(45,'cd7540c1-fad1-43b7-b6d4-c3a3ee3daeb7',NULL),(46,'/staff',NULL),(47,'/branch',NULL),(48,'/role',NULL),(49,'6226d5a9-d1a6-4f30-b108-377215ad6e4c',NULL),(50,'/widget',NULL),(51,'/option',NULL),(52,'/whitelist',NULL),(53,'/print',NULL),(54,'/modules',NULL),(55,'548675cb-188a-4c6f-b093-25fc8d30805d',NULL),(56,'/robot',NULL),(57,'/command',NULL),(58,'a3e288b1-ab7a-4fd3-bd22-dc75579ab769',NULL);
/*!40000 ALTER TABLE `sys_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_url_permission`
--

DROP TABLE IF EXISTS `sys_url_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_url_permission` (
  `id` int DEFAULT NULL,
  `url_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_url_permission`
--

LOCK TABLES `sys_url_permission` WRITE;
/*!40000 ALTER TABLE `sys_url_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_url_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `dept_code` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuK','admin',NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_role_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-01 16:53:25
