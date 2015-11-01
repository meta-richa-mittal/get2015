package com.car.facade;

import java.sql.Connection;
import java.util.List;

import com.car.exception.CarSystemException;
import com.car.exception.CarAlreadyExistsException;
import com.car.factory.CarSystemFactory;
import com.car.db.helper.CarDbHelper;
import com.car.model.Car;
import com.car.model.Vehicle;

public class CarSystemFacade {
	
	
	CarSystemFactory factory = new CarSystemFactory();
	public Car createCar(Connection connection, Car car) throws CarSystemException, CarAlreadyExistsException {
		Car carFromDB = null;
		
		CarDbHelper carDBHelper = new CarDbHelper();
		try {
			carFromDB = carDBHelper.getCarById(connection, car);
			if(carFromDB == null) {
				carDBHelper.create(connection, car);
				carFromDB = carDBHelper.getCarById(connection, car);
			} else {
				throw new CarAlreadyExistsException("Car with Id " + car.getId() + " already exists.");
			}
		} catch (CarSystemException e) {
			System.out.println("Exception while creating Car " + e.getMessage());
			throw e;
		}
		return carFromDB;
	}

	public Car getCarById(Connection connection, Car car) throws CarSystemException {
		Car response = null;
		CarDbHelper carDBHelper = new CarDbHelper();
		try {	
			response = carDBHelper.getCarById(connection, car);
		} catch(CarSystemException e) {
			System.out.println("Exception while getting car " + e.getMessage());
			throw e;
		}
		return response;	
	}

	public Vehicle getCarDetails(Connection connection, String vehicleId) throws CarSystemException {
		Vehicle response = factory.getVehicle(null);
		CarDbHelper carDBHelper = new CarDbHelper();
		try {	
			response = carDBHelper.getCarDetails(connection,vehicleId);
		} catch(CarSystemException e) {
			System.out.println("Exception while getting car " + e.getMessage());
			throw e;
		}
		return response;	
	}

	public List<Vehicle> getCarByBrand(Connection connection, String filterValue) throws CarSystemException {
		List<Vehicle> response = null;
		CarDbHelper carDBHelper = new CarDbHelper();
		try {	
			response = carDBHelper.getCarByBrand(connection,filterValue);
		} catch(CarSystemException e) {
			System.out.println("Exception while getting car " + e.getMessage());
			throw e;
		}
		return response;
	}

	public List<Vehicle> getCarByBudget(Connection connection,
			String filterValue) throws CarSystemException {
		List<Vehicle> response = null;
		CarDbHelper carDBHelper = new CarDbHelper();
		try {	
			response = carDBHelper.getCarByBudget(connection,filterValue);
		} catch(CarSystemException e) {
			System.out.println("Exception while getting car " + e.getMessage());
			throw e;
		}
		return response;
	}

	public void editCar(Connection connection, Car car) throws CarSystemException {
		
		//Car carFromDB = null;
		
		CarDbHelper carDBHelper = new CarDbHelper();
		try {
			//carFromDB = carDBHelper.getCarById(connection, car);
			carDBHelper.editCar(connection, car);
			
			
		} catch (CarSystemException e) {
			System.out.println("Exception while creating Car " + e.getMessage());
			throw e;
		}
	}

}
