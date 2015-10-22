package Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Richa Mittal
 * Description: contains function to apply for leave
 *
 */
public class LeaveRequest {
	
	static Scanner sc=new Scanner(System.in);
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			int noOfLeaves=0;
			System.out.println("Enter no. of leaves to apply for:");
			noOfLeaves=sc.nextInt();
			if(noOfLeaves<0) {
				System.out.println("Not a valid no. of leaves!!");
			}
			else if(noOfLeaves==0) {
				System.out.println("No need to apply for Leave!!");
			}
			else {
				applyForLeave(noOfLeaves);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Plz enter a number!!");
		}
		
	}
	
	
	/**
	 * function to apply for leave
	 * @param noOfLeaves
	 */
	private static void applyForLeave(int noOfLeaves) {
		Approver shubham = new Mentor();
		shubham.setNoOfLeaves(noOfLeaves);
		Approver amitabh = new SeniorMentor();
		amitabh.setNoOfLeaves(noOfLeaves);
		Approver deepika = new HRManager();
		deepika.setNoOfLeaves(noOfLeaves);
		shubham.setSuccessor(amitabh);
		amitabh.setSuccessor(deepika);
		deepika.setSuccessor(null);
		shubham.processRequest();
	}

}
