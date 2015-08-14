package CarService;

/**
 * 
 * @author Richa Mittal
 * Description: class contains three instance variables and
 * 				three functions and one constructor
 */
public class Mechanic extends People {
	
	private String type;
	private String rate;
	
	/**
	 * sets rate of the car
	 * @param r: value of rate
	 */
	public void setRate(String r)
	{
		try
		{
			//int val = Integer.parseInt(r);
			this.rate = r;
		}
		catch (Exception e)
		{
			this.rate = "0";
		}

	}
	
	/**
	 * gets the rate of servicing the car
	 * @return rate of servicing the car
	 */
	public String getRate()
	{
		return this.rate;
	}
	
	/**
	 * gets type of car
	 * @return type of car
	 */
	public String getType()
	{
		return this.type;
	}

	boolean isAvailable;
	
	/**
	 * constructor
	 * @param mechId: id of mechanic
	 * @param mechName: name of mechanic
	 * @param mechType: type of mechanic
	 * @param mechRate: rate of servicing car 
	 */
	public Mechanic(String mechId, String mechName, String mechType, String mechRate)
	{
		mechID = mechId;
		name = mechName;
		type = mechType;
		setRate(mechRate);
		isAvailable = true;
	}

}
