package connectionDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author Richa Mittal
 * Description: This contains functions to register drivers and 
 * 				open connection with the database library
 *
 */
public class ConnectionUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
	private static final String USER = "root";
	private static final String PASSWORD = "richa";
			
	private Connection con = null;
	
	/**
	 * registers driver and opens connection
	 * @return the connection that is created
	 */
	public Connection getConnection() {
		
		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
