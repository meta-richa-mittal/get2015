package binarySearch;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class contains main function
 */
public class Main {
	
	static Scanner sc;
	
	

	/**
	 * Main function
	 */
	public static void main(String ags[]) {
		
		sc=new Scanner(System.in);
		int valid=0;
		try {
			System.out.println("Enter no of elements in the array:");
			int noOfElements=sc.nextInt();
			System.out.println("Enter elements in sorted order:");
			int array[]=new int[noOfElements];
			for(int i=0;i<noOfElements;i++) {
				array[i]=sc.nextInt();
			}
			do {
				System.out.println("Enter element to search:");
				int element=sc.nextInt();
				int position=BinarySearch.binarySearch(array,0,noOfElements-1,element);
				if(position==-1) {
					System.out.println("Element "+element+" is not present in the array");
				}
				else {
					System.out.println("Element "+element+" is present at:"+position);
				}
				System.out.println("Enter 1 to continue search:");
				valid=sc.nextInt();
			}while(valid==1);
		}
		catch(InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
	}

}
