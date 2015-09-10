CREATE DATABASE eCommerce;


USE eCommerce;

CREATE TABLE category(
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_nm VARCHAR(30),
    parent_id INT
);

DESCRIBE category;


CREATE TABLE product(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_nm VARCHAR(30),
    parent_id INT,
    category_id INT,
    FOREIGN KEY(category_id) REFERENCES category(category_id) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE product AUTO_INCREMENT=100;

DESCRIBE product;



INSERT INTO category(category_nm) VALUES('Mobiles & Tablets');
INSERT INTO category(category_nm) VALUES('Computers');
INSERT INTO category(category_nm) VALUES('Home Appliances');

INSERT INTO category(parent_id,category_nm) VALUES(1,'Mobliles');
INSERT INTO category(parent_id,category_nm) VALUES(1,'Tablets');
INSERT INTO category(parent_id,category_nm) VALUES(1,'Accessories');
INSERT INTO category(parent_id,category_nm) VALUES(1,'Cases & Covers');
INSERT INTO category(parent_id,category_nm) VALUES(2,'Desktop');
INSERT INTO category(parent_id,category_nm) VALUES(2,'Laptop');
INSERT INTO category(parent_id,category_nm) VALUES(2,'Laptop Accessories');
INSERT INTO category(parent_id,category_nm) VALUES(2,'Printers');
INSERT INTO category(parent_id,category_nm) VALUES(3,'TVs');
INSERT INTO category(parent_id,category_nm) VALUES(3,'Air Conditioners');
INSERT INTO category(parent_id,category_nm) VALUES(3,'Washing Machines');



INSERT INTO product(category_id,product_nm) VALUES(4,'Smart Phones');
INSERT INTO product(category_id,product_nm) VALUES(4,'Featured Phones');
INSERT INTO product(category_id,product_nm) VALUES(5,'2G');
INSERT INTO product(category_id,product_nm) VALUES(5,'3G');
INSERT INTO product(category_id,product_nm) VALUES(10,'Keyboard');
INSERT INTO product(category_id,product_nm) VALUES(10,'Mouse');
INSERT INTO product(category_id,product_nm) VALUES(10,'Headphones');
INSERT INTO product(category_id,product_nm) VALUES(11,'Inkjet');
INSERT INTO product(category_id,product_nm) VALUES(11,'Laser');
INSERT INTO product(category_id,product_nm) VALUES(12,'LED');
INSERT INTO product(category_id,product_nm) VALUES(12,'LCD');
INSERT INTO product(category_id,product_nm) VALUES(12,'Plasma');
INSERT INTO product(category_id,product_nm) VALUES(14,'Full Automatic');
INSERT INTO product(category_id,product_nm) VALUES(14,'Semi Automatic');


INSERT INTO product(product_nm,parent_id) VALUES('Top Load',112);
INSERT INTO product(product_nm,parent_id) VALUES('Front Load',112);




SELECT c1.category_nm as category, IFNULL(c2.category_nm,'Top Category') as parent
FROM category AS c1 
LEFT JOIN
category AS c2
ON
c1.parent_id=c2.category_id
ORDER BY parent;




SELECT category_nm
FROM category 
WHERE parent_id IS NULL;