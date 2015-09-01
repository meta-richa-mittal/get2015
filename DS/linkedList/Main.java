package linkedList;

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
	 * main function
	 */
	public static void main(String args[]) {
		int ch;
		int item;
		int index=0;
		sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("\n 1. Insert item to sorted linked list"
						+ "\n 2. Display linked list "
						+ "\n 3. Exit");
				System.out.print("\n Enter Your choice : ");
				ch = sc.nextInt();
				switch (ch) // Apply switch case and call corresponding method
							// according to the user's choice
				{
					case 1:
						System.out.print("\n Enter item value : ");
						item = sc.nextInt();
						SortedLinkedList.checkIndex(index, item);
						break;
					case 2:
						SortedLinkedList.displayLinkedList();
						
						break;
					case 3:
						System.exit(0);
				}
			}
			
		}
		catch (InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
	}

}
