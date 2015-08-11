package assignment3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Assignment1Test {

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
	public void test1GCD() 
	{
			Assignment1 ob=new Assignment1();
			assertEquals(1,ob.gcd(2, 1));
	}
		
	@Test
	public void test2GCD() 
	{
		Assignment1 ob=new Assignment1();
			assertEquals(6,ob.gcd(12, 18));
	}
			
	@Test
	public void test3GCD() 
	{
		Assignment1 ob=new Assignment1();
			assertEquals(1,ob.gcd(100, 3));
	}
	
	@Test
	public void test1Rem() {
		Assignment1 ob=new Assignment1();
		assertEquals(0,ob.rem(2, 1));
	}
	
	@Test
	public void test2Rem() {
		Assignment1 ob=new Assignment1();
		assertEquals(-1,ob.rem(2, 0));
	}
	
	@Test
	public void test3Rem() {
		Assignment1 ob=new Assignment1();
		assertEquals(1,ob.rem(100, 3));
	}
	
	
	
	@Test
	public void test2Largest() {
		Assignment1 ob2=new Assignment1();
		assertEquals(9,ob2.largestDigit(1257369));
	}
	
	@Test
	public void test3Largest() {
		Assignment1 ob3=new Assignment1();
		assertEquals(4,ob3.largestDigit(444));
	}
	
	@Test
	public void test1Largest() {
		Assignment1 ob1=new Assignment1();
		assertEquals(2,ob1.largestDigit(2));
	}

}
