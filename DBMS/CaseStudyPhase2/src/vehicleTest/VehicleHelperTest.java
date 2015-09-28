package vehicleTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pojoClasses.Vehicle;
import vehicle.VehicleHelper;

public class VehicleHelperTest {
	VehicleHelper vehicleHelper=new VehicleHelper();
	
	@Test
	public void testCalculateOnRoadPrice() {
		
		Vehicle vehicle =  vehicleHelper.createVehicle ("Bike","Royal Enfield", "Bullet 300",
				350, 15, 30, 12000, 1500);
		assertNotNull(vehicle);			// if vehicle is not created
		assertEquals(15000 , vehicle.calculateOnRoadPrice());		// checks On Road price of bike
 	}
	
	@Test
	public void testCreateCar() {
		
		Vehicle vehicle =  vehicleHelper.createVehicle ("Car","Ford", "Sport", 
				2000, 50, 22, 85000, 4000);
		assertNotNull(vehicle);			// if vehicle is not created
		assertEquals("Sport" , vehicle.getModel());					// checks model of car
 	}

}
