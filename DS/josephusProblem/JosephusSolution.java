package josephusProblem;

import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: class to solve Josephus peoblem using circular linked list
 *
 */
public class JosephusSolution {
	static JosephusSolution js=new JosephusSolution();
	public Person start=null;
	public Person end=null;
	public Person current=null;
	static Scanner sc=new Scanner(System.in);
	
	
	
	/**
	 * main function
	 */
	public static void main(String args[]) {
		
		
		System.out.println("Enter no of persons:");
		int noOfPersons;
		noOfPersons=sc.nextInt();
		int m;
		while(true) {
			System.out.println("Enter value of m(m should be less than or equal no of persons):");
			m=sc.nextInt();
			if(m>noOfPersons) {
				System.out.println("Enter a value less than no of persons.\n");
				continue;
			}
			else {
				break;
			}
		}
		
		Person startNew=js.createCircle(noOfPersons);
		js.displayCircle(noOfPersons);
		Person newPerson=js.remove(noOfPersons, m,startNew);
		System.out.println("\n\n\n\nFinal Winner:");
		System.out.println(newPerson.getValue());
		
	}

	
	/**
	 * function to create arrangement of people in a circle
	 * @param n: number of persons
	 */
	public Person createCircle(int n) {
		int i=1;
		while(i<=n) {
			 Person newPerson = new Person(i,null);

		        if (start==null) {
		            start = newPerson;
		            current = start;
		        } 
		        else {
		            current.setNext( newPerson);
		        }

		        newPerson.setNext(start);
		        end = newPerson;
		        current = current.getNext();
		        i++;
		}
		return start;
	}
	
	
	
	/**
	 * function to display the persons left in the circle
	 * @param n: number of persons
	 */
	public void displayCircle(int n) {
		Person temp=start;
		int i=1;
		System.out.println("Elements are:");
		
		while(i<=n) {
			System.out.print(temp.getValue()+"\t");
			temp=temp.getNext();
			i++;
		}
		System.out.println();
	}
	
	
	/**
	 * function to remove person present at m position
	 */
	public Person remove(int n,int m,Person startNew) {
		if(n==1) {
			
			return startNew;
		}
		else {
			
			int i=1;
			Person temp=startNew;
			while(i<m-1) {
				temp=temp.getNext();
				i++;
			}
			if(i==m-1) {
				System.out.println("\nRemoved:\n"+temp.getNext().getValue());
			}
			temp.setNext(temp.getNext().getNext());
			
			
			n--;
			//JosephusSolution js=new JosephusSolution();
			js.displayCircle(n);
			return remove(n,m,temp.getNext() );
		}
	}
	
	
}
