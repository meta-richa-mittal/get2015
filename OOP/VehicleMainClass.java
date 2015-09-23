package vehicle;

import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This is the main class containing main function
 *
 */
public class VehicleMainClass {

	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Main function
	 */
	public static void main(String[] args) {
		
		VehicleHelper vehicleHelper = new VehicleHelper();
		VehicleDetailPrinter vehicleDetailPrinter = new VehicleDetailPrinter();

		vehicleDetailPrinter.display("Enter vehical type(Bike/Car) : ");
		String vehicleType = sc.next();

		Vehicle vehicle = vehicleHelper.getVehicleInput(vehicleType);

		if(vehicle!=null) {
			vehicleDetailPrinter.display("\nDetails of "+vehicleType+"\n"+vehicleDetailPrinter
					.printVehicleSpecification(vehicle));
			vehicleDetailPrinter.display("\n\nOn Road Price : "
					+ vehicle.calculateOnRoadPrice());
		}
	}

}
