package hashTable;


/**
 * 
 * @author Richa Mittal
 *  Description: This class defines guests names and their ages
 *
 */
public class Guests {
	
	int noOfGuests;
	String guestsNames[]=new String[noOfGuests];
	int age[]=new int[noOfGuests];
	
	
	
	public int getNoOfGuests() {
		return noOfGuests;
	}
	
	

	
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	
	
	
	public String[] getGuestsNames() {
		return guestsNames;
	}
	
	
	
	public void setGuestsNames(String[] guestsNames) {
		this.guestsNames = guestsNames;
	}
	
	
	
	public int[] getAge() {
		return age;
	}
	
	
	
	public void setAge(int[] age) {
		this.age = age;
	}
	
	
	/**
	 * function to display names of guests and their ages
	 */
	public void display() {
		System.out.println("Guests Name:\t\tAge:");
		for(int i=0;i<getNoOfGuests();i++) {
			System.out.println(getGuestsNames()[i]+"\t\t\t"+getAge()[i]);
		}
	}

}
