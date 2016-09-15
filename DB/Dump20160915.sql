CREATE DATABASE  IF NOT EXISTS `calendarappdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `calendarappdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: calendarappdb
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `event_master`
--

DROP TABLE IF EXISTS `event_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_master` (
  `ID` varchar(25) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Description` blob,
  `Start_Date` date NOT NULL,
  `Start_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `End_Date` date NOT NULL,
  `End_Time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Repeats` varchar(25) DEFAULT NULL,
  `Shared` blob,
  `User_Id` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Event_Master_User_Id_FK` (`User_Id`),
  CONSTRAINT `Event_Master_User_Id_FK` FOREIGN KEY (`User_Id`) REFERENCES `user_master` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_master`
--

LOCK TABLES `event_master` WRITE;
/*!40000 ALTER TABLE `event_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_master`
--

DROP TABLE IF EXISTS `login_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_master` (
  `ID` varchar(25) NOT NULL,
  `User_Name` varchar(200) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `User_ID` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LOGIN_MASTER_USER_ID_FK` (`User_ID`),
  CONSTRAINT `LOGIN_MASTER_USER_ID_FK` FOREIGN KEY (`User_ID`) REFERENCES `user_master` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_master`
--

LOCK TABLES `login_master` WRITE;
/*!40000 ALTER TABLE `login_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `ID` varchar(25) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) DEFAULT NULL,
  `Gender` varchar(6) DEFAULT NULL,
  `Phone` varchar(13) DEFAULT NULL,
  `Date_Of_Birth` varchar(10) NOT NULL,
  `Address` blob,
  `User_Language` varchar(3) NOT NULL,
  `Time_Zone` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-15 23:09:59
