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
		Approver mentor = new Mentor();
		mentor.setNoOfLeaves(noOfLeaves);
		Approver seniorMentor = new SeniorMentor();
		seniorMentor.setNoOfLeaves(noOfLeaves);
		Approver hrManager = new HRManager();
		hrManager.setNoOfLeaves(noOfLeaves);
		mentor.setSuccessor(seniorMentor);
		seniorMentor.setSuccessor(hrManager);
		hrManager.setSuccessor(null);
		mentor.processRequest();
	}

}
