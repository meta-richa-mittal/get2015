package com.car.db.helper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.exception.CarSystemException;
import com.car.db.ConnectionFactory;
import com.car.model.Car;
import com.car.model.Vehicle;

public class CarDbHelper extends VehicleDbHelper {
	
	private static String INSERT_CAR_QUERY = "insert into car (AC, power_steering, accessory_kit, id) VALUES (?, ?, ?, ?)";
	
	private static String SELECT_FOR_MODEL_QUERY = "Select v.id id, v.make make, v.engine_in_CC engine_in_CC, v.fuel_capacity fuel_capacity, v.milage milage, v.price price, v.roadTax roadTax, "
													+ " c.id id, c.AC AC, c.power_steering power_steering, c.accessory_kit accessory_kit, v.created_by created_by, v.created_time created_time "
													+ " from car c INNER JOIN  vehicle v ON c.id =  v.id where v.model=?";
	
	private static String UPDATE_CAR_QUERY = "update car set AC=?, power_steering=?, accessory_kit=? where id=?";
	
	
	public boolean create(Car car) throws CarSystemException {
		boolean created = false;
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				super.create(connection, car);
				String vehicleId = getVehicleIdByModel(connection, car.getModel());
				if(vehicleId != null) {
					preparedStatement = connection.prepareStatement(INSERT_CAR_QUERY);
					preparedStatement.setBoolean(1, car.getAC());
					preparedStatement.setBoolean(2, car.getPowerSteering());
					preparedStatement.setString(3, car.getAccessoryKit());
					preparedStatement.setString(4, vehicleId);
					created = preparedStatement.execute();
					connection.commit();
				}
			} catch(CarSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not rollback.");
				}
				throw new CarSystemException("Could not create Car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return created;
	}
	
	public Vehicle getCarDetails(String id) throws CarSystemException {
		Vehicle vehicle = new Vehicle();
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				vehicle=super.getVehicleIById(connection, id);
			}
			catch(CarSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			}  finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return vehicle;
	}
	
	public List<Vehicle> getCarByBrand(String brand) throws CarSystemException {
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				listOfVehicles=super.searchBrand(connection, brand);
			} catch(CarSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			}  finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return listOfVehicles;
	}
	
	public List<Vehicle> getCarByBudget(String filterValue) throws CarSystemException {
		
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				listOfVehicles=super.searchBudget(connection, filterValue);
			} catch(CarSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			}  finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return listOfVehicles;
	}
	
	
	public void editCar(Car car) throws CarSystemException {
	
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				super.edit(connection, car);
				connection.commit();
			}catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not rollback.");
				}
				throw new CarSystemException("Could not edit Car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
	}	
	
}
