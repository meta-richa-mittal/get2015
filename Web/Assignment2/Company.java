package Assignment2;

import java.util.List;


/**
 * 
 * @author Richa Mittal
 * Description: extends Employee class and defines its getters and setters, 
 * 				contains abstract method to get list of all employees of the company
 *
 */
public abstract class Company extends Employee {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public abstract List<Employee> getEmployees();
}
