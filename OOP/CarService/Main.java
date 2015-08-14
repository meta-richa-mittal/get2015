package CarService;
import java.util.HashMap;

/**
 * 
 * @author Richa Mittal
 *  Description: Class having main function
 */
public class Main {
	
	/**
	 * This is the main function
	 */
	public static void main(String[] args)
	{
		ServiceStation serviceStation = new ServiceStation();
		serviceStation.readMechanics();
		serviceStation.readCars();
		serviceStation.doAllotment();
		HashMap<String, Integer> carProcessingList = serviceStation.getCarProcessingStatus();

		System.out.println("CarType \t Number");

		for (String carType : carProcessingList.keySet())
		{
			System.out.println(carType + "\t\t" + carProcessingList.get(carType));
		}

		System.out.println("Total Earning \t" + serviceStation.getEarning());

	}

}
