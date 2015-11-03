DROP DATABASE employee;


CREATE DATABASE employee;

Use employee;
CREATE  TABLE `employee`.`EmployeeTable1` (
	`id` INT NOT NULL,
    
  `name` VARCHAR(50) NOT NULL ,

  `email` VARCHAR(45) NOT NULL ,

  `dob` VARCHAR(45) NOT NULL ,

  `address` VARCHAR(45) NOT NULL ,

  `salary` DOUBLE NOT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `id_UNIQUE` (`id` ASC) );
  
insert into Employeetable1(id,name,email,dob,address,salary) values(101,'Richa','richa@gmail.com','17Sep','Jaipur',20000);
insert into Employeetable1(id,name,email,dob,address,salary) values(102,'Nidhi','nidhi@gmail.com','23Nov','Sirohi',20000);
insert into Employeetable1(id,name,email,dob,address,salary) values(103,'Suman','suman@gmail.com','2Jan','Jaipur',20000);