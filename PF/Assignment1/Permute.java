package assignment4;


import java.util.HashSet;
import java.util.Set;

/**
 * Author: Richa Mittal
 * Description: This program contains a single class with three functions.
 * 		Function 1: To find the possible permutations
 * 		Function 2: To find a string to add to the Solution
 * 		Function 3: Main Function
 * Input: s( eg. abc) // any string
 * Output: 
 * 		Function 1: returns the final solution
 * 		Function 2: returns next string
 */
public class Permute {
		
	/**
	 * 
	 * @param str: input string to find all possible permutations
	 * @return set of all possible permutations
	 */
	public static Set<String> permutation(String str)
	{
        Set<String> solution = new HashSet<String>();
        if (str == null)									
        {
            return null;
        } 
        else if (str.length() == 0)
        {
            solution.add("");
            return solution;
        }
        char initial = str.charAt(0); 						// first character
        String rem = str.substring(1); 						// Full string without first character
        Set<String> words = permutation(rem);
        for (String strNew : words) 
        {
            for (int i = 0;i<=strNew.length();i++)
            {
                solution.add(insert(strNew, initial, i));
            }
        }
        return solution;
    }
 
	/**
	 * 
	 * @param str: string to find next permutation
	 * @param c: character to be shifted
	 * @param j: variable to divide string
	 * @return next permutation
	 */
	public static String insert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
 
    /**
     * This is the Main Function
     */
	public static void main(String[] args) 
    {
    	System.out.print("Enter the String:");
    	java.util.Scanner sc=new java.util.Scanner(System.in);
    	String s=sc.next();											// Input string
        System.out.println("\nPermutations for " + s + " are: \n" + permutation(s));	// Print permutations
        sc.close();
    }

}
