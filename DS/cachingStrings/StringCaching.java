package cachingStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 
 * @author Richa Mittal
 * Description: This class defines function to find no of unique characters in a string
 *
 */
public class StringCaching {
	
	
	static Map<String, Integer> cache=new HashMap<String, Integer>();
	
	/**
	 * function will find number of unique characters in a string if string is already processed
	 * then will find the value from the cache
	 */
	public static int findUniqueCharacters(String string) {
		int count=0;
		Set<Character> uniqueCharacters= new HashSet<Character>();
		if(cache.containsKey(string)) {
			return cache.get(string);
		}
		else {
			for(int i=0;i<string.length();i++) {
				uniqueCharacters.add(string.charAt(i));
			}
			count=uniqueCharacters.size();
			cache.put(string, count);
		}
		return count;
		
	}

}
