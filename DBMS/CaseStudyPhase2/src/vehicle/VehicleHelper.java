package vehicle;

import java.util.InputMismatchException;
import java.util.Scanner;

import pojoClasses.Bike;
import pojoClasses.Car;
import pojoClasses.Vehicle;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains functions to create vehicles
 *
 */
public class VehicleHelper {
	VehicleDetailPrinter vehicleDetailPrinter = new VehicleDetailPrinter();
	Scanner sc = new Scanner(System.in);
	
	/**
	 * function will get common input of vehicles from user 
	 * @param vehicleType: type of vehicle
	 * @return vehicle object
	 */
	public Vehicle getVehicleInput(String vehicleType) {
		try {
			if (vehicleType.equalsIgnoreCase("car") || vehicleType.equalsIgnoreCase("bike")) {
				vehicleDetailPrinter.display("Enter Maker : ");
				String maker = sc.next();
	
				vehicleDetailPrinter.display("Enter Model : ");
				String model = sc.next();
	
				vehicleDetailPrinter.display("Enter Engine in CC : ");
				int engineInCC = sc.nextInt();
	
				vehicleDetailPrinter.display("Enter Fuel Capacity : ");
				int fuelCapacity = sc.nextInt();
	
				vehicleDetailPrinter.display("Enter mailage : ");
				int milage = sc.nextInt();
	
				vehicleDetailPrinter.display("Enter Price : ");
				int price = sc.nextInt();
	
				vehicleDetailPrinter.display("Enter Road Tax : ");
				int roadTax = sc.nextInt();
				
				Vehicle vehicle=createVehicle(vehicleType,maker,
						model, engineInCC, fuelCapacity, milage, price, roadTax);
				return vehicle;
			}
			else {
				vehicleDetailPrinter.display("Not a valid Vehicle Type.");
				return null;
			}
			
		}
		catch(InputMismatchException ime) {
			System.out.println("Not a correct type of value.");
			return null;
		}
	}
	
	
	/**
	 * Function will get input of car from user
	 */
	public Vehicle getCarInput(Vehicle vehicle) {
		vehicleDetailPrinter.display("Whether aC(True/False) : ");
		boolean aC=sc.nextBoolean();
		vehicleDetailPrinter.display("Whether Power Steering(True/False) : ");
		boolean powerSteering=sc.nextBoolean();
		vehicleDetailPrinter.display("Enter Accessory Kit : ");
		String accessoryKit=sc.next();
		createCar(vehicle,aC,powerSteering,accessoryKit);
		return vehicle;
	}
	
	
	/**
	 * Function will get input of bike from user
	 */
	public Vehicle getBikeInput(Vehicle vehicle) {
		vehicleDetailPrinter.display("Whether Self Start(True/False) : ");
		boolean selfStart=sc.nextBoolean();
		vehicleDetailPrinter.display("Helmet Price : ");
		int helmetPrice=sc.nextInt();
		createBike(vehicle,selfStart,helmetPrice);
		return vehicle;
	}
	
	
	/**
	 * Function to create vehicle
	 */
	public Vehicle createVehicle(String vehicleType, String maker,
			String model, int engineInCC, int fuelCapacity, int milage,
			int price, int roadTax) {
		
				Vehicle vehicle=new Vehicle();
				if(vehicleType.equalsIgnoreCase("car")) {
					Car car =new Car();
					vehicleData(maker, model, engineInCC, fuelCapacity, milage, price,
							car,roadTax);
					vehicle=(Vehicle)getCarInput(car);
					vehicleDetailPrinter.display("\nDetails of "+vehicleType+"\n"+vehicleDetailPrinter
							.printVehicleSpecification(vehicle));
					vehicleDetailPrinter.display("\n\nOn Road Price : "
							+ vehicle.calculateOnRoadPrice());
				}
				else if(vehicleType.equalsIgnoreCase("bike")) {
					Bike bike=new Bike();
					vehicleData(maker, model, engineInCC, fuelCapacity, milage, price,
							bike,roadTax);
					
					vehicle=(Vehicle)getBikeInput(bike);
					vehicleDetailPrinter.display("\nDetails of "+vehicleType+"\n"+vehicleDetailPrinter
							.printVehicleSpecification(vehicle));
					vehicleDetailPrinter.display("\n\nOn Road Price : "
							+ vehicle.calculateOnRoadPrice());
				}
				return vehicle;

	}

	
	/**
	 * Function will set values given as argument for the vehicle
	 */
	private void vehicleData(String make, String model, int engineInCC,
			int fuelCapacity, int milage, int price, Vehicle vehicle, int roadTax) {
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setEngineInCC(engineInCC);
		vehicle.setFuelCapacity(fuelCapacity);
		vehicle.setMilage(milage);
		vehicle.setPrice(price);
		vehicle.setRoadTax(roadTax);
	}
	
	
	/**
	 * Function to create car
	 */
	public Car createCar(Vehicle vehicle, boolean aC, boolean powerSteering, String accessoryKit) {
		Car car = (Car) vehicle;
		car.setAC(aC);
		car.setPowerSteering(powerSteering);
		car.setAccessoryKit(accessoryKit);
		return car;
	}
	
	
	/**
	 * Function to create bike
	 */
	public Bike createBike(Vehicle vehicle, boolean selfStart, int helmetPrice) {
		Bike bike=(Bike)vehicle;
		bike.setSelfStart(selfStart);
		bike.setHelmetPrice(helmetPrice);
		return bike;
	}

}
