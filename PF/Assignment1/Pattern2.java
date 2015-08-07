package assignment2;

import java.util.Scanner;

public class Pattern2 {
	public String space(int row,int n)	//method to create row of spaces
	{
		int i;		//loop counter
		String str="";		//holds row of spaces
		
		for(i=1;i<=row-1;i++)
		{
			str+=" ";
		}
		return str;
		
	}
	public String numbers(int row,int n)	//method to create row of numbers
	{
		int i;		//loop counter
		String str="";		//holds row of numbers
		
		for(i=1;i<=n-row+1;i++)
		{
			str+=i;
		}
		return str;
		
	}
	public String printWholePyramid(int n)
	{
		int j;	//loop counter
		String str="";	//holds complete pattern
		//creating pattern
		for(j=1;j<=n;j++)
		{
			str+=space(j,n);
			str+=numbers(j,n);
			str+="\n";
		}
		return str;
	}
	public static void main(String args[])
	{
		int n;		//variable for no. of rows
		String str="";	//holds the returned pattern from function
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter No. of Rows:");
		do
		{
			n=sc.nextInt();
			if(n<0)
			{
				System.out.println("Please enter valid no. of rows");
			}
		}while(n<0);
		Pattern2 ob=new Pattern2();
		str=ob.printWholePyramid(n);
		System.out.print(str);
		sc.close();
	}

}
