

/**
 * 
 * @author Richa Mittal
 * Description: This class contains information of trains.
 */
public class Train {
	String _trainType;
	String _trainID;
	String _trainName;
	String _from;
	String _to;
	int _travelTime;
	int _ticketRate;
	
	/**
	 * default Consrtuctor
	 */
	public Train()
	{
		
	}
	
	/**
	 * Constructor to initialize object
	 */
	public Train(String trainType, String trainID,String trainName, String from,String to,int travelTime, int ticketRate) 
	{
		this._trainType=trainType;
		this._trainName = trainName;
		this._trainID = trainID;
		this._from = from;
		this._to = to;
		this._travelTime = travelTime;
		this._ticketRate = ticketRate;
	}
	
	
	
	
	
	

}

