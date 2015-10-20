package socialNetwork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * 
 * @author Richa Mittal
 * Description: This class is extending class Node and having additional 
 * 				details for a Person
 *
 */
public class Person extends Node {
	
	
	/**
	 * Constructor to initialize details of the Person
	 */
	public Person(String name, String description, String email, long pnoneNo, String password, String school, String college, String interests) {
		super(name, description, email, pnoneNo, password);
		this.school=school;
		this.college=college;
		this.interests=interests;
	}

	String school=null;
	
	String college=null;
	
	String interests=null;
	
	static Set<Person> personSet= new HashSet<Person>();

	
	
	/**
	 * This function will display list of all available Persons
	 */
	static public void display() {
		Iterator<Person> per;
		per=personSet.iterator();
		while(per.hasNext()) {
			Person p=per.next();
			System.out.println(p.name+","+p.description+","+p.email+","+p.phoneNo+","+p.school+","+p.college+","+p.interests);
		}
		
	}

}
