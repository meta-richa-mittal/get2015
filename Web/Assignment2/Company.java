package Assignment2;

import java.util.List;

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
