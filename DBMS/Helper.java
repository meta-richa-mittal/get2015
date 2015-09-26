package connectionDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains functions to fetch results from database 
 * 				for different queries
 *
 */
public class Helper {
	
	String titleName;
	
	/**
	 * Getter for titleName
	 * @return titleName of book
	 */
	public String getTitleName()
	{
		return titleName;
	}
	
	
	/**
	 * Setter for titleName
	 */
	public void setTitleName(String titleName)
	{
		this.titleName = titleName;
	}
	
	
	
	
	/**
	 * Fetch books by the author name
	 * @param authorName: name of author whose books are to be listed
	 * @return list of books
	 */
	public static ArrayList<Helper> getBooksByAuthorName(String authorName) 
	{
		ArrayList<Helper> titleList = new ArrayList<Helper>();
		String query = "SELECT TITLE_NM FROM TITLES WHERE TITLE_ID IN (SELECT TITLE_ID FROM TITLE_AUTHOR WHERE AUTHOR_ID IN (SELECT AUTHOR_ID FROM AUTHORS WHERE AUTHOR_NM like '%"
				+ authorName + "%' ));";					// query to fetch required result
		
		Connection con = null;							// opening connection
		
		ResultSet rs = null;							// Result set to store the result
		Statement stmt = null;
		
		ConnectionUtil conUtil = new ConnectionUtil();	
		
		Helper title = null;							// Creating object of the class
		con = conUtil.getConnection();					// Establishing the connection
		try 
		{
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);				// Executing the statement
			while (rs.next())
			{
				title = new Helper();
				title.setTitleName(rs.getString(1));
				titleList.add(title);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return titleList;
	}
	
	
	
	
	
	/**
	 * Issues book by the name of the book to member name like "ric%"
	 * @param bookName: name of book to be issued
	 * @return status whether book has been issued or not
	 */
	public static int bookIssueByBookName(String bookName)
	{
		// Query to update the Table
		String query = "INSERT INTO Book_Issue(issue_dt,accession_No, member_id, due_dt) VALUES(now(),(select accession_no  from books where status='Not Issued' and title_id =( select title_id from titles where title_nm= '"
				+ bookName+ "' ) limit 0,1), (select member_id from members where member_nm like  'ric%'),DATE_ADD(now(),INTERVAL 15 DAY));";
		// Query to update the status
		String nextQuery = "update books set status='Issued' where  title_id =( select title_id from titles where title_nm= '"+ bookName + "') and status ='Not Issued' limit 1;";
		
		int flag = 0;									// flag for whether book issued or not
		Connection con = null;
		Statement statement = null;
		Statement nextStatement = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try
		{
			
			statement = con.createStatement();			// creating statement
			
			flag = statement.executeUpdate(query);		// Calling the Query
			if (flag != 0)
			{
				
				nextStatement = con.createStatement();	
				nextStatement.executeUpdate(nextQuery);	// Calling the nextQuery
			}
		} 
		catch (SQLException e) 
		{
			return flag;
		}
		return flag;
	}
	
	
	
	
	/**
	 * Delete the books not issued in last one year
	 * @return no. of books deleted
	 */
	public static int deleteBooksLaterThan1Year() 
	{
		// Query to delete the Value
		String query="delete from books where accession_no not in("
					+"select bi.accession_no from book_issue bi where datediff(now(),bi.issue_dt)<365);";
		int deletedBooks = 0;							// stores no. of books deleted
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			
			deletedBooks = stmt.executeUpdate(query);	// Executing the Query
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return deletedBooks;
		}
		return deletedBooks;
	}

}
