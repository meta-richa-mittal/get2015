package josephusProblem;


public class Person {
	public int value;
	public Person next;
	
	public Person() {
		this.value=0;
		this.next=null;
	}
	
	public Person(int value, Person next) {
		this.value=value;
		this.next=next;
	}
	
	public int getValue() {
		return value;
	}
	
	
	public void setValue(int value) {
		this.value = value;
	}
	
	
	public Person getNext() {
		return next;
	}
	
	
	public void setNext(Person next) {
		this.next = next;
	}

}
