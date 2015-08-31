package heap;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 *  Description: This class contains main function
 *
 */
public class Main {
	
	static Scanner sc;
	static PriorityQueue q=new PriorityQueue();
	
	/**
	 * main function
	 */
	public static void main(String args[]) {
		
		int ch;
		String item;
		sc = new Scanner(System.in);
		q.setJobsPriority();
		try {
			while (true) {
				System.out.print("\n 1. List of type Jobs"
						+ "\n 2. Add job to queue"
						+ "\n 3. Display all available jobsin the queue "
						+"\n 4. view task currently in process"
						+"\n 5. view next job in queue"
						+ "\n 6. Exit");
				System.out.print("\n Enter Your choice : ");
				ch = sc.nextInt();
				switch (ch) // Apply switch case and call corresponding method
							// according to the user's choice
				{
				case 1:
					Jobs j=new Jobs();
					j.setJobs();
					j.setPriority();
					System.out.println("Available Jobs\t\tPriority");
					for(int i=0;i<j.jobs.length;i++) {
						System.out.println(j.jobs[i]+"\t\t"+j.priority[i]);
					}
					break;
					case 2:
						System.out.print("\n Enter name of job : ");
						item = sc.next();
						q.enqueue(item);
						break;
					
					case 3:
						q.displayQueue();
						break;
						
					case 4: 
						String task=q.dequeue();
						if(task!="") {
							System.out.print("Job currently processing is:"+task);
						}
						break;
					case 5:
						String nextTask=q.getFront();
						if(nextTask!="") {
							System.out.print("Next job in the queue is:"+nextTask);
						}
						break;
					case 6:
						System.exit(0);
						
					default:
						System.out.print("\n Enter a valid choice value");
						break;
				}
			}
		}
		catch (InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
		
	}

}
