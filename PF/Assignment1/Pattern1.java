package assignment2;

import java.util.Scanner;

public class Pattern1 {
	public String space(int row,int n)	//This method creates row of spaces
	{
		int i;
		String str="";
		for(i=row;i<n;i++)
		{
			str+=" ";
		}
		return str;
	}
	public String numbers(int row,int n)	//This method creates row of nos
	{
		int i;
		String str="";				//creating row of increasing no
		for(i=1;i<=row;i++)
		{
			str+=i;
		}
		for(i=row-1;i>0;i--)		//creating row of decreasing no
		{
			str+=i;
		}
		return str;
	}
	public String printWholePyramid(int n)	//This method creates complete Pyramid
	{
		int j;
		String str="";
		for(j=1;j<=n;j++)		// creating upward pyramid
		{
			str+=space(j,n);
			str+=numbers(j,n);
			str+="\n";
		}
		for(j=n-1;j>0;j--)		// creating downward pyramid
		{
			str+=space(j,n);
			str+=numbers(j,n);
			str+="\n";
		}
		
		return str;
	}
	public static void main(String args[])
	{
		int n;	//variable for no. of rows
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
		Pattern1 ob=new Pattern1();
		str=ob.printWholePyramid(n);
		System.out.print(str);
		sc.close();
	}

}
