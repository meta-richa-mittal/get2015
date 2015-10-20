package assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NQueensProbTest {

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
		NQueensProb ob=new NQueensProb();
		boolean exp=true;
		int board[][]=new int[4][4];
		boolean out=ob.nQueen(0, board, 4);
		assertEquals(exp,out);
		
	}

}
