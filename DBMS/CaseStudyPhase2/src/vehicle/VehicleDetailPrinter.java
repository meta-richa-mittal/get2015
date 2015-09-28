package vehicle;

import pojoClasses.Vehicle;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains functions to print details of vehicles
 * 
 */
public class VehicleDetailPrinter {
	
	
	/**
	 * Function will return details of the vehicle
	 * @param vehicle: vehicle whose details are to be printed
	 * @return details of the vehicle
	 */
	public String printVehicleSpecification(Vehicle vehicle) {
		String specification = vehicle.toString();
		return specification;
	}

	
	/**
	 * Function will display the string
	 * @param data: string to be displayed
	 */
	public void display(String data) {
		System.out.print(data);
	}

}
