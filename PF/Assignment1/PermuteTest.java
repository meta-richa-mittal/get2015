package assignment4;

import static org.junit.Assert.*;


import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PermuteTest {

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
		
		Set<String> res=new HashSet<String>();
		res=Permute.permutation("111b");
		String [] out = res.toArray(new String[res.size()]);
		String [] exp={"b111","1b11","111b","11b1"};
		assertArrayEquals(exp,out);
	}
	
	@Test
	public void test2() {
		
		Set<String> res=new HashSet<String>();
		res=Permute.permutation("abc");
		String [] out = res.toArray(new String[res.size()]);
		String [] exp={"bca", "acb", "abc", "cba", "bac", "cab"};
		assertArrayEquals(exp,out);
	}

}
