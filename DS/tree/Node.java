package tree;


/**
 * 
 * @author Richa
 * Description: This class defines a node with its data value, left sub tree and right tree
 */
public class Node {

	int data;
	Node leftNode;
	Node rightNode;
	
	Node(){
		
	}
	
	/**
	 * Constructor
	 * @param data: value of node
	 * @param leftNode: left sub tree
	 * @param rightNode: right sub tree
	 */
	Node (int data,Node leftNode,Node rightNode){
		this.data=data;
		this.leftNode=leftNode;
		this.rightNode=rightNode;
	}
	
	
	/**
	 * return value of node
	 */
	public int getData() {
		return data;
	}
	
	
	/**
	 * set value of node
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	
	/**
	 * return root node of left sub tree
	 */
	public Node getLeftNode() {
		return leftNode;
	}
	
	
	/**
	 * set left sub tree
	 */
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	
	
	/**
	 * return root node of right sub tree
	 */
	public Node getRightNode() {
		return rightNode;
	}
	
	
	
	/**
	 * set right sub tree
	 */
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

}
