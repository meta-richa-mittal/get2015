package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains functions to implement various queue operations
 * 				using collection
 *
 */
public class QueueOperations {
	
	Queue<Integer> queue=new LinkedList<Integer>();
	
	
	/**
	 * function will add new element at the last
	 */
	public void enQueue(int value) {
		try {
			queue.add(value);
		}
		catch(IllegalStateException  ise) {
			System.out.print("No more space in Queue");
		}
	}
	
	
	/**
	 * function will remove the front element
	 */
	public void deQueue() {
		try {
			int value=queue.poll();
			System.out.print("Value removed:"+value);
		}
		catch(NullPointerException ne) {
			System.out.print("Queue is empty");
		}
	}
	
	
	
	/**
	 * function will return the front element without removing it
	 */
	public void getFront() {
		
		try {
			int value=queue.peek();
			System.out.print("Value at head of queue is:"+value);
		}
		catch(NullPointerException ne) {
			System.out.print("Queue is empty");
		}
		
	}
	
	
	
	/**
	 * function will traverse the complete queue
	 */
	public void displayQueue() {
		
		Iterator<Integer> itr=queue.iterator();
		System.out.print("Queue contains:");
		while(itr.hasNext()) {
			System.out.print(itr.next()+"\t");
		}
	}
	
	
	
	/**
	 * function will delete all elements of the queue
	 */
	public void emptyQueue() {
		queue.clear();
	}
	

}
