package arrayList;


import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains functions to implement Array List using an array
 *
 */
public class MyArrayList {
	
	private Object[] myArray;
	private int initialSize=0;
	
	
	/**
	 * Constructor
	 */
	public MyArrayList() {
		 myArray =new Object[10];
	}
	
	
	/**
	 * setter function
	 * @param value: value to add to the list
	 */
	public void set(Object value) {
		if( myArray.length-initialSize<=0) {
			increaseSize();
		}
		 myArray[initialSize++]=value;
	}
	
	
	/**
	 * This function will increase the size of array when array gets full
	 */
	public void increaseSize() {
		//Arrays.copyOf(values, values.length+10);
		Object[] newArray=new Object[myArray.length+10];
		for(int i=0;i<initialSize;i++) {
			newArray[i]=myArray[i];
		}
		myArray=newArray;
	}
	
	
	
	/**
	 * This function will add a value at the given position
	 * @param position: where value is to be added
	 * @param value: value to be added
	 */
	public void addAt(int position, Object value) {
		if( myArray.length-initialSize<=0) {
			increaseSize();
		}
		if( initialSize<position) {
			 myArray[position-1]=value;
			 initialSize=position;
		}
		else {
			for(int j= initialSize-1;j>=position-1;j--) {
				 myArray[j+1]= myArray[j];
			}
			 myArray[position-1]=value;
			 initialSize++;
		}
		
		
	}
	
	
	
	/**
	 * this function retrieves the position of given element after the given position
	 * @param element: element to be find
	 * @param position: location after which element is to be searched
	 * @return: location of the element if present after the given position
	 */
	public int presentAt(Object element, int position) {
		for(int i=position;i<initialSize;i++) {
			if(myArray[i]==element) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	/**
	 * this function retrieves the position of given element
	 * @param value: element to be find
	 * @return location of the element if present
	 */
	public int retrievingFirstOccurrence(Object value) {
		for(int i=0;i<initialSize;i++) {
			if(myArray[i]==value) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * This function removes the element from the given position
	 * @param position: from where element is to be deleted
	 * @return: array list after deleting the item from the given position
	 */
	public Object[] removeAt(int position) {
		for(int i=position-1;i<initialSize-1;i++) {
			myArray[i]=myArray[i+1];
		}
		initialSize--;
		return myArray;
	}
	
	
	
	/**
	 * This function removes the given element if present
	 * @param value: element to be deleted
	 * @return array list after deleting the given item
	 */
	public Object[] removeElement(Object value) {
		for(int i=0;i<initialSize;i++) {
			if(myArray[i]==value) {
				for(int j=i;j<initialSize-1;j++) {
					myArray[j]=myArray[j+1];
				}
				initialSize--;
			}
		}
		return myArray;
	}
	
	
	/**
	 * This function will delete all the elements from the array list
	 */
	public void clearList() {
		initialSize=0;
	}
	
	
	/**
	 * This function will reverse the elements of the given array list
	 * @return the array list containing elements in the reverse order
	 */
	public Object[] reverse() {
		Object[] reverse= new Object[initialSize];
		int j=0;
		for(int i=initialSize-1;i>=0;i--) {
			reverse[j++]=myArray[i];
		}
		return reverse;
	}
	
	
	
	/**
	 * This function will sort the elements of the given array list
	 * @return: sorted list of elements
	 */
	public Object[] sort() {
		for(int i=0;i<initialSize;i++) {
			for(int j=0;j<i;j++) {
				if((int)myArray[j+1]<(int)myArray[j]) {
					Object temp=myArray[j+1];
					myArray[j+1]=myArray[j];
					myArray[j]=temp;
				}
			}
		}
		return myArray;
		
	}
	
	
	/**
	 * This function will print all elements of the array list
	 */
	public void printAllElements() {
		for (int i = 0; i < initialSize; i++) {
			System.out.print(myArray[i]+"\t");
		}
	}
	
	
	/**
	 * This function will display size of the array list
	 */
	public void printSizeOfArrayList() {
		System.out.println("Size of array list is:"+initialSize);
	}
	
	
	
	/**
	 * This function will merge the two array lists into one
	 * @param newList: new array list to be merged
	 */
	public void mergeLists(Object[] newList) {
		for(int i=0;i<newList.length;i++) {
			set(newList[i]);
		}
	}
	
	
	
	
	/**
	 * This is the main function
	 */
	public static void main(String args[]) {
		MyArrayList arrayList=new MyArrayList();
		int choice,position,value,valid1,valid2;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1. Adding an item into array list and check if list is full, then resizing that arraylist\n"
					+ "2. Adding an item into array list at the given particular location i\n"
					+ "3. Retrieving the first occurrence of an item based on its given location\n"
					+ "4. Retrieving the first index of particular item in the arraylist\n"
					+ "5. Removing an item based on particular location\n"
					+ "6. Remove given particular item from the arraylist\n"
					+ "7. Clear the list i.e. remove all the elements of the list\n"
					+ "8. Reverse the arraylist\n"
					+ "9. Sort the elements of arraylist\n"
					+ "10. Display all elements of arraylist\n"
					+ "11. Display size of arraylist\n"
					+ "12. Merge two lists");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			do {
				switch(choice)
				{
					case 1:
						System.out.println("Enter the value:");
						value=sc.nextInt();
						arrayList.set(value);
						break;
					case 2:
						System.out.println("Enter the value:");
						value=sc.nextInt();
						System.out.println("Enter the position:");
						position=sc.nextInt();
						arrayList.addAt(position, value);
						break;
					case 3:
						System.out.println("Enter the value:");
						value=sc.nextInt();
						System.out.println("Enter the position:");
						position=sc.nextInt();
						int location1=arrayList.presentAt(value, position);
						if(location1==-1) {
							System.out.println("Element is not present in the arraylist");
						}
						else {
							System.out.println("Element is present at "+(location1+1));
						}
						break;
					case 4:
						System.out.println("Enter the value:");
						value=sc.nextInt();
						int location2=arrayList.retrievingFirstOccurrence(value);
						if(location2==-1) {
							System.out.println("Element is not present in the arraylist");
						}
						else {
							System.out.println("Element is present at "+(location2+1));
						}
						break;
					case 5:
						System.out.println("Enter the position:");
						position=sc.nextInt();
						arrayList.removeAt(position);
						break;
					case 6:
						System.out.println("Enter the value:");
						value=sc.nextInt();
						arrayList.removeElement(value);
						break;
					case 7:
						arrayList.clearList();
						break;
					case 8:
						Object[] reverse=arrayList.reverse();
						for(int i=0;i<reverse.length;i++) {
							System.out.print(reverse[i]+"\t");
						}
						break;
					case 9:
						arrayList.sort();
						break;
					case 10:
						System.out.println("Array List is:");
						arrayList.printAllElements();
						break;
					case 11:
						arrayList.printSizeOfArrayList();
						break;
					case 12:
						System.out.println("Enter no of elements in new list:");
						int n=sc.nextInt();
						System.out.println("Enter a new list to merge with existing:");
						Object newList[]=new Object[n];
						for(int i=0;i<n;i++) {
							newList[i]=sc.nextInt();
						}
						arrayList.mergeLists(newList);
						break;
					default:
						break;
				}
				System.out.println("Enter 1 to continue 0 to exit..");
				valid2=sc.nextInt();
			}while(valid2==1);
			System.out.println("Enter 1 to perform another function 0 to exit..");
			valid1=sc.nextInt();
		}while(valid1==1);
		sc.close();
	}

}
