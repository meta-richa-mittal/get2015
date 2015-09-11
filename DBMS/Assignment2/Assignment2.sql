USE LIS;


/*Display subject wise info on no. of books purchased */
SELECT s.subject_nm,s.subject_id,COUNT(t.subject_id) AS No_Of_Books 
FROM subjects AS s 
INNER JOIN 
titles AS t 
ON 
s.subject_id=t.subject_id 
GROUP BY t.subject_id;



/*Display rows from book_issue table where a book can be returned after 2 months */
SELECT m.member_nm,m.member_id,t.title_nm,t.title_id,b.accession_No,b.issue_dt,b.due_dt , DATEDIFF(due_dt,issue_dt ) AS DiffDate 
FROM members m,book_issue b,titles t, books bk
WHERE 
(
m.member_id = b.member_id 
AND t.title_id = bk.title_id AND bk.accession_no = b.accession_no
) 
AND
(
DATEDIFF(b.due_dt,b.issue_dt ) > 60);






/*Display list of books having price greater than minimum price 
of books purchased so far*/
SELECT title_nm 
FROM titles 
JOIN 
books 
ON 
titles.title_id=books.title_id 
WHERE price > (
SELECT MIN(price) 
FROM books
);