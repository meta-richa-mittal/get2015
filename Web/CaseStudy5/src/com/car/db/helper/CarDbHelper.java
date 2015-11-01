package com.car.db.helper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.exception.CarSystemException;
import com.car.db.ConnectionFactory;
import com.car.model.Car;
import com.car.model.Vehicle;

public class CarDbHelper extends VehicleDbHelper {
	
	private static String INSERT_CAR_QUERY = "insert into car (AC, power_steering, accessory_kit, id) VALUES (?, ?, ?, ?)";
	
	private static String SELECT_FOR_MODEL_QUERY = "Select v.model model, v.make make, v.engine_in_CC engine_in_CC, v.fuel_capacity fuel_capacity, v.milage milage, v.price price, v.roadTax roadTax, "
													+ " c.id id, c.AC AC, c.power_steering power_steering, c.accessory_kit accessory_kit, v.created_by created_by, v.created_time created_time "
													+ " from car c INNER JOIN  vehicle v ON c.id =  v.id where v.id=?";
	
	private static String UPDATE_CAR_QUERY = "update car set AC=?, power_steering=?, accessory_kit=? where id=?";
	
	
	public boolean create(Connection connection, Car car) throws CarSystemException {
		boolean created = false;
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				super.create(connection, car);
				String vehicleId = getVehicleIdById(connection, car.getId());
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
				//ConnectionFactory.closeConnection(connection);
			}
		}
		
		return created;
	}
	
	
	
	public Car getCarById(Connection connection, Car car)
			throws CarSystemException {
		Car returnValue = null;
		
		if(connection != null && car != null && car.getModel() != null) {
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(SELECT_FOR_MODEL_QUERY);
				preparedStatement.setString(1, car.getId());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					returnValue = new Car();
					returnValue.setModel(resultSet.getString("model"));
					returnValue.setCreated_by(resultSet.getString("created_by"));
					returnValue.setCreated_time(resultSet.getString("created_time"));
					returnValue.setEngineInCC(Integer.parseInt(resultSet.getString("engine_in_CC")));
					returnValue.setFuelCapacity(Integer.parseInt(resultSet.getString("fuel_capacity")));
					returnValue.setMake(resultSet.getString("make"));
					returnValue.setMilage(Integer.parseInt(resultSet.getString("milage")));
					returnValue.setModel(resultSet.getString("model"));
					returnValue.setPrice(Integer.parseInt(resultSet.getString("price")));
					returnValue.setRoadTax(Integer.parseInt(resultSet.getString("roadTax")));
					returnValue.setAC(resultSet.getBoolean("AC"));
					returnValue.setAccessoryKit(resultSet.getString("accessory_kit"));
					returnValue.setPowerSteering(resultSet.getBoolean("power_steering"));
					break;
				}
			} catch(SQLException e) {
				System.out.println("Error while getting car by id " + car.getId());
				throw new CarSystemException("Error while getting car by id " + car.getId() + ", [" + e.getMessage() + "]", e);
			}
			
		}
		return returnValue;
	}
	
	
	
	public Vehicle getCarDetails(Connection connection, String id) throws CarSystemException {
		Vehicle vehicle = new Vehicle();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				vehicle=super.getVehicleById(connection, id);
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
				//ConnectionFactory.closeConnection(connection);
			}
		}
		
		return vehicle;
	}
	
	public List<Vehicle> getCarByBrand(Connection connection, String brand) throws CarSystemException {
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
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
			//	ConnectionFactory.closeConnection(connection);
			}
		}
		
		return listOfVehicles;
	}
	
	public List<Vehicle> getCarByBudget(Connection connection, String filterValue) throws CarSystemException {
		
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		
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
				//ConnectionFactory.closeConnection(connection);
			}
		}
		
		return listOfVehicles;
	}
	
	
	public void editCar(Connection connection, Car car) throws CarSystemException {
	
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
				//ConnectionFactory.closeConnection(connection);
			}
		}
		
	}	
	
}
