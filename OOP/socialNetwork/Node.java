package socialNetwork;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @author Richa Mittal
 * Description: This class Defines the details of a node
 *
 */
public class Node {
	String name=null;
	
	String description=null;
	
	String email=null;
	
	long phoneNo=0;
	
	String password=null;
	
	Set<Node> nodesSet=new HashSet<Node>();
	
	/**
	 * Constructor to initialize details of the node
	 * @param name: name of the node
	 * @param description: additional info about the node
	 * @param email: email Id of the node
	 * @param pnoneNo: contact no of the node
	 * @param password: password for logging into account
	 */
	public Node(String name, String description, String email, long pnoneNo, String password) {
		this.name=name;
		this.description=description;
		this.email=email;
		this.phoneNo=pnoneNo;
		this.password=password;
	}

}
