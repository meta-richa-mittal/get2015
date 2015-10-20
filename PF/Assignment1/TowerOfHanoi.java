package assignment4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Richa Mittal
 * Description: This program contains a single class with 
 * 				one instance variable and two functions.
 * 		Instance Variable 1: Used in Both functions
 * 		Function 1: To find solution for tower of hanoi problem
 * 		Function 2: Main Function
 * 
 * Input: noOfDisk (eg. 3)
 * 	
 * Output: 
 * 		Function 1: solution to the problem of tower Of hanoi
 * 		
 */
public class TowerOfHanoi {
	/**
	 * This List is used in Function to store the steps of the solution
	 */
	List<String> solution=new ArrayList<String>();
	
	/**
	 * 
	 * @param source: starting peg
	 * @param destination: final peg
	 * @param temp: temporary peg
	 * @param numOfDisk: no of disks in the start peg
	 * @return List of steps of the solution
	 */
	public List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
	{
		if(numOfDisk==1)
		{
			solution.add("Move disk "+numOfDisk+" from "+source+" -> "+destination);
		}
		else
		{
			towerOfHanoi(source,temp,destination,numOfDisk-1);
			solution.add("Move disk "+numOfDisk+" from "+source+" -> "+destination);
			towerOfHanoi(temp,destination,source,numOfDisk-1);
		}
		return solution;
	}
	
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		int noOfDisk;											// no of disks in start peg
		System.out.print("Enter no. of Disks:");
		TowerOfHanoi ob=new TowerOfHanoi();						// object of our class
		Scanner sc=new Scanner(System.in);
		noOfDisk=sc.nextInt();
		ob.solution=ob.towerOfHanoi("A", "C", "B", noOfDisk);	//calling function
		Iterator<String> itr=ob.solution.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		sc.close();
	}


}
