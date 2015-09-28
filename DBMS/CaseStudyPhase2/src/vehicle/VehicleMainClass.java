package vehicle;

import java.util.List;
import java.util.Scanner;




import pojoClasses.Vehicle;
import xml.XmlParsing;
import HelperClasses.*;

public class VehicleMainClass {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*Case study Assignment-1 part*/
		VehicleHelper vehicleHelper = new VehicleHelper();
		VehicleDetailPrinter vehicleDetailPrinter = new VehicleDetailPrinter();

		
		/*hash code and equals function implementation*/
		System.out.println("To check whether two vehicles are equal:");
		System.out.println("\nEnter details of vehicle 1:");
		vehicleDetailPrinter.display("Enter vehical type(Bike/Car) : ");
		String vehicleType = sc.next();
		Vehicle vehicle1 = vehicleHelper.getVehicleInput(vehicleType);
		
		
		System.out.println("\nEnter details of vehicle 2:");
		vehicleDetailPrinter.display("Enter vehical type(Bike/Car) : ");
		vehicleType = sc.next();
		Vehicle vehicle2 = vehicleHelper.getVehicleInput(vehicleType);
		System.out.println("\n*****");
		if(vehicle1!=null && vehicle2!= null) {
			System.out.println("\nVehicle 1 is equal to Vehicle 2:\t"+vehicle1.equals(vehicle2)+"\n*****");
		}
		else if(vehicle1==null && vehicle2== null) {
			System.out.println("Vehicles are not created");
		}
		else if(vehicle1==null) {
			System.out.println("Vehicle 1 is not created");
		}
		else if(vehicle2==null) {
			System.out.println("Vehicle 2 is not created");
		}
		System.out.println("*****\n");
		
		/*Parsing data from XML file and inserting in database*/
		XmlParsing read=new XmlParsing();
		
		/*Parsing data from XML file and inserting in database for car*/
	    List<Vehicle> readCar = read.readConfig("../CaseStudyPhase2/src/xml/Car.xml");
	    System.out.println("Reading data from Car XML file");
	    
	    for (Vehicle vehicleObject : readCar) 
	      CarHelper.InsertIntoVehicle(vehicleObject);
	
	    /* Parsing data from XML file and inserting in database for bike*/
	    List<Vehicle> readBike = read.readConfig("../CaseStudyPhase2/src/xml/Bike.xml");
	    System.out.println("Reading data from Bike XML file");
	   
	    for (Vehicle vehicleObject : readBike) 
		   BikeHelper.InsertIntoVehicle(vehicleObject);
	    
		sc.close();
	   }

}
