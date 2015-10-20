package generalizedList;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: contains main function
 *
 */
public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		List list = null;
		
		String input = null;
		int choice = -1;
		try {
			do {
				printMenu(); 
				choice=scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the expression to create list: ");
					input = scanner.next();
					if(List.isInputValid(input)) {
						list = new List(input);
					}
					else {
						System.out.println("Invalid Expression");
					}
					break;
				case 2:
					if(input == null ) {
						System.out.println("Enter the expression first");
						break;
					}
					else {
						System.out.println("List is:");
						list.traverse();
					}
					
					break;
				case 3 :
					if(input == null ) {
						System.out.println("Enter the expression first");
						break;
					}
					System.out.println("Maximum Number is:\t" + list.max());
					break;
				case 4:
					if(input == null ) {
						System.out.println("Enter the expression first");
						break;
					}
					System.out.println("Sum of Numbers is:\t" + list.sum());
					break;
				case 5:
					if(input == null ) {
						System.out.println("Enter the expression first");
						break;
					}
					System.out.println("Enter an element to find");
					while(!scanner.hasNextInt()) {
						System.out.println("Please Enter only Integer!");
						scanner.next();
					}
					int searchingElement = scanner.nextInt();
					if(list.find(searchingElement)) {
						System.out.println("\nElement is present in the given list");
					}
					else {
						System.out.println("\nElement is not present in the given list");
					}
					break;
					
				case 6:
					System.exit(0);
					
				default:
					System.out.println("Enter Correct Choice");
					break;
				}
			} while(choice != 6 );
		}
		catch(InputMismatchException ime) {
			System.out.println("Invalid Choice");
		}
		// list = new List("(3,4,(1,2),5,6,7,(8))");				
	}
	
	/**
	 * prints menu
	 */
	public static void printMenu(){
		System.out.println("\nEnter\n 1 To enter Expression \n 2 To Display List \n 3 "
				+ "To Find Maximum Number in the List \n 4 To find Sum of Numbers in the List \n 5 To Search a Number in the List \n 6 To Exit");
	}

}
