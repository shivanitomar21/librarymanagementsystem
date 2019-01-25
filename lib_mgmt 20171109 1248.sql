-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.73-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema library
--

CREATE DATABASE IF NOT EXISTS library;
USE library;

--
-- Definition of table `add_books`
--

DROP TABLE IF EXISTS `add_books`;
CREATE TABLE `add_books` (
  `book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `call_no` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `quantity` int(10) unsigned NOT NULL DEFAULT '0',
  `issued` int(10) unsigned NOT NULL DEFAULT '0',
  `added_date` datetime NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_books`
--

/*!40000 ALTER TABLE `add_books` DISABLE KEYS */;
INSERT INTO `add_books` (`book_id`,`call_no`,`name`,`author`,`publisher`,`quantity`,`issued`,`added_date`) VALUES 
 (1,'a@8','let us c','abc','mc graw hill',5,2,'2017-11-03 13:57:00'),
 (2,'d@3','engineering physics','xyz','mc graw hill',3,2,'2017-11-03 13:57:52');
/*!40000 ALTER TABLE `add_books` ENABLE KEYS */;


--
-- Definition of table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `st_id` int(10) unsigned NOT NULL,
  `s_name` varchar(45) NOT NULL,
  `rate` varchar(45) NOT NULL,
  `suggestion` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  KEY `st_id` (`st_id`),
  CONSTRAINT `st_id` FOREIGN KEY (`st_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` (`st_id`,`s_name`,`rate`,`suggestion`,`date`) VALUES 
 (2,'shivani','Very Good','hmmsnj','2017-11-03 03:37:02'),
 (7,'simran','Very Good','','2017-11-03 03:38:11'),
 (2,'shivani','Very Good','hnsajnj','2017-11-03 10:30:12'),
 (6,'divya','Good','hhyuwg','2017-11-03 10:33:35');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


--
-- Definition of table `issue_book`
--

DROP TABLE IF EXISTS `issue_book`;
CREATE TABLE `issue_book` (
  `book_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `book_call_no` varchar(45) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  `student_name` varchar(45) NOT NULL,
  `student_contact` varchar(45) NOT NULL,
  `issued_date` datetime NOT NULL,
  `return_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `returned` varchar(45) NOT NULL DEFAULT 'no',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue_book`
--

/*!40000 ALTER TABLE `issue_book` DISABLE KEYS */;
INSERT INTO `issue_book` (`book_id`,`book_call_no`,`student_id`,`student_name`,`student_contact`,`issued_date`,`return_date`,`returned`) VALUES 
 (1,'a@8','7','simran','9855678543','2017-11-03 14:02:05','2017-11-03 14:05:00','yes'),
 (2,'a@8','2','shivani','7820923469','2017-11-03 14:02:34','0000-00-00 00:00:00','no'),
 (3,'d@3','8','sakshi','9788774658','2017-11-03 14:02:49','0000-00-00 00:00:00','no'),
 (4,'d@3','4','pragati','9748576748','2017-11-03 14:03:16','0000-00-00 00:00:00','no'),
 (5,'a@8','7','simran','9775637465','2017-11-03 14:03:40','2017-11-03 14:05:00','yes');
/*!40000 ALTER TABLE `issue_book` ENABLE KEYS */;


--
-- Definition of table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE `librarian` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `qualification` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `contact_no` decimal(10,0) NOT NULL,
  `s_que` varchar(45) NOT NULL,
  `s_ans` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` (`id`,`username`,`name`,`password`,`email`,`gender`,`qualification`,`country`,`city`,`contact_no`,`s_que`,`s_ans`) VALUES 
 (44,'isachin','sachin tomar','Sachin@2','isachin@gmail.com','M','Phd','india','meerut','9823654534','what is your pet name?','tommy'),
 (45,'igola','gola chauhan','Imgola@2','golachauhan34@gmail.com','F','PG','india','meerut','7568961079','what is your pet name?','bujo'),
 (46,'ishivani','shivani','Shivani@2','shivani@gmail.com','F','UG','USA','london','9875346789','what is your favorite past-time?','singing'),
 (47,'ishreyashi','shreyashi','Shreyashi@2','shreyashi@gmail.com','F','UG','india','delhi','9876345622','what is your all time favorite sports team?','indian cricket team'),
 (48,'isimran','simran','Simran@2','simran@gmail.com','F','PG','America','paris','9834454345','what was the name of your first school?','banasthali'),
 (49,'isonali','sonali','Sonali@2','sonali@gmail.com','F','UG','USA','london','8673456798','what is your favorite past-time?','sleeping'),
 (50,'ipragati','pragati','Pragati@2','pragati@gmail.com','F','PG','india','meerut','7654356783','what is your favorite past-time?','sleeping'),
 (52,'ishriya','shriya','Shriya@2','Shriya@gmail.com','F','PG','USA','london','9837655652','what is your pet name?','tuffy'),
 (53,'ipika','Pika','Pika@2','pika@gmail.com','F','PG','india','delhi','9726363676','what is your pet name?','passi'),
 (54,'ibhoomika','bhoomika','Bhoomika@2','Bhoomika@gmail.com','F','PG','india','delhi','9887583746','what is your favorite past-time?','singing');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`,`name`) VALUES 
 (1,'abc'),
 (2,'shivani'),
 (3,'shreyashi'),
 (4,'pragati'),
 (5,'sonali'),
 (6,'divya'),
 (7,'simran'),
 (8,'sakshi'),
 (10,'garima'),
 (11,'ruchi');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
