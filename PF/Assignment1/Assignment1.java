package assignment3;

import java.util.Scanner;

/**
 * Author: Richa Mittal
 * Description: This program contains a single class with 
 * 				one instance variable and four functions.
 * 		Instance Variable 1: Used in Function 3
 * 		Function 1: To find remainder using Recursive Call
 * 		Function 2: To find GCD using Recursive Call
 * 		Function 3: To finf Largest Digit in a Number using Recursive Call
 * 		Function 4: Main Function
 * Input: Three numbers no1, no2 and num ( eg. 17,5,46687)
 * 		Function 1: no1,no2
 * 		Function 2: no1,no2
 * 		Function 3: num
 * Output: 
 * 		Function 1: rem (o/p: 2)
 * 		Function 2: gcd (o/p: 1)
 * 		Function 3: largest (o/p: 8)
 */
public class Assignment1 {
	/**
	 * This instance variable is used in Function 3 to store largest digit
	 */
	public int largest=0;
	
	/**
	 * This function takes two inputs and returns their remainder as output
	 * @param x: Dividend
	 * @param y: Divisor
	 * @return remainder when x is divided by y
	 */
	public int rem(int x,int y)
	{
		if(y==0)					// checks if divisor is 0
		{
			return -1;
		}
		else if(x==0)				// checks if dividend is 0
		{
			return 0;
		}
		else if(x>0 && y>0)			// if both numbers are positive
		{
			
			if(x>=y)
			{
				return rem(x-y,y);
			}
			else
			{
				return x;
			}
		}
		else if(x<0 && y>0)			// if dividend is negative & divisor is positive
		{
			return rem(x+y,y);
		}
		else if(x>0 && y<0)			// if dividend is positive & divisor is negative
		{
			return rem(x+y,y);
		}
		else						// if both numbers are negative
		{
			if(Math.abs(x)>=Math.abs(y))
			{
				return rem(x-y,y);
			}
			else
			{
				return x-y;
			}
		}
	}
	
	/**
	 * This function takes two inputs and returns their GCD as output
	 * @param x: first number
	 * @param y: second number
	 * @return GCD of x and y
	 */
	public int gcd(int x,int y)
	{
		int rem;
		x=Math.abs(x);				// makes first number positive
		y=Math.abs(y);				// makes second number positive
		if(x==0)					// checks if first number is 0
		{
			if(y==0)				// checks if second number is 0
			{
				return 0;
			}
			else 
			{
				return y;
			}
		}
		else if(y==0)				// checks if second number is 0
		{
			return x;
		}
		else if(x>=y)				// if first number is greater than or equal to second
		{
			rem=x%y;
			if(rem!=0)
			{
				return gcd(y,rem);
			}
			else
			{
				return y;
			}
		}
		else						// if second number is greater than first number
		{
			rem=y%x;
			if(rem!=0)
			{
				return gcd(x,rem);
			}
			else
			{
				return x;
			}
		}
	}
	
	/**
	 * This function takes one input and returns maximum digit in it as output
	 * @param x: any number
	 * @return maximum digit in the x
	 */
	public int largestDigit(long x)
	{
		x=Math.abs(x);				// makes given number positive
		if(x!=0)
		{
			if(x%10>largest)
			{
				largest=(int)x%10;
			}
			return largestDigit(x/10);
		}
		else
		{
			return largest;
		}
	}
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		int i;
		long num;
		int no1,no2;						// input variables
		int rem,gcd,largest;				// output variables
		Scanner sc=new Scanner(System.in);
		Assignment1 ob=new Assignment1();	// creating object of our class
		do
		{
			System.out.print("Enter 1 to find remainder of two no's.\nEnter 2 to find gcd of two no's.\nEnter 3 to find largest digit in a no.\nEnter 0 to exit.");
			i=sc.nextInt();
			switch(i)
			{
				case 1:
					System.out.print("Enter two no's:");
					no1=sc.nextInt();			
					no2=sc.nextInt();
					rem=ob.rem(no1, no2);				// calling first function to find remainder
					if(rem==-1)
					{
						System.out.println("Divide by 0 is not possible.");
					}
					else
					{
						System.out.println("Remainder when "+no1+" is divided by "+ no2+ " is:"+rem);
					}
					break;
				case 2:
					System.out.print("Enter two no's:");
					no1=sc.nextInt();			
					no2=sc.nextInt();
					gcd=ob.gcd(no1, no2);				// calling second function to find GCD
					System.out.println("GCD of given 2 no.'s is:"+gcd);
					break;
				case 3:
					System.out.print("Enter a no.:");
					num=sc.nextInt();
					largest=ob.largestDigit(num);		// calling third function to find largest digit
					System.out.println("Largest digit in the given No. "+num+ " is:"+largest);
					break;
				case 0:
					return;
				default:
					System.out.println("Enter a valid no.");
					break;
			}
		}while(i<0||i>3);
		sc.close();
	}
}
