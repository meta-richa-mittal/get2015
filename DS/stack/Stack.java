package stack;

import java.util.Scanner;

/**
 * 
 * @author Richa
 * this class will desines various functions to implement stack using linked list
 */
public class Stack {
	
	public Node start=null;
	private static Scanner sc;
	static Stack stack= new Stack();
	
	
	/**
	 * add item to stack
	 * @param item
	 */
	public void push(Object item) {
		
		Node newNode= new Node(item,null);
		if(start==null) {
			start=newNode;
		}
		else {
			newNode.setNext(start);
			start=newNode;
		}
	}
	
	
	/**
	 * pop an item from top of stack
	 * @return
	 */
	public Object pop() {
		Object item;
		Node temp=start;
		if(start==null) {
			//System.out.println("Stack is empty. Can not pop.");
			return 0;
		}
		else {
			item=temp.getValue();
			start=temp.getNext();
		}
		return item;
	}
	
	
	
	/**
	 * display the complete stack
	 */
	public void displayStack() {
		Node temp=start;
		System.out.println("Stack is:");
		while(temp!=null) {
			System.out.print(temp.getValue()+"\t");
			temp=temp.getNext();
		}
	}
	
	
	/**
	 * prints the top element of the stack
	 * @return
	 */
	public Object topItem() {
		Node temp=start;
		Object top;
		if(start==null) {
			return (Object)0;
		}
		else {
			top=temp.getValue();
		}
		return top;
	}
	
	
	/**
	 * convert infix notation to postfix
	 * @param infixString
	 * @return
	 */
	public String infixToPostFix(String infixString) {
		String postfixString="";
		int length=infixString.length();
		for(int i=0;i<length;i++) {
			//stack.displayStack();
			Object present=infixString.charAt(i);
			Object top;
			if(checkOperator(present)) {
				do {
						top=stack.topItem();
						if(stack.precedenceOfOperator(top)>=stack.precedenceOfOperator(present)) {
							postfixString+=top;
							stack.pop();
							top=stack.topItem();
						}
					}while(stack.precedenceOfOperator(top)>=stack.precedenceOfOperator(present));
						stack.push(present);
					//}
					//else {
					//	stack.push(present);
					//}
					
				
				
			}
			else {
				postfixString+=present;
			}
		}
		
		Node temp=start;
		while(temp!=null) {
			Object item=stack.pop();
			postfixString+=item;
			temp=temp.getNext();
		}
		return postfixString;
	}
	
	
	/**
	 * defines precedence of operators
	 * @param operator
	 * @return
	 */
	public int precedenceOfOperator(Object operator) {
		int precedence=-100;
		if(operator.equals('+') || operator.equals('-')) {
			precedence=1;
		}
		else if(operator.equals('*') || operator.equals('/') || operator.equals('%')) {
			precedence=2;
		}
		else if(operator.equals('^')) {
			precedence=3;
		}
		return precedence;
	}
	
	
	/**
	 * check whether charactor is operand or operator
	 * @param operator
	 * @return
	 */
	public boolean checkOperator(Object operator) {
		if(operator.equals('+') || operator.equals('-') || operator.equals('*') || operator.equals('/') || operator.equals('%') || operator.equals('^') ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String args[]) {
		
		int ch;
		Object item;
		sc = new Scanner(System.in);
		while (true) {
			System.out.print("\n 1. Push item to stack"
					+ "\n 2. Pop item from stack"
					+ "\n 3. Display Stack "
					+"\n 4. Display top element"
					+"\n 5. Convert infix notation ton postfix notation"
					+ "\n 6. Exit");
			System.out.print("\n Enter Your choice : ");
			ch = sc.nextInt();
			switch (ch) // Apply switch case and call corresponding method
						// according to the user's choice
			{
				case 1:
					System.out.print("\n Enter node value : ");
					item = sc.nextInt();
					stack.push(item);
					break;
				case 2:
					item=stack.pop();
					if((int)item!=0) {
						System.out.println("Item Popped:"+item);
					}
					else {
						System.out.println("Stack is empty");
					}
					break;
				case 3:
					stack.displayStack();
					break;
				case 4:
					Object top=stack.topItem();
					if((int)top!=0) {
						System.out.print("Top item is:"+top);
					}
					else {
						System.out.println("Stack is empty");
					}
					break;
				case 5:
					System.out.println("Enter String in infix notation:");
					String infixString=sc.next();
					String postfixString=stack.infixToPostFix(infixString);
					System.out.println("String in postfix notation is:"+postfixString);
					break;
				case 6:
					System.exit(0);
			}
		}
	}

}
