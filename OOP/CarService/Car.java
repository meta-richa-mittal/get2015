package CarService;

/**
 * 
 * @author Richa Mittal
 * Description: This program contains a single class with 
 * 				two instance variables and one constructor.
 */
public class Car {
	
	/**
	 * represents car no.
	 */
	String carNumber;
	
	/**
	 * represents type of car
	 */
	String carType;

	public Car(String CarNum, String CarTyp)
	{
		carNumber = CarNum;
		carType = CarTyp;
	}

}
