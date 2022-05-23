-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `Nume` varchar(30) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  `Tara` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Nume`),
  UNIQUE KEY `Nume_UNIQUE` (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bibliotecar`
--

DROP TABLE IF EXISTS `bibliotecar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bibliotecar` (
  `idBibliotecar` int unsigned NOT NULL AUTO_INCREMENT,
  `Nume` varchar(50) DEFAULT NULL,
  `Prenume` varchar(50) DEFAULT NULL,
  `Email` varchar(80) DEFAULT NULL,
  `NrTelefon` varchar(50) DEFAULT NULL,
  `Adresa` varchar(100) DEFAULT NULL,
  `DataAngajare` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idBibliotecar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `carte`
--

DROP TABLE IF EXISTS `carte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carte` (
  `Titlu` varchar(50) NOT NULL,
  `NumeAutor` varchar(45) DEFAULT NULL,
  `NumeEditura` varchar(45) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `NumeCategorie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Titlu`),
  KEY `NumeAutor_idx` (`NumeAutor`),
  KEY `NumeEditura_idx` (`NumeEditura`),
  KEY `NumeCategorie_idx` (`NumeCategorie`),
  CONSTRAINT `NumeAutor` FOREIGN KEY (`NumeAutor`) REFERENCES `autor` (`Nume`),
  CONSTRAINT `NumeCategorie` FOREIGN KEY (`NumeCategorie`) REFERENCES `categorie` (`Nume`),
  CONSTRAINT `NumeEditura` FOREIGN KEY (`NumeEditura`) REFERENCES `editura` (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `carteimprumutata`
--

DROP TABLE IF EXISTS `carteimprumutata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carteimprumutata` (
  `status` varchar(5) DEFAULT NULL,
  `LegitimatieClient` int DEFAULT NULL,
  `TitluCarte` varchar(45) DEFAULT NULL,
  `DataImprumut` varchar(50) DEFAULT NULL,
  `DataReturnare` varchar(50) DEFAULT NULL,
  KEY `Titlu_idx` (`TitluCarte`),
  KEY `Legitimatie_idx` (`LegitimatieClient`),
  CONSTRAINT `Legitimatie` FOREIGN KEY (`LegitimatieClient`) REFERENCES `persoana` (`Legitimatie`),
  CONSTRAINT `Titlu` FOREIGN KEY (`TitluCarte`) REFERENCES `carte` (`Titlu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `Nume` varchar(50) NOT NULL,
  `Etaj` int DEFAULT NULL,
  `Raft` int DEFAULT NULL,
  PRIMARY KEY (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `idClient` int unsigned NOT NULL AUTO_INCREMENT,
  `Nume` varchar(50) DEFAULT NULL,
  `Prenume` varchar(50) DEFAULT NULL,
  `Email` varchar(80) DEFAULT NULL,
  `NumarTelefon` varchar(50) DEFAULT NULL,
  `Adresa` varchar(100) DEFAULT NULL,
  `TipClient` varchar(50) DEFAULT NULL,
  `Legitimatie` int DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `editura`
--

DROP TABLE IF EXISTS `editura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editura` (
  `Nume` varchar(50) NOT NULL,
  `Adresa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Nume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `persoana`
--

DROP TABLE IF EXISTS `persoana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persoana` (
  `Nume` varchar(50) NOT NULL,
  `Prenume` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `NumarTelefon` varchar(45) DEFAULT NULL,
  `Adresa` varchar(45) DEFAULT NULL,
  `TipClient` varchar(45) DEFAULT NULL,
  `Legitimatie` int NOT NULL,
  `DataAngajare` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Nume`),
  UNIQUE KEY `Legitimatie_UNIQUE` (`Legitimatie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-23 17:54:32
