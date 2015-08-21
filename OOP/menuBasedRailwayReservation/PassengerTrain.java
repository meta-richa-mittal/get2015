

/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */

public class PassengerTrain extends Train {
	int _availableSeat;
	
	/**
	 * default Consrtuctor
	 */
	public PassengerTrain()
	{
		
	}

	/**
	 * Constructor to initialize object
	 */
	public PassengerTrain(String trainType, String trainID,String trainName, String from,String to,int travelTime, int ticketRate, int availableSeat)
	{
		super(trainType, trainID, trainName,from,to, travelTime, ticketRate);
		this._availableSeat = availableSeat;

	}
	
	
	

}
