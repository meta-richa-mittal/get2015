/*
@Author: Richa Mittal
@Description: This contains sql queries to create database, and tables
*/


/*Creating new database*/
CREATE DATABASE library_information;


/*Using newly created database*/
USE library_information;


/*Creating new table named authors*/
CREATE TABLE authors(
author_id INT NOT NULL,
author_fn VARCHAR(20),
author_ln VARCHAR(20),
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
category CHAR(1) CHECK(category IN('M','F')),
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



