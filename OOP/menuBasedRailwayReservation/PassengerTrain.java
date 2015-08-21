import java.util.ArrayList;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class is extending Train class
 *
 */

public class PassengerTrain extends Train {
	int _availableSeat;
	static Scanner sc=new Scanner(System.in);

	
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
	 * This function will display list of passenger train
	 * @param passTrainList: passenger train list
	 */
	public static void displayPassengerTrain(ArrayList<PassengerTrain> passTrainList)
	{
		java.util.Iterator<PassengerTrain> par1=passTrainList.iterator();
		
		while(par1.hasNext())
		{
			
			PassengerTrain  pass=par1.next();
			System.out.println(pass._trainName+"\t"+pass._trainID+"\t\t"+pass._from+"\t"+pass._to+"\t"+pass._travelTime+"\t\t"+pass._ticketRate+"\t"+pass._availableSeat);
		}
	}
	
	
	/**
	 * This function will filter the passenger trains acc to given source and destination
	 * @param passTrainList: list of all passenger trains
	 * @param filteredPassTrainList: list of filtered passenger trains
	 * @param from: source station
	 * @param to: destination station
	 * @return integer acc to whether any train is found or not
	 */
	public static int filteredPassengerTrain(ArrayList<PassengerTrain> passTrainList, ArrayList<PassengerTrain> filteredPassTrainList,String from, String to)
	{
		int flag=0;
		int size=0;
		java.util.Iterator<PassengerTrain> par1=passTrainList.iterator();
		 while(par1.hasNext())                       //loop to check weather Participant available or not
		  {
			 size++;
			 PassengerTrain  pass=par1.next();
			 if(pass._from.compareToIgnoreCase(from)==0 && pass._to.compareToIgnoreCase(to)==0  )
			 {
				 System.out.println(pass._trainName+"\t"+pass._trainID+"\t\t"+pass._from+"\t"+pass._to+"\t"+pass._travelTime+"\t\t"+pass._ticketRate+"\t"+pass._availableSeat);
				 filteredPassTrainList.add(pass);
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
	 * This function will reserve seats for passenger trains
	 * @param passTrainList: list of all passenger trains
	 * @param filteredPassTrainList: list of filtered passenger train
	 * @param trainId: Id of train
	 * @param tType: type of train
	 */
	public static void reservePassengerTrain(ArrayList<PassengerTrain> passTrainList, ArrayList<PassengerTrain> filteredPassTrainList,String trainId,String tType)
	{
		int flag=0,size=0;
		 java.util.Iterator<PassengerTrain> par1=filteredPassTrainList.iterator();
		 while(par1.hasNext())                       //loop to check weather Participant available or not
		  {
			 size++;
			 PassengerTrain  pass=par1.next();
			 if(pass._trainID.compareToIgnoreCase(trainId)==0 || pass._trainName.compareToIgnoreCase(trainId)==0)
			 {
				 System.out.println("Enter no of seats:");
				 int seats=sc.nextInt();
				 if(seats>pass._availableSeat)
				 {
					 System.out.println("No of seats available are less");
				 }
				 else
				 {
					 Payment pay=new Payment();
					long totalFare=pay.paymentMode(seats,pass._ticketRate);
					 pass._availableSeat-=seats;
					 TrainReservation.space();
					 System.out.println("Tickets Details:-----");
					 System.out.println("TRAIN NAME: "+pass._trainName+"\t"+"TRAIN ID: "+pass._trainID+"\t"+"SOURCE: "+pass._from+"\t"+"DESTINATION: "+pass._to+"\t"+"NO OF SEATS: "+seats+"\t"+"TOTAL AMOUNT PAID: "+totalFare);
					 TrainReservation.space();
					 PassengerTrain.displayPassengerTrain(passTrainList);
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
