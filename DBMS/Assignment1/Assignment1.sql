USE LIS;


/*Display information of books issued for more than 2 months */
SELECT * FROM
(
SELECT m.member_nm AS member_name,i.member_id,t.title_nm AS title_name,i.accession_no,i.issue_dt,i.due_dt,(DATEDIFF(CURDATE(),i.issue_dt))/30 AS issue_for_Months
FROM book_issue AS i
INNER JOIN 
members AS m
ON
i.member_id=m.member_id
INNER JOIN
books AS b
ON
i.accession_no=b.accession_no
INNER JOIN
titles AS t
ON
b.title_id=t.title_id
WHERE (b.status='Issued' AND DATEDIFF(CURDATE(),i.issue_dt)>60)
UNION
SELECT m.member_nm AS member_name,i.member_id,t.title_nm AS title_name,i.accession_no,i.issue_dt,i.due_dt,(DATEDIFF(r.return_dt,r.issue_dt))/30 AS issue_for_Months
FROM book_issue AS i
INNER JOIN 
members AS m
ON
i.member_id=m.member_id
INNER JOIN
books AS b
ON
i.accession_no=b.accession_no
INNER JOIN
titles AS t
ON
b.title_id=t.title_id
INNER JOIN
book_return AS r
ON 
i.accession_no=r.accession_no AND i.member_id=r.member_id
WHERE (b.status='Not Issued' AND DATEDIFF(r.return_dt,r.issue_dt)>60)

) a
ORDER BY member_name,title_name;





/*Display rows from members table having maximum length for member name */
SELECT member_nm,LENGTH(member_nm) AS Length_Of_Name 
FROM members 
WHERE LENGTH(member_nm) 
IN 
(
SELECT MAX(LENGTH(member_nm)) 
FROM members
);




/*Display count of no. of books issued so far */
SELECT COUNT(DISTINCT accession_no) AS Total_Books_Issued FROM book_issue;
SELECT COUNT(accession_no) AS Total_Books_Issued FROM book_issue;