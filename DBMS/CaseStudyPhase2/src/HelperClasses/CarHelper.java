package HelperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import pojoClasses.Car;
import pojoClasses.Vehicle;
import connection.ConnectionUtil;


/**
 * 
 * @author Richa Mittal
 * Description: This is the helper class for inserting car into database
 */
public class CarHelper {


	/**
	 * inserts car into database using prepared statement
	 */
	static boolean insertIntoCar(Vehicle vehicle) {

		/*Insert query for bike table*/
		String queryForBike = "INSERT INTO Car (id, AC, power_steering, accessory_kit)"
				+ " VALUES (?, ?, ?, ?); ";
		System.out.println("-Inserting data into 'car' table");

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;

		int result=0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		con = connectionUtil.getConnection();
		try {
			/*creating statement*/
			preStmt = con.prepareStatement(queryForBike);
			preStmt.setString(1,vehicle.getId());
			preStmt.setBoolean(2,((Car) vehicle).getAC());
			preStmt.setBoolean(3,((Car) vehicle).getPowerSteering());
			preStmt.setString(4,((Car) vehicle).getAccessoryKit());
			
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
