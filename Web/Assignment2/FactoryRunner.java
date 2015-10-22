package Assignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: contains main function to run the factory class
 *
 */
public class FactoryRunner {
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) {
		int choice;
		List<Employee> developers=new ArrayList<Employee>();
		
		try {
			do {
				System.out.println("Enter\n1 to add employee\n2 to get all employee list\n3 to exit");
				choice=sc.nextInt();
				
				switch(choice) {
					case 1:
						System.out.println("Enter name of Employee:");
						String name=sc.next();
						System.out.println("Enter role of Employee:");
						String role=sc.next();
						Factory factory=new Factory();
						factory.createEmployee(name, role);
						factory.addEmployee(factory);
						developers= factory.getEmployees();
						break;
						
					case 2:
							Iterator<Employee> itr=developers.iterator();
							int count=developers.size();
							if(count==0) {
								System.out.println("There is No Employee");
							}
							else {
								int index=0;
								while (itr.hasNext()) {
									index++;
									Employee dev=itr.next();
									String devName=dev.getName();
									String devRole=dev.getRole();
									System.out.println(index+".\tName:\t"+devName+"\t\tRole:\t"+devRole);
									
								}
							}
						break;
						
					case 3:
						System.exit(0);
						break;
					
					default:
						System.out.println("Enter valid choice");
						break;
				}
			}while(choice!=3);
		}
		catch(InputMismatchException ime) {
			System.out.println("Not a Number");
		}
		
		
		
		
		
	}

}
