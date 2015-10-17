
CREATE DATABASE registration;

USE registration;

CREATE  TABLE `registrationData` (

  `userName` VARCHAR(50) NOT NULL ,

  `emailId` VARCHAR(60) NOT NULL ,

  `password` VARCHAR(50) NOT NULL ,

  PRIMARY KEY (`emailId`) );

