package com.car.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.exception.CarSystemException;
import com.car.model.Car;
import com.car.model.Vehicle;

public class VehicleDbHelper {
	
	private static String INSERT_VEHICLE_QUERY = "insert into vehicle (id, created_by, created_time, make, model, engine_in_CC, fuel_capacity, milage, price, roadTax) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static String SELECT_FOR_VEHICLE_ID_QUERY = "select id from vehicle where id=?";
	
	private static String UPDATE_VEHICLE_QUERY = "update vehicle set created_by=?, created_time=?, engine_in_CC=?, fuel_capacity=?, milage=?, price=?, roadTax=?, make=?, model=? where id=?";
	
	private static String SELECT_BY_BRAND_QUERY = "select * from vehicle where make=?";
	
	private static String SELECT_BY_BUDGET_QUERY1 = "select * from vehicle where price <= ?";
	
	private static String SELECT_BY_BUDGET_QUERY2 = "select * from vehicle where price >= ?";
	
	private static String SELECT_FOR_ID_QUERY = "select * from vehicle where id=?";
	
	protected void create(Connection connection, Vehicle vehicle) throws CarSystemException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(INSERT_VEHICLE_QUERY);
			preparedStatement.setString(1, vehicle.getId());
			preparedStatement.setString(2, vehicle.getCreated_by());
			preparedStatement.setString(3, vehicle.getCreated_time());
			preparedStatement.setString(4, vehicle.getMake());
			preparedStatement.setString(5, vehicle.getModel());
			preparedStatement.setInt(6, vehicle.getEngineInCC());
			preparedStatement.setInt(7, vehicle.getFuelCapacity());
			preparedStatement.setInt(8, vehicle.getMilage());
			preparedStatement.setInt(9, vehicle.getPrice());
			preparedStatement.setInt(10, vehicle.getRoadTax());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new CarSystemException("Could not create Vehicle, [" + e.getMessage() + "]");
		} finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
				}
			}
		}
	}
	
	
	protected String getVehicleIdById(Connection connection, String vehicleId) throws CarSystemException {
		String id = null;
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(SELECT_FOR_VEHICLE_ID_QUERY);
				preparedStatement.setString(1, vehicleId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					id = resultSet.getString(1);
				}
			} catch(SQLException e) {
				throw new CarSystemException("Could not find Car by model, [" + e.getMessage() + "]");
			}
		}
		return id;
	}
	
	
	protected Vehicle getVehicleById(Connection connection, String id) throws CarSystemException {
		Vehicle vehicle= new Vehicle();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				preparedStatement = connection.prepareStatement(SELECT_FOR_ID_QUERY);
				preparedStatement.setString(1, id);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					
					vehicle.setId(resultSet.getString("id"));
					vehicle.setCreated_by(resultSet.getString("created_by"));
					vehicle.setCreated_time(resultSet.getString("created_time"));
					vehicle.setEngineInCC(Integer.parseInt(resultSet.getString("engine_in_CC")));
					vehicle.setFuelCapacity(Integer.parseInt(resultSet.getString("fuel_capacity")));
					vehicle.setMake(resultSet.getString("make"));
					vehicle.setMilage(Integer.parseInt(resultSet.getString("milage")));
					vehicle.setModel(resultSet.getString("model"));
					vehicle.setPrice(Integer.parseInt(resultSet.getString("price")));
					vehicle.setRoadTax(Integer.parseInt(resultSet.getString("roadTax")));
				}
			} catch(SQLException e) {
				throw new CarSystemException("Could not find Car by id, [" + e.getMessage() + "]");
			}
		}
		return vehicle;
	}


	public List<Vehicle> searchBrand(Connection connection, String brand) throws CarSystemException {
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		if(connection != null) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(SELECT_BY_BRAND_QUERY);
				preparedStatement.setString(1, brand);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Vehicle vehicle= new Vehicle();
					vehicle.setId(resultSet.getString("id"));
					vehicle.setCreated_by(resultSet.getString("created_by"));
					vehicle.setCreated_time(resultSet.getString("created_time"));
					vehicle.setEngineInCC(Integer.parseInt(resultSet.getString("engine_in_CC")));
					vehicle.setFuelCapacity(Integer.parseInt(resultSet.getString("fuel_capacity")));
					vehicle.setMake(resultSet.getString("make"));
					vehicle.setMilage(Integer.parseInt(resultSet.getString("milage")));
					vehicle.setModel(resultSet.getString("model"));
					vehicle.setPrice(Integer.parseInt(resultSet.getString("price")));
					vehicle.setRoadTax(Integer.parseInt(resultSet.getString("roadTax")));
					//System.out.print(vehicle.toString());
					listOfVehicles.add(vehicle);
				}
				
			} catch (SQLException e) {
				throw new CarSystemException("Could not search Vehicle, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
			}
		}
		
		return listOfVehicles;
	}


	public List<Vehicle> searchBudget(Connection connection, String filterValue) throws CarSystemException {
	
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		if(connection != null) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
			try {
				if(filterValue.equals("below 5 lac")) {
					preparedStatement = connection.prepareStatement(SELECT_BY_BUDGET_QUERY1);
				}
				else if(filterValue.equals("above 5 lac")) {
					preparedStatement = connection.prepareStatement(SELECT_BY_BUDGET_QUERY2);
				}
				
				preparedStatement.setInt(1, 500000);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Vehicle vehicle= new Vehicle();
					vehicle.setId(resultSet.getString("id"));
					vehicle.setCreated_by(resultSet.getString("created_by"));
					vehicle.setCreated_time(resultSet.getString("created_time"));
					vehicle.setEngineInCC(Integer.parseInt(resultSet.getString("engine_in_CC")));
					vehicle.setFuelCapacity(Integer.parseInt(resultSet.getString("fuel_capacity")));
					vehicle.setMake(resultSet.getString("make"));
					vehicle.setMilage(Integer.parseInt(resultSet.getString("milage")));
					vehicle.setModel(resultSet.getString("model"));
					vehicle.setPrice(Integer.parseInt(resultSet.getString("price")));
					vehicle.setRoadTax(Integer.parseInt(resultSet.getString("roadTax")));
					
					listOfVehicles.add(vehicle);
				}
				
			} catch (SQLException e) {
				throw new CarSystemException("Could not search Vehicle, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
			}
		}
		
		return listOfVehicles;
	}


	public void edit(Connection connection,Vehicle vehicle) throws CarSystemException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_VEHICLE_QUERY);
			preparedStatement.setString(10, vehicle.getId());
			preparedStatement.setString(1, vehicle.getCreated_by());
			preparedStatement.setString(2, vehicle.getCreated_time());
			
			preparedStatement.setInt(3, vehicle.getEngineInCC());
			preparedStatement.setInt(4, vehicle.getFuelCapacity());
			preparedStatement.setInt(5, vehicle.getMilage());
			preparedStatement.setInt(6, vehicle.getPrice());
			preparedStatement.setInt(7, vehicle.getRoadTax());
			preparedStatement.setString(8, vehicle.getMake());
			preparedStatement.setString(9, vehicle.getModel());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new CarSystemException("Could not edit Vehicle, [" + e.getMessage() + "]");
		} finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
				}
			}
		}
	}
	

}
