package Assignment3;


/**
 * 
 * @author Richa Mittal
 * Description: contains main function to implement Template Design Pattern
 *
 */
public class CricketTemplatePattern {
	
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String args[]) {
		Cricket cricket = new OneDayCricket();
		cricket.play();
		System.out.println();
		
		cricket = new TestCricket();
		cricket.play();
		System.out.println();
		
		cricket = new T20Cricket();
		cricket.play();
		System.out.println();
	}

}
