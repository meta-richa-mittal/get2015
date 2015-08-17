package Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Richa Mittal
 * Description: class containing main function
 *
 */
public class Main {
	
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		
		int uid=0;
		String name="";
		int studentId=0;
		int teacherId=0;
		String[] courses,subjects;
		int flag=1,flag1=1;
		int no=1,no1=1;
		int op;
		Scanner sc=new Scanner(System.in);
		List<Student> ls=new ArrayList<Student>();
		List<Teacher> ls1=new ArrayList<Teacher>();
		try
		{
			do
			{
				System.out.print("Enter 1 for Student.\nEnter 2 for Teacher.\nEnter 3 to exit.\n");
				op=sc.nextInt();
				switch(op)
				{
					case 1:							// for student info
						while(flag==1)
						{
							System.out.println("Enter details of student "+no+" :");
							System.out.print("Enter Uid:");
							uid=sc.nextInt();
							System.out.print("Enter Name:");
							name=sc.next();
							System.out.print("Enter Student Id:");
							studentId=sc.nextInt();
							System.out.print("Enter total no of courses:");
							int n=sc.nextInt();
							System.out.print("Enter name of courses:");
							courses=new String[n];
							for(int i=0;i<n;i++)
							{
								courses[i]=sc.next();
							}
							Student st=new Student(uid,name,studentId);
							st.setUid(uid);
							st.setName(name);
							st.setStudentId(studentId);
							st.setCourses(courses);
							st.toString();
							ls.add(st);
							System.out.print("Enter 1 to continue and 0 to exit.\n");
							flag=sc.nextInt();
							no++;
							
						}
						Iterator<Student> itr=ls.iterator();
						while(itr.hasNext())
						{
							Student s=itr.next();
							//System.out.println("Uid is:"+s.getUid());
							//System.out.println("Name is:"+s.getName());
							//System.out.println("Student Id is:"+s.getStudentId());
							System.out.println(s.toString());
							String output[]=s.getCourses();
							System.out.print("Courses are:");
							for(int i=0;i<output.length;i++)
							{
								System.out.print(output[i]+"\t");
							}
							System.out.print("\n");
						}
						break;
					case 2:							// for teacher info
						while(flag1==1)
						{
							System.out.println("Enter details of teacher "+no1+" :");
							System.out.print("Enter Uid:");
							uid=sc.nextInt();
							System.out.print("Enter Name:");
							name=sc.next();
							System.out.print("Enter Teacher Id:");
							teacherId=sc.nextInt();
							System.out.print("Enter total no of subjects:");
							int n=sc.nextInt();
							System.out.print("Enter name of subjects:");
							subjects=new String[n];
							for(int i=0;i<n;i++)
							{
								subjects[i]=sc.next();
							}
							Teacher st=new Teacher(uid,name,teacherId);
							st.setUid(uid);
							st.setName(name);
							st.setTeacherId(teacherId);
							st.setSubjects(subjects);
							st.toString();
							ls1.add(st);
							System.out.print("Enter 1 to continue and 0 to exit.");
							flag1=sc.nextInt();
							no1++;
							
						}
						Iterator<Teacher> itr1=ls1.iterator();
						while(itr1.hasNext())
						{
							Teacher s=itr1.next();
							//System.out.println("Uid is:"+s.getUid());
							//System.out.println("Name is:"+s.getName());
							//System.out.println("Student Id is:"+s.getStudentId());
							System.out.println(s.toString());
							String output[]=s.getSubjects();
							System.out.print("Subjects are:");
							for(int i=0;i<output.length;i++)
							{
								System.out.print(output[i]+"\t");
							}
							System.out.print("\n");
						}
						break;
					case 3:
						sc.close();
						break;
					default:
						break;
				}
			}while(op!=3);
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("Enter correct type of value.");
		}
		
		sc.close();
	}
}
