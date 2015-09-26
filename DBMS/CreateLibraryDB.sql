/*
@Author: Richa Mittal
@Description: This contains sql queries to create database, tables
And other queries
*/


/*Creating new database*/
CREATE DATABASE library;


/*Using newly created database*/
USE library;

/*Creating new table named authors*/
CREATE TABLE authors(
author_id INT NOT NULL,
author_nm VARCHAR(30),
PRIMARY KEY(author_id)
);



/*Describe all fields of table authors */
DESCRIBE authors;




/*Creating new table named publishers*/
CREATE TABLE publishers(
publisher_id INT NOT NULL,
publisher_nm VARCHAR(20),
PRIMARY KEY(publisher_id)
);


/*Describe all fields of table publishers */
DESCRIBE publishers;



/*Creating new table named subjects*/
CREATE TABLE subjects(
subject_id INT NOT NULL,
subject_nm VARCHAR(30),
PRIMARY KEY(subject_id)
);


/*Describe all fields of table subjects */
DESCRIBE subjects;




/*Creating new table named members*/
CREATE TABLE members(
member_id INT NOT NULL,
member_nm VARCHAR(20),
addressline1 VARCHAR(15),
addressline2 VARCHAR(15),
category CHAR(1) CHECK(category IN('S','F','O')),
PRIMARY KEY(member_id)
);


/*Describe all fields of table members */
DESCRIBE members;




/*Creating new table named titles*/
CREATE TABLE titles(
title_id INT NOT NULL,
title_nm VARCHAR(20),
subject_id INT,
publisher_id INT,
PRIMARY KEY(title_id),
FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Describe all fields of table titles */
DESCRIBE titles;





/*Creating new table named books*/
CREATE TABLE books(
accession_no INT NOT NULL,
title_id INT,
purchase_dt DATE,
price DOUBLE,
status VARCHAR(15),
PRIMARY KEY(accession_no),
FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Describe all fields of table books */
DESCRIBE books;





/*Creating new table named title_author*/
CREATE TABLE title_author(
title_id INT NOT NULL,
author_id INT,
PRIMARY KEY(title_id, author_id),
FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Describe all fields of table title_author */
DESCRIBE title_author;




/*Creating new table named book_issue*/
CREATE TABLE book_issue(
issue_dt DATE,
accession_no INT,
member_id INT,
due_dt DATE,
PRIMARY KEY(issue_dt, accession_no, member_id),
CONSTRAINT book_issue_fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT book_issue_fkey2 FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Describe all fields of table book_issue */
DESCRIBE book_issue;




/*Creating new table named book_return*/
CREATE TABLE book_return(
return_dt DATE,
accession_no INT,
member_id INT,
issue_dt DATE,
PRIMARY KEY(return_dt, accession_no, member_id),
CONSTRAINT book_return_fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT book_return_fkey2 FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Describe all fields of table book_return */
DESCRIBE book_return;

/******************************************************************/




/*using database LIS */
USE library;



/*Adding default constraint to issue_dt column*/
ALTER TABLE book_issue MODIFY COLUMN issue_dt TIMESTAMP  NOT NULL DEFAULT NOW();


/*Adding default constraint to due_dt column*/
/*
DELIMITER //

CREATE TRIGGER Book
AFTER INSERT ON book_issue
FOR EACH ROW 
BEGIN
if book_issue.issue_dt=now() then
 SET new.due_dt = now() + INTERVAL 15 day;
end if;
END; //

DELIMITER ;
*/


/*Describe all fields of table book_issue */
DESCRIBE book_issue;


/**********************************************************************/



/*Inserting data into authors table*/
INSERT INTO authors VALUES(111,'Yashwant Kanetkar');
INSERT INTO authors VALUES(222,'Henry Korth');
INSERT INTO authors VALUES(333,'John Andew');
INSERT INTO authors VALUES(444,'James Kurose');




/*Inserting data into publishers table*/
INSERT INTO publishers VALUES(55,'Schaum Series');
INSERT INTO publishers VALUES(66,'Tata MacGraw Hills');
INSERT INTO publishers VALUES(77,'Genius');



/*Inserting data into members table*/
INSERT INTO members VALUES(001,'Richa','Gopal Pura','Delhi','F');
INSERT INTO members VALUES(002,'Nidhi','Gandhi Nagar','Mumbai','F');
INSERT INTO members VALUES(003,'Shivam','Mansarovar','Gurgaon','S');
INSERT INTO members VALUES(004,'Suman','Triveni Nagar','Jaipur','S');
INSERT INTO members VALUES(005,'Chetna','Mansarovar','Jaipur','O');


/*Inserting data into subjects table*/
INSERT INTO subjects VALUES(1,'C');
INSERT INTO subjects VALUES(2,'DSA');
INSERT INTO subjects VALUES(3,'DBMS');
INSERT INTO subjects VALUES(4,'CN');



/*Inserting data into titles table*/
INSERT INTO titles VALUES(101,'Let Us C',1,77);
INSERT INTO titles VALUES(102,'Understanding C',1,66);
INSERT INTO titles VALUES(103,'DSA Concepts',2,55);
INSERT INTO titles VALUES(104,'DBMS Concepts',3,66);
INSERT INTO titles VALUES(105,'Computer Networking',4,55);
INSERT INTO titles VALUES(106,'Networks Concepts',4,66);
INSERT INTO titles VALUES(107,'DSA for You',2,66);






/*Inserting data into books table*/
INSERT INTO books VALUES(12345,101,'2004-04-04',300,'Issued');
INSERT INTO books VALUES(12346,102,'2009-09-17',450,'Not Issued');
INSERT INTO books VALUES(56789,103,'2000-01-22',200,'Not Issued');
INSERT INTO books VALUES(11111,104,'2014-07-23',400,'Issued');
INSERT INTO books VALUES(22222,105,'2002-06-12',350,'Issued');
INSERT INTO books VALUES(33333,106,'2011-03-02',200,'Not Issued');
INSERT INTO books VALUES(44444,107,'2012-05-02',250,'Not Issued');


/*Inserting data into title_author table*/
INSERT INTO title_author VALUES(101,111);
INSERT INTO title_author VALUES(102,333);
INSERT INTO title_author VALUES(103,111);
INSERT INTO title_author VALUES(104,222);
INSERT INTO title_author VALUES(105,444);
INSERT INTO title_author VALUES(106,333);



/*Inserting data into book_issue table*/
INSERT INTO book_issue VALUES('2015-09-09',12345,001,'2015-09-24');
INSERT INTO book_issue VALUES('2015-09-01',12346,002,'2015-09-20');
INSERT INTO book_issue VALUES('2015-09-09',11111,003,'2015-09-09');
INSERT INTO book_issue VALUES('2015-09-08',56789,001,'2015-09-23');
INSERT INTO book_issue VALUES('2014-08-07',22222,004,'2014-07-22');
INSERT INTO book_issue VALUES('2015-06-10',33333,005,'2015-06-25');



/*Inserting data into book_return table*/
INSERT INTO book_return VALUES('2015-09-08',12346,002,'2015-09-01');
INSERT INTO book_return VALUES('2015-09-10',56789,001,'2015-09-08');
INSERT INTO book_return VALUES('2015-09-10',33333,005,'2015-06-10');







