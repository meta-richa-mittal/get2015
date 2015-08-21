


/**
 * 
 * @author Richa Mittal
 * Description: This class contains details of the passengers
 *
 */
public class Passenger {
	String _userName="";
	String _trainID="";
	String _paymentId="";
	int _capacityRequired=0;
	int _totalAmount=0;

	/**
	 * Constructor to initialize all members of class
	 */
	public Passenger(String userName,String trainID,String ticketId,String paymentId,int capacityRequired,int totalAmount) 
	{
		this._userName=userName;
		this._trainID=trainID;
		//this._ticketId=ticketId;
		this._paymentId=paymentId;
		this._capacityRequired=capacityRequired;
		this._totalAmount=totalAmount;
		
	}
	
	/**
	 * Constructor to initialize _usenName member of class
	 */
	public Passenger(String userName)
	{
		this._userName=userName;
	}

}
