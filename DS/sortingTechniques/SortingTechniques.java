package sortingTechniques;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class contains function to perform various types of sorting in ascending order in an array. 
 * 				It also contains function to get array input and display array output. 
 *
 */
public class SortingTechniques {
	
	int[] array;
	Scanner sc=new Scanner(System.in);
	Queue<Integer> queues[];
	int max=0;
	int maxDigits=1;
	
	
	
	
	/**
	 * function to take input from user
	 * @param noOfElements: total no of elements
	 * @return max digits of elements present in the array
	 */
	public int input(int noOfElements) {
		try {
			if(noOfElements==0) {
				System.out.println("There are no elements in the array");
				return 0;
			}
			else {
				try {
					array=new int[noOfElements];
					System.out.println("Enter elements of array:");
					//int digitsMax=1;
					for(int i=0;i<noOfElements;i++) {
						array[i]=sc.nextInt();
					}
					
					max=findMax();
					
					maxDigits=maxDigits(max);
						
						
						/*int value=array[i];
						int digits=0;
						if(value==0) {
							digits=1;
						}
						else {
							while(value!=0) {
								value=value/10;
								digits++;
							}
						}
						if(digits>digitsMax) {
							digitsMax=digits;
						}*/
					return maxDigits;
				}
				catch(NegativeArraySizeException ne) {
					System.out.println("Array size can not be negative");
					return 0;
				}
			}
		}
		catch(InputMismatchException ie) {
			System.out.println("The value entered is not correct");
			 return 0;
		}
	}
	
	
	
	
	/**
	 * This function finds the max value present in the given array
	 * @return max value of the array
	 */
	public int findMax() {
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		return max;
	}
	
	
	
	
	
	/**
	 * This function finds total no. of digits 
	 * @param value: max value of the array
	 * @return max no. of digits
	 */
	public int maxDigits(int value) {
		int digits=0;
		
		if(value==0) {
			digits=1;
		}
		else {
			while(value!=0) {
				value=value/10;
				digits++;
			}
		}
		maxDigits=digits;
		return maxDigits;
	}
	
	
	
	
	/**
	 * This function performs bubble sort on the array to sort in ascending order
	 */
	public void bubbleSort() {
		boolean swapped=false;;
		int size=array.length;
		do {
			swapped=false;
			for(int i=0;i<size-1;i++) {
					if(array[i]>array[i+1]) {
						//swap(array[i],array[i+1]);
						int temp=array[i];
						array[i]=array[i+1];
						array[i+1]=temp;
						swapped=true;
					}
				}
			size--;
		}while(swapped);
	}
	
	
	
	/*public void swap(int x,int y) {
		int temp=x;
		x=y;
		y=temp;
	}*/
	
	
	
	
	
	/**
	 * This function performs quick sort on the array to sort in ascending order
	 * @param lb: lower bound of partition
	 * @param ub: upper bound of partition
	 */
	public void quickSort(int lb, int ub) {
		if(lb<ub) {
			int partitionIndex=partition(lb, ub);
			quickSort(lb, partitionIndex-1);
			quickSort(partitionIndex+1, ub);
		}
		
		
	}
	
	
	
	
	
	/**
	 * This function creates partition for performing quick sort
	 * @param initialIndex: upper bound of sub array
	 * @param lastIndex: lower bound sub array
	 * @return partition index
	 */
	public int partition(int initialIndex, int lastIndex) {
		
		//int pivot=array[initialIndex];
		int pivotIndex=initialIndex;
		int storeIndex=pivotIndex+1;
		
		for(int i=pivotIndex+1;i<=lastIndex;i++) {
			if(array[i]<array[pivotIndex]) {
				int temp=array[i];
				array[i]=array[storeIndex];
				array[storeIndex]=temp;
				storeIndex++;
			}
		}
		int temp=array[pivotIndex];
		array[pivotIndex]=array[storeIndex-1];
		array[storeIndex-1]=temp;
		int partitionIndex=storeIndex-1;
		return partitionIndex;
		
	}
	
	
	
	
	
	/**
	 * This function performs counting sort on the array to sort in ascending order
	 */
	public void countingSort() {
		/*int max=array[0];
		for(int i=0;i<array.length-1;i++) {
			if(array[i+1]>max) {
				max=array[i+1];
			}
		}*/
		int[] countArray=new int[max+1];
		
		for(int i=0;i<array.length;i++) {
			countArray[array[i]]++;
		}
		int j=0;
		for(int i=0;i<countArray.length;i++) {
			while(countArray[i]!=0) {
				array[j]=i;
				countArray[i]--;
				j++;
			}
		}
	}
	
	
	
	
	
	/**
	 * This function performs radix sort on the array to sort in ascending order
	 * @param noOfDigits: no of digits of the max value in the array
	 */
	@SuppressWarnings("unchecked")
	public void radixSort(int noOfDigits) {
		
		queues=new Queue[10];
		
		for(int i = 0; i <10; i++) {
		    queues[i] = new LinkedList<Integer>();
		}
		
		int tempArray[]= new int[array.length];
		
		for(int j=1;j<=noOfDigits;j++) {
			
			for(int i=0;i<array.length;i++) {
				tempArray[i]=array[i];
			}
			
			
			for(int i=0;i<tempArray.length;i++) {
				int temp=tempArray[i];
				for(int k=1;k<j;k++) {
					temp=temp/10;
				}
				int rem=temp%(10);
				queues[rem].add(tempArray[i]);
			}
			
			int index=0;
			for(int i=0;i<10;i++) {
				while(queues[i].size()!=0) {
					array[index]=queues[i].poll();
					index++;
				}
				
			}
		}
		
	}
	
	
	
	
	/**
	 * This function will display the array
	 */
	public void display() {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]+"\t");
		}
	}
	

}
