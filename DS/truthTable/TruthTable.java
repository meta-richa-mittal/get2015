package truthTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TruthTable {
	
	static Set<Character> variables=new HashSet<Character>();
	
	static List<String> setOfBinValues=new ArrayList<String>();
	
	static List<String> setOfValues=new ArrayList<String>();
	
	
	
	/**
	 * function will count no. of variables in the given expr
	 * @param expr
	 * @return
	 */
	public static int countVariables(String expr) {
		int i=0;
		while(i!=expr.length()) {
			if(expr.charAt(i)!='~' 
					&& expr.charAt(i)!='&' 
					&& expr.charAt(i)!='|' 
					&& expr.charAt(i)!='(' 
					&& expr.charAt(i)!=')') {
				variables.add(expr.charAt(i));
			}
			i++;
		}
		return variables.size();
	}
	
	
	/**
	 * function will find possible values for truth table
	 * @param count
	 */
	public static void findValues(int count) {
		
		for (int i = 0; i < Math.pow(2, count); i++) {
            String bin = Integer.toBinaryString(i);
            while (bin.length() < count) {
                bin = "0" + bin;
            }
            setOfBinValues.add(bin);
            int j=0;
            String truthValue="";
            while(j<bin.length()) {
            	if(bin.charAt(j)=='0') {
            		truthValue+="F";
            	}
            	else if(bin.charAt(j)=='1') {
            		truthValue+="T";
            	}
            	j++;
            }
            setOfValues.add(truthValue);
		}
		
	}
	
	
	/**
	 * function will furnish expr when more than one "~" is present for same variable
	 * @param input
	 * @return
	 */
	public static String furnish(String input) {
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '~') {
				if(input.charAt(i+1) == '~') {
					if(i == 0) {
						input = input.substring(i+2, input.length());
						i = -1;
					}
					else
						input = input.substring(0, i) + input.substring(i+2, input.length());
				}
			}
		}
		System.out.println(input);
		return input;
	}
	
	
	
	/**
	 * function will perform "&" and "|" operations
	 * @param c1
	 * @param c2
	 * @param op
	 * @return
	 */
	public static Character operationPerform(char c1, char c2, char op) {
		if(op == '&') {
			if(c1 == 'F' || c2 == 'F') {
				return 'F';
			}
			else
				return 'T';
		}
		
		else {
			if(c1 == 'T' || c2 == 'T') {
				return 'T';
			}
			else
				return 'F';
		}
	}
	
	
	/**
	 * function will perform "~"
	 * @param c1
	 * @param op
	 * @return
	 */
	public static Character operationPerform(char c1, char op) {
		if(c1 == 'F')
			return 'T';
		else
			return 'F';
	}
	
	
	
	/**
	 * function will convert infix expr to postfix expr
	 * @param input
	 * @return
	 */
	public static String postfixConvertor(String input) {
		Stack<Character> stackObj = new Stack<Character>();
		
		/* Calculating length of infix expression */
		int inputLength = input.length();
		String postfixExpression = "";
		Object poppedItem;
		int countBraces = 0;
		
		
		for(int i = 0; i < inputLength; i++) {
			Character temp = new Character(input.charAt(i));
			
			
			if(Character.isLetter(temp))
			{
				
				postfixExpression = postfixExpression + temp;
			}
			else if(input.charAt(i) == '(')
			{
				stackObj.push(temp);
				countBraces++;
			}
			else if(temp == ')')
			{
				if(countBraces == 0)
				{
					System.out.println("Invalid Expression");
					return null;
				}
				
				while(!((char)stackObj.peek() == '('))
				{
					poppedItem = stackObj.pop();
					postfixExpression = postfixExpression + poppedItem;
				}
				stackObj.pop();
				countBraces--;
			}
			else if(temp == '&' || temp == '|' || temp == '~')
			{
				if(stackObj.size() == 0) {
					stackObj.push(temp);
				}
				else
				{
					
					if(input.charAt(i) == '~')
					{
						
						if((char)stackObj.peek() == '~')
						{
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
						}
					}
					else if(input.charAt(i) == '&')
					{
						while(stackObj.peek() != '|' && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
							if(stackObj.size() == 0)
								break;
						}
					}
					else if(input.charAt(i) == '|')
					{
						while(stackObj.size() != 0 && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
						}
					}	
					stackObj.push(temp);
				}
			}
		}

		
		while(stackObj.size() != 0)
		{
			poppedItem = stackObj.pop();
			postfixExpression = postfixExpression + poppedItem;
		}
		return postfixExpression;
	}
	
	
	
	/**
	 * function will evaluate postfix expr
	 * @param inputPostfix
	 */
public static void evalPostfix(String inputPostfix) {
		
	    char res = ' ';
	    int n=countVariables(inputPostfix);
	    int m=(int)Math.pow(2, n);
	    
	    char[][] chars=new char[m][n];
	    int k=0;
	    Iterator<String> truthValuesIterator = setOfValues.iterator();
	    while(truthValuesIterator.hasNext()) {
    		String str = truthValuesIterator.next();
    		for(int j=0;j<str.length();j++) {
    			char c= str.charAt(j);
    			chars[k][j]=c;
    		}
    		k++;
    	}
	    
	    Iterator<Character> letterSetIterator1 = variables.iterator();
    	while(letterSetIterator1.hasNext()) {
    		char c = letterSetIterator1.next();
    		System.out.print(c+"\t");
    	}
    	System.out.print("Output");
    	System.out.println();
	    for(int i = 0; i < chars.length; i++) {
	    	String inputUpdate = inputPostfix;
	    	int j = 0;
	    	Iterator<Character> letterSetIterator = variables.iterator();
	    	while(letterSetIterator.hasNext()) {
	    		char c = letterSetIterator.next();
	    		inputUpdate = inputUpdate.replace(c, chars[i][j]);
	    		j++;
	    	}
		    Stack<Character> list = new Stack<Character>();
		    char c1;     //result of 1st popping
		    char c2;     // result of 2nd popping
		    for (j = 0; j < inputUpdate.length(); j++) {
		        char ch = inputUpdate.charAt(j);
	            if (ch == ' ') {
	            } 
	            else {
	            	if (Character.isLetter(ch)) {
	                    list.push(ch);
	                } 
	                else {
	                	if(ch == '~') {
	                		c1 = list.pop();
	                		list.push(operationPerform(c1, ch));
	                	}
	                	else {
		                    c1 = list.pop();
		                    c2 = list.pop();
	
		                    switch (ch) {
		                        case '&':
		                            list.push(operationPerform(c1,c2,'&'));
		                            break;
		                        case '|':
		                            list.push(operationPerform(c1,c2,'|'));
		                            break;
		                        default:
		                            System.out.println("Invalid operator order!");
		                    }
	                	}
	                }
	            }
		    }
		    res =  list.pop();
		    for(int count = 0; count < chars[0].length; count++) {
		    	System.out.print(chars[i][count]+"\t");
		    }
		    System.out.println(res);
		}
	}
	
}
