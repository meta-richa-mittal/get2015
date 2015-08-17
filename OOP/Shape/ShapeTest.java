package Shape;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShapeTest {

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
		Circle cr=new Circle(5);
		double out=cr.getArea();
		assertEquals(78.5,out,0.001);
	}
	
	@Test
	public void test2() {
		Square sq=new Square(5);
		double out=sq.getArea();
		assertEquals(25.00,out,0.001);
	}

}
