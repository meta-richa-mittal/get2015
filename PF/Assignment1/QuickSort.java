package assignment3;

import java.util.Scanner;
/**
 * Author: Richa Mittal
 * Description: This program contains a single class with 
 * 				three functions.
 * 		Function 1: Sorting array using recursive calls
 * 		Function 2: Partitioning of array into smaller sub arrays such that
 * 					left sub array contains smaller elements than pivot while
 * 					right sub array contains greater elements than pivot
 * 		Function 3: Main Function
 * Input:
 * 		input 1: No. of elements in the array (size)
 * 		input 2: elements of array (arr)
 * 		
 * 		Function 1: arr,lb,ub (eg. {5,2,4},0,2)
 * 		Function 2: arr,lb,ub (eg. {5,2,4},0,2)
 * Output: 
 * 		Function 1: sorted array in increasing order (o/p: 2,4,5)
 * 		Function 2: position of pivot element (o/p: 2)
 */
public class QuickSort {
	/**
	 * 
	 * @param arr: given input array
	 * @param lb: lower index of array arr
	 * @param ub: upper index of array arr
	 * @return sorted array arr in inreasing order
	 */
	int [] quickSort(int arr[],int lb,int ub)
	{
		int mid;								// holds position of pivot element
		if(lb<ub)
		{
			mid=partition(arr,lb,ub);		// calling Function2 for partitioning array
			quickSort(arr,lb,mid-1);		// recursive call of Function 1 for left sub array
		}
		if(lb<ub)
		{
			mid=partition(arr,lb,ub);		// calling Function2 for partitioning array
			quickSort(arr,mid+1,ub);		// recursive call of Function 1 for right sub array
		}
		return arr;
	}
	
	/**
	 * 
	 * @param arr: given input array
	 * @param lb: lower index of array arr
	 * @param ub: upper index of array arr
	 * @return position of pivot element in arr
	 */
	int partition(int arr[],int lb,int ub)
	{
		
		int i=lb+1;								// loop  counter
		int j=ub;								// loop  counter
		int temp;								// temporary variable for swapping two elements
		int x=arr[lb];							// pivot element
		while(j>=lb && arr[j]>x)				// tracking from right end of array
		{
			j--;
		}
		while(i<=ub && arr[i]<x)				// tracking from left end of array
		{
			i++;
		}
		if(i<j)
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		else
		{
			temp=arr[j];
			arr[j]=arr[lb];
			arr[lb]=temp;
		}
		
		return j;
	}
	
	/**
	 * This is tha main function
	 */
	public static void main(String args[])
	{
		int size;													// takes input for no. of elements
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of elements in array:");
		size=sc.nextInt();
		
		if(size==0)
		{
			System.out.println("There are no element to sort.");
			sc.close();
			return;
			
		}
		else if(size<0)
		{
			System.out.println("Plz provide a valid no. of elements.");
			sc.close();
			return;
			
		}
		else
		{
			int arr[]=new int[size];								// creating array if size is positive
			System.out.print("Enter elements of array:");
			for(int i=0;i<size;i++)
			{
				 arr[i]=sc.nextInt();
			}
			int output[]=new int[size];								// array to hold sorted output array
			QuickSort ob=new QuickSort();							// creating object of our class
			output=ob.quickSort(arr, 0, size-1);					// calling Function 1
			if(size>1)
			{
				System.out.println("Array after sorting in increasing order is:");
				for(int i=0;i<size;i++)
				{
					System.out.print(output[i]+"\t");
				}
			}
			else if(size==1)
			{
				System.out.println("Array after sorting in increasing order is:");
				System.out.print(arr[0]+"\t");
			}
		}
		sc.close();
	}
	

}
