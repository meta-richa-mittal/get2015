package HelperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import pojoClasses.Vehicle;
import connection.ConnectionUtil;


/**
 * 
 * @author Richa Mittal
 * Description: This is the helper class for inserting vehicle into database
 */
public class HelperVehicle {
	
	
	/**
	 * inserts vehicle into database using prepared statement
	 */
	public static boolean InsertIntoVehicle(Vehicle vehicle,String vehicleType) {
		
		/*Insert query for vehicle table*/
		String query = "INSERT INTO vehicle (id, created_by, created_time, make, model, engine_in_CC, fuel_capacity,"
		+ " milage, price, roadTax)"
		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";	


		System.out.println("-Inserting data into 'vehicle' table");
		//insertIntoDatabase(query,vehicle);
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;

		int result=0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		con = connectionUtil.getConnection();
		try {
			/*creating statement*/
			preStmt = con.prepareStatement(query);
			preStmt.setString(1,vehicle.getId());
			preStmt.setString(2,vehicle.getCreated_by());
			preStmt.setString(3,vehicle.getCreated_time());
			preStmt.setString(4,vehicle.getMake());
			preStmt.setString(5,vehicle.getModel());
			preStmt.setInt(6,vehicle.getEngineInCC());
			preStmt.setInt(7,vehicle.getFuelCapacity());
			preStmt.setInt(8,vehicle.getMilage());
			preStmt.setInt(9,vehicle.getPrice());
			preStmt.setInt(10,vehicle.getRoadTax());
			/*executing query*/
			result = preStmt.executeUpdate();
	
			System.out.println("--Data Inserted");
			if(result>0) {
				if(vehicleType.equalsIgnoreCase("car")) {
					  boolean b = CarHelper.insertIntoCar(vehicle);
					  if(b==true)
						  return true;
					  else
						  return false;
				}
				else if(vehicleType.equalsIgnoreCase("bike")) {
					 boolean b = BikeHelper.insertIntoBike(vehicle);
					 if(b==true)
						 return true;
					 else
						 return false;
				}
			}

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
