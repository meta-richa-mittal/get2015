package sortingTechniques;


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
		
		SortingTechniques sort=new SortingTechniques();
		String typeOfSort="";
		sc=new Scanner(System.in);
		int noOfElements=0;
		try {
		System.out.println("Enter no of elements in array:");
		noOfElements=sc.nextInt();
		}
		catch(InputMismatchException ie) {
			System.out.println("Enter valid no. of elements");
			main(null);
			return;
		}
		int noOfDigits=sort.input(noOfElements);
		if(noOfDigits==0) {
			main(null);
			return;
		}
		String choice="";
		do
		{
			System.out.println("Choose the type of sorting you want to implement:");
			System.out.println("1. Comparison Sorting \n2. Linear Sorting \n3. Exit");
			choice=sc.next();
			
			
			switch(choice) {
			case "1":
				if(noOfElements<=10) {
					typeOfSort="Bubble Sort";
					sort.bubbleSort();
				}
				else {
					typeOfSort="Quick Sort";
					sort.quickSort(0, noOfElements-1);
				}
				
				break;
			case "2":
				if(noOfDigits<=2) {
					typeOfSort="Counting Sort";
					sort.countingSort();			
				}
				else {
					typeOfSort="Radix Sort";
					sort.radixSort(noOfDigits);
				}
				break;
			case "3":
				System.exit(0);
			default:
				System.out.println("Enter valid option");
				continue;
			}
		}while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
		
		System.out.println("System has used "+typeOfSort+" sorting technique and sorted list is as below:");
		sort.display();	
	}
	

}
