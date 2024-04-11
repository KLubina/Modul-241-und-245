DROP DATABASE IF EXISTS paal;
CREATE DATABASE paal;

USE paal;

CREATE TABLE User (
	usrID INT PRIMARY KEY AUTO_INCREMENT,
    usrName VARCHAr(50),
    usrFName VARCHAr(50),
    usrBDate VARCHAR(50),
    usrExP INT,
    usrLevel INT);

INSERT INTO User (
 	usrID,
    usrName,
    usrFName,
    usrBDate,
    usrExP,
    usrLevel)
VALUES (
	0,
    "Marti",
    "Lukas",
    "24.9.1986",
    0,
    1);
    
CREATE TABLE Card (
	crdID INT PRIMARY KEY AUTO_INCREMENT,
    crdName VARCHAR(50),
    usrID INT,
    crdQuant INT);
    
INSERT INTO Card (
	crdID,
    crdName,
    usrID,
    crdQuant)
VALUES (
	0,
    "JGreed",
    1,
    2),
	(
	0,
    "JMercy",
    1,
    1);
    
CREATE TABLE StudyUnit (
	suID INT PRIMARY KEY AUTO_INCREMENT,
    suHours INT,
    suMin INT,
    suDate VARCHAR(50),
    usrID INT);
    
INSERT INTO StudyUnit (
	suID,
    suHours,
    suMin,
    suDate,
    usrID)
VALUES (
	0,
    1,
    20,
    "25.4.2024",
    1),
	(
    0,
    0,
    55,
    "28.4.2024",
    1);
    
ALTER TABLE StudyUnit
	ADD CONSTRAINT fk_StudyUnit_User_usrID
    FOREIGN KEY (usrID) REFERENCES User (usrID);
    
ALTER TABLE Card
	ADD CONSTRAINT fk_Card_User_usrID
    FOREIGN KEY (usrID) REFERENCES User (usrID);
