package HelperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import connection.ConnectionUtil;
import pojoClasses.Vehicle;
import pojoClasses.Bike;


public class BikeHelper {
	
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
				String queryForBike = "INSERT INTO bike (se"
						+ "lf_start,helmet_price,ID) VALUES('"
						+ ((Bike) vehicle).getSelfStart()
						+ "',"
						+ ((Bike) vehicle).getHelmetPrice()
						+ ",'"
						+ vehicle.getId() + "');";
				
				System.out.println("-Inserting data into 'bike' table");
				insertIntoDatabase(queryForBike);
				
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
			System.out.println("--Data Inserted");

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
	}

}
