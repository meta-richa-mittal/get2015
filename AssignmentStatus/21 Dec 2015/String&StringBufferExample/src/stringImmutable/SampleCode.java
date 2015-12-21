package stringImmutable;


public class SampleCode {
	
	public static void main(String args[]) {
		String s = "Let’s test";
		
		// value is not changed
		s.concat(" if the String object is IMMUTABLE");

		System.out.println(s);
		
		// value is changed
		s = s.concat(" if the String object is IMMUTABLE");

		System.out.println(s);
	}
	
}
