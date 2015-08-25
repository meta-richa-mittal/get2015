package socialNetwork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Richa Mittal
 * Description: This class is extending class Node and having additional 
 * 				details for an Organization
 *
 */
public class Organization extends Node {
	
	String courses=null;
	
	String placements=null;
	
	static Set<Organization> organizationSet= new HashSet<Organization>();
	
	
	/**
	 * Constructor to initialize details of the organization
	 */
	public Organization(String name, String description, String email, long pnoneNo, String password, String courses, String placements) {
		super(name, description, email, pnoneNo, password);
		this.courses=courses;
		this.placements=placements;
	}


	/**
	 * This function will display list of all available organizations
	 */
	static public void display() {
		Iterator<Organization> org;
		org=organizationSet.iterator();
		while(org.hasNext()) {
			Organization or=org.next();
			System.out.println(or.name+","+or.description+","+or.email+","+or.phoneNo+","+or.courses+","+or.placements);
		}
		
	}

}
