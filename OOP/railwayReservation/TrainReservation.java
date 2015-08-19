package railwayReservation;


import java.util.ArrayList;
import java.util.Scanner;

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
	
	static ArrayList<PassengerTrain> pt=new ArrayList<PassengerTrain>();
	static ArrayList<GoodsTrain> gt=new ArrayList<GoodsTrain>();
	static ArrayList<PassengerTrain> ptNew=new ArrayList<PassengerTrain>();
	static ArrayList<GoodsTrain> gtNew=new ArrayList<GoodsTrain>();
		
	/**
	 * This function displays all the available trains of a particular type
	 * @param tType: type of train
	 * @return an integer value of 1 if trains of tType are available else 0
	 */
	public static int display(String tType)
	{
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 
			 System.out.println("Train Chart:-----");
			 System.out.println("Train Name\tTrain Id\tFrom\tTo\tTime Duration\tFare\tAvailable");
			 java.util.Iterator<PassengerTrain> par1=pt.iterator();
				
			while(par1.hasNext())
			{
				
				PassengerTrain  pass=par1.next();
				System.out.println(pass._trainName+"\t"+pass._trainID+"\t\t"+pass._from+"\t"+pass._to+"\t"+pass._travelTime+"\t\t"+pass._ticketRate+"\t"+pass._availableSeat);
			}
		}
	   else if(tType.compareToIgnoreCase("G")==0)
	   {
		   System.out.println("Train Chart:-----");
			 System.out.println("Train Name\tTrain Id\tFrom\tTo\tTime Duration\tFare\tAvailable");
		   java.util.Iterator<GoodsTrain> par2=gt.iterator();
			
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
			 System.out.println("Available trains are:-----");
			 System.out.println("Train Name\tTrain Id\tFrom\tTo\tTime Duration\tFare\tAvailable");
			 
			 java.util.Iterator<PassengerTrain> par1=pt.iterator();
			 while(par1.hasNext())                       //loop to check weather Participant available or not
			  {
				 size++;
				 PassengerTrain  pass=par1.next();
				 if(pass._from.compareToIgnoreCase(from)==0 && pass._to.compareToIgnoreCase(to)==0  )
				 {
					 System.out.println(pass._trainName+"\t"+pass._trainID+"\t\t"+pass._from+"\t"+pass._to+"\t"+pass._travelTime+"\t\t"+pass._ticketRate+"\t"+pass._availableSeat);
					 ptNew.add(pass);
				 }
				 else
				 {
					 flag++;
				 }
			  }
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			
			 System.out.println("Available trains are:-----");
			 System.out.println("Train Name\tTrain Id\tFrom\tTo\tTime Duration\tFare\tAvailable");
			 java.util.Iterator<GoodsTrain> par2=gt.iterator();
			 while(par2.hasNext())                       //loop to check weather Participant available or not
			  {
				 size++;
				 GoodsTrain good=par2.next();
				 if(good._from.compareToIgnoreCase(from)==0 && good._to.compareToIgnoreCase(to)==0)
				 {
					
					 System.out.println(good._trainName+"\t"+good._trainID+"\t\t"+good._from+"\t"+good._to+"\t"+good._travelTime+"\t\t"+good._ticketRate+"\t"+good._availableWeight);
					 gtNew.add(good);
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
		try
		{
			System.out.println("Enter train id:");
			train=sc.nextLine();
			
		//	String train=sc.next();
		 if(tType.compareToIgnoreCase("P")==0)
		 {
			 
				
			 java.util.Iterator<PassengerTrain> par1=ptNew.iterator();
			 while(par1.hasNext())                       //loop to check weather Participant available or not
			  {
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
						 long totalFare=0;
						 //long totalFare=seats*pass._ticketRate;
						 System.out.println("Please select the mode of payment:\n1 for Credit Card\n2 for Wallet\n3 for Net Banking");
						 int option=sc.nextInt();
						 Payment p=new Payment();
						 switch(option)
						 {
						 	case 1:
						 		totalFare=p.creditCard(seats, pass._ticketRate);
						 		break;
						 	case 2:
						 		
						 		totalFare=p.wallet(seats, pass._ticketRate);
						 		break;
						 	
						 	case 3:
						 		
						 		totalFare=p.netBanking(seats, pass._ticketRate);
						 		break;
						 	
						 	default:
						 		System.out.println("Please enter corrent mode of payment:");
						 		break;
						 }
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
					 System.out.println("No such trains available.");
				 }
			  }
		 }
		 else if(tType.compareToIgnoreCase("G")==0)
		 {
			 
			 java.util.Iterator<GoodsTrain> par2=gtNew.iterator();
			 while(par2.hasNext())                      
			  {
				 GoodsTrain  good=par2.next();
				 if(good._trainID.compareToIgnoreCase(train)==0 || good._trainName.compareToIgnoreCase(train)==0)
				 {
					 System.out.println("Enter no of seats:");
					 int weight=sc.nextInt();
					 if(weight>good._availableWeight)
					 {
						 System.out.println("available weight is less");
					 }
					 else
					 {
						 long totalFare=0;
						 System.out.println("Please select the mode of payment:\n1 for Credit Card\n2 for Wallet\n3 for Net Banking");
						 int option=sc.nextInt();
						 Payment p=new Payment();
						 switch(option)
						 {
						 	case 1:
						 		totalFare=p.creditCard(weight, good._ticketRate);
						 		break;
						 	case 2:
						 		
						 		totalFare=p.wallet(weight, good._ticketRate);
						 		break;
						 	
						 	case 3:
						 		
						 		totalFare=p.netBanking(weight, good._ticketRate);
						 		break;
						 	
						 	default:
						 		System.out.println("Please enter corrent mode of payment:");
						 		break;
						 }
						 good._availableWeight-=weight;
						 System.out.println("Tickets Details:");
						 System.out.println(good._trainName+"\t"+good._trainID+"\t"+good._from+"\t"+good._to+"\t"+weight+"\t"+totalFare);
						 display(tType);
					 }
				 }
				 else
				 {
					 System.out.println("No such trains available.");
				 }
			  }
		 }
		 //sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This is the main Function
	 */
	public static void main(String[] args) 
	{
		PassengerTrain pTrn=new PassengerTrain();
		GoodsTrain gTrn=new GoodsTrain();
		pt=pTrn.readTrains("P");
		gt=gTrn.readTrains("G");
		int valid=0;
		do
		{
			try
			{
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter your name:");
				String name=sc.next();
				@SuppressWarnings("unused")
				Passenger ps=new Passenger(name);
				System.out.println("Enter which type of train you want(Enter P for Passenger train and G for Goods train):");
				String tType=sc.next();
				int i=display(tType);
				if(i==0)
				{
					return;
				}
				space();
				
				int j=filteredTrain(tType);
				if(j==0)
				{
					return;
				}
				space();
				 
				seatReserve(tType);
				space();
				System.out.println("press 1 to continue and 0 to exit");
				valid=sc.nextInt();
				// sc.close();
			}
			catch(Exception e) 
			{
		        e.printStackTrace();
			}
			
		}while(valid==1);	
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
