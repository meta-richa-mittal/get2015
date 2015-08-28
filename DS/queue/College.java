package queue;


/**
 * 
 * @author Richa
 * Description: this class defines the list of colleges and their seats acc to their rank
 */
public class College {
	
	public String[] collegeName={"JECRC","SKIT","PCE","VIT","YIT"};
	public int[] noOfSeats={2,3,1,2,2};
	String allotment[][]=new String[collegeName.length][];
	//static List<String> collegeList=new ArrayList<College>();
	//Scanner sc=new Scanner(System.in);
	//static College college=new College();
	public College() {
		
		for(int i=0;i<this.collegeName.length;i++) {
			allotment[i]=new String[this.noOfSeats[i]];
		}
		allotment[0]=new String[2];
		allotment[1]=new String[3];
		allotment[2]=new String[1];
		allotment[3]=new String[2];
		allotment[4]=new String[2];
	}
	
	
	/**
	 * display college list
	 */
	public void displayColleges() {
		System.out.println("List of colleges:");
		
		System.out.println("COLLEGE NAME\tNO. OF SEATS");
		for(int i=0;i<collegeName.length;i++) {
			System.out.println(collegeName[i]+"\t\t\t"+noOfSeats[i]);
		}
	}

}
