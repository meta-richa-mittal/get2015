

CREATE DATABASE VehicleManagement;

USE VehicleManagement;



/*Create table vehicle*/
CREATE TABLE vehicle(
	id VARCHAR(20) PRIMARY KEY,
	created_by VARCHAR(100),
	created_time VARCHAR(100),
	make VARCHAR(100),
	model VARCHAR(100),
	engine_in_CC int,
	fuel_capacity int,
	milage int,
	price int,
	roadTax int
);



/*Creating Table car*/
CREATE TABLE car(
  AC VARCHAR(100),
  power_steering VARCHAR(100),
  accessory_kit VARCHAR(100),
  id VARCHAR(20),
  CONSTRAINT freign_key1 FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE ON UPDATE CASCADE 
);


/*Creating Table bike*/
CREATE TABLE bike(
  self_start VARCHAR(100),
	helmet_price int,
	id VARCHAR(20),
  	CONSTRAINT freign_key2 FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE ON UPDATE CASCADE
);

