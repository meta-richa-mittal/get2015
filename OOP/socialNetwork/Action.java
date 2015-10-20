package socialNetwork;

/**
 * 
 * @author Richa Mittal
 * description: This class contains functions which call appropriate functions depending upon user choice 
 *
 */
public class Action {
	
	
	/**
	 * This function will perform action depending upon the chosen menu Item
	 * @param choice: value chosen by user
	 * @return integer depending upon whether to call another function or exit
	 */
	public int perform(int choice)
	{
		Main m=new Main();
		int i=0;
		switch(choice)
		{
			case 1:
				m.signUp();
				break;
			case 2:
				m.signIn();
				break;
			case 3:
				i=1;
			default:
				break;
		}
		return i;
	}
	
	
	/**
	 * This function will perform action depending upon the chosen Sub menu Item after a user logs in
	 * @param choice: value chosen by user
	 * @param requestingNode: node that is logged in
	 * @return integer depending upon whether to call another function or exit
	 */
	public int performSubAction(int choice, Node requestingNode)
	{
		Main m=new Main();
		int i=0;
		switch(choice)
		{
			case 1:
				m.addFriend(requestingNode);
				break;
			case 2:
				m.search();
				break;
			case 3:
				Graph g=new Graph();
				g.displayConnections();
				break;
			case 4:
				i=1;
			default:
				break;
		}
		return i;
	}

}
