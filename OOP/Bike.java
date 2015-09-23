package vehicle;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains getter methods, setter methods, 
 * extends vehicle class
 * 
 */
public class Bike extends Vehicle {

	private boolean selfStart;
	private int helmetPrice;

	public boolean getSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public int getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(int helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	@Override
	public int calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + getHelmetPrice();

	}
	
	@Override
	public String toString() {
		return super.toString() +" SelfStart : "+ getSelfStart()+ " HelmetPrice : "+ getHelmetPrice();
	}

}
