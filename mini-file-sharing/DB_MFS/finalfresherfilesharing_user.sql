-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: finalfresherfilesharing
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `rank_id` int(11) DEFAULT '1',
  `active` int(11) DEFAULT '1',
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rank_user_idx` (`rank_id`),
  CONSTRAINT `FKf6d0lfj1w8su3rf35rs7h1066` FOREIGN KEY (`rank_id`) REFERENCES `rank` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (30,'admin@gmail.com','$2a$10$8tMYHhqJplI6v03uoKudQO7tUiUyPtiJTDOd3UYDqQMUZ0lDHuskK','Admin',1,1,'Admin'),(31,'user1@gmail.com','$2a$10$iLQzMYdHpX3XyZday2BJT.jO4eezZVjlzKfOBfyJYdH6iuIvxGCZW','user1',1,1,'user1'),(32,'user2@gmail.com','$2a$10$SIawTgZJ9SPrP.6byBzfsO69wtrW7h0hysEcf7EV59/Felkph5l.S','user2',1,1,'user2'),(33,'user3@gmail.com','$2a$10$pRD.jWZp8HeGUSbjMbhsUeBkVEYA6X1.Q41H7IKosGCPFCBs12fU6','user3',1,1,'user3'),(34,'user4@gmail.com','$2a$10$BMewB.f7fH.h2R.1eR2hv.QTBHUpHiXsgGeAcnTR5pW/0IJA3uZJe','user4',2,1,'user4'),(35,'user5@gmail.com','$2a$10$/gCClWU4nMzIBMKLMgyJ0udl.hQNfMLWAYR3SfPTQqlb59oZtCQam','user5',1,0,'user5'),(36,'dung@gmail.com','$2a$10$DCro/RS/2Dd0QA9kOc96b.nJGKUKhfx/VTuzMtBE1dah7q20FZEUe','dung',1,1,'dung'),(37,'dung1@gmail.com','$2a$10$x3PBFPudpJ322KDKXGS5SeXNfBMk1v9vyYJ9EjMMIMnsZxe.OkIJW','dung1',1,1,'dung1'),(38,'dung2@gmail.com','$2a$10$hCz7s8y9bcG.tKLZ5MFXIeUDGYrhD7QyJnND2GpmCPIb761/1VUAe','dung2',1,1,'dung2'),(39,'dung3@gmail.com','$2a$10$xUTh8XHNESzSblKISMn5f.o9x2w/lx9/MTtJC4.z16WRFP444yVK6','dung3',1,1,'dung3'),(40,'dung4@gmail.com','$2a$10$tmEJ2Cye6L5AFqOqdth7DucqsSdjgp2xdCbgaqXy/3rfaoiaJ/HP2','dung4',1,1,'dung4'),(41,'dung5@gmail.com','$2a$10$Q4yCt5jndV.e74yQRuYflOhHU3CO3s9Cxp4sxF2ANqXnZYrXAFuAy','dung5',1,1,'dung5'),(42,'dung6@gmail.com','$2a$10$dtuTg8W78I2sy9SpY/yE/O7yi784ksPI2ViTNB59oit9ZRCdvpl52','dung6',1,1,'dung6');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-07 21:20:42