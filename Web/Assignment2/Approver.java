package Assignment2;


/**
 * 
 * @author Richa Mittal
 * Description: have property no. of leaves to apply for and
 * 				defines successors for leave approval
 *
 */
public abstract class Approver {
	
	protected int noOfLeaves;

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}
	
	protected Approver successor;
	
	public void setSuccessor(Approver successor) {
		this.successor=successor;
	}
	
	public abstract void processRequest();

}
