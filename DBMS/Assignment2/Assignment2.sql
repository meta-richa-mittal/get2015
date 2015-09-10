/*
@Author: Richa Mittal
@Description: This contains sql queries to find information from
using exsiting database library_information tables
*/


/*Using exsiting database library_information*/
USE library_information;


/*Query to display info of all the books issued with ascending order
of issue date and members name*/
SELECT i.issue_dt, i.accession_no, i.member_id,r.return_dt 
FROM book_issue AS i 
LEFT OUTER JOIN 
book_return AS r 
ON i.accession_no=r.accession_no 
ORDER BY i.issue_dt, (SELECT member_nm FROM members WHERE i.member_id=member_id) ASC;