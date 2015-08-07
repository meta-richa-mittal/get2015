package assignment2;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
//This test suite is to run tests of both Pattern1Test and Pattern2Test
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	Pattern1Test.class,Pattern2Test.class
})
public class TestSuite {

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
	public void test() {
		
	}
	

}
