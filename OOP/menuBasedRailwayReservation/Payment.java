

import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class determines the modes of payment and functionality of each mode
 *
 */
public class Payment {
	long totalFare=0;
	Scanner sc=new Scanner(System.in);
	
	
	/**
	 * This method will find the mode of payment
	 * @param seats: no of seats to be booked
	 * @param rate: cost of each seat
	 * @return total fare
	 */
	public long paymentMode(int seats,int rate)
	{
		 //long totalFare=seats*pass._ticketRate;
		 System.out.println("Please select the mode of payment:\n1 for Credit Card\n2 for Wallet\n3 for Net Banking");
		 int option=sc.nextInt();
		 Payment p=new Payment();
		 switch(option)
		 {
		 	case 1:
		 		totalFare=p.creditCard(seats, rate);
		 		break;
		 	case 2:
		 		
		 		totalFare=p.wallet(seats, rate);
		 		break;
		 	
		 	case 3:
		 		
		 		totalFare=p.netBanking(seats, rate);
		 		break;
		 	
		 	default:
		 		System.out.println("Please enter corrent mode of payment:");
		 		break;
		 }
		 return totalFare;
	}
	
	/**
	 * This function will pay using credit card
	 * @param no: total no of tickets to reserve
	 * @param rate: cost of each ticket
	 * @return total fare for "no" tickets
	 */
	public long creditCard(int no,int rate)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter CC no.:");
 		@SuppressWarnings("unused")
		long ccNo=sc.nextLong();
 		System.out.println("Enter CVV no.:");
 		@SuppressWarnings("unused")
		long cvvNo=sc.nextLong();
 		System.out.println("Proceeding to pay amount...");
 		totalFare=no*rate;
 		
 		return totalFare;
	}
	
	
	
	
	/**
	 * This function will pay using wallet
	 * @param no: total no of tickets to reserve
	 * @param rate: cost of each ticket
	 * @return total fare for "no" tickets
	 */
	public long wallet(int no,int rate)
	{
		System.out.println("Proceeding to pay amount...");
 		totalFare=no*rate;
 		
 		return totalFare;
	}
	
	
	
	
	/**
	 * This function will pay using Net Banking
	 * @param no: total no of tickets to reserve
	 * @param rate: cost of each ticket
	 * @return total fare for "no" tickets
	 */
	public long netBanking(int no,int rate)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter name of bank:");
 		@SuppressWarnings("unused")
		String bank=sc.nextLine();
 		System.out.println("Enter user name:");
 		@SuppressWarnings("unused")
		String userName=sc.next();
 		System.out.println("Enter password:");
 		@SuppressWarnings("unused")
		String password=sc.next();
 		System.out.println("Proceeding to pay amount...");
 		totalFare=no*rate;
 		return totalFare;
	}
	
	
	

}
