package railwayReservation;

import java.util.Scanner;

public class Payment {
	long totalFare=0;
	
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
