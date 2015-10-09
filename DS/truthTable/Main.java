package truthTable;

import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: contains main function
 *
 */
public class Main {
	static Scanner sc=new Scanner(System.in);
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("TRUTH TABLE");
		System.out.println("Enter expression to find its truth table:");
		String expr=sc.next();
		expr=expr.trim();
		if(Validation.isExpression(expr)) {
			expr = TruthTable.furnish(expr);
			int count=TruthTable.countVariables(expr);
		
			System.out.println("No of variables are:"+ count );
			TruthTable.findValues(count);
		
			String inputPostfix=TruthTable.postfixConvertor(expr);
			System.out.println("****"+inputPostfix+"****");
			TruthTable.evalPostfix(inputPostfix);
		
		}
		else {
			System.out.println("Enter Valid Expression");
		}
		
	}
}
