USE lis;



/*Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/
CREATE VIEW member_issue AS
SELECT m.member_nm, m.member_id, m.addressline1, m.addressline2, m.category,
bi.issue_dt, bi.accession_no, bi.due_dt FROM book_issue bi
INNER JOIN members m
ON m.member_id = bi.member_id;


/*Show view member_issue*/
SELECT * FROM member_issue;



/*Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.
*/
CREATE VIEW member_info AS
SELECT member_nm,member_id,
if ( category = 'O' ,'Other',if ( category = 'S' ,'Student',if ( category = 'F' ,'Faculty',category))) AS category
FROM members;


/*Show view member_info*/
SELECT * FROM member_info;




/*Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
*/
CREATE VIEW book_details AS
SELECT s.subject_nm,t.title_nm,m.member_nm,m.category,bi.issue_dt,bi.due_dt,br.return_dt
FROM books b,subjects s,titles t,members m,
book_issue bi
LEFT OUTER JOIN
book_return br
ON
bi.accession_no=br.accession_no AND bi.member_id=br.member_id
WHERE m.member_id = bi.member_id AND bi.accession_no = b.accession_no AND b.title_id = t.title_id
AND  t.subject_id = s.subject_id;


/*Show view book_details*/
SELECT * FROM book_details;



