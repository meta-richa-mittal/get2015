package treeSort;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TreeSortTest {

	TreeSort tree=new TreeSort();
	
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
		int inpArray[]={5,3,7,1,4,3,2,7,4};
		
		for(int i=0;i<inpArray.length;i++) {
			tree.insertToBST(inpArray[i]);
		}
		tree.display(tree.student);
		
		
		Integer expArray[]={1,2,3,3,4,4,5,7,7,};
		
		for(int i=0;i<inpArray.length;i++)  {
			if(tree.sortedList.get(i)!=expArray[i]) {
				fail("Method fails");
				break;
			}
		}
		
	}

}
