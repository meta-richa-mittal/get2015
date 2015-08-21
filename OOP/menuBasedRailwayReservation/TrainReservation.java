

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
				/*
			  * calling function of PassengerTrain to display trains
			  */
			 PassengerTrain.displayPassengerTrain(passTrainList);
		}
	   else if(tType.compareToIgnoreCase("G")==0)
	   {
		   displayHeading();
		   	/*
			  * calling function of GoodsTrain to display trains
			  */
		   GoodsTrain.displayGoodsTrain(goodTrainList);
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
		 int value=0;
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 System.out.println(Constant.AVAILABLETRAINS);
			 /*
			  * calling function of PassengerTrain to filter trains
			  */
			 value=PassengerTrain.filteredPassengerTrain(passTrainList, filteredPassTrainList, from, to);
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			
			 System.out.println(Constant.AVAILABLETRAINS);
			 /*
			  * calling function of GoodsTrain to filter trains
			  */
			 value=GoodsTrain.filteredGoodsTrain(goodTrainList, filteredGoodTrainList, from, to);
		 }
		 return value;
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
		String trainId="";
		try
		{
			System.out.println("Enter train id:");
			trainId=sc.nextLine();
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 /*
			  * calling function of PassengerTrain to reserve seats
			  */
			 PassengerTrain.reservePassengerTrain(passTrainList, filteredPassTrainList, trainId, tType);
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			 /*
			  * calling function of GoodsTrain to reserve seats
			  */
			 GoodsTrain.reserveGoodsTrain(goodTrainList, filteredGoodTrainList, trainId, tType);
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
