-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketplatform
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.10-MariaDB

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketsellerid` int(11) NOT NULL DEFAULT 0,
  `titleofevent` varchar(30) NOT NULL,
  `placeofevent` varchar(30) NOT NULL,
  `description` tinytext NOT NULL DEFAULT '',
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `localtimeofshow` time NOT NULL,
  `priceofticket` varchar(10) NOT NULL,
  `picture` longblob DEFAULT NULL,
  `numberoftickets` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_event_ticketseller` (`ticketsellerid`),
  CONSTRAINT `fk_event_ticketseller` FOREIGN KEY (`ticketsellerid`) REFERENCES `ticketseller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (16,6,'titleA','placeA','descriptionA','2020-01-01','2020-01-10','10:00:00','$50',NULL,1000,'2020-02-22 22:41:52'),(17,7,'titleB','placeB','descriptionB','2020-02-01','2020-02-10','10:00:00','$60',NULL,2000,'2020-02-22 22:43:01'),(18,8,'titleC','placeC','descriptionC','2020-03-01','2020-03-10','10:00:00','$70',NULL,3000,'2020-02-22 22:43:39'),(19,9,'titleD','placeD','descriptionD','2020-04-01','2020-04-10','10:00:00','$80',NULL,4000,'2020-02-22 22:44:10'),(20,10,'titleE','placeE','descriptionE','2020-05-01','2020-05-10','10:00:00','$90',NULL,5000,'2020-02-22 22:44:40'),(21,11,'titleF','placeF','descriptionF','2020-06-01','2020-06-10','10:00:00','$100',NULL,6000,'2020-02-22 22:45:13'),(22,12,'titleG','placeG','descriptionG','2020-07-01','2020-07-10','10:00:00','$40',NULL,7000,'2020-02-22 22:45:50'),(23,13,'titleH','placeH','descriptionH','2020-08-01','2020-08-10','10:00:00','$30',NULL,8000,'2020-02-22 22:46:22'),(24,14,'titleI','placeI','descriptionI','2020-09-01','2020-09-10','10:00:00','$20',NULL,9000,'2020-02-22 22:46:54'),(25,15,'titleJ','placeJ','descriptionJ','2020-10-01','2020-10-10','10:00:00','$110',NULL,10000,'2020-02-22 22:47:29');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketbuyerid` int(11) NOT NULL DEFAULT 0,
  `eventid` int(11) NOT NULL DEFAULT 0,
  `ticketsellerid` int(11) NOT NULL DEFAULT 0,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `fk_ticket_ticketbuyer` (`ticketbuyerid`),
  KEY `fk_ticket_ticketseller` (`ticketsellerid`),
  KEY `fk_ticket_event` (`eventid`),
  CONSTRAINT `fk_ticket_event` FOREIGN KEY (`eventid`) REFERENCES `event` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ticket_ticketbuyer` FOREIGN KEY (`ticketbuyerid`) REFERENCES `ticketbuyer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ticket_ticketseller` FOREIGN KEY (`ticketsellerid`) REFERENCES `ticketseller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (12,18,17,7,'2020-03-10 16:17:50'),(13,24,21,11,'2020-03-10 16:42:16'),(15,21,17,7,'2020-05-26 00:17:20'),(16,28,21,11,'2020-05-31 02:24:11'),(17,21,20,10,'2020-05-31 03:57:29');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketbuyer`
--

DROP TABLE IF EXISTS `ticketbuyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketbuyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `password` varchar(70) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketbuyer`
--

LOCK TABLES `ticketbuyer` WRITE;
/*!40000 ALTER TABLE `ticketbuyer` DISABLE KEYS */;
INSERT INTO `ticketbuyer` VALUES (18,'buyerAfirst','buyerAlast','addressBuyerA','email@buyerA','111111111111','$2a$10$g0kKHSghhDyEhMDQZ0jKDuQwRMHHdaTvP.a2rAeHFoKq6Rm0bptzG','BUYER'),(19,'buyerBfirst','buyerBlast','addressBuyerB','email@buyerB','2222222222','$2a$10$Iw2Aiv6A8N9s5fvIczjt2uGWznVF3bTSnzeWNalAOTizINzl44Oym','BUYER'),(20,'buyerCfirst','buyerClast','addressBuyerC','email@buyerC','3333333333','$2a$10$4b124dXamerLeZCi3gSSj.JHcn503N6WP06UIo5dCEXFMkuEiPsdG','BUYER'),(21,'buyerDfirst','buyerDlast','addressBuyerD','email@buyerD','4444444444','$2a$10$A.scFwf7.zCCT0T8yWvzgu..4IFh/yxS7qa5MqgMhjH1eHUoVuhni','BUYER'),(22,'buyerEfirst','buyerElast','addressBuyerE','email@buyerE','5555555555','$2a$10$LW3b/3NPbCpHUMuJ8BZI8ettgPGUiVD0PK4EaQnJfZTbVwf2rYeSW','BUYER'),(23,'buyerFfirst','buyerFlast','addressBuyerF','email@buyerF','6666666666','$2a$10$Nwvnj71/D9s2z4Sv2Zb5yO./0QBXr/Yi79vaCYm6XumVkHKa/FREe','BUYER'),(24,'buyerGfirst','buyerGlast','addressBuyerG','email@buyerG','7777777777','$2a$10$A0GIMlqIZBSIUr2.x96xc.sR.CbGA3tmt3PGhiMaOkza7YtWj16MW','BUYER'),(25,'buyerHfirst','buyerHlast','addressBuyerH','email@buyerH','8888888888','$2a$10$LIZLgwo351kQY1uto2.kL.V1S/mWRcdjMDipENp7ZyDKYfC9ZZS5.','BUYER'),(26,'buyerIfirst','buyerIlast','addressBuyerI','email@buyerI','9999999999','$2a$10$.qXIGqlklMeHirZDwIFhS.OCmmmtCL95qyf94G/6bonaqKVLUi38q','BUYER'),(27,'buyerJfirst','buyerJlast','addressBuyerJ','email@buyerJ','1234567890','$2a$10$pPLOMuq9yU0AWh34Ju/Uxut.J6fxDuslccgiPmLRdxX4DJUieXTbG','BUYER'),(28,'buyer','buyer','address','email@buyer.com','1111111111','$2a$10$pAUJoRhX4ajlcqqIYe0cDuR7dKahzZCge.OcnQO2NpcxnZEjvhPRe','BUYER');
/*!40000 ALTER TABLE `ticketbuyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketseller`
--

DROP TABLE IF EXISTS `ticketseller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketseller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orgname` varchar(30) NOT NULL,
  `orgaddress` varchar(50) NOT NULL,
  `webaddress` varchar(20) NOT NULL,
  `contactfirstname` varchar(30) DEFAULT NULL,
  `contactlastname` varchar(30) DEFAULT NULL,
  `contactemail` varchar(30) NOT NULL,
  `contactphone` varchar(30) DEFAULT NULL,
  `password` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketseller`
