CREATE DATABASE  if not exists VehicleManagement;

USE VehicleManagement;

drop table if exists car;

drop table if exists vehicle;

/*Create table vehicle*/
CREATE TABLE vehicle(
	id VARCHAR(50) PRIMARY KEY ,
	created_by VARCHAR(100) not null,
	created_time VARCHAR(100) not null,
	make VARCHAR(100) not null,
	model VARCHAR(100) not null,
	engine_in_CC int unsigned not null,
	fuel_capacity int unsigned not null,
	milage int unsigned not null,
	price int not null,
	roadTax int unsigned not null
);



/*Creating Table car*/
CREATE TABLE car(
  AC boolean not null,
  power_steering boolean not null,
  accessory_kit VARCHAR(100) not null,
  id VARCHAR(50) PRIMARY KEY,
  CONSTRAINT freign_key1 FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE ON UPDATE CASCADE 
);