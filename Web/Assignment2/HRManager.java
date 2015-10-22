package Assignment2;


/**
 * 
 * @author Richa Mittal
 * Description: extends Approver class
 *
 */
public class HRManager extends Approver {
	
	
	/**
	 * method to process request for the applied leave by HR Manager
	 */
	@Override
	public void processRequest() {
		// TODO Auto-generated method stub
		if(noOfLeaves>=3 && noOfLeaves<=5) {
			System.out.println("Leave approved by HR Manager!!");
		}
		else if(successor==null){
			System.out.println("Leave Approval requires a meeting!!");
		}
	}

}
