package Assignment2;


/**
 * 
 * @author Richa Mittal
 * Description: extends Approver class
 *
 */
public class Mentor extends Approver {

	/**
	 * method to process request for the applied leave by Mentor
	 */
	@Override
	public void processRequest() {
		// TODO Auto-generated method stub
		if(noOfLeaves==1) {
			System.out.println("Leave approved by Mentor!!");
		}
		else if(successor != null) {
			successor.processRequest();
		}
	}
	
	

}
