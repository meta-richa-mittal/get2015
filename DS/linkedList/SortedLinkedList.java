package linkedList;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains recursive function to insertitem into a sorted linked list
 *
 */
public class SortedLinkedList {
	
	static LinkedList<Integer> linkedList=new LinkedList<Integer>();
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
						checkIndex(index, item);
						break;
					case 2:
						displayLinkedList();
						
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
	
	
	
	/**
	 * function will find position to add new item in a sorted linked list
	 */
	public static void checkIndex(int index, int element)
	{
		if(index==linkedList.size())
		{
			linkedList.add(element);
		}
		else if(((int)linkedList.get(index) < element)&&((index+1)<=linkedList.size())) {
			checkIndex(index+1, element);
		}	
		else {
			linkedList.add(index, element);
		}	
	}
	

	
	
	/**
	 * function will display the complete linked list
	 */
	static public void displayLinkedList() {
		Iterator<Integer> itr=linkedList.iterator();
		System.out.println("The linked list is.. ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+"\t");
		}
	}

}
