package assignment2;

import java.util.Scanner;

public class Pattern2 {
	public String space(int row,int n)
	{
		int i;
		String s="";
		//creating row of spaces
		for(i=1;i<=row-1;i++)
		{
			s+=" ";
		}
		return s;
		
	}
	public String numbers(int row,int n)
	{
		int i;
		String s="";
		//creating row of numbers
		for(i=1;i<=n-row+1;i++)
		{
			s+=i;
		}
		return s;
		
	}
	public String printWholePyramid(int n)
	{
		int j;
		String s="";
		//creating pattern
		for(j=1;j<=n;j++)
		{
			s+=space(j,n);
			s+=numbers(j,n);
			s+="\n";
		}
		return s;
	}
	public static void main(String args[])
	{
		int n;
		String s="";
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter No. of Rows:");
		n=sc.nextInt();
		Pattern2 ob=new Pattern2();
		s=ob.printWholePyramid(n);
		System.out.print(s);
		sc.close();
	}

}
