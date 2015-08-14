import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class MatrixClassTest {
	MatrixClass matrix=new MatrixClass(3,3);

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
		int flag;
		matrix.addElements(1, 2, 5);
		if(matrix.data[1][2]==5)
		{
			flag=1;
		}
		else
		{
			flag=0;
		}
		assertEquals(1,flag);
		
	}
	
	@Test
	public void test2() {
		MatrixClass matrix1=new MatrixClass(3,3);
		
		int out[][]={{1,2,3},{4,5,6},{7,8,9}};
		matrix.data=out;
		matrix1=matrix.transpose();
		int exp[][]={{1,4,7},{2,5,8},{3,6,9}};
		MatrixClassTest test1=new MatrixClassTest();
		assertEquals(1,test1.isEqual(exp, matrix1.data));
	}
	
	public int isEqual(int exp[][], int out[][])
	{
		int flag=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(exp[i][j]!=out[i][j])
				{
					flag=0;
					break;
				}
			}
		}
		return flag;
	}

}
