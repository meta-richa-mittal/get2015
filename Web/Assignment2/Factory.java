package Assignment2;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Richa Mittal
 * Description: extends Company and contains functions to create a new employee
 * 				and add it to the list of existing employees
 *
 */
public class Factory extends Company{

	public static List<Employee> employees= new ArrayList<Employee>();
	
	
	/**
	 * returns list of all available employees of the company
	 */
	@Override
	public List<Employee> getEmployees() {
		
		return employees;
	}
	
	public Factory() {
		
	}
	
	
	/**
	 * creates a new employee
	 * @param name: name of new employee
	 * @param role: role of new employee in the company
	 */
	public void createEmployee(String name, String role) {
		this.setName(name);
		this.setRole(role);
	}
	
	
	/**
	 * adds new employee to the list of employees
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
