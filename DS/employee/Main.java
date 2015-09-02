package employee;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class contains main function
 */
public class Main {
	
	
	static Scanner sc;
	
	
	/**
	 * Main function
	 */
	public static void main(String args[]) {
		
		int ch;
		int empId;
		String name,address;
		sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("\n 1. Add employee"
						+"\n 2. Display all Employees"
						+"\n 3. Perform natural order sorting"
						+"\n 4. Perform sorting acc to Employee name"
						+"\n 5. Exit");
				System.out.print("\n Enter Your choice : ");
				ch = sc.nextInt();
				switch (ch) // Apply switch case and call corresponding method
							// according to the user's choice
				{
					case 1:
						System.out.print("\n Enter employee id: ");
						empId = sc.nextInt();
						System.out.print("\n Enter employee name: ");
						name = sc.next();
						System.out.print("\n Enter employee address: ");
						address = sc.next();
						Employee emp=new Employee(empId, name, address);
						emp.addEmployeeToCollection(emp);				// calling function to add the employee to the collection
						break;
					case 2:
						Employee.printCollection();						// calling function to print the complete collection
						break;
					case 3:
						Collections.sort(Employee.employeeCollection);	// calling function to sort according to empId
						Employee.printCollection();
						break;
					case 4:
						SortAccToName c=new SortAccToName();			// calling function to sort according to name
						Collections.sort(Employee.employeeCollection, c);
						Employee.printCollection();
						break;
					case 5:
						
						System.exit(0);
				}
			}
			
		}
		catch (InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
	}

}
