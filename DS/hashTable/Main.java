package hashTable;

import java.util.Hashtable;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains function to allot rooms and main function
 */
public class Main {
	
	static Guests guest=new Guests();
	static Scanner sc;
	static Hashtable<Integer, String> hTable=new Hashtable<Integer,String>();
	
	
	/**
	 * main function
	 */
	public static void main(String args[]) {
		int noGuests=0;
		int rooms=0;
		sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter no of rooms:");
			rooms=sc.nextInt();
			if(!checkPrime(rooms)) {
				System.out.println("Enter a prime no.:");
				continue;
			}
			else {
				break;
			}
		}
		while(true) {
			System.out.println("Enter no of guests:");
			noGuests=sc.nextInt();
			if(rooms<noGuests) {
				System.out.println("enter no of guests less than no of rooms.");
				continue;
			}
			else {
				break;
			}
		}
		
		String guestsNames[]=new String[noGuests];
		int age[]=new int[noGuests];
		guest.setNoOfGuests(noGuests);
		for(int i=0;i<guest.getNoOfGuests();i++) {
			System.out.println("Enter name of guest:");
			guestsNames[i]=sc.next();
			System.out.println("Enter age:");
			age[i]=sc.nextInt();
		}
		
		guest.setGuestsNames(guestsNames);
		guest.setAge(age);
		
		guest.display();
		
		roomAllotment(rooms);
		System.out.println("Room Allotment is:");
		System.out.println(hTable);
		
		
	}
	
	
	/**
	 * function to check whether given no n is prime or nor
	 */
	static public boolean checkPrime(int n) {
		for(int i=2;i<n/2;i++) {
			for(int j=2;j<=i;j++) {
				if(n%j==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/**
	 * function to allot rooms to guests according to their age
	 * @param rooms: no of rooms
	 */
	static public void roomAllotment(int rooms) {
		for(int i=0;i<guest.noOfGuests;i++) {
			int roomNo=guest.getAge()[i]%rooms;
			if(roomNo==0) {
				roomNo++;
				if(roomNo>rooms) {
					roomNo=1;
				}
			}
			while(hTable.containsKey(roomNo)) {
				roomNo++;
				if(roomNo>rooms) {
					roomNo=1;
				}
			}
			hTable.put(roomNo, guest.getGuestsNames()[i]);
		}
	}

}
