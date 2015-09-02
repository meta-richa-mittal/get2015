package employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * @author Richa Mittal
 * Desription: This class defines the properties of an employee and implements Comparable interface
 *
 */
public class Employee implements Comparable<Object> {
	
	
	private Integer empId;
	private String name;
	private String address;
	
	static public List<Employee> employeeCollection= new ArrayList<Employee>();
	static List<Integer> empIdList=new ArrayList<Integer>();
	
	public Employee(Integer empId, String name, String address) {
		this.empId=empId;
		this.name=name;
		this.address=address;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	
	
	/**
	 * function to add a new employee to the collection
	 * @param emp
	 */
	public void addEmployeeToCollection(Employee emp) {
		
		if(AvoidDuplicates.checkDuplicates(emp)) {				// calling function to check whether employee is already present in the collection
			System.out.println("Employee already exists");
		}
		else {
			empIdList.add(emp.getEmpId());
			employeeCollection.add(emp);
		}
	}
	
	
	
	
	/**
	 * function to print all the employees added in the collection
	 */
	static public void printCollection() {
		Iterator<Employee> itr=employeeCollection.iterator();
		System.out.println("EmpId\tName\tAddress");
		while(itr.hasNext()) {
			Employee e=itr.next();
			
			System.out.println(e.getEmpId()+"\t"+e.getName()+"\t"+e.getAddress());
		}
	}

	
	
	
	@Override
	public int compareTo(Object obj) {
			Employee emp = (Employee) obj;
			return getEmpId().compareTo(emp.getEmpId());
		}

}
