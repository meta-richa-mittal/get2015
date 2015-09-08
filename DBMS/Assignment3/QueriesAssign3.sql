/*
@Author: Richa Mittal
@Description: This contains sql queries to updating values, delete table, insert using substitution, and deleting a particular row
*/



/*Sets sql updates to 0*/
SET SQL_SAFE_UPDATES = 0;



/*Changing value of addressLine2 column of Members table with “Jaipur”*/
UPDATE members
SET addressline2='Jaipur';


/*Changing value of addressLine1 column of Members table with value “EPIP,
Sitapura” for the members belonging to category “F”*/
UPDATE members
SET addressline1='EPIP, Sitapura'
WHERE category='F';




/*Deleting all the rows from Publishers table*/
DELETE FROM publishers;





/*Insert the sample data back in Publishers table using substitution variables*/


/*Setting substitution variables*/
SET @pub_id_inp1=55, @pub_nm_inp1='Schaum Series',@pub_id_inp2=66, 
@pub_nm_inp2='Tata MacGraw Hills',@pub_id_inp3=77, @pub_nm_inp3='Genius';


/*inserting into publishers table using substitution variables*/
INSERT INTO publishers VALUES(@pub_id_inp1,@pub_nm_inp1);
INSERT INTO publishers VALUES(@pub_id_inp2,@pub_nm_inp2);
INSERT INTO publishers VALUES(@pub_id_inp3,@pub_nm_inp3);


/*reinserting into titles table*/
INSERT INTO titles VALUES(101,'Let Us C',1,77);
INSERT INTO titles VALUES(102,'Understanding C',1,66);
INSERT INTO titles VALUES(103,'DSA Concepts',2,55);
INSERT INTO titles VALUES(104,'DBMS Concepts',3,66);



/*Delete those rows of Titles table belonging to Publisher with publisher_id = 55*/
DELETE FROM  titles WHERE publisher_id=55;



