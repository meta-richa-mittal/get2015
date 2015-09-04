package treeSort;


/**
 * 
 * @author Richa Mittal
 * Description: This class defines student entity with its roll no, left student and right student
 */
public class Student {
	
	int rollNo;
	Student leftNode;
	Student rightNode;
	
	Student(){
		
	}
	
	/**
	 * Constructor
	 * @param data: roll no. of student
	 * @param leftNode: left sub tree
	 * @param rightNode: right sub tree
	 */
	Student (int rollNo,Student leftNode,Student rightNode){
		this.rollNo=rollNo;
		this.leftNode=leftNode;
		this.rightNode=rightNode;
	}
	
	
	/**
	 * return roll no. of student
	 */
	public int getData() {
		return rollNo;
	}
	
	
	/**
	 * set roll no. of student
	 */
	public void setData(int rollNo) {
		this.rollNo = rollNo;
	}
	
	
	/**
	 * return student at root of left sub tree
	 */
	public Student getLeftNode() {
		return leftNode;
	}
	
	
	/**
	 * set left sub tree
	 */
	public void setLeftNode(Student leftNode) {
		this.leftNode = leftNode;
	}
	
	
	/**
	 * return student at root of right sub tree
	 */
	public Student getRightNode() {
		return rightNode;
	}
	
	
	
	/**
	 * set right sub tree
	 */
	public void setRightNode(Student rightNode) {
		this.rightNode = rightNode;
	}


}

