package socialNetwork;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains six functions
 * 		Function 1: adds node to the nodes list
 * 		Function 2: removes node from the nodes list
 * 		Function 3: searches nodes by the given name
 * 		Function 4: adds connection between two nodes
 * 		Function 5: removes connection between two nodes
 * 		Function 6: displays all available connections
 *
 */
public class Graph {
	
	static Set<Node> nodeSet=new HashSet<Node>();
	
	Set<Node> filteredNodeSet=new HashSet<Node>();
	
	Iterator<Node> iterator;
	
	static Map<String,Set<Node>> map=new HashMap<String, Set<Node>>();
	
	
	/**
	 * This function adds node to the nodes list
	 * @param node: node to be added
	 */
	public void addNode(Node node) {
		nodeSet.add(node);
	}
	
	
	/**
	 * This function removes node from the nodes list
	 * @param node: node to be deleted
	 */
	public void removeNode(Node node) {
		nodeSet.remove(node);
	}
	
	
	/**
	 * This function searches nodes by the given name
	 * @param name: name to be searched in the nodes list
	 * @return a set of nodes containing information of all available users having given name
	 */
	public Set<Node> searchByName(String name) {
		
		 iterator= nodeSet.iterator();
		 while(iterator.hasNext())
		 {
			 Node nodeValue=iterator.next();
			 if(nodeValue.name.compareToIgnoreCase(name)==0)
			 {
				 filteredNodeSet.add(nodeValue);
			 }
		 }
		 return filteredNodeSet;
	}
	
	
	/**
	 * This function adds connection between two nodes
	 * @param node1: node requesting for the connection
	 * @param node2: node accepting connection
	 */
	void addEdge(Node node1, Node node2) {
		//System.out.println("-----"+node1.email+"----");
		//System.out.println("-----"+node2.email+"----");
		node1.nodesSet.add(node2);
		node2.nodesSet.add(node1);
		try
		{
			map.put(node1.email, node1.nodesSet);
			map.put(node2.email, node2.nodesSet);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	/**
	 * This function removes connection between two nodes
	 * @param node1: node requesting for the disconnection
	 * @param node2: node accepting disconnection
	 */
	void removeEdge(Node node1, Node node2) {
		map.remove(node2, node2);
		map.remove(node2, node1);
	}
	
	
	/**
	 * This function displays all available connections
	 */
	public void displayConnections()
	{
		
			if(map.size()==0)
			{
				System.out.println("No connections");
			}
			Set<String> keys = map.keySet();
	        Iterator<String> itr = keys.iterator();
	 
	        String key;
	        Set<Node> values;
	        while(itr.hasNext())
	        {
	            key = (String)itr.next();
	            values =map.get(key);
	            System.out.println("\nFriends of "+ key + " are ---- ");
	            Iterator<Node> i=values.iterator();
	            while(i.hasNext())
	            {
	            	 System.out.println(i.next().email);
	            }
	        }
		
	}
}
