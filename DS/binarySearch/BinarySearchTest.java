package binarySearch;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

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
		int array[]={1,1,3,4,4,7};
		int exp=0;
		int out=BinarySearch.binarySearch(array, 0, 5, 1);
		assertEquals(exp, out);
	}
	
	@Test
	public void test2() {
		int array[]={1,1,3,4,4,7};
		int exp=3;
		int out=BinarySearch.binarySearch(array, 0, 5, 4);
		assertEquals(exp, out);
	}
	
	@Test
	public void test3() {
		int array[]={1,1,3,4,4,7};
		int exp=-1;
		int out=BinarySearch.binarySearch(array, 0, 5, 9);
		assertEquals(exp, out);
	}
	
	@Test
	public void test4() {
		int array[]={1,1,3,4,4,7};
		int exp=2;
		int out=BinarySearch.binarySearch(array, 0, 5, 3);
		assertEquals(exp, out);
	}

	
	@Test
	public void test5() {
		int array[]={1,1,3,4,4,7};
		int exp=5;
		int out=BinarySearch.binarySearch(array, 0, 5, 7);
		assertEquals(exp, out);
	}
}
