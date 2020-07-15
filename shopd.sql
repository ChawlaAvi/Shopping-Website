-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: shopdatabase
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

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
-- Table structure for table `BATCH_PRODUCT`
--

DROP TABLE IF EXISTS `BATCH_PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BATCH_PRODUCT` (
  `product_id` int(11) NOT NULL,
  `packet_size` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`product_id`,`packet_size`),
  CONSTRAINT `fk_bp_p` FOREIGN KEY (`product_id`) REFERENCES `PRODUCT` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BATCH_PRODUCT`
--

LOCK TABLES `BATCH_PRODUCT` WRITE;
/*!40000 ALTER TABLE `BATCH_PRODUCT` DISABLE KEYS */;
INSERT INTO `BATCH_PRODUCT` VALUES (1,1000,20,75),(2,50,50,375),(2,150,35,1100),(3,1000,40,75),(3,1500,60,110),(4,100,10,300),(4,200,20,575),(5,100,30,300),(5,200,40,600),(6,250,15,400),(6,300,30,450),(7,100,50,80),(8,100,70,50),(8,200,30,95),(9,100,30,200),(9,300,30,550),(10,150,30,1950),(10,300,30,3800);
/*!40000 ALTER TABLE `BATCH_PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CART`
--

DROP TABLE IF EXISTS `CART`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CART` (
  `username` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  `packet_size` int(11) NOT NULL,
  `quantity_in_cart` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `available` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`username`,`product_id`,`packet_size`),
  KEY `fk_c_p` (`product_id`),
  CONSTRAINT `fk_c_c` FOREIGN KEY (`username`) REFERENCES `CUSTOMER` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_c_p` FOREIGN KEY (`product_id`) REFERENCES `PRODUCT` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CART`
--

LOCK TABLES `CART` WRITE;
/*!40000 ALTER TABLE `CART` DISABLE KEYS */;
/*!40000 ALTER TABLE `CART` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER` (
  `username` varchar(255) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `aadhar_number` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_c_u` FOREIGN KEY (`username`) REFERENCES `USERS` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES ('avi','Avi Chawla','88 sector 5 gurugram','M','125119807659','avi_chawla2003@yahoo.com','9910094680'),('eshan','Eshan Chawla','11, cresent drive gurugram','M','165477865346','eshan.chawla22@gmail.com','7503687960');
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERS`
--

DROP TABLE IF EXISTS `ORDERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDERS` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `packet_size` int(11) NOT NULL,
  `ordered_quantity` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`,`packet_size`),
  KEY `fk_o_bp` (`product_id`,`packet_size`),
  CONSTRAINT `fk_o_bp` FOREIGN KEY (`product_id`, `packet_size`) REFERENCES `BATCH_PRODUCT` (`product_id`, `packet_size`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_o_uo` FOREIGN KEY (`order_id`) REFERENCES `USER_ORDERS` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERS`
--

LOCK TABLES `ORDERS` WRITE;
/*!40000 ALTER TABLE `ORDERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ORDERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES (1,'regent'),(2,'nativo'),(3,'phorate'),(4,'folicur'),(5,'confidor'),(6,'persuit'),(7,'datis'),(8,'cyper maprin'),(9,'avuant'),(10,'coraven');
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(15) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES ('admin1','ankit@12','ROLE_ADMIN',1),('admin2','ankit@123','ROLE_ADMIN',1),('admin3','ankit@1234','ROLE_ADMIN',1),('avi','avi','ROLE_USER',1),('eshan','eshan','ROLE_USER',1);
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ORDERS`
--

DROP TABLE IF EXISTS `USER_ORDERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ORDERS` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `grand_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_uo_c` (`username`),
  CONSTRAINT `fk_uo_c` FOREIGN KEY (`username`) REFERENCES `CUSTOMER` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ORDERS`
--

LOCK TABLES `USER_ORDERS` WRITE;
/*!40000 ALTER TABLE `USER_ORDERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ORDERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WORKER`
--

DROP TABLE IF EXISTS `WORKER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WORKER` (
  `worker_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `aadhar_number` varchar(40) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `bank_name` varchar(30) DEFAULT NULL,
  `IFSC` varchar(30) DEFAULT NULL,
  `account_no` varchar(30) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`worker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WORKER`
--

LOCK TABLES `WORKER` WRITE;
/*!40000 ALTER TABLE `WORKER` DISABLE KEYS */;
INSERT INTO `WORKER` VALUES (1,'Ajay','suraj ganj mandi','135118156003',4500,'ajay.jain@gmail.com','SBI BANK','SBI0021100N','18992348790','Working','M'),(2,'Rajesh','railway station','124262884673',6000,'rajesh.pandey@gmail.com','Bank of Baroda','BBO2992119','12327738365','Working','M');
/*!40000 ALTER TABLE `WORKER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-01 16:39:18
