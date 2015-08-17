package Person;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {

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
		Student st=new Student(111,"Richa",123);
		String out=st.toString();
		String exp="Name:Richa, Uid:111, Student Id:123";
		assertEquals(exp,out);
	}
	@Test
	public void test2() {
		Teacher st=new Teacher(111,"Richa",123);
		String out=st.toString();
		String exp="Name:Richa, Uid:111, Teacher Id:123";
		assertEquals(exp,out);
	}

}
