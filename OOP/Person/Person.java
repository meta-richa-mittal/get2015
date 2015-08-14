package Person;

/**
 * 
 * @author Richa Mittal
 * Description: class containing 2 instance variables and 5 functions with one constructor
 *
 */
public class Person {
	private int uid;
	private String name;
	
	/**
	 * constructor
	 * @param uid: id of person
	 * @param name name of person
	 */
	public Person(int uid,String name)
	{
		this.uid=uid;
		this.name=name;
	}
	
	/**
	 * gets uid of person 
	 * @return uid of oerson
	 */
	public int getUid()
	{
		return uid;
	}
	
	/**
	 * sets sets uid of person
	 * @param uid: uid of person
	 */
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	

	/**
	 * gets name of person 
	 * @return name of oerson
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * sets sets name of person
	 * @param name: name of person
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	
	/**
	 * returns string for info
	 */
	public String toString()
	{
		return "Name:"+name+", Uid:"+uid;
	}

}
