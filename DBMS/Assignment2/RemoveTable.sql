/*using database library_information */
USE library_information;



/*Altering table book_issue to remove foreign key constraint*/
ALTER TABLE book_issue
DROP FOREIGN KEY book_issue_fkey1;


/*
@Author: Richa Mittal
@Description: This contains sql queries to delete table having foreign key constraints
*/




/*Altering table book_return to remove foreign key constraint*/
ALTER TABLE book_return
DROP FOREIGN KEY book_return_fkey1;



/*Droping table members*/
DROP TABLE members;



/*Show all available tables in the selected database*/
SHOW TABLES;