--

LOCK TABLES `ticketseller` WRITE;
/*!40000 ALTER TABLE `ticketseller` DISABLE KEYS */;
INSERT INTO `ticketseller` VALUES (6,'companyA','addressA','webaddressA','contactfirstA','contactlastA','email@companyA','+11111111111','$2a$10$h9yVhpXxR6YGF9gk5qWdRO3EZ5aA4pnVusXqWsnHwHLsVAyUTNwZq'),(7,'companyB','addressB','webaddressB','contactfirstB','contactlastB','email@companyB','+2222222222','$2a$10$juKVVQUJpORoekv75jqR.uJ1V8h90enMW79iQ4umbx78TJsx9x6uq'),(8,'companyC','addressC','webaddressC','contactfirstC','contactlastC','email@companyC','3333333333','$2a$10$TnysK3uQTxDf8amqZWrEle915nOxFyQNcwmx8337/THVphTffmu6W'),(9,'companyD','addressD','webaddressD','contactfirstD','contactlastD','email@companyD','4444444444','$2a$10$f4UFxdZhx2ezFgoVfIgU0uOpqHWxfDmFBUJ/HkM2VGPowcRVP2BoO'),(10,'companyE','addressE','webaddressE','contactfirstE','contactlastE','email@companyE','5555555555','$2a$10$egqf/aA90TGycKiplFuh.OeD64oRGhRLiXZ6OyNEoFYeWLYRwDdje'),(11,'companyF','addressF','webaddressF','contactfirstF','contactlastF','email@companyF','6666666666','$2a$10$OHCIULfNdpyyPNIEnsHLNeTh875qw7LztWIKqjGl/XckplJHG7BV.'),(12,'companyG','addressG','webaddressG','contactfirstG','contactlastG','email@companyG','7777777777','$2a$10$eG03.1veb/zu7BeyWYN91..RFYWp1wRndTE2AqsM93p.MsX68zJem'),(13,'companyH','addressH','webaddressH','contactfirstH','contactlastH','email@companyH','8888888888','$2a$10$VGcO5.u8uf9uGEFZvWjAUe63wdo4ZV1SgMfQvg8LijNJ7U6HyjITe'),(14,'companyI','addressI','webaddressI','contactfirstI','contactlastI','email@companyI','9999999999','$2a$10$J9plN9TLYu6cUH6B57ZM1OqP5LHqCl4koH.EaZFmSMyg0CCjthvcK'),(15,'companyJ','addressJ','webaddressJ','contactfirstJ','contactlastJ','email@companyJ','1234567890','$2a$10$yY8RmM5cTOoZs49mPZQ7K.bPCCOsxdzKtE9Xd.SCqcbSIwgkbqPv6');
/*!40000 ALTER TABLE `ticketseller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-03 20:20:20
