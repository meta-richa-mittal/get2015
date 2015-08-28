package queue;


import java.util.Scanner;


/**
 * 
 * @author Richa
 * Description: this class defines the queue of students acc to their rank
 */
public class Student {
	
	Scanner sc=new Scanner(System.in);
	
	/**
	 * will add students to the queue
	 */
	public void addStudents() {
		System.out.println("Enter name of student acc to rank:");
		Object studentName=sc.next();
		Queue.q.enqueue(studentName);
	}
		
	/**
	 * will display students acc to their rank	
	 */
	public void displayStudents() {
			System.out.println("List of students:");
			Queue.q.displayQueue();
	}

}
