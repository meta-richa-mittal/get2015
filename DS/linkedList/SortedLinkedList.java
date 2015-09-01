package linkedList;


import java.util.Iterator;
import java.util.LinkedList;



/**
 * 
 * @author Richa Mittal
 * Description: This class contains recursive function to insertitem into a sorted linked list
 *
 */
public class SortedLinkedList {
	
	static LinkedList<Integer> linkedList=new LinkedList<Integer>();
	
	
	
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
