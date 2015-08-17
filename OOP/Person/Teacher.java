package Person;


/**
 * 
 * @author Richa Mittal
 * Description: class contains 2 instance variables and 5 functions
 * 				with one constructor and extends class Person
 *
 */
public class Teacher extends Person{
	private int teacherId;
	private String[] subjects;
	
	/**
	 * Constructor
	 * @param uid: uid of teacher
	 * @param name: name of teacher
	 * @param teacherId: teacher id
	 */
	public Teacher(int uid,String name,int teacherId)
	{
		super(uid,name);
		this.teacherId=teacherId;
	}
	
	/**
	 * get teacher id
	 * @return teacher id
	 */
	public int getTeacherId()
	{
		return teacherId;
	}
	
	/**
	 * sets teacher id
	 * @param teacherId: id of teacher
	 */
	public void setTeacherId(int teacherId)
	{
		this.teacherId=teacherId;
	}
	
	/**
	 * get subjects that a teacher teaches
	 * @return array of string containing all subjects
	 */
	public String[] getSubjects()
	{
		return subjects;
	}
	
	/**
	 * set subjects that a teacher teaches
	 * @param courses: array of all subjects
	 */
	public void setSubjects(String[] subjects)
	{
		this.subjects=subjects;
	}
	
	/**
	 * returns string for info
	 */
	public String toString()
	{
		return super.toString() +", Teacher Id:"+teacherId;
	}

}
