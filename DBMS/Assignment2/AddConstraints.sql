/*
@Author: Richa Mittal
@Description: This contains sql queries to add default constraints to columns
*/



/*using database library_information */
USE library_information;



/*Adding default constraint to issue_dt column*/
ALTER TABLE book_issue MODIFY COLUMN issue_dt TIMESTAMP  NOT NULL DEFAULT NOW();




/*Adding default constraint to due_dt column*/
DELIMITER //

CREATE TRIGGER Book
BEFORE INSERT ON book_issue
FOR EACH ROW 
BEGIN
SET NEW.due_dt = now() + INTERVAL 15 day;
END; //

DELIMITER ;




/*Describe all fields of table book_issue */
DESCRIBE book_issue;