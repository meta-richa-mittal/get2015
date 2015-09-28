package pojoClasses;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains getter methods, setter methods, 
 * extends vehicle class
 * 
 */
public class Car extends Vehicle {

	private boolean AC;
	private boolean powerSteering;
	private String accessoryKit;

	public boolean getAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}
	
	public String getAccessoryKit() {
		return accessoryKit;
	}
	
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	@Override
	public int calculateOnRoadPrice() {
		return super.calculateOnRoadPrice();
	}
	
	@Override
	public String toString() {
		return super.toString() + " AC : " + getAC() + " powerSteering : "+getPowerSteering() + " AccessoryKit : " + getAccessoryKit();
	}

}

