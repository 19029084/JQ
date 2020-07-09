-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: JQ
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.20.04.1

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Module`
--

LOCK TABLES `Module` WRITE;
/*!40000 ALTER TABLE `Module` DISABLE KEYS */;
INSERT INTO `Module` VALUES (1,0,'数据大屏',1,1),(2,0,'数据中心',2,1),(3,2,'扶贫管理',NULL,1),(4,2,'名人管理',NULL,1),(5,2,'公共设施管理',NULL,1),(6,2,'交通信息管理',NULL,1),(7,2,'养老设施管理',NULL,1),(8,2,'卫生设施管理',NULL,1),(9,2,'教育信息管理',NULL,1),(10,2,'文体设施管理',NULL,1),(11,2,'集体资产管理',NULL,1),(12,2,'土地资源管理',NULL,1),(13,2,'农业设施管理',NULL,1),(14,2,'工业信息管理',NULL,1),(15,2,'商贸信息管理',NULL,1),(16,2,'旅游景点管理',NULL,1),(17,0,'组织与人员',NULL,1),(18,17,'城镇管理',NULL,1),(19,17,'行政村管理',NULL,1),(20,17,'自然村/村民小组管理',NULL,1),(21,17,'干部管理',NULL,1),(22,17,'工会管理',NULL,1),(23,17,'村民管理',NULL,1),(24,17,'家庭户管理',NULL,1),(25,17,'党支部管理',NULL,1),(26,17,'党员管理',NULL,1),(27,0,'模板管理',3,1),(28,0,'权限管理',NULL,1),(29,28,'员工管理',4,1),(30,28,'部门管理',5,1),(31,28,'角色管理',6,1),(32,0,'系统管理',NULL,1),(33,32,'字典管理',7,1),(34,32,'系统白名单',8,1),(35,32,'打印设置',9,1),(36,32,'菜单管理',10,1),(37,0,'AI机器人管理',NULL,1),(38,37,'机器人管理',11,1),(39,37,'指令管理',12,1),(40,0,'巡查上报-待处理',NULL,1);
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
  `ModuleID` int NOT NULL,
  `PropertyID` int NOT NULL,
  `ConfigID` int NOT NULL,
  `SortKey` int NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=491 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ModuleConfig`
--

