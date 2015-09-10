/*
@Author: Richa Mittal
@Description: This contains sql queries to create database, tables
and to find information from those tables
*/

/*Creating new database*/
CREATE DATABASE zipcode_information;

/*Using newly created database*/
USE zipcode_information;


/*Creating new table named state_info*/
CREATE TABLE state_info(
state_id INT PRIMARY KEY AUTO_INCREMENT,
state_nm VARCHAR(20)
);

DESCRIBE state_info;


/*Creating new table named city_info*/
CREATE TABLE city_info(
city_id INT PRIMARY KEY AUTO_INCREMENT,
city_nm VARCHAR(20),
state_id INT,
FOREIGN KEY(state_id) REFERENCES state_info(state_id) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE city_info AUTO_INCREMENT=101;

DESCRIBE city_info;


/*Creating new table named zipcode_info*/
CREATE TABLE zipcode_info(
zipcode BIGINT PRIMARY KEY,
city_id INT,
FOREIGN KEY(city_id) REFERENCES city_info(city_id) ON DELETE CASCADE ON UPDATE CASCADE
);

DESCRIBE zipcode_info;


/*Inserting values into table named state_info*/
INSERT INTO state_info(state_nm) VALUES
('Rajasthan'),
('UP'),
('Maharashtra'),
('Bihar');


/*Inserting values into table named city_info*/
INSERT INTO city_info(city_nm,state_id) VALUES
('Jaipur',1),
('Ajmer',1),
('Mumbai',3),
('Patna',4),
('Gaziabad',2),
('Bareilly',2);


/*Inserting values into table named zipcode_info*/
INSERT INTO zipcode_info(zipcode,city_id) VALUES
(302018,101),
(302022,102),
(203015,103),
(110320,104),
(312202,105),
(312201,106);



/*query for that returns a Resultset
containing Zip Code, City Names and
States ordered by State Name and City Name*/
SELECT zipcode,city_nm,state_nm 
FROM zipcode_info 
INNER JOIN
city_info
ON
zipcode_info.city_id=city_info.city_id
INNER JOIN
state_info
ON
city_info.state_id=state_info.state_id
ORDER BY state_nm,city_nm;