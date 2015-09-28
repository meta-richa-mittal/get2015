package vehicleTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pojoClasses.Vehicle;
import xml.XmlParsing;

public class XmlParsingTest {

	XmlParsing xml = new XmlParsing();
	
	@Test
	public void readConfigTest() {
		List<Vehicle> cars = xml.readConfig("../CaseStudyPhase2/src/xml/Car.xml");
		List<Vehicle> bikes = xml.readConfig("../CaseStudyPhase2/src/xml/Bike.xml");
		if(cars.size()==0 || bikes.size()==0) {
			fail("Objects are not created");
		}	
	}

}
