package Assignment2.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author Richa Mittal
 * Description: defines properties of an employee with its getters and setters
 *
 */
public class Employee {

	
	String employeeName;
	
	
	int employeeId;
	
	@JsonIgnore
	String emailId;
	
	@JsonIgnore
	String dateOfBirth;
	
	
	String dateOfJoining;
	
	@JsonIgnore
	double ctcPerAnnum;

	
	
	public String getEmployeeName() {
		return employeeName;
	}

	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	public int getEmployeeId() {
		return employeeId;
	}
	
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@JsonProperty
	public String getEmailId() {
		return emailId;
	}

	@JsonIgnore
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public String getDateOfJoining() {
		return dateOfJoining;
	}

	
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public double getCtcPerAnnum() {
		return ctcPerAnnum;
	}

	
	public void setCtcPerAnnum(double ctcPerAnnum) {
		this.ctcPerAnnum = ctcPerAnnum;
	}
	
	
	@Override
	public String toString() {
		
		return "EmployeeName:\t"+getEmployeeName()+"\nEmployeeId:\t"+getEmployeeId()+"\nEmailId:\t"+getEmailId()+"\nDateOfBirth:\t"+getDateOfBirth()+"\nDateOfJoining:\t"+getDateOfJoining()+"\nCtcPerAnnum:\t"+getCtcPerAnnum();
	}
	

}
