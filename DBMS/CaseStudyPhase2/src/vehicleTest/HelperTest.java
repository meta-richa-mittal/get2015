package vehicleTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import HelperClasses.HelperVehicle;
import pojoClasses.Vehicle;
import xml.XmlParsing;

public class HelperTest {

	XmlParsing xml = new XmlParsing();
	List<Vehicle> cars = xml.readConfig("../CaseStudyPhase2/src/xml/Car.xml");
	List<Vehicle> bikes = xml.readConfig("../CaseStudyPhase2/src/xml/Bike.xml");
	
	//test case for method insert into vehicle
	@Test
	public void insertIntoVehicleTest() {
		boolean expected = true;
		boolean actual = false;
		for(Vehicle vehicle : cars){
			actual = HelperVehicle.InsertIntoVehicle(vehicle,"car");
		}
		for(Vehicle vehicle : bikes){
			actual = (HelperVehicle.InsertIntoVehicle(vehicle,"bike"));
		}
		assertEquals( expected, actual);
	}

}
