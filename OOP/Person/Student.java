package Person;


/**
 * 
 * @author Richa Mittal
 * Description: class contains 2 instance variables and 5 functions
 * 				with one constructor and extends class Person
 *
 */
public class Student extends Person {
	private int studentId;
	private String[] courses;
	
	/**
	 * Constructor
	 * @param uid: uid of student
	 * @param name: name of student
	 * @param studentId: student id
	 */
	public Student(int uid,String name,int studentId)
	{
		super(uid,name);
		this.studentId=studentId;
	}
	
	/**
	 * get student id
	 * @return student id
	 */
	public int getStudentId()
	{
		return studentId;
	}
	
	/**
	 * sets student id
	 * @param studentId: id of student
	 */
	public void setStudentId(int studentId)
	{
		this.studentId=studentId;
	}
	
	/**
	 * get courses in which student is enrolled
	 * @return array of string containing all courses
	 */
	public String[] getCourses()
	{
		return courses;
	}
	
	/**
	 * set courses in which student is enrolled
	 * @param courses: array of all courses
	 */
	public void setCourses(String[] courses)
	{
		this.courses=courses;
	}
	
	/**
	 * returns string for info
	 */
	public String toString()
	{
		return super.toString() +", Student Id:"+studentId;
	}

}
