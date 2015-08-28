package queue;

import java.util.Scanner;

/**
 * 
 * @author Richa
 *class to implement queue
 */
public class Queue {
	static Scanner sc;
	Object[] queue=new Object[20];
	int front =0;
	int rear=0;
	static Queue q=new Queue();
	
	
	/**
	 * Adding an Object item
	 * @param item
	 */
	public void enqueue(Object item ) {
		if(rear==20) {
			System.out.println("Queue is full");
			return;
		}
		else {
			try {
				queue[rear]=item;
			}
			catch(ArrayStoreException ase) {
				System.out.println(ase);
			}
			rear++;
		}
	}
	
	/**
	 *  Remove and return the least recent item inserted
	 * @return
	 */
	public Object dequeue( ) {
		Object item;
		if(rear==0) {
			System.out.println("No item in queue to remove");
			return -1;
		}
		else {
			item=queue[front];
			for(int i=0;i<rear-1;i++) {
				queue[i]=queue[i+1];
			}
			rear--;
		}
		
		return item;
	}
		
	
	/**
	 * Remove all items of queue and make queue empty
	 */
	public void makeEmpty( ) {
		rear=0;
	}
	
	/**
	 * Return least recently inserted item
	 * @return
	 */
	public Object getFront( ) {
		Object item;
		if(rear==0) {
			System.out.println("Queue is empty");
			return -1;
		}
		else {
			item=queue[front];
		}
		
		return item;
	}
	
	
	/**
	 * will display the queue elements
	 */
	public void displayQueue() {
		System.out.println("Queue is:");
		for(int i=0;i<rear;i++) {
			System.out.println(queue[i]+"\n");
		}
	}
	
	/**
	 * ,ain function
	 * @param args
	 */
	public static void main(String args[]) {
		
		int ch;
		Object item;
		sc = new Scanner(System.in);
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
					q.enqueue(item);
					break;
				case 2:
					Object itemRemoved=q.dequeue();
					if((int)itemRemoved!=-1) {
						System.out.println("Item removed:"+itemRemoved);
					}
					break;
				case 3:
					q.displayQueue();
					break;
				case 4:
					Object top=q.getFront();
					if((int)top!=-1) {
						System.out.print("Top item is:"+top);
					}
					break;
				case 5:
					q.makeEmpty();
					break;
				case 6:
					System.exit(0);
			}
		}
		
	}

}
