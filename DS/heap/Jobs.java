package heap;


/**
 * 
 * @author Richa Mittal
 *  Description: This class defines jobs names and their priorities
 *
 */
public class Jobs {
	
	String jobs[]=new String[4];
	int priority[]=new int[4];
	
	
	public String[] getJobs() {
		return jobs;
	}
	
	
	public void setJobs() {
		jobs[0]="undergraduate";
		
		jobs[1]="graduate";
		
		jobs[2]="professor";
		
		jobs[3]="chair";
		
	}
	
	
	public int[] getPriority() {
		return priority;
	}
	
	
	public void setPriority() {
		priority[0]=1;
		
		priority[1]=2;
		
		priority[2]=3;
		
		priority[3]=4;
	}
	
	

}
