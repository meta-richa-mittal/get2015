package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Factory extends Company{

	public static List<Employee> employees= new ArrayList<Employee>();
	
	@Override
	public List<Employee> getEmployees() {
		
		return employees;
	}
	
	public Factory() {
		
	}
	
	public void createEmployee(String name, String role) {
		this.setName(name);
		this.setRole(role);
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
