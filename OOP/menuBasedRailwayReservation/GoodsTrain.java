
/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */
public class GoodsTrain extends Train{
	int _availableWeight;

	/**
	 * default Consrtuctor
	 */
	public GoodsTrain()
	{
		
	}
	
	/**
	 * Constructor to initialize object
	 */
	public GoodsTrain(String trainType, String trainID,String trainName, String from,String to,int travelTime, int ticketRate, int availableWeight)
	{
		super(trainType, trainID,trainName, from,to, travelTime, ticketRate);
		this._availableWeight = availableWeight;

	}

}
