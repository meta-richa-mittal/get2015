package assignment3;

import java.util.Scanner;
/**
 * Author: Richa Mittal
 * Description: This program contains a single class with 
 * 				three functions.
 * 		Function 1: To search an element in an array using recursive linear search
 * 		Function 2: To search an element in an array using recursive binary search
 * 		Function 3: Main Function
 * Input:
 * 		input 1: No. of elements in the array (len,len1)
 * 		input 2: elements of array (arr,arr1)
 * 		input 3: No. to be searched in the array (no,no1)
 * 		
 * 		Function 1: arr,no,len (eg. {5,2,4},4,3)
 * 		Function 2: arr1,no1,0,len1 (arr1 is sorted) (eg. {1,2,4},4,3)
 * Output: 
 * 		Function 1: Position of element in the array (o/p: 3)
 * 		Function 2: Position of element in the array (o/p: 3)
 */
public class Assignment2 {
	/**
	 * This function takes 3 parameters and return the position of element to
	 * be searched in the given array
	 * @param a: given array
	 * @param n: number to be searched in the array
	 * @param len: size of array
	 * @return position of n in the a[]
	 */
	public int linearSearch(int a[],int n,int len)
	{	
		if(len-1>=0)
		{
			if(a[len-1]==n)
			{
				return len-1;
			}
			else
			{
				return linearSearch(a,n,--len);
			}
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 *  This function takes 3 parameters and return the position of element to
	 * be searched in the given array
	 * @param a: given sorted array
	 * @param n: number to be searched
	 * @param start: starting index of array i.e. 0
	 * @param end: ending index of array i.e. size of array-1
	 * @return position of n in the a[]
	 */
	public int binarySearch(int a[],int n,int start,int end)
	{
		int pos=start+end;										// variable to store position of element
		if(start<=end)
		{
			if(a[pos/2]==n)
			{
				return pos/2;
			}
			else if(a[pos/2]>=n)
			{
				end=pos/2-1;
				return binarySearch(a,n,start,end);
			}
			else
			{
				start=pos/2+1;
				return binarySearch(a,n,start,end);
			}
		}
		else
		{
			return -1;
		}
	}
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		int no,no1,len,len1;									// input variables
		int i;													// loop counter
		int pos,pos1;											// variables to holds position of element
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the No. of values in array:");
		len=sc.nextInt();
		int arr[]=new int[len];									// input array for linear searching
		System.out.print("Enter the values of array:");
		for(i=0;i<len;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter the No. to be searched:");
		no=sc.nextInt();
		Assignment2 ob=new Assignment2();						// creating object of our class
		pos=ob.linearSearch(arr,no,len);						// calling Function 1 for linear search
		System.out.println("using linear search:");
		if(pos>=0)
		{
			System.out.println(no+" is present at "+(pos+1)+" position.");
		}
		else
		{
			System.out.println(no+" is not present in the given array.");
		}
		System.out.println("using binary search:");
		System.out.print("Enter the No. of values in array:");
		len1=sc.nextInt();
		int arr1[]=new int[len1];								// input sorted array for binary searching
		System.out.print("Enter the values of sorted array:");
		for(i=0;i<len1;i++)
		{
			arr1[i]=sc.nextInt();
		}
		System.out.print("Enter the No. to be searched:");
		no1=sc.nextInt();
		pos1=ob.binarySearch(arr1,no1,0,len1-1);				// calling Function 1 for binary search
		
		if(pos1>=0)
		{
			System.out.println(no1+" is present at "+(pos1+1)+" position.");
		}
		else
		{
			System.out.println(no1+" is not present in the given array.");
		}
		sc.close();
	}

}
