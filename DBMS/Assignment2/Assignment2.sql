USE library_information;

SELECT i.issue_dt, i.accession_no, i.member_id,r.return_dt 
FROM book_issue AS i 
LEFT OUTER JOIN 
book_return AS r 
ON i.accession_no=r.accession_no 
ORDER BY i.issue_dt, (SELECT member_nm FROM members WHERE i.member_id=member_id) ASC;