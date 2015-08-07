package assignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Pattern1Test {

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
	public void test2() {
		Pattern1 ob=new Pattern1();
		String out=ob.numbers(3,5);
		String exp="12321";
		assertEquals(exp,out);
	}
	@Test
	public void test1() {
		Pattern1 ob=new Pattern1();
		String out=ob.space(3,5);
		String exp="  ";
		assertEquals(exp,out);
	}
	@Test
	public void test3() {
		Pattern1 ob=new Pattern1();
		String out=ob.printWholePyramid(2);
		String exp=" 1\n121\n 1\n";
		assertEquals(exp,out);
	}

}
