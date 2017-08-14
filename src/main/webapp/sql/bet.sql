CREATE DATABASE  IF NOT EXISTS `betworld` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `betworld`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: betworld
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
-- Table structure for table `ball_bet_run`
--

DROP TABLE IF EXISTS `ball_bet_run`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ball_bet_run` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `matchId` int(11) DEFAULT NULL,
  `playerId` int(11) DEFAULT NULL,
  `runs` int(11) DEFAULT NULL,
  `over` float DEFAULT NULL,
  `ball` float DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `staticBetRuleId` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_mapping_idx` (`playerId`),
  KEY `match_mapping_idx` (`matchId`),
  KEY `ruleID_mapping_idx` (`staticBetRuleId`),
  CONSTRAINT `match_mapping` FOREIGN KEY (`matchId`) REFERENCES `match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `player_mapping` FOREIGN KEY (`playerId`) REFERENCES `player` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ruleID_mapping` FOREIGN KEY (`staticBetRuleId`) REFERENCES `match_bet_applicable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ball_bet_run`
--

LOCK TABLES `ball_bet_run` WRITE;
/*!40000 ALTER TABLE `ball_bet_run` DISABLE KEYS */;
INSERT INTO `ball_bet_run` VALUES (1,1,1,2,1,1,2345,1,'A',NULL,NULL);
/*!40000 ALTER TABLE `ball_bet_run` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `city_country_id` FOREIGN KEY (`id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Madurai',1),(4,'chennai',1),(7,'chennai',1),(10,'test city',1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(100) NOT NULL,
  `population` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'India',20000000),(2,'India',20000000),(4,'Pak',20000000),(7,'India',20000000),(10,'Africa',20000000),(11,'India',20000000),(12,'Thailandxxxxx',20000000),(13,'testcountry',9090),(14,'',9090);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamA` int(11) DEFAULT NULL,
  `teamB` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `seriesId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teamA_mapping_idx` (`teamA`),
  KEY `teamB_mapping_idx` (`teamB`),
  KEY `series_mapping_idx` (`seriesId`),
  CONSTRAINT `series_mapping` FOREIGN KEY (`seriesId`) REFERENCES `series` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamA_mapping` FOREIGN KEY (`teamA`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamB_mapping` FOREIGN KEY (`teamB`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,1,1,'a','jkhjk hh  kjh',NULL,NULL,NULL,NULL,1),(2,1,1,'a','useless match',NULL,NULL,NULL,NULL,1),(6,1,1,'a','test x match',NULL,NULL,NULL,NULL,NULL),(7,1,1,'a','test x match',NULL,NULL,NULL,NULL,1),(8,1,1,'a','test x match',NULL,NULL,NULL,NULL,1),(9,NULL,1,'a','test x match',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match_bet_applicable`
--

DROP TABLE IF EXISTS `match_bet_applicable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match_bet_applicable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matchId` int(11) DEFAULT NULL,
  `staticBetId` int(11) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `value` float DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `match_bet_idx` (`matchId`),
  KEY `bet_for_match_idx` (`staticBetId`),
  CONSTRAINT `bet_for_match` FOREIGN KEY (`staticBetId`) REFERENCES `static_bet_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `match_bet` FOREIGN KEY (`matchId`) REFERENCES `match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_bet_applicable`
--

LOCK TABLES `match_bet_applicable` WRITE;
/*!40000 ALTER TABLE `match_bet_applicable` DISABLE KEYS */;
INSERT INTO `match_bet_applicable` VALUES (1,1,1,NULL,NULL,100,10,'a');
/*!40000 ALTER TABLE `match_bet_applicable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_wallet`
--

DROP TABLE IF EXISTS `my_wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `peron_wallet_idx` (`person_id`),
  CONSTRAINT `peron_wallet` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_wallet`
--

LOCK TABLES `my_wallet` WRITE;
/*!40000 ALTER TABLE `my_wallet` DISABLE KEYS */;
INSERT INTO `my_wallet` VALUES (1,1,12345,NULL,NULL),(2,1,1234567,NULL,NULL);
/*!40000 ALTER TABLE `my_wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `viewName` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'venkatesh',31,'venkateshjramesh@gmail.com','1234567890','attacky',NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `viewName` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tam_player_mapping_idx` (`team_id`),
  CONSTRAINT `tam_player_mapping` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'sachin',1,'useless match','tendulkar',NULL,NULL),(2,'sachin',1,'useless match','tendulkar',NULL,NULL),(3,'sachin',1,'useless match','tendulkar',NULL,NULL),(4,'sachin',1,'useless match','tendulkar',NULL,NULL);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,'ipl','ipl series',NULL,NULL);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `static_bet_type`
--

DROP TABLE IF EXISTS `static_bet_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `static_bet_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule` varchar(45) DEFAULT NULL,
  `displayName` varchar(45) DEFAULT NULL,
  `betType` varchar(45) DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `static_bet_type`
--

LOCK TABLES `static_bet_type` WRITE;
/*!40000 ALTER TABLE `static_bet_type` DISABLE KEYS */;
INSERT INTO `static_bet_type` VALUES (1,'SBBR','Single Ball Bet - Runs','person',NULL,NULL),(2,'SBBW','Single Ball Bet - Wicket','person',NULL,NULL),(3,'SOBR','Single Over Bet - Runs','person',NULL,NULL),(4,'SOBW','Single Over Bet - Wicket','person',NULL,NULL),(5,'MOTM','Man of the Match','person',NULL,NULL),(6,'MOTS','Man of the Series','person',NULL,NULL),(7,'MW','Match Winner','team',NULL,NULL),(8,'SW','Series Winner','team',NULL,NULL),(9,'TS','Toss Winner','team',NULL,NULL),(10,'MSP','Max Sixes','player',NULL,NULL),(11,'MST','Max Sixes','team',NULL,NULL),(12,'MFP','Max Fours','player',NULL,NULL),(13,'MFT','MAx Fours','team',NULL,NULL);
/*!40000 ALTER TABLE `static_bet_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `photoId` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `viewName` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'india','1234','this is a test','rockers',NULL,NULL),(2,'india','1234','this is a test','rockers',NULL,NULL);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet_transaction`
--

DROP TABLE IF EXISTS `wallet_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wallet_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wallet_id` int(11) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `transactionType` varchar(45) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `wallet_transaction_idx` (`wallet_id`),
  CONSTRAINT `wallet_transaction` FOREIGN KEY (`wallet_id`) REFERENCES `my_wallet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet_transaction`
--

LOCK TABLES `wallet_transaction` WRITE;
/*!40000 ALTER TABLE `wallet_transaction` DISABLE KEYS */;
INSERT INTO `wallet_transaction` VALUES (1,1,1248997,'Credit',NULL,NULL),(2,1,1248997,'Credit',NULL,NULL),(3,1,1248997,'Credit',NULL,NULL),(4,1,1248997,'Credit',NULL,NULL),(5,1,1248997,'Credit',NULL,NULL);
/*!40000 ALTER TABLE `wallet_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'betworld'
--

--
-- Dumping routines for database 'betworld'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 17:00:12
