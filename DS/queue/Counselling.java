package queue;
import queue.Queue;


import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class will allot seats to the students acc to rank
 *
 */
public class Counselling {
	
	static Scanner sc=new Scanner(System.in);
	static Student st=new Student();
	static College college=new College();
	static int totalSeats[]=new int[college.noOfSeats.length];
	
	
	/**
	 * method to allot seats
	 */
	static public void seatAllotment() {
		int i;
		
		for(int k=0;k<college.noOfSeats.length;k++) {
			totalSeats[k]=college.noOfSeats[k];
		}
		
		
		for(i=0;i<Queue.q.rear;i++) {
			int flag=-1,check=-1;
			//Object studentName=Queue.q.getFront();
			Object studentName=Queue.q.queue[i];
			//College.college.displayColleges();
			 
			System.out.println(studentName+": Enter the college of your choice:");
			String inputCollegeName=sc.next();
			for(int j=0;j<college.collegeName.length;j++) {
				if(college.collegeName[j].compareToIgnoreCase(inputCollegeName)==0) {
					check=1;
					if(college.noOfSeats[j]>0) {
						flag=1;
						System.out.println("Congratulations "+studentName+"!! You are alotted the seat");
						college.allotment[j][college.noOfSeats[j]-1]=(String)studentName;
						//System.out.println("**"+college.allotment[j][college.noOfSeats[j]-1]);
						college.noOfSeats[j]--;
						
					}
					else {
						flag=0;
					}
					break;
				}
				else {
					check=0;
				}
				
			}
		
			if(flag==0) {
				System.out.println("Sorry!! All seats are full. Please try some other college");
			}
			if(check==0) {
				System.out.println("You have enetred a wrong college name");
			}
			System.out.println();
			college.displayColleges();
			//System.out.println(i+"*****"+Queue.q.rear);
			Queue.q.dequeue();
			i--;
		
		}
		if(Queue.q.rear==0) {
			System.out.println("COUNSELLING DONE....!!!!");
			//printAllotment();
		}
	}
	
	
	/**
	 * method to display allotment
	 */
	static public void printAllotment() {
		for(int i=0;i<college.collegeName.length;i++)
		{
			System.out.print(college.collegeName[i]+":");
			for(int j=0;j<totalSeats[i];j++) {
				System.out.print(college.allotment[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	
	/**
	 * Main function
	 */
	public static void main(String args[]) {
		int ch;
		while (true) {
			System.out.print("1. Add Students"
					+"\n2. Display Students "
					+"\n3. Display Colleges"
					+"\n4. Seat Allotment"
					+"\n5. Display Allotment"
					+ "\n6. Exit");
			System.out.print("\n Enter Your choice : ");
			ch = sc.nextInt();
			switch (ch) // Apply switch case and call corresponding method
						// according to the user's choice
			{
				case 1:
					st.addStudents();
					break;
				case 2:
					st.displayStudents();
					break;
				case 3:
					college.displayColleges();
					break;
				case 4:
					seatAllotment();
					break;
				case 5:
					printAllotment();
					break;
				case 6:
					System.exit(0);
			}
		}
	}
	

}
