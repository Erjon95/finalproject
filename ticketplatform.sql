-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table ticketplatform.event
CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketsellerid` int(11) NOT NULL,
  `titleofevent` varchar(30) NOT NULL,
  `placeofevent` varchar(30) NOT NULL,
  `description` tinytext NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketplatform.event: ~10 rows (approximately)
DELETE FROM `event`;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`id`, `ticketsellerid`, `titleofevent`, `placeofevent`, `description`, `startdate`, `enddate`, `localtimeofshow`, `priceofticket`, `picture`, `numberoftickets`, `timestamp`) VALUES
	(6, 9, 'titleA', 'placeA', 'descriptionA', '2020-01-10', '2020-01-20', '10:00:00', '$50', NULL, 100, '2020-02-24 10:03:59'),
	(7, 10, 'titleB', 'placeB', 'descriptionB', '2020-02-10', '2020-02-20', '10:00:00', '$60', NULL, 200, '2020-02-24 10:05:20'),
	(8, 11, 'titleC', 'placeC', 'descriptionC', '2020-03-10', '2020-03-20', '10:00:00', '$70', NULL, 300, '2020-02-24 10:06:01'),
	(9, 11, 'titleD', 'placeD', 'descriptionD', '2020-04-10', '2020-04-20', '10:00:00', '$80', NULL, 400, '2020-02-24 10:06:30'),
	(10, 11, 'titleE', 'placeE', 'descriptionE', '2020-05-10', '2020-05-20', '10:00:00', '$90', NULL, 500, '2020-02-24 10:07:02'),
	(11, 12, 'titleF', 'placeF', 'descriptionF', '2020-06-10', '2020-06-20', '10:00:00', '$100', NULL, 600, '2020-02-24 10:07:37'),
	(12, 12, 'titleG', 'placeG', 'descriptionG', '2020-07-10', '2020-07-20', '10:00:00', '$110', NULL, 700, '2020-02-24 10:08:20'),
	(13, 12, 'titleH', 'placeH', 'descriptionH', '2020-08-10', '2020-08-20', '10:00:00', '$120', NULL, 800, '2020-02-24 10:08:47'),
	(14, 13, 'titleI', 'placeI', 'descriptionI', '2020-09-10', '2020-09-20', '10:00:00', '$130', NULL, 900, '2020-02-24 10:09:20'),
	(15, 13, 'titleJ', 'placeJ', 'descriptionJ', '2020-10-10', '2020-10-20', '10:00:00', '$140', NULL, 1000, '2020-02-24 10:09:53');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- Dumping structure for table ticketplatform.ticket
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketbuyerid` int(11) NOT NULL,
  `ticketsellerid` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `eventid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_ticketbuyer` (`ticketbuyerid`),
  KEY `fk_ticket_ticketseller` (`ticketsellerid`),
  KEY `fk_ticket_event` (`eventid`),
  CONSTRAINT `fk_ticket_event` FOREIGN KEY (`eventid`) REFERENCES `event` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ticket_ticketbuyer` FOREIGN KEY (`ticketbuyerid`) REFERENCES `ticketbuyer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ticket_ticketseller` FOREIGN KEY (`ticketsellerid`) REFERENCES `ticketseller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketplatform.ticket: ~1 rows (approximately)
DELETE FROM `ticket`;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` (`id`, `ticketbuyerid`, `ticketsellerid`, `timestamp`, `eventid`) VALUES
	(14, 11, 12, '2020-02-24 10:27:41', 12);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;

-- Dumping structure for table ticketplatform.ticketbuyer
CREATE TABLE IF NOT EXISTS `ticketbuyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `password` varchar(70) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketplatform.ticketbuyer: ~10 rows (approximately)
DELETE FROM `ticketbuyer`;
/*!40000 ALTER TABLE `ticketbuyer` DISABLE KEYS */;
INSERT INTO `ticketbuyer` (`id`, `firstname`, `lastname`, `address`, `email`, `phone`, `password`, `role`) VALUES
	(5, 'BuyerAFirst', 'BuyerALast', 'addressBuyerA', 'email@BuyerA', '1111111111', '$2a$10$hN35oBjuSrIunfMuCmNHj.8ac.6pYPG41uVfdQT0rrqittLqYpK3G', 'BUYER'),
	(6, 'BuyerBFirst', 'BuyerBLast', 'addressBuyerB', 'email@BuyerB', '2222222222', '$2a$10$WGlPgnEUi21HFMdQ56fyq.oyWk85JX4lOkdDnkdEX2mSqc3joVLhm', 'BUYER'),
	(7, 'BuyerCFirst', 'BuyerCLast', 'addressBuyerC', 'email@BuyerC', '3333333333', '$2a$10$WGoIdFPpxzuQGlzk8e/iKOAso.YIQRLNbqPdcos3Qu4mHOJNB/02W', 'BUYER'),
	(8, 'BuyerDFirst', 'BuyerDLast', 'addressBuyerD', 'email@BuyerD', '4444444444', '$2a$10$I5DR5.My8JYBDwEAgMI2nu3it0BT5i.rA5wwNGqWGeXHqV76xPloe', 'BUYER'),
	(9, 'BuyerEFirst', 'BuyerELast', 'addressBuyerE', 'email@BuyerE', '5555555555', '$2a$10$N6Fx1mW5NUDEegBiSFm9ye4UyAbz5j8SCXohPM.xaByS2V9gew/uq', 'BUYER'),
	(10, 'BuyerFFirst', 'BuyerFLast', 'addressBuyerF', 'email@BuyerF', '6666666666', '$2a$10$6yV0sRznypuIiDFl9G0OMOwYuBGb/1OtkeOpkWzfWJBGc8ABrsnGW', 'BUYER'),
	(11, 'BuyerGFirst', 'BuyerGLast', 'addressBuyerG', 'email@BuyerG', '7777777777', '$2a$10$fCLoUMIC4Xujt8yWzBvA0OP3wIzS8iAPkagL5Y/zmlOLthzxZZzl2', 'BUYER'),
	(12, 'BuyerHFirst', 'BuyerHLast', 'addressBuyerH', 'email@BuyerH', '8888888888', '$2a$10$.Q3sS0QrYJwDA79.4Z2WwO2pvxg4SRZ1PWxA8Iwsx3CmDQdcVuFEm', 'BUYER'),
	(13, 'BuyerIFirst', 'BuyerILast', 'addressBuyerI', 'email@BuyerI', '9999999999', '$2a$10$dmj5aXNDu4fBCTwvs5UGguYP3g/kJE0EIQ4b6pTf9poGY7nUL5K1q', 'BUYER'),
	(14, 'BuyerJFirst', 'BuyerJLast', 'addressBuyerJ', 'email@BuyerJ', '1234567890', '$2a$10$x7i7Fs9DZ872t3SpyvFk9uYOIluDRm10wpDWUCumZmkOxW9YrZb96', 'BUYER');
