package HelperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import pojoClasses.Car;
import pojoClasses.Vehicle;
import connection.ConnectionUtil;

public class CarHelper {

	
public static void InsertIntoVehicle(Vehicle vehicle) {
		
		/*Insert query for vehicle table*/
		String query = "INSERT INTO vehicle VALUES('" + vehicle.getId() + "','"
				+ vehicle.getCreated_by() + "','" + vehicle.getCreated_time()
				+ "','" + vehicle.getMake() + "','" + vehicle.getModel() + "',"
				+ vehicle.getEngineInCC() + "," + vehicle.getFuelCapacity()
				+ "," + vehicle.getMilage() + "," + vehicle.getPrice() + ","
				+ vehicle.getRoadTax() + ");";
		
		System.out.println("-Inserting data into 'vehicle' table");
		insertIntoDatabase(query);
		
			
			/*Insert query for bike table*/
		String queryForCar = "INSERT INTO car (AC,power_steering,accessory_kit,ID) VALUES('"
				+ ((Car) vehicle).getAC()
				+ "','"
				+ ((Car) vehicle).getPowerSteering()
				+ "','"
				+((Car) vehicle).getAccessoryKit()
				+"','"
				+ vehicle.getId() + "');";
		
		System.out.println("-Inserting data into 'car' table");
		insertIntoDatabase(queryForCar);
		
	}

	private static void insertIntoDatabase(String query) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		con = connectionUtil.getConnection();
		try {
			/*creating statement*/
			preStmt = con.prepareStatement(query);
			/*executing query*/
			preStmt.execute();
			System.out.println("--Data inserted");

		} 
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Integrity Constraint violation");
			System.exit(1);
			
		}
		catch (SQLException e) {
			System.out.println("SQL error");
			System.exit(1);
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
	}
}
