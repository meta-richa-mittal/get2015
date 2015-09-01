package collections;


import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;


/**
 * 
 * @author Richa Mittal
 * Description: This class defines function to find concordance of characters
 *
 */
public class CharacterConcordance {
	
	static Hashtable<Character, Set<Integer>> characters=new Hashtable<Character, Set<Integer>>();
	
	
	/**
	 * This function will find the concordance of characters present in the given String
	 */
	public static Hashtable<Character, Set<Integer>> findCharacterConcordance(String completeString) {
		for(int i=0;i<completeString.length();i++) {
			char character=completeString.charAt(i);
			Set<Integer> characterSet=characters.get(character);
			if(characterSet==null) {
				characterSet=new HashSet<Integer>();
			}
			characterSet.add(i);
			characters.put(character, characterSet);
		}
		return characters;
	}
	
	
	/**
	 * function to display result of concordance
	 */
	public static void display() {
		System.out.println(characters);
	}


}
