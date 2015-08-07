package assignment1;

public class mergingSortedArray {
	public int[] join(int a[],int asize,int b[],int bsize,int c[]) //method to merge 2 sorted arrays into single sorted array
	{
		int i=0,j=0,k=0; //loop counters
		while(i<asize && j<bsize)
		{
			if(a[i]>b[j])
			{
				c[k++]=b[j++];
				
			}
			else
			{
				c[k++]=a[i++];
				
			}
		}
		while(i<asize)
		{
			c[k++]=a[i++];
			
		}
		while(j<bsize)
		{
			c[k++]=b[j++];
			
		}
		return c;
	}
	public static void main(String args[])
	{
		int a[]={1,4,6,9}; //given array1
		int b[]={2,3,6,8};	//given array2
		int asize=a.length;
		int bsize=b.length;
		int c[]=new int[asize+bsize];
		int i;
		mergingSortedArray ob=new mergingSortedArray();
		c=ob.join(a, asize, b, bsize, c);
		for(i=0;i<c.length;i++)
		{
			System.out.println(c[i]);
		}	
	}

}
