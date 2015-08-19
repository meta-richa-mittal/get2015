package railwayReservation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains information of trains.
 */
public abstract class Train {
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

/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */
class PassengerTrain extends Train
{
	ArrayList<PassengerTrain> pt=new ArrayList<PassengerTrain>();
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

	/**
	 * This function reads all the passenger trains from the file
	 * @param tType: type of train
	 * @return array list of passenger trains
	 */
	public ArrayList<PassengerTrain> readTrains(String tType)
	{	
		
		BufferedReader br = null;     //input BY file

		try 
		{

			StringTokenizer stringTokenizer;

			FileInputStream fin = new FileInputStream(new File("D:\\Trainchart.txt"));
			DataInputStream in = new DataInputStream(fin);
			br = new BufferedReader(new InputStreamReader(in));

			String traindata="";

			String trainType="",trainID="",trainName="",from="",to="",duration="",amount="",available="";

			while ((traindata = br.readLine()) != null) 
			{

				stringTokenizer = new StringTokenizer(traindata,","); 
				
				while (stringTokenizer.hasMoreTokens()) 
				{ 
			        trainType=stringTokenizer.nextToken();
			        trainID=stringTokenizer.nextToken();
			        trainName=stringTokenizer.nextToken();
			        from=stringTokenizer.nextToken();
			        to=stringTokenizer.nextToken();
			        duration=stringTokenizer.nextToken();
			        amount=stringTokenizer.nextToken();
			        available=stringTokenizer.nextToken();
				}
			   int time=Integer.parseInt(duration); 
			   int amount1=Integer.parseInt(amount); 
			   int available1=Integer.parseInt(available); 
			   if(trainType.compareTo("P")==0)
			   {
			       pt.add(new PassengerTrain(trainType,trainID,trainName,from,to,time,amount1,available1));
			   }
				  
			}
			br.close();

		  } 
		catch (IOException e)
		{
			  e.printStackTrace();
		} 
		
		return pt;
	}
	

}

/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */
class GoodsTrain extends Train
{
	int _availableWeight;
	ArrayList<GoodsTrain> gt=new ArrayList<GoodsTrain>();

	/**
	 * default Consrtuctor
	 */
	public GoodsTrain()
	{
		
	}
	
	/**
	 * Constructor to initialize object
	 */
	public GoodsTrain(String trainType,String trainName, String trainID, String from,String to,int travelTime, int ticketRate, int availableWeight)
	{
		super(trainType, trainID,trainName, from,to, travelTime, ticketRate);
		this._availableWeight = availableWeight;

	}

	/**
	 * This function reads all the good trains from the file
	 * @param tType: type of train
	 * @return array list of good trains
	 */
	public ArrayList<GoodsTrain> readTrains(String tType)
	{
		
		
		BufferedReader br = null;     //input BY file

		try {

			StringTokenizer stringTokenizer;

			FileInputStream fin = new FileInputStream(new File("D:\\Trainchart.txt"));

			DataInputStream in = new DataInputStream(fin);

			br = new BufferedReader(new InputStreamReader(in));

			String traindata="";

			String trainType="",trainID="",trainName="",from="",to="",duration="",amount="",available="";

			while ((traindata = br.readLine()) != null) 
			{

			stringTokenizer = new StringTokenizer(traindata,","); 
		
			
			
			while (stringTokenizer.hasMoreTokens()) 
			{  
			       
			        trainType=stringTokenizer.nextToken();
			       
			        trainID=stringTokenizer.nextToken();
			       
			        trainName=stringTokenizer.nextToken();
			       
			        from=stringTokenizer.nextToken();
			       
			        to=stringTokenizer.nextToken();
			        
			        duration=stringTokenizer.nextToken();
			       
			        amount=stringTokenizer.nextToken();
			       
			        available=stringTokenizer.nextToken();
			        
			    }
			   int time=Integer.parseInt(duration); 
			   int amount1=Integer.parseInt(amount); 
			   int available1=Integer.parseInt(available); 
			   if(trainType.compareTo("G")==0)
			       gt.add(new GoodsTrain(trainType,trainID,trainName,from,to,time,amount1,available1));
			  
			}
			br.close();

		  } 
		catch (IOException e)
		{
			  e.printStackTrace();
		} 
		return gt;
	}
	
}

