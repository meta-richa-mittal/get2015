package assignment2;

import java.util.Scanner;

public class Pattern2 {
	public String space(int row,int n)
	{
		int i;
		String str="";
		//creating row of spaces
		for(i=1;i<=row-1;i++)
		{
			str+=" ";
		}
		return str;
		
	}
	public String numbers(int row,int n)
	{
		int i;
		String str="";
		//creating row of numbers
		for(i=1;i<=n-row+1;i++)
		{
			str+=i;
		}
		return str;
		
	}
	public String printWholePyramid(int n)
	{
		int j;
		String str="";
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
		int n;
		String str="";
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
