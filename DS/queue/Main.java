package queue;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains main function
 */
public class Main {
	
	static QueueOperations q=new QueueOperations();
	static Scanner sc;
	
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String args[]) {
		
		int ch;
		int item;
		sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("\n 1. Add item to queue"
						+ "\n 2. Remove item from queue"
						+ "\n 3. Display queue "
						+"\n 4. Display least recently inserted element"
						+"\n 5. clear the queue"
						+ "\n 6. Exit");
				System.out.print("\n Enter Your choice : ");
				ch = sc.nextInt();
				switch (ch) // Apply switch case and call corresponding method
							// according to the user's choice
				{
					case 1:
						System.out.print("\n Enter item value : ");
						item = sc.nextInt();
						q.enQueue(item);
						break;
					case 2:
						q.deQueue();
						
						break;
					case 3:
						q.displayQueue();
						break;
					case 4:
						q.getFront();
						
						break;
					case 5:
						q.emptyQueue();
						break;
					case 6:
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
