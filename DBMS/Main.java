package connectionDb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This is the main class containing main function
 * 				 and a function to choose action to be performed
 *
 */
public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Main function
	 */
	public static void main(String[] args) 
	{
		System.out.println("Database Connectivity to fetch data");
		
		InputStreamReader inpReader = new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(inpReader);
		String option= "";					// will hold the choice of user
		do
		{
			try
			{
				action();					// Calling the Action
				System.out.println("Enter y to continue other value to exit");
				option= buffer.readLine();	// getting the Choice from user
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}while(option.equalsIgnoreCase("y"));
		
	}
	
	
	
	
	/**
	 * performs the action chosen by the user
	 * @throws IOException
	 */
	public static void action() throws IOException 
	{
		
		InputStreamReader inpReader = new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(inpReader);
		System.out.print("\nPress 1: To find the books by authors name \nPress 2: To isuue a book(if not already issued) \npress 3: TO delete books which has not been issued in 1 year \npress 4: To exit\n");
		System.out.println("Enter the Choice");
		try {
			
			int option = sc.nextInt();			// getting Choice from user
			
			switch (option) 
			{
			 
				// To Find the list of Books from the author name
				case 1:
					String authorName;
					System.out.print("\n Enter Author Name : ");
					authorName = buffer.readLine();
					
					ArrayList<Helper> titleList = Helper.getBooksByAuthorName(authorName);
					Iterator<Helper> iterator = titleList.iterator();
					
					if (titleList.size() == 0) 
					{
						System.out.println("There are no books of "+authorName+" present");
					} 
					else 
					{
						
						System.out.println("\n Books of "+authorName+" are :");
						while (iterator.hasNext())
						{
							
							System.out.println(iterator.next().getTitleName() + " ");
						}
					}
					break;
					
					
				// To issue a book by title of the book
				case 2:
					
					String bookName;
					System.out.print("\n Enter title of Book to be issued: ");
					bookName = buffer.readLine();
					
					
					int flag = Helper.bookIssueByBookName(bookName);
					// Counting the Books and checking if updated or not
					if (flag == 0) 
					{
						System.out.println("\n Book can't be issued ");
					} 
					else 
					{
						System.out.println("\n Book has issued");
					}
					break;
					
				// Deleting the books not issued in last one year
				case 3:
					
					int deletedBooks = Helper.deleteBooksLaterThan1Year();
					if (deletedBooks == 0)
					{
						System.out.println("\n No such books are there");
					} 
					else 
					{
						System.out.println("\n Number of books deleted are : "+ deletedBooks);
					}
					break;
					
				// Exiting from the system
				case 4:
					System.out.println("System exiting");
					System.exit(1);
					break;
					
				//default
				default:
					System.out.println("No such option");
			}
		}
		catch(InputMismatchException ime) {
			
			System.out.println("Invalid input");
			System.exit(1);
		}
	}

}
