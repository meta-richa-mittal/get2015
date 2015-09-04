package sortingTechniques;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortingTechniquesTest {
	
	SortingTechniques st=new SortingTechniques();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		
		int inpArray[]={5,3,7,1,4,3,2,7,4};
		st.array=inpArray;
		
		st.bubbleSort();
		
		int outArray[]=st.array;
		
		int expArray[]={1,2,3,3,4,4,5,7,7};
		
		Assert.assertArrayEquals(expArray,outArray);
		
		
	}
	
	
	
	@Test
	public void test2() {
		
		int inpArray[]={5,3,7,1,4,3,2,7,4};
		st.array=inpArray;
		
		st.quickSort(0,st.array.length-1);
		
		int outArray[]=st.array;
		
		int expArray[]={1,2,3,3,4,4,5,7,7};
		
		Assert.assertArrayEquals(expArray,outArray);
		
		
	}
	
	
	
	
	@Test
	public void test3() {
		
		int inpArray[]={5,3,7,1,4,3,2,7,4};
		st.array=inpArray;
		int max=st.findMax();
		@SuppressWarnings("unused")
		int maxDigits=st.maxDigits(max);
		st.countingSort();
		
		int outArray[]=st.array;
		
		int expArray[]={1,2,3,3,4,4,5,7,7};
		
		Assert.assertArrayEquals(expArray,outArray);
		
		
	}
	
	
	
	
	@Test
	public void test4() {
		
		int inpArray[]={15,3,47,1,47,315,2,7,4};
		st.array=inpArray;
		int max=st.findMax();
		int maxDigits=st.maxDigits(max);
		st.radixSort(maxDigits);
		
		int outArray[]=st.array;
		
		int expArray[]={1,2,3,4,7,15,47,47,315};
		
		Assert.assertArrayEquals(expArray,outArray);
		
		
	}

}
