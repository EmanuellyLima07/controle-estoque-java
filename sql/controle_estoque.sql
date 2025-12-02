CREATE DATABASE  IF NOT EXISTS `controle_estoque` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `controle_estoque`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: controle_estoque
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `eletronico`
--

DROP TABLE IF EXISTS `eletronico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eletronico` (
  `id_eletro` int(11) NOT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `garantiaMeses` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_eletro`),
  CONSTRAINT `fk_eletro_prod` FOREIGN KEY (`id_eletro`) REFERENCES `produto_base` (`id_prod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eletronico`
--

LOCK TABLES `eletronico` WRITE;
/*!40000 ALTER TABLE `eletronico` DISABLE KEYS */;
INSERT INTO `eletronico` VALUES (1,'AU7700',12),(5,'G15 5510',12),(6,'W800BT Plus',6);
/*!40000 ALTER TABLE `eletronico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ferramenta`
--

DROP TABLE IF EXISTS `ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ferramenta` (
  `id_fer` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `material` varchar(100) NOT NULL,
  `peso` double NOT NULL,
  `comprimento` double NOT NULL,
  `eletrica` tinyint(1) NOT NULL,
  `potencia` int(11) NOT NULL,
  PRIMARY KEY (`id_fer`),
  CONSTRAINT `fk_ferramenta_prod` FOREIGN KEY (`id_fer`) REFERENCES `produto_base` (`id_prod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ferramenta`
--

LOCK TABLES `ferramenta` WRITE;
/*!40000 ALTER TABLE `ferramenta` DISABLE KEYS */;
INSERT INTO `ferramenta` VALUES (4,'Elétrica','Perfuração','Aço Inoxidável e Plástico ABS',2.5,30,1,850),(11,'Medição','Medição/Marcação','Plástico ABS e Borracha',0.15,8,0,0);
/*!40000 ALTER TABLE `ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perecivel`
--

DROP TABLE IF EXISTS `perecivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perecivel` (
  `id_pr` int(11) NOT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `embalagem` varchar(100) DEFAULT NULL,
  `origem` varchar(100) DEFAULT NULL,
  `dt_fabricacao` date NOT NULL,
  `dt_validade` date NOT NULL,
  PRIMARY KEY (`id_pr`),
  CONSTRAINT `fk_perecivel_prod` FOREIGN KEY (`id_pr`) REFERENCES `produto_base` (`id_prod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perecivel`
--

LOCK TABLES `perecivel` WRITE;
/*!40000 ALTER TABLE `perecivel` DISABLE KEYS */;
INSERT INTO `perecivel` VALUES (3,'Alimento','Caixa','1.0','2025-01-15','2026-08-19'),(9,'Óleos e Azeites','Garrafa de Vidro','Portugal','2025-09-10','2026-03-10'),(10,'Panificados','Saco Plástico','Nacional','2025-11-25','2025-12-05');
/*!40000 ALTER TABLE `perecivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_base`
--

DROP TABLE IF EXISTS `produto_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_base` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `marca` varchar(80) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `data_cadastro` date NOT NULL,
  `tipo_produto` enum('ELETRONICO','PERECIVEL','ROUPA','FERRAMENTA') NOT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_base`
--

LOCK TABLES `produto_base` WRITE;
/*!40000 ALTER TABLE `produto_base` DISABLE KEYS */;
INSERT INTO `produto_base` VALUES (1,'Smart TV LED 50\"','Samsung',1,2599.90,'2025-11-26','ELETRONICO'),(2,'Camiseta Básica','Niran',55,49.90,'2025-11-27','ROUPA'),(3,'Leite Integral','Italac',15,5.49,'2025-11-27','PERECIVEL'),(4,'Furadeira de Impacto','Bosch',15,359.90,'2025-11-27','FERRAMENTA'),(5,'Notebook Gamer 15\"','Dell',25,5899.99,'2025-11-27','ELETRONICO'),(6,'Fone de Ouvido Wireless','Edifier',180,249.99,'2025-11-27','ELETRONICO'),(7,'Calça Jeans Skinny','Hering',90,159.90,'2025-11-27','ROUPA'),(8,'Camiseta Polo Básica','Mahalo',125,89.50,'2025-11-27','ROUPA'),(9,'Azeite de Oliva Extra Virgem','Tradicional',450,35.75,'2025-11-28','PERECIVEL'),(10,'Pão de Forma Integral','Pullen',320,12.99,'2025-11-28','PERECIVEL'),(11,'Trena a Laser Digital','Ribbon',119,185.00,'2025-11-28','FERRAMENTA');
/*!40000 ALTER TABLE `produto_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roupa`
--

DROP TABLE IF EXISTS `roupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roupa` (
  `id_roupa` int(11) NOT NULL,
  `cor` varchar(50) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `material` varchar(50) NOT NULL,
  `lavavel_na_maquina` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_roupa`),
  CONSTRAINT `fk_roupa_prod` FOREIGN KEY (`id_roupa`) REFERENCES `produto_base` (`id_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roupa`
--

LOCK TABLES `roupa` WRITE;
/*!40000 ALTER TABLE `roupa` DISABLE KEYS */;
INSERT INTO `roupa` VALUES (2,'Preto','M','Feminino','Algodão',1),(7,'Azul Escuro','40','Masculino','Algodão com Elastano',1),(8,'Vermelho Bordô','G','Feminino','Piquet de Algodão',1);
/*!40000 ALTER TABLE `roupa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-28  1:08:52
