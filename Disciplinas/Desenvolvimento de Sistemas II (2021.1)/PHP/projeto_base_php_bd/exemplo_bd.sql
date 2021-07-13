CREATE DATABASE  IF NOT EXISTS `academico` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `academico`;
-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: academico
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id_aluno` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nome_aluno` varchar(100) NOT NULL,
  `email_aluno` varchar(50) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `curso` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  UNIQUE KEY `id_aluno` (`id_aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Ebonee','eyakobowitz0@intel.com','Análise e Desenvolvimento de Sistemas'),(2,'Fraser','fofairy1@skyrock.com','Análise e Desenvolvimento de Sistemas'),(3,'Jamey','jlyddiatt2@imdb.com','Análise e Desenvolvimento de Sistemas'),(4,'Amargo','achristoforou3@aboutads.info','Análise e Desenvolvimento de Sistemas'),(5,'Cloris','ccasella4@bloglovin.com','Análise e Desenvolvimento de Sistemas'),(6,'Rod','rarthan5@weebly.com','Análise e Desenvolvimento de Sistemas'),(8,'Esther','ewoodford7@blogspot.com','Análise e Desenvolvimento de Sistemas'),(9,'Mike','mvear8@wikipedia.org','Análise e Desenvolvimento de Sistemas'),(10,'Vonni','vcruikshanks9@pinterest.com','Análise e Desenvolvimento de Sistemas'),(11,'Teodorico','theindricka@feedburner.com','Análise e Desenvolvimento de Sistemas'),(12,'Gabriela','gsainesb@geocities.jp','Análise e Desenvolvimento de Sistemas'),(13,'Bertie','bbarrouxc@weibo.com','Análise e Desenvolvimento de Sistemas'),(14,'Malinde','mnelthorpd@woothemes.com','Análise e Desenvolvimento de Sistemas'),(15,'Tanya','tasife@google.es','Análise e Desenvolvimento de Sistemas'),(16,'Alvera','asinclarf@google.co.uk','Análise e Desenvolvimento de Sistemas'),(17,'Dana','dramsellg@woothemes.com','Análise e Desenvolvimento de Sistemas'),(18,'Iseabal','izukermanh@paypal.com','Análise e Desenvolvimento de Sistemas'),(19,'Jill','jfrancisi@ovh.net','Análise e Desenvolvimento de Sistemas'),(20,'Larisa','lkeepj@google.nl','Análise e Desenvolvimento de Sistemas'),(21,'Dorothea','dnoirk@archive.org','Análise e Desenvolvimento de Sistemas'),(22,'Jamill','jnarramorl@ebay.com','Análise e Desenvolvimento de Sistemas'),(23,'Syman','schalfontm@eventbrite.com','Análise e Desenvolvimento de Sistemas'),(24,'Hedda','hginnanen@tripadvisor.com','Análise e Desenvolvimento de Sistemas'),(25,'Eben','edowningo@boston.com','Análise e Desenvolvimento de Sistemas'),(26,'Sabina','sleftlyp@jiathis.com','Análise e Desenvolvimento de Sistemas'),(27,'Gusty','gnurseq@clickbank.net','Análise e Desenvolvimento de Sistemas'),(28,'Martica','mmacgahyr@friendfeed.com','Análise e Desenvolvimento de Sistemas'),(29,'Nicolina','nbernhardssons@statcounter.com','Análise e Desenvolvimento de Sistemas');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23 14:42:12
