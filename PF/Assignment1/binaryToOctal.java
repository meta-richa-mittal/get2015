package assignment1;

public class binaryToOctal {
	public int convertBinaryToOctal(int bin)	//method to convert binary no to octal no
	{
		int octal=0,count=0;
		int i=0;	//loop counter
		while(bin!=0)
		{
			octal=(int)((((bin%10)*Math.pow(2, i))*Math.pow(10,count))+octal);
			bin=bin/10;
			i++;
			if(i==3)
			{
				i=0;
				count++;
				continue;
			}
		}
		return octal;
	}
	public static void main(String args[])
	{
		int octal;
		binaryToOctal ob=new binaryToOctal();
		octal=ob.convertBinaryToOctal(101110101);
		System.out.println(octal);
	}
	

}
