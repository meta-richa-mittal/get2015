package assignment1;

public class rmvDuplicate {
	public int[] removeDuplicate(int input[])	//method to remove duplicates from given array
	{
		int n=input.length-1; //variable to hold length of array
		int i,j,k;	//loop counters
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<=n;j++)
			{
				if(input[i]==input[j])
				{
					for(k=j;k<n;k++)
					{
						input[k]=input[k+1];
					}
					n--;
					j--;
				}
			}
		}
		int output[]=new int[n+1];
		for(i=0;i<=n;i++)
		{
			output[i]=input[i];
		}
		return output;
	
	}
	public static void main(String[] args) 
	{
		int[] output;
		int[] input={1,2,2,4,2,3,2,4};
		rmvDuplicate ob=new rmvDuplicate();
		output=ob.removeDuplicate(input);
		for(int i=0;i<output.length;i++)
		{
			System.out.println(output[i]);
		}
	}

}
