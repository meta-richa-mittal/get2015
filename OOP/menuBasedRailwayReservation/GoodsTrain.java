import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */
public class GoodsTrain extends Train{
	int _availableWeight;
	static Scanner sc=new Scanner(System.in);
	
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
	
	
	/**
	 * This function will display list of goods train
	 * @param goodTrainList: goods train list
	 */
	public static void displayGoodsTrain(ArrayList<GoodsTrain> goodTrainList)
	{
		java.util.Iterator<GoodsTrain> par1=goodTrainList.iterator();
		
		while(par1.hasNext())
		{
			
			GoodsTrain  good=par1.next();
			System.out.println(good._trainName+"\t"+good._trainID+"\t\t"+good._from+"\t"+good._to+"\t"+good._travelTime+"\t\t"+good._ticketRate+"\t"+good._availableWeight);
		}
	}
	
	
	/**
	 * This function will filter the goods trains acc to given source and destination
	 * @param goodTrainList: list of all goods trains
	 * @param filteredGoodTrainList: list of filtered goods trains
	 * @param from: source station
	 * @param to: destination station
	 * @return integer acc to whether any train is found or not
	 */
	public static int filteredGoodsTrain(ArrayList<GoodsTrain> goodTrainList, ArrayList<GoodsTrain> filteredGoodTrainList,String from, String to)
	{
		int flag=0;
		int size=0;
		java.util.Iterator<GoodsTrain> par1=goodTrainList.iterator();
		 while(par1.hasNext())                      
		  {
			 size++;
			 GoodsTrain  good=par1.next();
			 if(good._from.compareToIgnoreCase(from)==0 && good._to.compareToIgnoreCase(to)==0  )
			 {
				 System.out.println(good._trainName+"\t"+good._trainID+"\t\t"+good._from+"\t"+good._to+"\t"+good._travelTime+"\t\t"+good._ticketRate+"\t"+good._availableWeight);
				 filteredGoodTrainList.add(good);
			 }
			 else
			 {
				 flag++;
			 }
		  }
		 if(flag==size)
		 {
			 System.out.println("No trains found.");
			 return 0;
		 }
		 return 1;
	}
	
	
	
	/**
	 * This function will reserve seats for goods trains
	 * @param goodTrainList: list of all goods trains
	 * @param filteredGoodTrainList: list of filtered goods train
	 * @param trainId: Id of train
	 * @param tType: type of train
	 */
	public static void reserveGoodsTrain(ArrayList<GoodsTrain> goodTrainList, ArrayList<GoodsTrain> filteredGoodTrainList,String trainId,String tType)
	{
		int flag=0,size=0;
		 java.util.Iterator<GoodsTrain> par1=filteredGoodTrainList.iterator();
		 while(par1.hasNext())                       //loop to check weather Participant available or not
		  {
			 size++;
			 GoodsTrain  good=par1.next();
			 if(good._trainID.compareToIgnoreCase(trainId)==0 || good._trainName.compareToIgnoreCase(trainId)==0)
			 {
				 System.out.println("Enter no of seats:");
				 int weight=sc.nextInt();
				 if(weight>good._availableWeight)
				 {
					 System.out.println("No of seats available are less");
				 }
				 else
				 {
					 Payment pay=new Payment();
					long totalFare=pay.paymentMode(weight,good._ticketRate);
					 good._availableWeight-=weight;
					 TrainReservation.space();
					 System.out.println("Tickets Details:-----");
					 System.out.println("TRAIN NAME: "+good._trainName+"\t"+"TRAIN ID: "+good._trainID+"\t"+"SOURCE: "+good._from+"\t"+"DESTINATION: "+good._to+"\t"+"NO OF SEATS: "+weight+"\t"+"TOTAL AMOUNT PAID: "+totalFare);
					 TrainReservation.space();
					 GoodsTrain.displayGoodsTrain(goodTrainList);
				 }
			 }
			 else
			 {
				 flag++;
			 }
		  }
		 if(flag==size)
		 {
			 System.out.println("No such trains available.");
		 }
	}

}
