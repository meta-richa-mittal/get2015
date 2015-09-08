/*
@Author: Richa Mittal
@Description: This contains sql queries to recreate table
*/



/*using database library_information */
USE library_information;



/*creating table members */
CREATE TABLE members(
member_id INT NOT NULL,
member_nm VARCHAR(20),
addressline1 VARCHAR(15),
addressline2 VARCHAR(15),
category CHAR(1) CHECK(category IN('M','F')),
PRIMARY KEY(member_id)
);

/*Describe table members */
DESCRIBE members;



/*Altering table book_issue to add foreign key constraint*/
ALTER TABLE book_issue
ADD CONSTRAINT book_issue_fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;



/*Altering table book_return to add foreign key constraint*/
ALTER TABLE book_return
ADD CONSTRAINT book_return_fkey1 FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;



/*Show all available tables in the selected database*/
SHOW TABLES;