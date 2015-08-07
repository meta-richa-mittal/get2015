package assignment1;

public class incSequence {
	public static void main(String[] args) 
	{
		int input[]={1,3,4,2,4,5,6,1,7,8};
		incSequence ob=new incSequence();
		int output[]=ob.longestSequence(input);
		int i;
		for(i=0;i<output.length;i++)
			System.out.print(output[i]);

	}
	public int[] longestSequence(int input[])	//method to find longest increasing seq in given array
	{
		int len=input.length;	//variable to hold total no of elements in given array
		int arr1[]=new int[len]; //array 1 to hold inc seq
		int arr2[]=new int[len]; //array 2 to hold inc seq
		int count1=1,count2=1; //variable to hold no. of elements in increasing seqs
		int k=0;	//loop counter
		int i,j,l;	//loop counter
		arr1[k]=input[0];
		for(i=0;i<len;)
		{
			k=0;
			arr2[k++]=input[i];
			for(j=i;j<len-1;j++)
			{
				if(input[j]>=input[j+1])
				{
					
					break;
				}
				arr2[k++]=input[j+1];
				count2++;
			}
			if(count2>count1)
			{
				for(l=0;l<count2;l++)
					arr1[l]=arr2[l];
				count1=count2;
			}
			i=i+count2;
			count2=1;
		}
		int output[]=new int[count1];
		for(i=0;i<count1;i++)
		output[i]=arr1[i];
		return output;
	}

}
