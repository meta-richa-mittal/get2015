package stack;

	
	/**
	 * 
	 * @author Richa Mittal
	 * Description: This class defines the items that the stack node list will hold
	 * 				and getter, setter methods for them
	 */
	public class Node {
		private Object value;
		private Node next;
		
		
		/**
		 * default Constructor
		 */
		Node() {
			this.value=0;
			this.next=null;
		}
		
		
		/**
		 * Constructor to initialize values with given values
		 */
		public Node(Object value,Node next) {
			this.value=value;
			this.next=next;
		}
		
		
		public Object getValue() {
			return value;
		}
		
		
		public void setValue(int value) {
			this.value = value;
		}
		
		
		public Node getNext() {
			return next;
		}
		
		
		public void setNext(Node next) {
			this.next = next;
		}

}
