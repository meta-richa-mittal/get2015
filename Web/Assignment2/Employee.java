package Assignment2;


/**
 * 
 * @author Richa Mittal
 * Description: defines an employee and contains its abstract getters and setters
 *
 */
public abstract class Employee {

	protected String name;
	
	protected String role;
	
	public abstract String getName();
	public abstract void setName(String name);

	public abstract String getRole();
	public abstract void setRole(String role);
}
