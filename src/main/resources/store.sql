CREATE DATABASE  IF NOT EXISTS `store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `store`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: store
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `client_nif` varchar(10) DEFAULT NULL,
  `client_name` varchar(45) DEFAULT NULL,
  `client_surname` varchar(45) DEFAULT NULL,
  `client_email` varchar(45) DEFAULT NULL,
  `client_phone` varchar(45) DEFAULT NULL,
  `client_balance` double DEFAULT '0',
  `client_vip` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `client_nif_UNIQUE` (`client_nif`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'43204409J','Javier','Diz','jds@iesemilidarder.com','678313344',1000,0),(2,'43202626L','Leonor','Mateo','lmc@iesemilidarder.com','661262626',0,0),(4,'43204409x','Joan','Ques','joan@gmail.com','661345678',3000,1);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `game_name` varchar(45) DEFAULT NULL,
  `game_description` varchar(45) DEFAULT NULL,
  `game_cover` varchar(45) DEFAULT NULL,
  `game_gender` enum('SURVIVAL','ADVENTURES','TERROR','ACTION') DEFAULT NULL,
  `game_balance` double DEFAULT '0',
  `game_pegi` varchar(45) DEFAULT NULL,
  `game_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'RUST','FACEPUNCH GAME','rust.jpg','SURVIVAL',30,'16','https://store.steampowered.com/app/252490/Rust/'),(2,'CS:GO','VALVE GAME','csgo.jpg','ACTION',20,'16','https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?l=spanish'),(3,'DOTA 2','VALVE GAME','dota2.jpg','ACTION',0,'12','https://es.dota2.com/'),(4,'League of legends','RIOT GAME','lol.jpg','SURVIVAL',0,'8','https://na.leagueoflegends.com/es-es/'),(5,'Fortnite','EPIC GAMES','fortnite.jpg','ACTION',0,'8','https://www.epicgames.com/fortnite/es-ES/home');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skins`
--

DROP TABLE IF EXISTS `skins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skins` (
  `skin_id` int NOT NULL AUTO_INCREMENT,
  `skin_name` varchar(45) NOT NULL,
  `skin_price` double NOT NULL DEFAULT '0',
  `skin_cover` varchar(45) DEFAULT NULL,
  `skin_game_id` int DEFAULT NULL,
  `skin_stock` int DEFAULT NULL,
  PRIMARY KEY (`skin_id`),
  KEY `skin_game_fk_idx` (`skin_game_id`),
  CONSTRAINT `skin_game_fk` FOREIGN KEY (`skin_game_id`) REFERENCES `games` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skins`
--

LOCK TABLES `skins` WRITE;
/*!40000 ALTER TABLE `skins` DISABLE KEYS */;
INSERT INTO `skins` VALUES (1,'RUST-1',500,'rust1.jpg',1,50),(2,'RUST-2',5,'rust2.jpg',1,28),(3,'RUST-3',10,'rust3.jpeg',1,25),(4,'CSGO-1',25,'csgo1.jpg',1,25),(5,'CSGO-2',20,'csgo2.jpg',1,35),(18,'GRATIS',50,'rust1.jpg',1,50);
/*!40000 ALTER TABLE `skins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'store'
--

--
-- Dumping routines for database 'store'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23  4:10:16