LOCK TABLES `ModuleConfig` WRITE;
/*!40000 ALTER TABLE `ModuleConfig` DISABLE KEYS */;
INSERT INTO `ModuleConfig` VALUES (1,3,1,0,1,1),(2,3,2,0,-1,1),(3,3,3,0,-1,1),(4,3,4,0,-1,1),(5,3,5,0,-1,1),(6,3,6,0,-1,1),(7,3,7,0,-1,1),(8,3,8,0,-1,1),(9,3,9,0,-1,1),(10,3,10,0,-1,1),(11,3,11,0,-1,1),(12,3,12,0,-1,1),(13,3,13,0,-1,1),(14,3,14,0,-1,1),(15,3,15,0,-1,1),(16,3,16,0,-1,1),(17,3,17,0,-1,1),(18,3,18,0,-1,1),(19,3,19,0,-1,1),(20,3,20,0,-1,1),(21,3,21,0,-1,1),(22,3,22,0,-1,1),(23,3,23,0,-1,1),(24,3,24,0,-1,1),(25,3,25,0,-1,1),(26,3,26,0,-1,1),(27,3,27,0,-1,1),(28,3,28,0,-1,1),(29,3,29,0,-1,1),(30,3,30,0,-1,1),(31,3,31,100,-1,1),(32,3,32,100,-1,1),(33,3,33,100,-1,1),(34,3,34,100,-1,1),(35,4,1,0,-1,1),(36,4,35,0,-1,1),(37,4,36,0,-1,1),(38,4,37,0,-1,1),(39,4,38,0,-1,1),(40,4,16,0,-1,1),(41,4,17,0,-1,1),(42,4,18,0,-1,1),(43,4,29,0,-1,1),(44,4,30,0,-1,1),(45,4,31,100,-1,1),(46,4,32,100,-1,1),(47,4,33,100,-1,1),(48,4,34,100,-1,1),(49,5,1,0,-1,1),(50,5,39,0,-1,1),(51,5,40,0,-1,1),(52,5,41,0,-1,1),(53,5,29,0,-1,1),(54,5,16,0,-1,1),(55,5,17,0,-1,1),(56,5,18,0,-1,1),(57,5,42,0,-1,1),(58,5,30,0,-1,1),(59,5,31,100,-1,1),(60,5,32,100,-1,1),(61,5,33,100,-1,1),(62,5,34,100,-1,1),(63,6,1,0,-1,1),(64,6,43,0,-1,1),(65,6,44,0,-1,1),(66,6,45,0,-1,1),(67,6,29,0,-1,1),(68,6,16,0,-1,1),(69,6,17,0,-1,1),(70,6,18,0,-1,1),(71,6,46,0,-1,1),(72,6,42,0,-1,1),(73,6,30,0,-1,1),(74,6,31,100,-1,1),(75,6,32,100,-1,1),(76,6,33,100,-1,1),(77,6,34,100,-1,1),(78,7,1,0,-1,1),(79,7,47,0,-1,1),(80,7,48,0,-1,1),(81,7,45,0,-1,1),(82,7,29,0,-1,1),(83,7,16,0,-1,1),(84,7,17,0,-1,1),(85,7,18,0,-1,1),(86,7,41,0,-1,1),(87,7,42,0,-1,1),(88,7,30,0,-1,1),(89,7,31,100,-1,1),(90,7,32,100,-1,1),(91,7,33,100,-1,1),(92,7,34,100,-1,1),(93,8,1,0,-1,1),(94,8,49,0,-1,1),(95,8,50,0,-1,1),(96,8,45,0,-1,1),(97,8,29,0,-1,1),(98,8,16,0,-1,1),(99,8,17,0,-1,1),(100,8,18,0,-1,1),(101,8,41,0,-1,1),(102,8,42,0,-1,1),(103,8,30,0,-1,1),(104,8,31,100,-1,1),(105,8,32,100,-1,1),(106,8,33,100,-1,1),(107,8,34,100,-1,1),(108,8,51,200,-1,1),(109,8,52,200,-1,1),(110,8,29,200,-1,1),(111,8,53,200,-1,1),(112,8,54,200,-1,1),(113,8,55,200,-1,1),(114,8,34,200,-1,1),(115,9,1,0,-1,1),(116,9,56,0,-1,1),(117,9,57,0,-1,1),(118,9,45,0,-1,1),(119,9,58,0,-1,1),(120,9,16,0,-1,1),(121,9,17,0,-1,1),(122,9,18,0,-1,1),(123,9,41,0,-1,1),(124,9,42,0,-1,1),(125,9,30,0,-1,1),(126,9,31,100,-1,1),(127,9,32,100,-1,1),(128,9,33,100,-1,1),(129,9,34,100,-1,1),(130,10,1,0,-1,1),(131,10,59,0,-1,1),(132,10,60,0,-1,1),(133,10,45,0,-1,1),(134,10,29,0,-1,1),(135,10,16,0,-1,1),(136,10,17,0,-1,1),(137,10,18,0,-1,1),(138,10,41,0,-1,1),(139,10,42,0,-1,1),(140,10,30,0,-1,1),(141,10,31,100,-1,1),(142,10,32,100,-1,1),(143,10,33,100,-1,1),(144,10,34,100,-1,1),(145,11,1,0,-1,1),(146,11,61,0,-1,1),(147,11,62,0,-1,1),(148,11,63,0,-1,1),(149,11,64,0,-1,1),(150,11,16,0,-1,1),(151,11,17,0,-1,1),(152,11,18,0,-1,1),(153,11,65,0,-1,1),(154,11,66,0,-1,1),(155,11,67,0,-1,1),(156,11,30,0,-1,1),(157,11,31,100,-1,1),(158,11,32,100,-1,1),(159,11,33,100,-1,1),(160,11,34,100,-1,1),(161,11,68,200,-1,1),(162,11,29,200,-1,1),(163,11,53,200,-1,1),(164,11,54,200,-1,1),(165,11,55,200,-1,1),(166,11,69,200,-1,1),(167,11,34,200,-1,1),(168,12,1,0,-1,1),(169,12,70,0,-1,1),(170,12,71,0,-1,1),(171,12,72,0,-1,1),(172,12,73,0,-1,1),(173,12,16,0,-1,1),(174,12,17,0,-1,1),(175,12,18,0,-1,1),(176,12,74,0,-1,1),(177,12,42,0,-1,1),(178,12,75,0,-1,1),(179,12,30,0,-1,1),(180,12,31,100,-1,1),(181,12,32,100,-1,1),(182,12,33,100,-1,1),(183,12,34,100,-1,1),(184,13,1,0,-1,1),(185,13,76,0,-1,1),(186,13,77,0,-1,1),(187,13,45,0,-1,1),(188,13,16,0,-1,1),(189,13,17,0,-1,1),(190,13,18,0,-1,1),(191,13,74,0,-1,1),(192,13,42,0,-1,1),(193,13,30,0,-1,1),(194,13,31,100,-1,1),(195,13,32,100,-1,1),(196,13,33,100,-1,1),(197,13,34,100,-1,1),(198,14,1,0,-1,1),(199,14,78,0,-1,1),(200,14,79,0,-1,1),(201,14,80,0,-1,1),(202,14,16,0,-1,1),(203,14,17,0,-1,1),(204,14,18,0,-1,1),(205,14,41,0,-1,1),(206,14,29,0,-1,1),(207,14,81,0,-1,1),(208,14,82,0,-1,1),(209,14,83,0,-1,1),(210,14,42,0,-1,1),(211,14,30,0,-1,1),(212,14,31,100,-1,1),(213,14,32,100,-1,1),(214,14,33,100,-1,1),(215,14,34,100,-1,1),(216,15,1,0,-1,1),(217,15,84,0,-1,1),(218,15,85,0,-1,1),(219,15,45,0,-1,1),(220,15,16,0,-1,1),(221,15,17,0,-1,1),(222,15,18,0,-1,1),(223,15,41,0,-1,1),(224,15,29,0,-1,1),(225,15,42,0,-1,1),(226,15,30,0,-1,1),(227,15,31,100,-1,1),(228,15,32,100,-1,1),(229,15,33,100,-1,1),(230,15,34,100,-1,1),(231,16,1,0,-1,1),(232,16,86,0,-1,1),(233,16,87,0,-1,1),(234,16,45,0,-1,1),(235,16,16,0,-1,1),(236,16,17,0,-1,1),(237,16,18,0,-1,1),(238,16,41,0,-1,1),(239,16,29,0,-1,1),(240,16,42,0,-1,1),(241,16,30,0,-1,1),(242,16,31,100,-1,1),(243,16,32,100,-1,1),(244,16,33,100,-1,1),(245,16,34,100,-1,1),(246,18,1,0,-1,1),(247,18,88,0,-1,1),(248,18,89,0,-1,1),(249,18,90,0,-1,1),(250,18,91,0,-1,1),(251,18,92,0,-1,1),(252,18,93,0,-1,1),(253,18,30,0,-1,1),(254,18,31,100,-1,1),(255,18,32,100,-1,1),(256,18,33,100,-1,1),(257,18,34,100,-1,1),(258,19,1,0,-1,1),(259,19,94,0,-1,1),(260,19,87,0,-1,1),(261,19,89,0,-1,1),(262,19,90,0,-1,1),(263,19,91,0,-1,1),(264,19,18,0,-1,1),(265,19,95,0,-1,1),(266,19,30,0,-1,1),(267,19,31,100,-1,1),(268,19,32,100,-1,1),(269,19,33,100,-1,1),(270,19,34,100,-1,1),(271,20,1,0,-1,1),(272,20,96,0,-1,1),(273,20,97,0,-1,1),(274,20,18,0,-1,1),(275,20,89,0,-1,1),(276,20,90,0,-1,1),(277,20,91,0,-1,1),(278,20,98,0,-1,1),(279,20,99,0,-1,1),(280,20,17,0,-1,1),(281,20,30,0,-1,1),(282,20,31,100,-1,1),(283,20,32,100,-1,1),(284,20,33,100,-1,1),(285,20,34,100,-1,1),(286,21,1,0,-1,1),(287,21,100,0,-1,1),(288,21,101,0,-1,1),(289,21,102,0,-1,1),(290,21,16,0,-1,1),(291,21,17,0,-1,1),(292,21,18,0,-1,1),(293,21,103,0,-1,1),(294,21,104,0,-1,1),(295,21,15,0,-1,1),(296,21,105,0,-1,1),(297,21,29,0,-1,1),(298,21,31,100,-1,1),(299,21,32,100,-1,1),(300,21,33,100,-1,1),(301,21,34,100,-1,1),(302,22,1,0,-1,1),(303,22,106,0,-1,1),(304,22,107,0,-1,1),(305,22,108,0,-1,1),(306,22,16,0,-1,1),(307,22,17,0,-1,1),(308,22,18,0,-1,1),(309,22,109,0,-1,1),(310,22,30,0,-1,1),(311,22,31,100,-1,1),(312,22,32,100,-1,1),(313,22,33,100,-1,1),(314,22,34,100,-1,1),(315,22,51,200,-1,1),(316,22,110,200,-1,1),(317,22,29,200,-1,1),(318,22,53,200,-1,1),(319,22,54,200,-1,1),(320,22,55,200,-1,1),(321,22,69,200,-1,1),(322,22,34,200,-1,1),(323,23,1,0,-1,1),(324,23,111,0,-1,1),(325,23,112,0,-1,1),(326,23,113,0,-1,1),(327,23,114,0,-1,1),(328,23,15,0,-1,1),(329,23,16,0,-1,1),(330,23,17,0,-1,1),(331,23,18,0,-1,1),(332,23,115,0,-1,1),(333,23,116,0,-1,1),(334,23,117,0,-1,1),(335,23,69,0,-1,1),(336,23,118,0,-1,1),(337,23,119,0,-1,1),(338,23,120,0,-1,1),(339,23,5,0,-1,1),(340,23,10,0,-1,1),(341,23,121,0,-1,1),(342,23,122,0,-1,1),(343,23,6,0,-1,1),(344,23,123,0,-1,1),(345,23,7,0,-1,1),(346,23,21,0,-1,1),(347,23,124,0,-1,1),(348,23,9,0,-1,1),(349,23,8,0,-1,1),(350,23,31,100,-1,1),(351,23,32,100,-1,1),(352,23,33,100,-1,1),(353,23,34,100,-1,1),(354,24,1,0,-1,1),(355,24,125,0,-1,1),(356,24,112,0,-1,1),(357,24,113,0,-1,1),(358,24,114,0,-1,1),(359,24,126,0,-1,1),(360,24,127,0,-1,1),(361,24,128,0,-1,1),(362,24,129,0,-1,1),(363,24,15,0,-1,1),(364,24,16,0,-1,1),(365,24,17,0,-1,1),(366,24,18,0,-1,1),(367,24,130,0,-1,1),(368,24,131,0,-1,1),(369,24,132,0,-1,1),(370,24,133,0,-1,1),(371,24,134,0,-1,1),(372,24,135,0,-1,1),(373,24,136,0,-1,1),(374,24,137,0,-1,1),(375,24,138,0,-1,1),(376,24,83,0,-1,1),(377,24,139,0,-1,1),(378,24,140,0,-1,1),(379,24,28,0,-1,1),(380,24,31,100,-1,1),(381,24,32,100,-1,1),(382,24,33,100,-1,1),(383,24,34,100,-1,1),(384,24,141,200,-1,1),(385,24,112,200,-1,1),(386,24,3,200,-1,1),(387,24,53,200,-1,1),(388,24,54,200,-1,1),(389,24,142,200,-1,1),(390,24,143,200,-1,1),(391,24,29,200,-1,1),(392,24,34,200,-1,1),(393,25,1,0,-1,1),(394,25,144,0,-1,1),(395,25,16,0,-1,1),(396,25,17,0,-1,1),(397,25,18,0,-1,1),(398,25,41,0,-1,1),(399,25,29,0,-1,1),(400,25,30,0,-1,1),(401,25,31,100,-1,1),(402,25,32,100,-1,1),(403,25,33,100,-1,1),(404,25,34,100,-1,1),(405,26,1,0,-1,1),(406,26,145,0,-1,1),(407,26,113,0,-1,1),(408,26,146,0,-1,1),(409,26,147,0,-1,1),(410,26,5,0,-1,1),(411,26,148,0,-1,1),(412,26,15,0,-1,1),(413,26,16,0,-1,1),(414,26,17,0,-1,1),(415,26,18,0,-1,1),(416,26,149,0,-1,1),(417,26,150,0,-1,1),(418,26,31,100,-1,1),(419,26,32,100,-1,1),(420,26,33,100,-1,1),(421,26,34,100,-1,1),(422,27,151,0,-1,1),(423,27,152,0,-1,1),(424,27,153,0,-1,1),(425,27,154,0,-1,1),(426,27,155,0,-1,1),(427,27,156,0,-1,1),(428,27,34,0,-1,1),(429,29,157,0,-1,1),(430,29,158,0,-1,1),(431,29,159,0,-1,1),(432,29,160,0,-1,1),(433,29,161,0,-1,1),(434,29,32,0,-1,1),(435,29,31,0,-1,1),(436,29,156,0,-1,1),(437,29,34,0,-1,1),(438,30,162,0,-1,1),(439,30,163,0,-1,1),(440,30,32,0,-1,1),(441,30,164,0,-1,1),(442,30,34,0,-1,1),(443,31,161,0,-1,1),(444,31,32,0,-1,1),(445,31,31,0,-1,1),(446,31,34,0,-1,1),(447,33,165,0,-1,1),(448,33,166,0,-1,1),(449,33,154,0,-1,1),(450,33,167,0,-1,1),(451,33,168,0,-1,1),(452,33,169,0,-1,1),(453,33,156,0,-1,1),(454,33,31,0,-1,1),(455,33,32,0,-1,1),(456,33,34,0,-1,1),(457,34,170,0,-1,1),(458,34,32,0,-1,1),(459,34,31,0,-1,1),(460,34,156,0,-1,1),(461,34,34,0,-1,1),(462,35,171,0,-1,1),(463,35,172,0,-1,1),(464,35,173,0,-1,1),(465,35,174,0,-1,1),(466,35,175,0,-1,1),(467,35,176,0,-1,1),(468,35,156,0,-1,1),(469,35,34,0,-1,1),(470,36,151,0,-1,1),(471,36,152,0,-1,1),(472,36,153,0,-1,1),(473,36,154,0,-1,1),(474,36,155,0,-1,1),(475,36,156,0,-1,1),(476,36,34,0,-1,1),(477,38,177,0,-1,1),(478,38,172,0,-1,1),(479,38,173,0,-1,1),(480,38,174,0,-1,1),(481,38,178,0,-1,1),(482,38,179,0,-1,1),(483,38,156,0,-1,1),(484,38,34,0,-1,1),(485,39,180,0,-1,1),(486,39,181,0,-1,1),(487,39,32,0,-1,1),(488,39,31,0,-1,1),(489,39,156,0,-1,1),(490,39,34,0,-1,1);
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
  `ParentID` int NOT NULL,
  `Data` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ModuleData`
--

LOCK TABLES `ModuleData` WRITE;
/*!40000 ALTER TABLE `ModuleData` DISABLE KEYS */;
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
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Property`
--

