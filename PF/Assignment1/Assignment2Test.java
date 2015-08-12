package assignment3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Assignment2Test {

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
		Assignment2 ob=new Assignment2();
		int inp[]={2,5,8,9,10,77,55};
		assertEquals(-1,ob.linearSearch(inp, 88, 7));
	}
	
	@Test
	public void test2() {
		Assignment2 ob=new Assignment2();
		int inp[]={2,5,8,9,10,77,55,11};
		assertEquals(5,ob.linearSearch(inp, 77, 8));
	}
	
	@Test
	public void test3() {
		Assignment2 ob=new Assignment2();
		int inp[]={2,5,8,9,10,55,77};
		assertEquals(-1,ob.linearSearch(inp, 88, 7));
	}
	
	@Test
	public void test4() {
		Assignment2 ob=new Assignment2();
		int inp[]={2,5,8,9,10,55,77};
		assertEquals(6,ob.linearSearch(inp, 77, 7));
	}

}
