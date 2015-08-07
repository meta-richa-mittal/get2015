package assignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Pattern2Test {

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
		Pattern2 ob=new Pattern2();
		String out=ob.numbers(3,5);
		String exp="123";
		assertEquals(exp,out);
	}
	@Test
	public void test1() {
		Pattern2 ob=new Pattern2();
		String out=ob.space(3,5);
		String exp="  ";
		assertEquals(exp,out);
	}
	@Test
	public void test3() {
		Pattern2 ob=new Pattern2();
		String out=ob.printWholePyramid(5);
		String exp="12345\n 1234\n  123\n   12\n    1\n";
		assertEquals(exp,out);
	}

}
