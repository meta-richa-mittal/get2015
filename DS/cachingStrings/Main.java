package cachingStrings;


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
	public static void main(String args[]) {
		int valid=0;
		sc=new Scanner(System.in);
		String string;
		try {
			do {
				System.out.println("Enter string:");
				string=sc.next();
				int count=StringCaching.findUniqueCharacters(string);						// calling function to find unique characters
				System.out.println("Unique Characters in the given string are:\t"+count);
				System.out.println("Enter 1 to continue");
				valid=sc.nextInt();
			}while(valid==1);
		}
		catch(InputMismatchException ime) {
			System.out.println("Enter valid input");
			main(null);
		}
	}

}
