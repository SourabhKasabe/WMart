CREATE DATABASE  IF NOT EXISTS `wmart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wmart`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: wmart
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `Product_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(225) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Description` varchar(1550) DEFAULT NULL,
  `Qauntity` int DEFAULT NULL,
  PRIMARY KEY (`Product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Laptop',50000,'Ram DDR4 12gb,SSD-550gb,Graphics-2Gb,intel i5 Processor',1),(2,'Mobile',15000,'Ram-8Gb,Rom-128Gb,FrontCamera-12mp,RareCamera-64mp,Battery-5000mpa',1),(3,'EarPhones',1000,'Wireless,Bluetooth version:5,With Mic:Yes, Noise Cancelling,Google Assistant/Siri',1),(4,'Speaker',1500,'Power Output-16w, Battery Life-10hr,WaterProof,charging time-3.5hr,Bluetooth Support',1),(5,'Washing Machine',35000,'Fully Automatic, 3Star Rating,6.5kg,hi',1),(6,'Refrigerators',25000,'185L, 4 star, Deep chiller, Low voltage140v, 680rpm higherthe spin speed, Dry',1),(7,'Microwave',10000,'28L,Convection&Grill, Touch KeyPad, Child lock',1),(8,'Air Conditioner',40000,'1.5Ton, 5Star, Auto Restart, Copper, Sleep mode',1),(9,'Television',25000,'LED(55 inch) Ultra Hd 4K, Android 12, Sound O/P-25W, Ram-2gb, Rom-8Gb',1),(10,'Smart Watch',2500,'1.69 inch Display, 40 sport Modes, Battery 400mAh(15Day), TouchScreen, Calling, Assistant Support',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-28 20:11:21
