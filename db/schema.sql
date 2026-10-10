/*
SQLyog Community v13.3.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - skautovanje2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`skautovanje2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `skautovanje2`;

/*Table structure for table `igrac` */

DROP TABLE IF EXISTS `igrac`;

CREATE TABLE `igrac` (
  `idIgrac` int(11) NOT NULL AUTO_INCREMENT,
  `imePrezime` varchar(100) NOT NULL,
  `godinaRodjenja` int(11) NOT NULL,
  `pozicija` varchar(20) NOT NULL,
  PRIMARY KEY (`idIgrac`),
  CONSTRAINT `chk_pozicija` CHECK (`pozicija` in ('Napadac','Vezni','Odbrambeni','Golman')),
  CONSTRAINT `chk_godinaRodjenja` CHECK (`godinaRodjenja` > 1926 and `godinaRodjenja` <= 2026)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `igrac` */

insert  into `igrac`(`idIgrac`,`imePrezime`,`godinaRodjenja`,`pozicija`) values 
(1,'Cristiano Ronaldo',1985,'Napadac'),
(2,'Luka Modric',1985,'Vezni'),
(3,'Toni Kroos',1990,'Vezni'),
(4,'Karim Benzema',1987,'Napadac'),
(5,'Sergio Ramos',1986,'Odbrambeni'),
(6,'Iker Casillas',1981,'Golman'),
(7,'Lionel Messi',1987,'Napadac'),
(8,'Xavi Hernandez',1980,'Vezni'),
(9,'Manuel Neuer',1986,'Golman'),
(10,'Robert Lewandowski',1988,'Napadac'),
(11,'Kevin De Bruyne',1991,'Vezni'),
(12,'Erling Haaland',2000,'Napadac'),
(13,'Wayne Rooney',1985,'Napadac'),
(14,'Kylian Mbappe',1998,'Napadac'),
(15,'Gianluigi Buffon',1978,'Golman'),
(16,'Paolo Maldini',1968,'Odbrambeni'),
(17,'Frank Lampard',1978,'Vezni'),
(18,'Thierry Henry',1977,'Napadac');

/*Table structure for table `izvestaj` */

DROP TABLE IF EXISTS `izvestaj`;

CREATE TABLE `izvestaj` (
  `idIzvestaj` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL DEFAULT '1900-01-01',
  `idSkaut` int(11) DEFAULT NULL,
  `idKlub` int(11) DEFAULT NULL,
  PRIMARY KEY (`idIzvestaj`),
  KEY `fk_Izvestaj_Skaut` (`idSkaut`),
  KEY `fk_Izvestaj_Klub` (`idKlub`),
  CONSTRAINT `fk_Izvestaj_Klub` FOREIGN KEY (`idKlub`) REFERENCES `klub` (`idKlub`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Izvestaj_Skaut` FOREIGN KEY (`idSkaut`) REFERENCES `skaut` (`idSkaut`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `izvestaj` */

insert  into `izvestaj`(`idIzvestaj`,`datum`,`idSkaut`,`idKlub`) values 
(1,'2026-08-15',1,1),
(2,'2026-08-22',2,10),
(3,'2026-08-29',1,9),
(4,'2026-09-05',2,1),
(6,'2025-09-22',1,1);

/*Table structure for table `klub` */

DROP TABLE IF EXISTS `klub`;

CREATE TABLE `klub` (
  `idKlub` int(11) NOT NULL AUTO_INCREMENT,
  `nazivKluba` varchar(100) NOT NULL DEFAULT '',
  `idLiga` int(11) DEFAULT NULL,
  PRIMARY KEY (`idKlub`),
  UNIQUE KEY `uq_klub_nazivKluba` (`nazivKluba`),
  KEY `fk_Klub_Liga` (`idLiga`),
  CONSTRAINT `fk_Klub_Liga` FOREIGN KEY (`idLiga`) REFERENCES `liga` (`idLiga`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `klub` */

insert  into `klub`(`idKlub`,`nazivKluba`,`idLiga`) values 
(1,'Real Madrid',1),
(2,'Arsenal',2),
(3,'Paris Saint-Germain',3),
(4,'Monaco',3),
(5,'Marseille',3),
(6,'Inter Milan',4),
(7,'AC Milan',4),
(8,'Juventus',4),
(9,'Bayern Munich',5),
(10,'Borussia Dortmund',5),
(11,'Bayer Leverkusen',5),
(12,'Real Sociedad',1),
(13,'Manchester City',2),
(14,'Chelsea',2),
(15,'Napoli',4),
(16,'Atletico Madrid',1);

/*Table structure for table `licenca` */

DROP TABLE IF EXISTS `licenca`;

CREATE TABLE `licenca` (
  `idLicenca` int(11) NOT NULL AUTO_INCREMENT,
  `nazivLicence` varchar(100) NOT NULL DEFAULT '',
  `opisLicence` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`idLicenca`),
  UNIQUE KEY `uq_licenca_nazivLicence` (`nazivLicence`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `licenca` */

insert  into `licenca`(`idLicenca`,`nazivLicence`,`opisLicence`) values 
(1,'UEFA A','Licenca za skautovanje u UEFA takmicenjima'),
(2,'UEFA B','Osnovna licenca za rad sa mladim igracima'),
(3,'FIFA A','Medjunarodna licenca za profesionalno skautovanje');

/*Table structure for table `liga` */

DROP TABLE IF EXISTS `liga`;

CREATE TABLE `liga` (
  `idLiga` int(11) NOT NULL AUTO_INCREMENT,
  `nazivLige` varchar(100) NOT NULL,
  `zemlja` varchar(100) NOT NULL,
  PRIMARY KEY (`idLiga`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `liga` */

insert  into `liga`(`idLiga`,`nazivLige`,`zemlja`) values 
(1,'LaLiga','Spanija'),
(2,'Premier League','Engleska'),
(3,'Ligue 1','Francuska'),
(4,'Serie A','Italija'),
(5,'Bundesliga','Nemacka');

/*Table structure for table `ocenaigraca` */

DROP TABLE IF EXISTS `ocenaigraca`;

CREATE TABLE `ocenaigraca` (
  `idIzvestaj` int(11) NOT NULL,
  `idOcenaIgraca` int(11) NOT NULL AUTO_INCREMENT,
  `ocena` double NOT NULL DEFAULT 1,
  `brojGolova` int(11) NOT NULL DEFAULT 0,
  `brojAsistencija` int(11) NOT NULL DEFAULT 0,
  `idIgrac` int(11) DEFAULT NULL,
  PRIMARY KEY (`idIzvestaj`,`idOcenaIgraca`),
  KEY `fk_OcenaIgraca_Igrac` (`idIgrac`),
  KEY `idOcenaIgraca` (`idOcenaIgraca`),
  CONSTRAINT `fk_OcenaIgraca_Igrac` FOREIGN KEY (`idIgrac`) REFERENCES `igrac` (`idIgrac`) ON UPDATE CASCADE,
  CONSTRAINT `fk_OcenaIgraca_Izvestaj` FOREIGN KEY (`idIzvestaj`) REFERENCES `izvestaj` (`idIzvestaj`) ON UPDATE CASCADE,
  CONSTRAINT `chk_ocena` CHECK (`ocena` >= 1 and `ocena` <= 10),
  CONSTRAINT `chk_brojGolova` CHECK (`brojGolova` >= 0),
  CONSTRAINT `chk_brojAsistencija` CHECK (`brojAsistencija` >= 0)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `ocenaigraca` */

insert  into `ocenaigraca`(`idIzvestaj`,`idOcenaIgraca`,`ocena`,`brojGolova`,`brojAsistencija`,`idIgrac`) values 
(1,1,10,50,12,1),
(1,2,9.4,6,18,2),
(1,3,9.3,0,0,6),
(1,4,8.8,45,5,12),
(2,1,9.6,40,15,4),
(2,2,9.5,5,20,3),
(2,3,8,0,0,9),
(2,4,8.5,1,2,16),
(2,5,8.9,42,6,10),
(3,1,9.7,44,10,14),
(3,2,9.2,3,1,5),
(3,3,8.4,0,0,15),
(3,4,8,30,8,13),
(4,1,10,47,9,1),
(4,2,8.9,8,16,11),
(4,3,7.8,12,7,17),
(4,4,9.1,0,0,6),
(4,5,8.7,38,11,18),
(6,1,10,900,200,1),
(6,2,9.4,211,1,12);

/*Table structure for table `skaut` */

DROP TABLE IF EXISTS `skaut`;

CREATE TABLE `skaut` (
  `idSkaut` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`idSkaut`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `skaut` */

insert  into `skaut`(`idSkaut`,`ime`,`prezime`,`korisnickoIme`,`lozinka`) values 
(1,'aleksa','djt','aleksa','aleksa'),
(2,'minja','lukovic','minja','minja'),
(3,'maksim','djoric','maksim','maksim'),
(4,'igor','djordjevic','igor','igor');

/*Table structure for table `skautlicenca` */

DROP TABLE IF EXISTS `skautlicenca`;

CREATE TABLE `skautlicenca` (
  `idSkaut` int(11) NOT NULL,
  `idLicenca` int(11) NOT NULL,
  `datumSticanjaLicence` date NOT NULL,
  PRIMARY KEY (`idSkaut`,`idLicenca`),
  KEY `fk_SkautLicenca_Licenca` (`idLicenca`),
  CONSTRAINT `fk_SkautLicenca_Licenca` FOREIGN KEY (`idLicenca`) REFERENCES `licenca` (`idLicenca`) ON UPDATE CASCADE,
  CONSTRAINT `fk_SkautLicenca_Skaut` FOREIGN KEY (`idSkaut`) REFERENCES `skaut` (`idSkaut`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `skautlicenca` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
