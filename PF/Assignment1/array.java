package assignment1;

public class array {
	public int checkOrder(int arr[])	//checks the order of the given array
	{
		int len,flag=-1;
		int i;	//loop counter
		len=arr.length;	//holds length of array
		for(i=1;i<len;i++)
		{
			if(arr[i]>=arr[i-1] && flag!=2)
			{
				flag=1;
			}
			else
			{
				if(arr[i]<=arr[i-1] && flag!=1)
				{
					flag=2;
				}
				else
				{
					flag=0;
					break;
				}
			}
		}
		return flag;
	}
	public static void main(String args[])
	{
		int input[]={8,5,3,2,1};
		int value;	//variable to check the return value of the function
		array ob=new array();
		value=ob.checkOrder(input);
		if(value==1)
		{
			System.out.println("Array is in Ascending Order.");
		}
		else if(value==2)
		{
			System.out.println("Array is in Descending Order.");
		}
		else if(value==0)
		{
			System.out.println("Array is not Sorted.");
		}	
	}

}
