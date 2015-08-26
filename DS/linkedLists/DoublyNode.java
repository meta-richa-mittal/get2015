package linkedLists;


/**
 * 
 * @author Richa Mittal
 * Description: This class defines the items that the doubly linked list will hold
 * 				and getter, setter methods for them
 */
public class DoublyNode {
	private int value;
	private DoublyNode next;
	private DoublyNode prev;
	
	

	/**
	 * default Constructor
	 */
	public DoublyNode(){
		this.value=0;
		this.next=null;
		this.prev=null;
	}
	
	
	/**
	 * Constructor to initialize values with given values
	 */
	public DoublyNode(int value,DoublyNode next,DoublyNode prev){
		this.value=value;
		this.next=next;
		this.prev=prev;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public DoublyNode getNext() {
		return next;
	}
	public void setNext(DoublyNode next) {
		this.next = next;
	}
	
	public DoublyNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyNode prev) {
		this.prev = prev;
	}

}
