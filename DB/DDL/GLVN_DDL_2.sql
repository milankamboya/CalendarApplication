-- DDL CHANGES 
-- CREATED BY : MILAN KAMBOYA
-- CREATED DATE : 12/19/2016
-- Created new table for SignUp Confirmation info.

CREATE DATABASE  IF NOT EXISTS `CALENDARAPPDB`;
USE `CALENDARAPPDB`;

-- Create index on email column otherwise foreign key form user_signup_confirmation table will not be apply.
-- This creating index will work only in few DBMS. 
-- In other dbs where this is not supported, you have to create unique key on that column.
CREATE UNIQUE INDEX `UX01_User_Master_email` ON calendarappdb.user_master(email);

-- Change Address column type from blob to address as it is not working propery in SPRING MVC binding.
ALTER TABLE calendarappdb.user_master MODIFY address varchar(500);



--
-- Table structure for table `user_signup_confirmation`
--

DROP TABLE IF EXISTS `user_signup_confirmation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_signup_confirmation` (
  `ID` varchar(25) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Confirmation_Token` varchar(32) NOT NULL,
  `Is_Signup_Confirmed` char(1) NOT NULL,
  `Time_Stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `User_Signup_Confirmation_Email_FK` (`Email`),
  CONSTRAINT `User_Signup_Confirmation_Email_FK` FOREIGN KEY (`Email`) REFERENCES `user_master` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_signup_confirmation`
--

LOCK TABLES `user_signup_confirmation` WRITE;
/*!40000 ALTER TABLE `user_signup_confirmation` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_signup_confirmation` ENABLE KEYS */;
UNLOCK TABLES;
