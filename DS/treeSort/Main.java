package treeSort;

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
			
			TreeSort tree=new TreeSort();
			sc=new Scanner(System.in);
			int ch;
			try {
				do {
					System.out
							.println("1. Add new student \n2. Display roll no in ascending order \n3. Exit\n");
					System.out.println("Enter your choice: ");
					int choice = 0;

					choice = sc.nextInt();
					switch (choice) {
					case 1:
						int studentRollNo=tree.inputStudent();
						tree.insertToBST(studentRollNo);
						break;
					case 2:
						tree.display(tree.student);
						System.out.println();
						
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("Enter the correct option");
					}
					System.out.println("\nEnter 1 to continue ");
					ch = sc.nextInt();
				} while (ch == 1);
			} 
			catch (InputMismatchException ex) {
				System.out.println("Enter valid input ");
				main(null);
			}
		}

}
