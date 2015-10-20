package socialNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Iterator;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;



/**
 * 
 * @author Richa Mittal
 * Description: This is the main class having main function and some additional functions
 *
 */
public class Main {
	BufferedReader br = null;
	static Scanner sc=new Scanner(System.in);
	BufferedWriter bw=null;
	String information="";
	String type="",name="",description="",email="",phoneNo="",school="",college="",interests="",courses="",placements="",password="";
	long phone=0;
	
	
	/**
	 * This function will read information of all existing users from the file
	 */
	public void readInformation() {
		
		try 
		{

			StringTokenizer stringTokenizer;

			FileInputStream fin = new FileInputStream(new File(Constant.LOCATION));
			DataInputStream in = new DataInputStream(fin);
			br = new BufferedReader(new InputStreamReader(in));

			

			while ((information = br.readLine()) != null) 
			{

				stringTokenizer = new StringTokenizer(information,","); 
				try
				{
					while (stringTokenizer.hasMoreTokens()) 
					{ 
						type=stringTokenizer.nextToken();
				        name=stringTokenizer.nextToken();
				        description=stringTokenizer.nextToken();
				        email=stringTokenizer.nextToken();
				        phoneNo=stringTokenizer.nextToken();
				        phone=Long.parseLong(phoneNo); 
				        password=stringTokenizer.nextToken();
				        Node node=new Node(name, description, email, phone, password);
				        
				        if(type.compareToIgnoreCase("Org")==0) 
				        {
				        	courses=stringTokenizer.nextToken();
				        	placements=stringTokenizer.nextToken();
				        	Organization nodeOrg= new Organization(name, description, email, phone, password, courses, placements);
				        	Organization.organizationSet.add(nodeOrg);
				        }
				        else if(type.compareToIgnoreCase("Person")==0) 
				        {
				        	school=stringTokenizer.nextToken();
				        	college=stringTokenizer.nextToken();
				        	interests=stringTokenizer.nextToken();
				        	Person nodePer=(new Person(name, description, email, phone, password, school, college, interests));
				        	Person.personSet.add(nodePer);
				        }
				        Graph graph= new Graph();
				        graph.addNode(node);
					}
				}
				catch(NoSuchElementException ne) {
					
				}
			}
			br.close();

		  } 
		catch (IOException e)
		{
			  System.out.println(e);
		} 
	}
	
	
	/**
	 * This function will display all the existing users
	 */
	static public void display() {
		Graph graph= new Graph();
		graph.iterator=Graph.nodeSet.iterator();
		while(graph.iterator.hasNext()) {
			Node n=graph.iterator.next();
			System.out.println(n.name+","+n.description+","+n.email+","+n.phoneNo);
		}
		
	}
	
	
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		
		Main m=new Main();
		m.readInformation();
		int valid;
		do {
			valid=0;
			Menu menu=new Menu();
			menu.display();
			int choice=sc.nextInt();
			Action action=new Action();
			int i=action.perform(choice);
			if(i!=1)
			{
				System.out.println("press 1 to continue 0 to exit");
				valid=sc.nextInt();
			}
		}while(valid==1);
		
	}
	
	
	/**
	 * This function will search users by their name
	 */
	public void search()
	{
		System.out.println("Enter name to search:");
		String name=sc.next();
		Graph gr=new Graph();
		Set<Node> filteredNode=new HashSet<Node>();
		filteredNode=gr.searchByName(name);
		if(filteredNode.size()==0)
		{
			System.out.println("No such user present");
		}
		Iterator<Node> it=filteredNode.iterator();
		while(it.hasNext()) {
			Node n=it.next();
			System.out.println(n.name+","+n.description+","+n.email+","+n.phoneNo);
		}
	}
	
	
	
	/*
	 * This function will provide the functionality of signing up a user
	 */
	public void signUp()
	{
		try
		{
			
			
			System.out.println("Enter your Type:");
			type=sc.next();
			if(type.compareToIgnoreCase("Person")==0)
			{
				System.out.println("Enter your name:");
				name=sc.next();
				System.out.println("Enter your description:");
				description=sc.next();
				System.out.println("Enter your email:");
				email=sc.next();
				System.out.println("Enter your phone No.:");
				phone=sc.nextLong();
				System.out.println("Enter your school:");
				school=sc.next();
				System.out.println("Enter your college:");
				college=sc.next();
				System.out.println("Enter your interests:");
				interests=sc.next();
				System.out.println("Enter your password:");
				password=sc.next();
				Person per=new Person(type, name, description, phone, password, school, college, interests);
				Person.personSet.add(per);
				
				FileWriter fw = new FileWriter(Constant.LOCATION,true);
				bw = new BufferedWriter(fw);
				information=type+","+name+","+description+","+email+","+phone+","+password+","+school+","+college+","+interests;
				bw.newLine();
				bw.write(information);
				
				
			}
			else if(type.compareToIgnoreCase("Org")==0)
			{
				System.out.println("Enter your name:");
				name=sc.next();
				System.out.println("Enter your description:");
				description=sc.next();
				System.out.println("Enter your email:");
				email=sc.next();
				System.out.println("Enter your phone No.:");
				phone=sc.nextLong();
				System.out.println("Enter your courses:");
				courses=sc.next();
				System.out.println("Enter your placements:");
				placements=sc.next();
				System.out.println("Enter your password:");
				password=sc.next();
				Organization or=new Organization(type, name, description, phone, password, courses, placements);
				Organization.organizationSet.add(or);
				
				FileWriter fw = new FileWriter(Constant.LOCATION,true);
				bw = new BufferedWriter(fw);
				information=type+","+name+","+description+","+email+","+phone+","+password+","+courses+","+placements;
				bw.newLine();
				bw.write(information);
				
			}
			Node newNode= new Node(name, description, email, phone, password);
			Graph.nodeSet.add(newNode);
			System.out.println("Successfully signed up..");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
		System.out.println("\n\nAll available users are:----");
		display();
	}
	
	
	/**
	 * This function will sign in a user by checking its userId and password
	 */
	public void signIn()
	{
		System.out.println("Enter your email:");
		email=sc.next();
		System.out.println("Enter your password:");
		password=sc.next();
		int flag=0;
		Graph graph= new Graph();
		graph.iterator=Graph.nodeSet.iterator();
		while(graph.iterator.hasNext()) {
			Node n=graph.iterator.next();
			String originalEmail=n.email;
			String originalPassword=n.password;
			if(originalEmail.compareToIgnoreCase(email)==0 && originalPassword.compareToIgnoreCase(password)==0)
			{
				flag=1;
				System.out.println("Successfully logged In..");
				int valid;
				do {
					Menu menu=new Menu();
					menu.displaySubMenu();										// calling function of Menu class
					
					valid=0;
					int choice=sc.nextInt();
					Action action=new Action();
					int i=action.performSubAction(choice, n);					// calling function of Action class
					if(i!=1)
					{
						System.out.println("press 1 to continue 0 to exit");
						valid=sc.nextInt();
					}
				}while(valid==1);
				
				break;
				
			}
			else
			{
				flag=0;
				
			}
		}
		if(flag==0)
		{
			System.out.println("email id or password is incorrect..");
		}
	}
	
	
	
	/**
	 * This function will add a new friend to the requesting friend
	 * @param requestingNode: node requesting for adding friend
	 */
	public void addFriend(Node requestingNode)
	{
		System.out.println("Enter email of friend to add:");
		String newEmail=sc.next();
		Graph graph=new Graph();
		int flag=0;
		graph.iterator=Graph.nodeSet.iterator();
		while(graph.iterator.hasNext())
		{
			Node n=graph.iterator.next();
			if(n.email.compareToIgnoreCase(newEmail)==0)
			{
				flag=1;
				//System.out.println("-----"+n.email+"----");
				//System.out.println("-----"+requestingNode.email+"----");
				graph.addEdge(requestingNode, n);							// calling method of Graph class
				System.out.println("Friend Added");
				//graph.displayConnections();
				break;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==0)
		{
			System.out.println("No such user is present");
		}
	}

}