LOCK TABLES `Property` WRITE;
/*!40000 ALTER TABLE `Property` DISABLE KEYS */;
INSERT INTO `Property` VALUES (1,'序号','1',1),(2,'人数','1',1),(3,'与户主关系','2',1),(4,'贫困户姓名','3',1),(5,'民族','3',1),(6,'文化程度','3',1),(7,'在校生状况','3',1),(8,'健康状况','3',1),(9,'劳动技能','3',1),(10,'务工状态','3',1),(11,'务工时间（月）','4',1),(12,'脱贫属性','3',1),(13,'脱贫年度','3',1),(14,'帮扶责任人','3',1),(15,'所属村民小组','3',1),(16,'所属自然村','3',1),(17,'所属行政村','3',1),(18,'所属城镇','3',1),(19,'贫困人员识别时间','3',1),(20,'脱贫时间','3',1),(21,'参加大病医疗','3',1),(22,'致贫原因','3',1),(23,'危房户','3',1),(24,'改房情况','3',1),(25,'改厕情况','3',1),(26,'是否解决安全饮用水','3',1),(27,'改水情况','3',1),(28,'人均纯收入','3',1),(29,'联系电话','3',1),(30,'简介','5',1),(31,'更新人','3',1),(32,'更新时间','3',1),(33,'状态','3',1),(34,'操作','2',1),(35,'名人姓名','3',1),(36,'名人类型','3',1),(37,'出生地址','3',1),(38,'安葬地址','3',1),(39,'公共设施名称','3',1),(40,'公共设施类型','3',1),(41,'地址','3',1),(42,'照片','3',1),(43,'交通名称','3',1),(44,'交通类型','3',1),(45,'建设状态','3',1),(46,'长度','3',1),(47,'养老设施名称','3',1),(48,'养老设施类型','3',1),(49,'卫生设施名称','3',1),(50,'医院类型','3',1),(51,'成员','3',1),(52,'村医类型','3',1),(53,'就业情况','3',1),(54,'学历','3',1),(55,'工作性质','3',1),(56,'学校名称','3',1),(57,'学校类型','3',1),(58,'容纳人数','3',1),(59,'文体名称','3',1),(60,'文体类型','3',1),(61,'集体资产名称','3',1),(62,'集体资产类型','3',1),(63,'是否登记注册','3',1),(64,'资产成员数','3',1),(65,'集体资产收入','3',1),(66,'资产照片','3',1),(67,'集体资产价值','3',1),(68,'资产成员','3',1),(69,'工作类型','3',1),(70,'资源名称','3',1),(71,'资源类型','3',1),(72,'资源状态','3',1),(73,'面积','3',1),(74,'是否有收益','3',1),(75,'土地承包合同','3',1),(76,'农业设施名称','3',1),(77,'设施类型','3',1),(78,'工业名称','3',1),(79,'工业类型','3',1),(80,'规模','3',1),(81,'效益','3',1),(82,'主要销往','3',1),(83,'年收入','3',1),(84,'商贸名称','3',1),(85,'商贸类型','3',1),(86,'景点名称','3',1),(87,'景点类型','3',1),(88,'城镇名称','3',1),(89,'管辖面积（亩）','3',1),(90,'管辖户数','3',1),(91,'管辖人口','3',1),(92,'办公室照片','3',1),(93,'城镇规划','3',1),(94,'行政村名称','3',1),(95,'村部照片','3',1),(96,'自然村名称','3',1),(97,'村民小组名称','3',1),(98,'村荣照片','3',1),(99,'村貌照片','3',1),(100,'领导名称','3',1),(101,'职位','3',1),(102,'职务','3',1),(103,'所属机构','3',1),(104,'机构岗位','3',1),(105,'干部照片','3',1),(106,'工会名称','3',1),(107,'工会类型','3',1),(108,'工会人数','3',1),(109,'工会照片','3',1),(110,'工会任职','3',1),(111,'村民姓名','3',1),(112,'身份证号','3',1),(113,'性别','3',1),(114,'年龄','3',1),(115,'人编号','3',1),(116,'工作单位','3',1),(117,'手机号','3',1),(118,'身份证反面照','3',1),(119,'身份证正面照','3',1),(120,'养老保险情况','3',1),(121,'务工时间','3',1),(122,'参加情况','3',1),(123,'医疗保险情况','3',1),(124,'参加低保情况','3',1),(125,'户主','3',1),(126,'家庭人数','3',1),(127,'贫困户','3',1),(128,'低保户','3',1),(129,'残疾人','3',1),(130,'出生年月','3',1),(131,'家庭户类型','3',1),(132,'自来水情况','3',1),(133,'通电情况','3',1),(134,'户口类型','3',1),(135,'贫困户类型','3',1),(136,'房屋照片','3',1),(137,'是否军人家属','3',1),(138,'网络情况','3',1),(139,'房屋情况','3',1),(140,'户编号','3',1),(141,'家庭成员','3',1),(142,'养老保险','3',1),(143,'医疗保险','3',1),(144,'党支部名称','3',1),(145,'党员名称','3',1),(146,'入党时间','3',1),(147,'入党年限','3',1),(148,'是否后备干部','3',1),(149,'所属党支部','3',1),(150,'所属党小组','3',1),(151,'菜单名称','6',1),(152,'模板编号','6',1),(153,'图标','6',1),(154,'排序','6',1),(155,'URL','6',1),(156,'可用性状态','6',1),(157,'员工账号','6',1),(158,'员工姓名','6',1),(159,'部门','6',1),(160,'角色数量','6',1),(161,'角色名称','6',1),(162,'部门名称','6',1),(163,'员工数量','6',1),(164,'上次调度时间','6',1),(165,'字典名称','6',1),(166,'编码','6',1),(167,'数据值数量','6',1),(168,'描述','6',1),(169,'引用数量','6',1),(170,'IP名称','6',1),(171,'备注名称','6',1),(172,'设备品牌','6',1),(173,'设备号码','6',1),(174,'设备密钥','6',1),(175,'打印纸款','6',1),(176,'连接状态','6',1),(177,'设备名称','6',1),(178,'设备类型','6',1),(179,'链接状态','6',1),(180,'指令名称','6',1),(181,'指令编码','6',1);
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
  `PID` int NOT NULL,
  `VALUE` varchar(255) NOT NULL,
  `VALID` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PropertyOption`
--

LOCK TABLES `PropertyOption` WRITE;
/*!40000 ALTER TABLE `PropertyOption` DISABLE KEYS */;
INSERT INTO `PropertyOption` VALUES (1,34,'编辑',1),(2,34,'禁用',1),(3,34,'删除',1),(4,34,'权限项查看',1),(5,34,'添加下级',1),(6,34,'打卡轨迹',1),(7,34,'重置密码',1),(8,34,'新增子部门',1),(9,34,'数据项管理',1);
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
INSERT INTO `PropertyType` VALUES (1,'inputNumber',NULL,1),(2,'select',NULL,1),(3,'text',NULL,1),(4,'dataPicker',NULL,1),(5,'textArea',NULL,1),(6,'UNKNOWN',NULL,1);
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
INSERT INTO `oauth_access_token` VALUES ('2020-07-09 08:07:10','f74adaad2fc507c76c4bce5f88542553',_binary '�\�\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken��6$�\�\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6�Z\�\�\�\0\0xpsr\0java.util.Datehj�KYt\0\0xpw\0\0s50c�xsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\�Gc�\�ɷ\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\�\ncT\�^\0L\0valueq\0~\0xpt\0nPYbxCqEQlZa5XALEIzPNjBVv4Msq\0~\0	w\0\0s\���xsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxt\0bearert\0Doc1bCES-ByptOJ7_ncOxrUw5Ts','924a2e27f4ee687e0a198b89c77ce6c9','admin','webapp',_binary '�\�\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication�@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0\0w\0\0\0\0xq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUrit\0Ljava/lang/String;L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>�qi�\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0webappsr\0%java.util.Collections$UnmodifiableMap\��t\�B\0L\0mq\0~\0xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xq\0~\0	sr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0\0w\0\0\0\0xq\0~\0*sr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0q\0~\0\Zq\0~\0q\0~\0x\0psr\0com.jq.entity.JQAccount+�\�P�\�\0Z\0expireZ\0lockedL\0nicknameq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0pt\0<$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuKt\0admin','0ac3b428c6fe63772f97b94580c006fa');
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
INSERT INTO `oauth_refresh_token` VALUES ('2020-07-09 08:07:10','0ac3b428c6fe63772f97b94580c006fa',_binary '�\�\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\�Gc�\�ɷ\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\�\ncT\�^\0L\0valuet\0Ljava/lang/String;xpt\0nPYbxCqEQlZa5XALEIzPNjBVv4Msr\0java.util.Datehj�KYt\0\0xpw\0\0s\���x',_binary '�\�\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2Authentication�@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^\�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0\0w\0\0\0\0xq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUrit\0Ljava/lang/String;L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>�qi�\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0webappsr\0%java.util.Collections$UnmodifiableMap\��t\�B\0L\0mq\0~\0xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSet��я��U\0\0xq\0~\0	sr\0java.util.LinkedHashSet\�l\�Z�\�*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0allxsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsq\0~\0 w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0\0w\0\0\0\0xq\0~\0*sr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0q\0~\0\Zq\0~\0q\0~\0x\0psr\0com.jq.entity.JQAccount+�\�P�\�\0Z\0expireZ\0lockedL\0nicknameq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xp\0\0pt\0<$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuKt\0admin');
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission_code` varchar(32) DEFAULT NULL,
  `permission_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` char(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('1','ROLE_ADMIN','管理员'),('2','ROLE_USER','用户');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
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
  `url` varchar(128) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_url`
--

LOCK TABLES `sys_url` WRITE;
/*!40000 ALTER TABLE `sys_url` DISABLE KEYS */;
INSERT INTO `sys_url` VALUES (1,'/',NULL),(2,'/datacenter',NULL),(3,'/template',NULL),(4,'/staff',NULL),(5,'/branch',NULL),(6,'/role',NULL),(7,'/property',NULL),(8,'/whitelist',NULL),(9,'/print',NULL),(10,'/modules',NULL),(11,'/robot',NULL),(12,'/command',NULL);
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
  `username` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `activated` tinyint DEFAULT NULL,
  `activationkey` varchar(50) DEFAULT NULL,
  `resetpasswordkey` varchar(50) DEFAULT NULL,
  `id` char(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('admin','admin@qq.com','$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuK',1,NULL,NULL,'1');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` char(32) NOT NULL,
  `user_id` char(32) DEFAULT NULL,
  `role_id` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_role_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','1','1');
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

-- Dump completed on 2020-07-09 16:23:58
