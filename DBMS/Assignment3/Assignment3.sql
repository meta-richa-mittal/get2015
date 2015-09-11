Use LIS;



/*Display total no of faculties, students and others */
SELECT
(
SELECT COUNT(category) AS No_Of_Faculties
FROM members
GROUP BY category 
HAVING category='F'
) AS No_Of_Faculties,
(
SELECT COUNT(category) AS No_Of_Students
FROM members
GROUP BY category 
HAVING category='S'
) AS No_Of_Students,
(
SELECT COUNT(category) AS No_Of_Others
FROM members
GROUP BY category 
HAVING category='O'
) AS No_Of_Others;




/*Display titles issued more than 2 times */
SELECT DISTINCT titles.title_nm,books.purchase_dt,books.price
FROM 
titles 
INNER JOIN
books
ON
titles.title_id=books.title_id
INNER JOIN
book_issue
ON 
books.accession_no=book_issue.accession_no
AND
book_issue.accession_no
IN
(
SELECT accession_no
FROM book_issue
GROUP BY accession_no 
HAVING
COUNT(accession_no)>2
);




/*Display books issued to category other than 'F' */
SELECT book_issue.issue_dt,book_issue.accession_no,book_issue.member_id,book_issue.due_dt,
members.member_nm,members.addressline1,members.addressline2,members.category
FROM book_issue
INNER JOIN
members
ON
book_issue.member_id=members.member_id
WHERE members.category<>'F';



/*Display authors for which at least one book have been purchased */
SELECT DISTINCT authors.author_fn,authors.author_ln
FROM authors 
INNER JOIN 
title_author 
ON 
authors.author_id=title_author.author_id
WHERE 
title_author.title_id 
IN
(
SELECT title_id 
FROM titles
);