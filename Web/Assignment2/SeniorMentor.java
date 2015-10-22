package Assignment2;


/**
 * 
 * @author Richa Mittal
 * Description: extends Approver class
 *
 */
public class SeniorMentor extends Approver{
	
	
	/**
	 * method to process request for the applied leave by Senior Mentor
	 */
	@Override
	public void processRequest() {
		// TODO Auto-generated method stub
		if(noOfLeaves==2) {
			System.out.println("Leave approved by Senior Mentor!!");
		}
		else if(successor != null) {
			successor.processRequest();
		}
	}

}
