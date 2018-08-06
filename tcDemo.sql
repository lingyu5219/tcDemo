CREATE DATABASE  IF NOT EXISTS `db_tc_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_tc_demo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_tc_demo
-- ------------------------------------------------------
-- Server version	5.6.33-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_system_author`
--

DROP TABLE IF EXISTS `tb_system_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_system_author` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createBy` varchar(20) NOT NULL,
  `remark` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=1026 DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_system_author`
--

LOCK TABLES `tb_system_author` WRITE;
/*!40000 ALTER TABLE `tb_system_author` DISABLE KEYS */;
INSERT INTO `tb_system_author` VALUES (906,1,79,'2017-05-08 15:53:01','1','超级管理员'),(907,1,78,'2017-05-08 15:53:01','1','超级管理员'),(908,1,77,'2017-05-08 15:53:01','1','超级管理员'),(909,1,76,'2017-05-08 15:53:01','1','超级管理员'),(910,1,75,'2017-05-08 15:53:01','1','超级管理员'),(911,1,74,'2017-05-08 15:53:01','1','超级管理员'),(912,1,73,'2017-05-08 15:53:01','1','超级管理员'),(913,1,72,'2017-05-08 15:53:01','1','超级管理员'),(914,1,71,'2017-05-08 15:53:01','1','超级管理员'),(915,1,68,'2017-05-08 15:53:01','1','超级管理员'),(916,1,67,'2017-05-08 15:53:01','1','超级管理员'),(917,1,66,'2017-05-08 15:53:01','1','超级管理员'),(918,1,65,'2017-05-08 15:53:01','1','超级管理员'),(919,1,64,'2017-05-08 15:53:01','1','超级管理员'),(920,1,63,'2017-05-08 15:53:01','1','超级管理员'),(921,1,62,'2017-05-08 15:53:01','1','超级管理员'),(922,1,61,'2017-05-08 15:53:01','1','超级管理员'),(923,1,60,'2017-05-08 15:53:01','1','超级管理员'),(924,1,59,'2017-05-08 15:53:01','1','超级管理员'),(925,1,58,'2017-05-08 15:53:01','1','超级管理员'),(926,1,57,'2017-05-08 15:53:01','1','超级管理员'),(927,1,56,'2017-05-08 15:53:01','1','超级管理员'),(928,1,55,'2017-05-08 15:53:01','1','超级管理员'),(929,1,54,'2017-05-08 15:53:01','1','超级管理员'),(930,1,53,'2017-05-08 15:53:01','1','超级管理员'),(931,1,52,'2017-05-08 15:53:01','1','超级管理员'),(932,1,51,'2017-05-08 15:53:01','1','超级管理员'),(933,1,50,'2017-05-08 15:53:01','1','超级管理员'),(934,1,49,'2017-05-08 15:53:01','1','超级管理员'),(935,1,48,'2017-05-08 15:53:01','1','超级管理员'),(936,1,47,'2017-05-08 15:53:01','1','超级管理员'),(937,1,46,'2017-05-08 15:53:01','1','超级管理员'),(938,1,45,'2017-05-08 15:53:01','1','超级管理员'),(939,1,44,'2017-05-08 15:53:01','1','超级管理员'),(940,1,43,'2017-05-08 15:53:01','1','超级管理员'),(941,1,42,'2017-05-08 15:53:01','1','超级管理员'),(942,1,41,'2017-05-08 15:53:01','1','超级管理员'),(943,1,40,'2017-05-08 15:53:01','1','超级管理员'),(944,1,39,'2017-05-08 15:53:01','1','超级管理员'),(945,1,38,'2017-05-08 15:53:01','1','超级管理员'),(946,1,37,'2017-05-08 15:53:01','1','超级管理员'),(947,1,36,'2017-05-08 15:53:01','1','超级管理员'),(948,1,35,'2017-05-08 15:53:01','1','超级管理员'),(949,1,34,'2017-05-08 15:53:01','1','超级管理员'),(950,1,33,'2017-05-08 15:53:01','1','超级管理员'),(951,1,32,'2017-05-08 15:53:01','1','超级管理员'),(952,1,31,'2017-05-08 15:53:01','1','超级管理员'),(953,1,30,'2017-05-08 15:53:01','1','超级管理员'),(954,1,29,'2017-05-08 15:53:01','1','超级管理员'),(955,1,70,'2017-05-08 15:53:01','1','超级管理员'),(956,1,69,'2017-05-08 15:53:01','1','超级管理员'),(957,1,84,'2017-05-08 15:53:01','1','超级管理员'),(958,1,83,'2017-05-08 15:53:01','1','超级管理员'),(959,1,82,'2017-05-08 15:53:01','1','超级管理员'),(960,1,81,'2017-05-08 15:53:01','1','超级管理员'),(961,1,80,'2017-05-08 15:53:01','1','超级管理员'),(962,14,79,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(963,14,78,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(964,14,77,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(965,14,76,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(966,14,75,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(967,14,74,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(968,14,73,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(969,14,72,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(970,14,71,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(971,14,68,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(972,14,67,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(973,14,66,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(974,14,65,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(975,14,64,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(976,14,63,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(977,14,62,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(978,14,61,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(979,14,60,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(980,14,59,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(981,14,58,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(982,14,57,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(983,14,56,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(984,14,55,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(985,14,54,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(986,14,53,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(987,14,52,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(988,14,51,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(989,14,50,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(990,14,49,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(991,14,48,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(992,14,47,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(993,14,46,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(994,14,45,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(995,14,44,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(996,14,43,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(997,14,42,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(998,14,41,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(999,14,40,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1000,14,39,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1001,14,38,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1002,14,37,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1003,14,36,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1004,14,35,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1005,14,34,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1006,14,33,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1007,14,32,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1008,14,31,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1009,14,30,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1010,14,29,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1011,14,70,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1012,14,69,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1013,14,84,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1014,14,83,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1015,14,82,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1016,14,81,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1017,14,80,'2017-05-09 10:33:20','7','系统管理员角色具有模块管理、菜单管理、角色管理、权限管理、用户管理的功能'),(1018,3,70,'2017-05-09 10:33:39','7',''),(1019,3,69,'2017-05-09 10:33:39','7',''),(1020,3,84,'2017-05-09 10:33:39','7',''),(1021,3,83,'2017-05-09 10:33:39','7',''),(1022,3,82,'2017-05-09 10:33:39','7',''),(1023,3,81,'2017-05-09 10:33:39','7',''),(1024,3,80,'2017-05-09 10:33:39','7',''),(1025,15,70,'2017-05-17 14:53:57','1','');
/*!40000 ALTER TABLE `tb_system_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_system_menu`
--

DROP TABLE IF EXISTS `tb_system_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_system_menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(40) NOT NULL,
  `menuOrder` int(11) DEFAULT NULL COMMENT '菜单排列顺序',
  `moduleId` int(11) NOT NULL COMMENT '菜单所属模块ID',
  `isPublic` varchar(3) DEFAULT NULL COMMENT '1表示公开 2表示不公开 该字段目前无用',
  `isFork` int(11) NOT NULL COMMENT '1表示枝干 2表示叶子',
  `parentId` int(11) DEFAULT NULL COMMENT '菜单的父节点ID 该字段目前无用',
  `location` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createBy` varchar(20) NOT NULL,
  `remark` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`menuId`),
  UNIQUE KEY `menuName` (`menuName`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_system_menu`
--

LOCK TABLES `tb_system_menu` WRITE;
/*!40000 ALTER TABLE `tb_system_menu` DISABLE KEYS */;
INSERT INTO `tb_system_menu` VALUES (29,'模块管理',NULL,1,NULL,1,NULL,'system/moduleList','2017-03-13 12:55:10','1','进入模块管理功能'),(30,'模块查询带分页',NULL,1,NULL,2,NULL,'system/queryModuleList','2017-03-13 12:56:12','1','模块管理查询功能'),(31,'模块增加页面',NULL,1,NULL,2,NULL,'forward?page=system/moduleAdd','2017-03-13 13:06:01','1','增加模块窗口打开的页面'),(32,'模块增加',NULL,1,NULL,2,NULL,'system/addModule','2017-03-13 13:07:16','1','增加模块窗口点击保存按钮时增加一个模块'),(33,'模块修改页面',NULL,1,NULL,2,NULL,'forward?page=system/moduleModify','2017-03-13 13:08:03','1','修改模块窗口打开的页面'),(34,'模块修改',NULL,1,NULL,2,NULL,'system/updateModule','2017-03-13 13:08:41','1','修改模块窗口点击保存按钮修改模块'),(35,'模块查看页面',NULL,1,NULL,2,NULL,'forward?page=system/moduleDetail','2017-03-13 13:09:31','1','查看模块窗口打开的页面'),(36,'模块删除',NULL,1,NULL,2,NULL,'system/delModule','2017-03-13 13:09:57','1','删除一个模块'),(37,'模块查询不带分页',NULL,1,NULL,2,NULL,'system/queryModule','2017-03-13 13:11:03','1','模块下拉框等查询模块数据，不带分页'),(38,'菜单管理',NULL,1,NULL,1,NULL,'system/menuList','2017-03-13 13:32:07','1',''),(39,'菜单查询带分页',NULL,1,NULL,2,NULL,'system/queryMenuList','2017-03-13 13:32:20','1',''),(40,'菜单增加页面',NULL,1,NULL,2,NULL,'forward?page=system/menuAdd','2017-03-13 13:32:34','1',''),(41,'菜单增加',NULL,1,NULL,2,NULL,'system/addMenu','2017-03-13 13:35:06','1',''),(42,'菜单修改页面',NULL,1,NULL,2,NULL,'forward?page=system/menuModify','2017-03-13 14:05:38','1',''),(43,'菜单修改',NULL,1,NULL,2,NULL,'system/updateMenu','2017-03-13 14:06:48','1',''),(44,'菜单查看页面',NULL,1,NULL,2,NULL,'forward?page=system/menuDetail','2017-03-13 14:07:04','1',''),(45,'菜单删除',NULL,1,NULL,2,NULL,'system/delMenu','2017-03-13 14:07:18','1',''),(46,'菜单查询不带分页',NULL,1,NULL,2,NULL,'system/queryMenu','2017-03-13 14:07:32','1',''),(47,'角色管理',NULL,1,NULL,1,NULL,'system/roleList','2017-03-13 14:09:14','1',''),(48,'角色查询带分页',NULL,1,NULL,2,NULL,'system/queryRoleList','2017-03-13 14:09:27','1',''),(49,'角色增加页面',NULL,1,NULL,2,NULL,'forward?page=system/roleAdd','2017-03-13 14:09:41','1',''),(50,'角色增加',NULL,1,NULL,2,NULL,'system/addRole','2017-03-13 14:09:53','1',''),(51,'角色修改页面',NULL,1,NULL,2,NULL,'forward?page=system/roleModify','2017-03-13 14:10:09','1',''),(52,'角色修改',NULL,1,NULL,2,NULL,'system/updateRole','2017-03-13 14:10:23','1',''),(53,'角色查看页面',NULL,1,NULL,2,NULL,'forward?page=system/roleDetail','2017-03-13 14:10:39','1',''),(54,'角色删除',NULL,1,NULL,2,NULL,'system/delRole','2017-03-13 14:10:52','1',''),(55,'角色查询不带分页',NULL,1,NULL,2,NULL,'system/queryRole','2017-03-13 14:11:06','1',''),(56,'权限管理',NULL,1,NULL,1,NULL,'system/authorList','2017-03-13 14:12:32','1',''),(57,'权限查询带分页',NULL,1,NULL,2,NULL,'system/queryAuthorList','2017-03-13 14:12:44','1',''),(58,'权限修改页面',NULL,1,NULL,2,NULL,'forward?page=system/authorModify','2017-03-13 14:12:58','1',''),(59,'权限修改',NULL,1,NULL,2,NULL,'system/updateAuthor','2017-03-13 14:13:12','1',''),(60,'权限查看页面',NULL,1,NULL,2,NULL,'forward?page=system/authorDetail','2017-03-13 14:13:25','1',''),(61,'用户管理',NULL,1,NULL,1,NULL,'system/userList','2017-03-13 14:21:28','1',''),(62,'用户查询带分页',NULL,1,NULL,2,NULL,'system/queryUserList','2017-03-13 14:21:48','1',''),(63,'用户增加页面',NULL,1,NULL,2,NULL,'forward?page=system/userAdd','2017-03-13 14:22:03','1',''),(64,'用户增加',NULL,1,NULL,2,NULL,'system/addUser','2017-03-13 14:22:17','1',''),(65,'用户修改页面',NULL,1,NULL,2,NULL,'forward?page=system/userModify','2017-03-13 14:22:30','1',''),(66,'用户修改',NULL,1,NULL,2,NULL,'system/updateUser','2017-03-13 14:22:43','1',''),(67,'用户查看页面',NULL,1,NULL,2,NULL,'forward?page=system/userDetail','2017-03-13 14:22:56','1',''),(68,'用户删除',NULL,1,NULL,2,NULL,'system/delUser','2017-03-13 14:23:11','1',''),(69,'上下班签到考勤',NULL,6,NULL,2,NULL,'atndmgt/signIn','2017-03-30 22:07:25','1','上下班签到打卡'),(70,'考勤记录',NULL,6,NULL,1,NULL,'atndmgt/signInList','2017-03-30 22:29:19','1','查看个人考勤签到记录'),(71,'系统公告管理',NULL,1,NULL,1,NULL,'system/noticeList','2017-05-04 13:00:04','1',''),(72,'系统公告查询带分页',NULL,1,NULL,2,NULL,'system/queryNoticeList','2017-05-04 13:00:24','1',''),(73,'系统公告增加页面',NULL,1,NULL,2,NULL,'forward?page=system/noticeAdd','2017-05-04 13:00:40','1',''),(74,'系统公告增加',NULL,1,NULL,2,NULL,'system/addNotice','2017-05-04 13:00:54','1',''),(75,'系统公告修改页面',NULL,1,NULL,2,NULL,'forward?page=system/noticeModify','2017-05-04 13:01:06','1',''),(76,'系统公告修改',NULL,1,NULL,2,NULL,'system/updateNotice','2017-05-04 13:01:18','1',''),(77,'系统公告查看页面',NULL,1,NULL,2,NULL,'forward?page=system/noticeDetail','2017-05-04 13:01:33','1',''),(78,'系统公告删除',NULL,1,NULL,2,NULL,'system/delNotice','2017-05-04 13:01:47','1',''),(79,'系统公告发布/撤销',NULL,1,NULL,2,NULL,'system/publishNotice','2017-05-04 13:02:11','1',''),(80,'系统消息',NULL,21,NULL,1,NULL,'msgmgt/msgList','2017-05-05 14:19:55','1',''),(81,'系统消息列表查询带分页',NULL,21,NULL,2,NULL,'msgmgt/queryMsgList','2017-05-05 14:20:10','1',''),(82,'系统消息详情页面',NULL,21,NULL,2,NULL,'msgmgt/msgDetail','2017-05-05 14:20:26','1',''),(83,'系统消息websocket广播服务',NULL,21,NULL,2,NULL,'notice/ws','2017-05-05 14:20:50','1',''),(84,'head区域消息提示',NULL,21,NULL,2,NULL,'msgmgt/queryMsg','2017-05-08 15:49:37','7','head区域用于查询当前登录用户未读消息列表');
/*!40000 ALTER TABLE `tb_system_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_system_module`
--

DROP TABLE IF EXISTS `tb_system_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_system_module` (
  `moduleId` int(11) NOT NULL AUTO_INCREMENT,
  `moduleName` varchar(16) NOT NULL,
  `createBy` int(11) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'model create time',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`moduleId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='系统模块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_system_module`
--

LOCK TABLES `tb_system_module` WRITE;
/*!40000 ALTER TABLE `tb_system_module` DISABLE KEYS */;
INSERT INTO `tb_system_module` VALUES (1,'系统管理模块',1,'2016-12-28 15:00:24','模块管理、菜单管理、用户管理、角色管理、权限配置、系统参数、系统公告'),(2,'组织管理模块',1,'2016-12-28 15:00:33','组织管理模块'),(3,'资产管理模块',1,'2016-12-28 15:00:46','资产管理模块'),(4,'人事管理模块',1,'2016-12-28 15:01:04','人事管理模块'),(5,'学生管理模块',1,'2016-12-28 15:01:15','学生管理模块'),(6,'考勤管理模块',1,'2016-12-28 15:01:28',NULL),(7,'教务管理模块',1,'2016-12-28 15:01:51',NULL),(8,'学习管理模块',1,'2016-12-28 15:02:03',NULL),(9,'成绩管理模块',1,'2016-12-28 15:02:23',NULL),(10,'就业管理模块',1,'2016-12-30 14:30:20',NULL),(20,'系统架构模块',1,'2017-02-15 17:32:31','系统架构'),(21,'消息中心',1,'2017-05-04 11:38:42','该模块主要负责用户系统公告查询功能');
/*!40000 ALTER TABLE `tb_system_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_system_role`
--

DROP TABLE IF EXISTS `tb_system_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_system_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(40) NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createBy` varchar(20) NOT NULL,
  `remark` varchar(40) DEFAULT NULL,
  `isDefault` int(1) DEFAULT '1' COMMENT '是否默认角色 1否 2是',
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleName` (`roleName`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_system_role`
--

LOCK TABLES `tb_system_role` WRITE;
/*!40000 ALTER TABLE `tb_system_role` DISABLE KEYS */;
INSERT INTO `tb_system_role` VALUES (0,'匿名用户','2017-10-23 16:26:46','1',NULL,1),(1,'超级管理员','2016-12-29 15:50:46','1','超级管理员角色',1),(3,'学生',NULL,'1','默认学生角色',2),(14,'系统管理员','2017-03-13 14:26:37','1','主要负责系统配置管理',1),(15,'考勤管理员','2017-05-17 14:53:27','1','',1);
/*!40000 ALTER TABLE `tb_system_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_system_user`
--

DROP TABLE IF EXISTS `tb_system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_system_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL DEFAULT '3',
  `userName` varchar(40) NOT NULL,
  `userPassword` varchar(15) NOT NULL,
  `picPath` varchar(60) DEFAULT 'static/images/man.png',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createBy` varchar(20) DEFAULT NULL,
  `remark` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_system_user`
--

LOCK TABLES `tb_system_user` WRITE;
/*!40000 ALTER TABLE `tb_system_user` DISABLE KEYS */;
INSERT INTO `tb_system_user` VALUES (1,1,'admin','123456','static/upload/pic/user/20170310/1.jpg','2017-03-16 12:04:14','1','超级管理员'),(7,14,'huchaofan','huchaofan','static/images/women.png','2017-03-13 14:29:56','1',''),(8,14,'test','test',NULL,'2017-03-15 13:26:55','1','test'),(11,3,'121212334456','121212',NULL,'2017-03-16 10:31:07','0','哈哈哈哈'),(14,3,'201340703301','201340703301',NULL,'2017-03-16 11:19:55','1',NULL),(15,3,'201340703302','201340703302',NULL,'2017-03-16 11:31:04','1',NULL),(17,3,'201340703303','201340703303',NULL,'2017-03-16 13:44:08','1',NULL),(18,3,'201340703304','201340703304',NULL,'2017-03-16 14:03:35','1',NULL),(19,3,'201340703306','201340703306',NULL,'2017-03-16 22:50:59','0',NULL),(20,3,'201340703307','201340703307',NULL,'2017-03-16 22:56:02','0',NULL),(22,3,'201340703338','201340703338',NULL,'2017-03-16 23:07:31','0',NULL),(24,3,'201340703308','201340703308',NULL,'2017-03-20 15:52:19','0',NULL),(27,3,'201340703309','201340703309',NULL,'2017-03-22 10:39:20','0',NULL),(28,3,'201340703314','201340703314',NULL,'2017-03-22 10:49:08','0',NULL),(29,3,'201340703315','201340703315',NULL,'2017-03-22 10:52:25','0',NULL),(30,3,'201340703316','201340703316',NULL,'2017-03-22 10:56:09','0',NULL),(31,3,'201340703317','201340703317',NULL,'2017-03-22 11:10:11','0',NULL),(32,3,'201340703319','201340703319',NULL,'2017-03-22 11:12:58','0',NULL),(34,3,'201340703321','201340703321',NULL,'2017-03-22 11:42:40','0',NULL),(35,3,'201340703322','201340703322',NULL,'2017-03-22 11:44:41','0',NULL),(36,3,'201340703323','201340703323',NULL,'2017-03-22 11:46:33','0',NULL),(37,3,'201340703324','201340703324',NULL,'2017-03-22 15:25:06','0',NULL),(39,3,'201340703325','201340703325',NULL,'2017-03-22 15:31:31','0',NULL),(40,3,'201340703320','201340703320',NULL,'2017-03-22 15:55:42','0',NULL),(41,3,'201340703327','201340703327',NULL,'2017-03-29 15:22:07','0',NULL),(42,15,'kaoqin','123456',NULL,'2017-05-17 14:54:24','1',''),(43,0,'noname','123456','static/images/man.png','2017-10-23 16:27:42','1',NULL);
/*!40000 ALTER TABLE `tb_system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_tc_demo'
--

--
-- Dumping routines for database 'db_tc_demo'
--
/*!50003 DROP PROCEDURE IF EXISTS `proc_perfmgt_attend` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`edumgt_webapp`@`%` PROCEDURE `proc_perfmgt_attend`(
TIME1 VARCHAR(10),
TIME2 VARCHAR(10),
in inyear VARCHAR(10),
in inmajor VARCHAR(10),
in inclass VARCHAR(10),
in instuname VARCHAR(10),
in instuno VARCHAR(10),
in inuserid int,
in inflag int,
in instart int,
in inlength int
)
BEGIN
select tst.userId,tst.stuName,tst.stuNo,ty.description as yearName,tm.majorName,tc.batchName,t3.signinDays,t4.leaveDays,
(	select count(1) 
    from tb_system_calendar 
	where calendarType='1' 
	and calendarDate between TIME1 and TIME2 
    )as totalDays
from tb_stumgt_student tst
left join tb_stumgt_batch tc on tst.batchId = tc.batchId
left join tb_edumgt_year ty on tc.yearId = ty.yearId
left join tb_edumgt_major tm on tc.majorId = tm.majorId
left join( 
	select t1.userId,count(t1.createTime) signinDays
	from(
		select ts.userId, ti.createTime
		from tb_stumgt_student ts 
		join (
			select userId, DATE_FORMAT(createTime, '%Y-%m-%d') createTime 
			from tb_atndmgt_signin 
			where DATE_FORMAT(createTime, '%Y-%m-%d') between TIME1 and TIME2
			group by userId, DATE_FORMAT(createTime, '%Y-%m-%d')
		) ti on ts.userId = ti.userId
		join tb_system_calendar tl on tl.calendarDate = ti.createTime
		where tl.calendarType = '1'
	)t1
	group by t1.userId
)t3 on t3.userId=tst.userId
left join(
	select tal2.userId,count(userId) as leaveDays
	from tb_atndmgt_leavetime as tal
	left join tb_atndmgt_leave as tal2 on tal.leaveId=tal2.leaveId
	where DATE_FORMAT(tal.leaveDate, '%Y-%m-%d') between TIME1 and TIME2
	group by userId
) t4 on t4.userId=tst.userId
where ty.description=inyear  COLLATE utf8_unicode_ci
or tm.majorName=inmajor  COLLATE utf8_unicode_ci
or tc.batchName=inclass  COLLATE utf8_unicode_ci
or tst.stuName like instuname  COLLATE utf8_unicode_ci
or tst.stuNo like instuno COLLATE utf8_unicode_ci
or tst.userId=inuserid
or 1=inflag
order by tst.userId
limit instart,inlength;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_perfmgt_attend_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`edumgt_webapp`@`%` PROCEDURE `proc_perfmgt_attend_count`(
TIME1 VARCHAR(10),
TIME2 VARCHAR(10),
in inyear VARCHAR(10),
in inmajor VARCHAR(10),
in inclass VARCHAR(10),
in instuname VARCHAR(10),
in instuno VARCHAR(10),
in inuserid int,
in inflag int
)
BEGIN
select count(*)
from tb_stumgt_student tst
left join tb_stumgt_batch tc on tst.batchId = tc.batchId
left join tb_edumgt_year ty on tc.yearId = ty.yearId
left join tb_edumgt_major tm on tc.majorId = tm.majorId
left join( 
	select t1.userId,count(t1.createTime) signinDays
	from(
		select ts.userId, ti.createTime
		from tb_stumgt_student ts 
		join (
			select userId, DATE_FORMAT(createTime, '%Y-%m-%d') createTime 
			from tb_atndmgt_signin 
			where DATE_FORMAT(createTime, '%Y-%m-%d') between TIME1 and TIME2
			group by userId, DATE_FORMAT(createTime, '%Y-%m-%d')
		) ti on ts.userId = ti.userId
		join tb_system_calendar tl on tl.calendarDate = ti.createTime
		where tl.calendarType = '1'
	)t1
	group by t1.userId
)t3 on t3.userId=tst.userId
left join(
	select tal2.userId,count(userId) as leaveDays
	from tb_atndmgt_leavetime as tal
	left join tb_atndmgt_leave as tal2 on tal.leaveId=tal2.leaveId
	where DATE_FORMAT(tal.leaveDate, '%Y-%m-%d') between TIME1 and TIME2
	group by userId
) t4 on t4.userId=tst.userId
where ty.description=inyear  COLLATE utf8_unicode_ci
or tm.majorName=inmajor  COLLATE utf8_unicode_ci
or tc.batchName=inclass  COLLATE utf8_unicode_ci
or tst.stuName like instuname  COLLATE utf8_unicode_ci
or tst.stuNo like instuno COLLATE utf8_unicode_ci
or tst.userId=inuserid
or 1=inflag
order by tst.userId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_perfmgt_score` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`edumgt_webapp`@`%` PROCEDURE `proc_perfmgt_score`(
in inuserId int,
in instuId VARCHAR(10),
in instuName VARCHAR(10),
in incourseName VARCHAR(10),
in inbatchName VARCHAR(10),
in inmajorName VARCHAR(10),
in intermName VARCHAR(10),
in inyearName VARCHAR(10),
in inflag int,
in instart int,
in inlength int
)
BEGIN

select tstu.userId,tstu.stuId,tstu.stuName,tb.batchName,tma.majorName,ty.description as yearName,CONCAT( tt.YEAR,tt.sylQuarter) as termName,tc.cName as courseName,tc.cId as courseId,ts.score
from 
(
select YEAR,sylQuarter,classId,coursesId from tb_edumgt_syllabus tsbus
left join tb_edumgt_sybitem tsitem on tsitem.syllabusId=tsbus.id
where tsitem.isDel=0 and tsbus.isDel=0
group by tsbus.id
) tt
left join tb_edumgt_course tc on tc.cId=tt.coursesId
left join tb_stumgt_batch tb on tb.batchId=tt.classId
left join tb_edumgt_year ty on ty.yearId=tb.yearId
left join tb_edumgt_major tma on tma.majorId=tb.majorId
left join tb_stumgt_student tstu on tb.batchId=tstu.batchId
left join tb_perfmgt_score ts on ts.scoreCourseId=tc.cId 
where 
 tstu.userId=inuserId 
or tstu.stuId=instuId  COLLATE utf8_unicode_ci
or tstu.stuName =instuName  COLLATE utf8_unicode_ci
or tc.cName=incourseName COLLATE utf8_unicode_ci
or tb.batchName=inbatchName COLLATE utf8_unicode_ci
or tma.majorName=inmajorName  COLLATE utf8_unicode_ci
or CONCAT(tt.YEAR,tt.sylQuarter)=intermName  COLLATE utf8_unicode_ci
or ty.description=inyearName   COLLATE utf8_unicode_ci
or 1=inflag
limit instart,inlength;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_perfmgt_score_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`edumgt_webapp`@`%` PROCEDURE `proc_perfmgt_score_count`(
in inuserId int,
in instuId VARCHAR(10),
in instuName VARCHAR(10),
in incourseName VARCHAR(10),
in inbatchName VARCHAR(10),
in inmajorName VARCHAR(10),
in intermName VARCHAR(10),
in inyearName VARCHAR(10),
in inflag int
)
BEGIN

select count(tc.cId)
from tb_stumgt_student tstu
left join tb_stumgt_batch tb on tb.batchId=tstu.batchId
left join tb_edumgt_year ty on ty.yearId=tb.yearId
left join tb_edumgt_major tma on tma.majorId=tb.majorId
left join tb_edumgt_syllabus tsbus on tsbus.classId=tstu.batchId
left join tb_edumgt_sybitem tsitem on tsitem.syllabusId=tsbus.id
left join tb_edumgt_course tc on tc.cId=tsitem.coursesId
left join tb_perfmgt_score ts on ts.scoreCourseId=tc.cId 
where tsitem.isDel=0 and tsbus.isDel=0
and(
 tstu.userId=inuserId 
or tstu.stuId=instuId  COLLATE utf8_unicode_ci
or tstu.stuName =instuName  COLLATE utf8_unicode_ci
or tc.cName=incourseName COLLATE utf8_unicode_ci
 or tb.batchName=inbatchName COLLATE utf8_unicode_ci
 or tma.majorName=inmajorName  COLLATE utf8_unicode_ci
 or CONCAT(tsbus.YEAR,tsbus.sylQuarter)=intermName  COLLATE utf8_unicode_ci
 or ty.description=inyearName   COLLATE utf8_unicode_ci
 or 1=inflag)
group by tc.cId,tstu.stuId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-06 20:16:15
