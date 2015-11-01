package com.car.factory;

import com.car.model.Car;
import com.car.model.Vehicle;

public class CarSystemFactory {
	 public Vehicle getVehicle(String vehicleType){
	      if(vehicleType == null){
	         return null;
	      }		
	      else if(vehicleType.equalsIgnoreCase("CAR")){
	         return new Car();
	      }
	      
	      return null;
	   }
}
