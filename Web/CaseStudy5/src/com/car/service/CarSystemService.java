package com.car.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.car.exception.CarSystemException;
import com.car.exception.CarAlreadyExistsException;
import com.car.db.ConnectionFactory;
import com.car.facade.CarSystemFacade;
import com.car.factory.CarSystemFactory;
import com.car.model.Car;
import com.car.model.Vehicle;

public class CarSystemService {

	CarSystemFactory factory = new CarSystemFactory();
	
	public Car createCar(Car car)
			throws CarSystemException, CarAlreadyExistsException {
		Car returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			returnValue = facade.createCar(connection, car);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public Car getCarById(Car car)
			throws CarSystemException {
		Car returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			returnValue = facade.getCarById(connection, car);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}
	
	
	public Vehicle getCarDetails(String vehicleId)
			throws CarSystemException {
		Vehicle returnValue = factory.getVehicle(null);
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			returnValue = facade.getCarDetails(connection, vehicleId);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public List<Vehicle> getCarByBrand(String filterValue) throws CarSystemException {
		List<Vehicle> returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			returnValue = facade.getCarByBrand(connection, filterValue);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public List<Vehicle> getCarByBudget(String filterValue) throws CarSystemException {
		List<Vehicle> returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			returnValue = facade.getCarByBudget(connection, filterValue);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public void editCar(Car car) throws CarSystemException {
		//Car returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarSystemFacade facade = new CarSystemFacade();
		try {
			facade.editCar(connection, car);
		} catch (CarSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not rollback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	
}
