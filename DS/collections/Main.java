package collections;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains main function
 */
public class Main {
	
	//static CharacterConcordance cc=new CharacterConcordance();
	
	
	/**
	 * main function
	 */
	public static void main(String args[]) {
		//String arg[]={"Hello","World"};
		String completeString="";
		for(String str: args) {
			completeString+=str;
		}
		CharacterConcordance.findCharacterConcordance(completeString);		// calling concordance function
		System.out.println("Character Concordance is:");
		CharacterConcordance.display();
		
	}

}
