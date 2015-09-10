/*
@Author: Richa Mittal
@Description: This contains sql queries to find information from
using exsiting database library_information tables
*/


/*Using exsiting database library_information*/
USE library_information;


/*Query to display all the members of members table*/
SELECT * FROM members;


/*Query to display member_nm,member_id,category*/
SELECT member_nm, member_id,category 
FROM members;



/*Query to display member_nm,member_id,category where category is 'F'*/
SELECT member_nm, member_id,category 
FROM members 
WHERE category='F';



/*Query to display various categories*/
SELECT DISTINCT category 
FROM members;



/*Query to display member name and their categories in descending order of members name*/
SELECT member_nm,category 
FROM members 
ORDER BY member_nm DESC;




/*Query to display all the titles, their subjects, and publishers*/
SELECT t.title_nm, s.subject_nm, p.publisher_nm 
FROM titles AS t, subjects AS s, publishers AS p 
WHERE s.subject_id=t.subject_id AND p.publisher_id=t.publisher_id;

/*SELECT t.title_nm, s.subject_nm, p.publisher_nm 
FROM titles AS t 
INNER JOIN 
subjects AS s 
ON s.subject_id=t.subject_id 
INNER JOIN 
publishers AS p 
ON 
p.publisher_id=t.publisher_id;*/


/*Query to display no. of members present in each category*/
SELECT category,COUNT(category) 
FROM members 
GROUP BY CATEGORY;




/*Query to display name of those members who belong to category to
which 'Richa' belongs*/
SELECT DISTINCT m1.member_nm 
FROM members m1 
JOIN 
members m2 
ON 
m1.category 
IN(SELECT category FROM members WHERE member_nm='Richa');


/*Query to display info of all the books issued*/
SELECT i.issue_dt, i.accession_no, i.member_id,r.return_dt 
FROM book_issue AS i 
LEFT OUTER JOIN 
book_return AS r 
ON 
i.issue_dt=r.issue_dt AND i.accession_no=r.accession_no;

