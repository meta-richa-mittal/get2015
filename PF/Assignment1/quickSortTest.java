package assignment3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class quickSortTest {

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
		QuickSort ob=new QuickSort();
		int exp[]={2,5,8,9,10,11,55,77};
		int inp[]={2,5,8,9,10,77,55,11};
		int size=inp.length;
		assertArrayEquals(exp,ob.quickSort(inp,0,size-1));
	}
	
	@Test
	public void test2() {
		QuickSort ob=new QuickSort();
		int exp[]={};
		int inp[]={};
		int size=inp.length;
		assertArrayEquals(exp,ob.quickSort(inp,0,size-1));
	}


}
