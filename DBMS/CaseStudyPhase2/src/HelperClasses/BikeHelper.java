package HelperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import connection.ConnectionUtil;
import pojoClasses.Vehicle;
import pojoClasses.Bike;

/**
 * 
 * @author Richa Mittal
 * Description: This is the helper class for inserting bike into database
 */
public class BikeHelper {
	

	/**
	 * inserts bike into database using prepared statement
	 */
	static boolean insertIntoBike(Vehicle vehicle) {

		
		/*Insert query for bike table*/
		String queryForBike = "INSERT INTO bike (self_start, helmet_price, id)"
				+ " VALUES (?, ?, ?); ";
		System.out.println("-Inserting data into 'bike' table");

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;

		int result=0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		con = connectionUtil.getConnection();
		try {
			/*creating statement*/
			preStmt = con.prepareStatement(queryForBike);
			preStmt.setBoolean(1,((Bike) vehicle).getSelfStart());
			preStmt.setInt(2,((Bike) vehicle).getHelmetPrice());
			preStmt.setString(3,((Bike) vehicle).getId());
			
			/*executing query*/
			result = preStmt.executeUpdate();
	
			System.out.println("--Data Inserted");
			
			if(result>0)
				return true;
			else
				return false;

		} 
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Integrity Constraint violation");
			System.exit(1);
			
		}
		catch (SQLException e) {
			System.out.println("SQL error");
			e.printStackTrace();
		} 
		finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (preStmt != null) {
					preStmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} 
			catch (SQLException e) {
				System.out.println("Error in closing connection");
				e.printStackTrace();
			}
		}
		return false;
	}

}
