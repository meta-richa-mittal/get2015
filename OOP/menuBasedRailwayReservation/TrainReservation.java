

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains 5 functions.
 * 		Function1: Displays all the available trains of a particular type
 * 		Function2: Displays trains after filtering according to given source and destination
 * 		Function3: reserves the seats and shows ticket details
 * 		Function4: main function
 * 		Functiuon5: to print blank lines
 *
 */
public class TrainReservation {
	
	static ArrayList<PassengerTrain> passTrainList=new ArrayList<PassengerTrain>();
	static ArrayList<GoodsTrain> goodTrainList=new ArrayList<GoodsTrain>();
	static ArrayList<PassengerTrain> filteredPassTrainList=new ArrayList<PassengerTrain>();
	static ArrayList<GoodsTrain> filteredGoodTrainList=new ArrayList<GoodsTrain>();
	
	
	
	
	/**
	 * This function will read all the trains and store them in their respective lists
	 */
	public void readTrains()
	{
		
		String traindata="";
		String trainType="",trainID="",trainName="",from="",to="",duration="",amount="",available="";
		BufferedReader br = null;     //input BY file

		try 
		{

			StringTokenizer stringTokenizer;

			FileInputStream fin = new FileInputStream(new File(Constant.LOCATION));
			DataInputStream in = new DataInputStream(fin);
			br = new BufferedReader(new InputStreamReader(in));

			

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
			        int time=Integer.parseInt(duration); 
				    int amount1=Integer.parseInt(amount); 
				    int available1=Integer.parseInt(available); 
				    if(trainType.compareTo("P")==0)
				    {
				    	passTrainList.add(new PassengerTrain(trainType,trainID,trainName,from,to,time,amount1,available1));
				    }
				    else if(trainType.compareTo("G")==0)
				    {
				    	goodTrainList.add(new GoodsTrain(trainType,trainID,trainName,from,to,time,amount1,available1)); 
				    }
				    
				}
			}
			br.close();

		  } 
		catch (IOException e)
		{
			  e.printStackTrace();
		} 
	}
	
	
	
	
	/**
	 * This function reads all the passenger trains from the file
	 * @param tType: type of train
	 * @return array list of passenger trains
	 */
	public static ArrayList<PassengerTrain> readPassengerTrains(String tType)
	{	
		return passTrainList;
	}
	
	
	
	
	/**
	 * This function reads all the good trains from the file
	 * @param tType: type of train
	 * @return array list of good trains
	 */
	public static ArrayList<GoodsTrain> readGoodsTrains(String tType)
	{
		return goodTrainList;
	}
	
	
	
	
	/**
	 * This function displays all the available trains of a particular type
	 * @param tType: type of train
	 * @return an integer value of 1 if trains of tType are available else 0
	 */
	public static int display(String tType)
	{
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 displayHeading();
			 java.util.Iterator<PassengerTrain> par1=passTrainList.iterator();
				
			while(par1.hasNext())
			{
				
				PassengerTrain  pass=par1.next();
				System.out.println(pass._trainName+"\t"+pass._trainID+"\t\t"+pass._from+"\t"+pass._to+"\t"+pass._travelTime+"\t\t"+pass._ticketRate+"\t"+pass._availableSeat);
			}
		}
	   else if(tType.compareToIgnoreCase("G")==0)
	   {
		   displayHeading();
		   java.util.Iterator<GoodsTrain> par2=goodTrainList.iterator();
			
			while(par2.hasNext())                       
			  {
				
				GoodsTrain  good=par2.next();
				System.out.println(good._trainName+"\t"+good._trainID+"\t\t"+good._from+"\t"+good._to+"\t"+good._travelTime+"\t\t"+good._ticketRate+"\t"+good._availableWeight);
			  }
		      
	   }
	   else
	   {
		   System.out.println("Enter correct input");
		   return 0;
	   }
		return 1;
	}
	
	
	
	
	/**
	 * This function will display the heading for train chart
	 */
	public static void displayHeading()
	{
		 System.out.println(Constant.TRAINCHART);
	}
	
	
	
	
	/**
	 * This Function displays trains after filtering according to given source and destination
	 * @param tType: type of train
	 * @return an integer value of 1 if trains of tType are available from given source to destination else 0
	 */
	public static int filteredTrain(String tType)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter FROM station:");
		 String from=sc.next();
		 System.out.println("Enter TO station:");
		 String to=sc.next();
		 space();
		 int flag=0;
		 int size=0;
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 System.out.println(Constant.AVAILABLETRAINS);
			 
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
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			
			 System.out.println(Constant.AVAILABLETRAINS);
			 java.util.Iterator<GoodsTrain> par2=goodTrainList.iterator();
			 while(par2.hasNext())                       //loop to check weather Participant available or not
			  {
				 size++;
				 GoodsTrain good=par2.next();
				 if(good._from.compareToIgnoreCase(from)==0 && good._to.compareToIgnoreCase(to)==0)
				 {
					
					 System.out.println(good._trainName+"\t"+good._trainID+"\t\t"+good._from+"\t"+good._to+"\t"+good._travelTime+"\t\t"+good._ticketRate+"\t"+good._availableWeight);
					 filteredGoodTrainList.add(good);
				 }
				 else
				 {
					 flag++;
				 }
			  }
		 }
		 if(flag==size)
		 {
			 System.out.println("No trains found.");
			 return 0;
		 }
		 return 1;
		 //sc.close();
		 
	}
	
	
	
	
	/**
	 * This function reserves the seats and shows ticket details
	 * @param tType: type of train
	 */
	public static void seatReserve(String tType)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String train="";
		int flag=0,size=0;
		try
		{
			System.out.println("Enter train id:");
			train=sc.nextLine();
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 
				
			 java.util.Iterator<PassengerTrain> par1=filteredPassTrainList.iterator();
			 while(par1.hasNext())                       //loop to check weather Participant available or not
			  {
				 size++;
				 PassengerTrain  pass=par1.next();
				 if(pass._trainID.compareToIgnoreCase(train)==0 || pass._trainName.compareToIgnoreCase(train)==0)
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
						 space();
						 System.out.println("Tickets Details:-----");
						 System.out.println("TRAIN NAME: "+pass._trainName+"\t"+"TRAIN ID: "+pass._trainID+"\t"+"SOURCE: "+pass._from+"\t"+"DESTINATION: "+pass._to+"\t"+"NO OF SEATS: "+seats+"\t"+"TOTAL AMOUNT PAID: "+totalFare);
						 space();
						 display(tType);
					 }
				 }
				 else
				 {
					 flag++;
				 }
			  }
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			 
			 java.util.Iterator<GoodsTrain> par2=filteredGoodTrainList.iterator();
			 while(par2.hasNext())                      
			  {
				 size++;
				 GoodsTrain  good=par2.next();
				 if(good._trainID.compareToIgnoreCase(train)==0 || good._trainName.compareToIgnoreCase(train)==0)
				 {
					 System.out.println("Enter total weight:");
					 int weight=sc.nextInt();
					 if(weight>good._availableWeight)
					 {
						 System.out.println("available weight is less");
					 }
					 else
					 {
						 Payment pay=new Payment();
						 long totalFare=pay.paymentMode(weight,good._ticketRate);
						 good._availableWeight-=weight;
						 System.out.println("Tickets Details:");
						 System.out.println(good._trainName+"\t"+good._trainID+"\t"+good._from+"\t"+good._to+"\t"+weight+"\t"+totalFare);
						 display(tType);
					 }
				 }
				 else
				 {
					 flag++;
				 }
			  }
		 }
		 if(flag==size)
		 {
			 System.out.println("No such trains available.");
		 }
		 //sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * This function will print two blank lines
	 */
	public static void space()
	{
		for(int i=0;i<2;i++)
		{
			System.out.print("\n");
		}
	}
	

}
