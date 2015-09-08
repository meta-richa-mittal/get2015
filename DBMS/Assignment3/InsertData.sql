/*
@Author: Richa Mittal
@Description: This contains sql queries to insert values into tables
*/




/*Inserting data into authors table*/
INSERT INTO authors VALUES(111,'Yashwant','Kanetkar');
INSERT INTO authors VALUES(222,'Henry','Korth');
INSERT INTO authors VALUES(333,'John','Andew');



/*Inserting data into publishers table*/
INSERT INTO publishers VALUES(55,'Schaum Series');
INSERT INTO publishers VALUES(66,'Tata MacGraw Hills');
INSERT INTO publishers VALUES(77,'Genius');



/*Inserting data into members table*/
INSERT INTO members VALUES(001,'Richa','Gopal Pura','Delhi','F');
INSERT INTO members VALUES(002,'Nidhi','Gandhi Nagar','Mumbai','F');
INSERT INTO members VALUES(003,'Shivam','Mansarovar','Gurgaon','M');



/*Inserting data into subjects table*/
INSERT INTO subjects VALUES(1,'C');
INSERT INTO subjects VALUES(2,'DSA');
INSERT INTO subjects VALUES(3,'DBMS');




/*Inserting data into titles table*/
INSERT INTO titles VALUES(101,'Let Us C',1,77);
INSERT INTO titles VALUES(102,'Understanding C',1,66);
INSERT INTO titles VALUES(103,'DSA Concepts',2,55);
INSERT INTO titles VALUES(104,'DBMS Concepts',3,66);





/*Inserting data into books table*/
INSERT INTO books VALUES(12345,101,'2004-04-04',300,'Issued');
INSERT INTO books VALUES(12346,102,'2009-09-17',450,'Not Issued');
INSERT INTO books VALUES(56789,103,'2000-01-22',200,'Issued');
INSERT INTO books VALUES(11111,104,'2014-07-22',400,'Issued');


/*Inserting data into title_author table*/
INSERT INTO title_author VALUES(101,111);
INSERT INTO title_author VALUES(102,333);
INSERT INTO title_author VALUES(103,111);
INSERT INTO title_author VALUES(104,222);



/*Inserting data into book_issue table*/
INSERT INTO book_issue(accession_no,member_id) VALUES(12345,001);
INSERT INTO book_issue VALUES('2015-09-01',56789,002,'2015-09-20');
INSERT INTO book_issue(accession_no,member_id) VALUES(11111,003);



/*Inserting data into book_return table*/
INSERT INTO book_return VALUES('2015-09-08',56789,002,'2015-09-01');