/*!40000 ALTER TABLE `ticketbuyer` ENABLE KEYS */;

-- Dumping structure for table ticketplatform.ticketseller
CREATE TABLE IF NOT EXISTS `ticketseller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orgname` varchar(30) NOT NULL,
  `orgaddress` varchar(50) NOT NULL,
  `webaddress` varchar(50) NOT NULL,
  `contactfirstname` varchar(30) DEFAULT NULL,
  `contactlastname` varchar(30) DEFAULT NULL,
  `contactemail` varchar(70) NOT NULL,
  `contactphone` varchar(30) DEFAULT NULL,
  `password` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketplatform.ticketseller: ~10 rows (approximately)
DELETE FROM `ticketseller`;
/*!40000 ALTER TABLE `ticketseller` DISABLE KEYS */;
INSERT INTO `ticketseller` (`id`, `orgname`, `orgaddress`, `webaddress`, `contactfirstname`, `contactlastname`, `contactemail`, `contactphone`, `password`) VALUES
	(9, 'companyA', 'addressA', 'webaddressA', 'contactFirstA', 'contactLastA', 'email@companyA', '1111111111', '$2a$10$bJ11BT08uWyJDVb2KkoGlO/MgoPDdfoYkUAMLqLobTqmV5rdjQU9C'),
	(10, 'companyB', 'addressB', 'webaddressB', 'contactFirstB', 'contactLastB', 'email@companyB', '2222222222', '$2a$10$MfMwPati6av1S0xqYRg28eBjxJ8oIXjq/mzLiwbzo1anf9oHGAOde'),
	(11, 'companyC', 'addressC', 'webaddressC', 'contactFirstC', 'contactLastC', 'email@companyC', '3333333333', '$2a$10$tMc4Vu2QxHaCf89bLflbNOTLsKg4eYQYZD/YWReKelZtqjnCCqfHu'),
	(12, 'companyD', 'addressD', 'webaddressD', 'contactFirstD', 'contactLastD', 'email@companyD', '4444444444', '$2a$10$nn/1po7L/aBaAuC0UZ2SquCPGwf0LKH2nr9Gj7XxTAKo4mnU.r6MW'),
	(13, 'companyE', 'addressE', 'webaddressE', 'contactFirstE', 'contactLastE', 'email@companyE', '5555555555', '$2a$10$wN1KwFM766so8YSl2OI9oeO6/o3HFQdbytfghjf2xH8ZdLypErupO'),
	(14, 'companyF', 'addressF', 'webaddressF', 'contactFirstF', 'contactLastF', 'email@companyF', '6666666666', '$2a$10$1kRbA/3pZU8jY5l9zKBrreT/9D2h51bl6KsnQJO8pL2SxUbKpcJ9.'),
	(15, 'companyG', 'addressG', 'webaddressG', 'contactFirstG', 'contactLastG', 'email@companyG', '7777777777', '$2a$10$xBvdPpk20P2g5a7VKOh8DuNAXiUXq5SMyChIBPofnxNj3G7DvWQnS'),
	(16, 'companyH', 'addressH', 'webaddressH', 'contactFirstH', 'contactLastH', 'email@companyH', '8888888888', '$2a$10$i8CsGOiK/KGvTSpevARNFOPdAAAeT.TcizZw3JKpv8eFSAHhzXYh6'),
	(17, 'companyI', 'addressI', 'webaddressI', 'contactFirstI', 'contactLastI', 'email@companyI', '9999999999', '$2a$10$E1rhsAMwOLO09hwh7U4DAu2Yf2IYwg/UFeLgv6x.OOkcMzdeSQVTW'),
	(18, 'companyJ', 'addressJ', 'webaddressJ', 'contactFirstJ', 'contactLastJ', 'email@companyJ', '1234567890', '$2a$10$qYqrF0yY8OQrFYTV8UkmkOXO9cH033wut.4hGYZ1RLmTwVxnhEwWa');
/*!40000 ALTER TABLE `ticketseller` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
