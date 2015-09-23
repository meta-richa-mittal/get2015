package vehicle;

import static org.junit.Assert.*;

import org.junit.Test;


public class VehicleDetailPrinterTest {
	VehicleHelper vehicleHelper=new VehicleHelper();
	VehicleDetailPrinter vehicleDetailPrinter=new VehicleDetailPrinter();

	@Test
	public void testPrintVehicleSpecification() {
		
		Vehicle vehicle =  vehicleHelper.createVehicle ("Bike","bajaj", "discover",
				350, 15, 30, 12000, 1500);
		assertNotNull(vehicle);
		assertEquals(" Company name : bajaj Model : discover EngineInCC : 350 Mileage : 30 FuelCapacity : 15 Price : 12000 RoadTax : 1500 SelfStart : true HelmetPrice : 1500", vehicleDetailPrinter.printVehicleSpecification(vehicle));
	}

}
