-- DDL CHANGES 
-- CREATED BY : MILAN KAMBOYA
-- CREATED DATE : 12/27/2016
-- Created new table for user role information.

CREATE DATABASE  IF NOT EXISTS `CALENDARAPPDB`;
USE `CALENDARAPPDB`;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `ID` varchar(25) NOT NULL,
  `User_ID` varchar(25) NOT NULL,
  `Role` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ROLES_USER_ID_FK` (`User_ID`),
  CONSTRAINT `USER_ROLES_USER_ID_FK` FOREIGN KEY (`User_ID`) REFERENCES `user_master` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;


-- Increase password column size to store hashing password.
ALTER TABLE calendarappdb.login_master MODIFY password varchar(70);
