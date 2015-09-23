package vehicle;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains getter methods, setter methods and
 * is the super class of Bike and Car classes
 * 
 */
public class Vehicle {

	private String make;
	private String model;
	private int engineInCC;
	private int fuelCapacity;
	private int milage;
	private int price;
	private int roadTax;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(int roadTax) {
		this.roadTax = roadTax;
	}

	public int calculateOnRoadPrice() {
		return getPrice() + getRoadTax();
	}
	
	@Override
	public String toString() {
		return " Company name : "+ getMake() + " Model : "+ getModel() + " EngineInCC : "+ getEngineInCC()
		+" Mileage : "+ getMilage() +" FuelCapacity : "+ getFuelCapacity() +" Price : "+ getPrice()
		+" RoadTax : "+ getRoadTax();
	}
}
