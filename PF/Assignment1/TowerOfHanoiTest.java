package assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TowerOfHanoiTest {

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
		TowerOfHanoi ob=new TowerOfHanoi();
		List<String> res=new ArrayList<String>();
		res=ob.towerOfHanoi("A","C","B", 1);
		String [] out = res.toArray(new String[res.size()]);
		String [] exp={"Move disk 1 from A -> C"};
		assertArrayEquals(exp,out);
		
	}
	
	@Test
	public void tes2() {
		TowerOfHanoi ob=new TowerOfHanoi();
		List<String> res=new ArrayList<String>();
		res=ob.towerOfHanoi("A","C","B", 2);
		String [] out = res.toArray(new String[res.size()]);
		String [] exp={"Move disk 1 from A -> B","Move disk 2 from A -> C","Move disk 1 from B -> C"};
		assertArrayEquals(exp,out);
		
	}
	
	@Test
	public void test3() {
		TowerOfHanoi ob=new TowerOfHanoi();
		List<String> res=new ArrayList<String>();
		res=ob.towerOfHanoi("A","C","B", 3);
		String [] out = res.toArray(new String[res.size()]);
		String [] exp={"Move disk 1 from A -> C","Move disk 2 from A -> B","Move disk 1 from C -> B","Move disk 3 from A -> C","Move disk 1 from B -> A","Move disk 2 from B -> C","Move disk 1 from A -> C"};
		assertArrayEquals(exp,out);
		
	}

}
