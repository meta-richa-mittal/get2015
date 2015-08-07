package assignment2;

import java.util.Scanner;

public class Pattern1 {
	public String space(int row,int n)
	{
		int i;
		String s="";
		//creating row of spaces
		for(i=row;i<n;i++)
		{
			s+=" ";
		}
		return s;
	}
	public String numbers(int row,int n)
	{
		int i;
		String s="";
		//creating row of increasing no
		for(i=1;i<=row;i++)
		{
			s+=i;
		}
		//creating row of decreasing no
		for(i=row-1;i>0;i--)
		{
			s+=i;
		}
		return s;
	}
	public String printWholePyramid(int n)
	{
		int j;
		String s="";
		// creating upward pyramid
		for(j=1;j<=n;j++)
		{
			s+=space(j,n);
			s+=numbers(j,n);
			s+="\n";
		}
		// creating downward pyramid
		for(j=n-1;j>0;j--)
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
		Pattern1 ob=new Pattern1();
		s=ob.printWholePyramid(n);
		System.out.print(s);
		sc.close();
	}

}
