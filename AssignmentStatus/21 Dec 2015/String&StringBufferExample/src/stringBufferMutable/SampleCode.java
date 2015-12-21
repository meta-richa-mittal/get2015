package stringBufferMutable;


public class SampleCode {
	
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Let’s test");

		sb.append(" if the String object is IMMUTABLE");

		System.out.println(sb);

		sb = sb.append(" if the String object is IMMUTABLE");

		System.out.println(sb);
	}
	
}
