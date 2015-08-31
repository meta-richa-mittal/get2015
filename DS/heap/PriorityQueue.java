package heap;


/**
 * 
 * @author Richa Mittal
 *  Description: This class defines functions to implement jobs processing using priority queue
 *
 */
public class PriorityQueue {

	String[] queue=new String[20];
	int front =0;
	int rear=0;
	Jobs job=new Jobs();
	
	
	/**
	 * function to set priorities of jobs
	 */
	public void setJobsPriority() {
		job.setJobs();
		job.setPriority();
	}
	
	
	/**
	 * function to add new job to the queue
	 */
	public void enqueue(String value ) {
		if(rear==20) {
			System.out.println("Queue is full");
			return;
		}
		else {
			try {
				queue[rear]=value;
				maxHeapify(rear);
			}
			catch(ArrayStoreException ase) {
				System.out.println(ase);
			}
			rear++;
		}
	}
	
	
	
	/**
	 * function to create max heap
	 */
	public void maxHeapify(int index ) {
		int parentIndex=index;
		int currPriority=0, parentPriority=0;
		
		while(parentIndex!=0) {
			parentIndex=((int)Math.ceil((double)index/2))-1;
			for(int i=0;i<job.jobs.length;i++){
				//System.out.println("******"+job.jobs[i]+"********");
				if(queue[index].compareToIgnoreCase(job.jobs[i])==0) {
					currPriority=job.priority[i];	
					
				}
				if(queue[parentIndex].compareToIgnoreCase(job.jobs[i])==0) {
					parentPriority=job.priority[i];	
				}
				//System.out.println("******"+currPriority+"*******"+parentPriority);
				
			}
			if(currPriority>parentPriority) {
				String temp=queue[parentIndex];
				queue[parentIndex]=queue[index];
				queue[index]=temp;
			}
			else {
				return;
			}
			index=parentIndex;
			
		}
	}
	

	/**
	 * will display all jobs in the queue
	 */
	public void displayQueue() {
		System.out.println("Queue is:");
		for(int i=0;i<rear;i++) {
			System.out.println(queue[i]+"\n");
		}
	}
	
	
	
	
	
	/**
	 *  Remove and process the first job in the queue
	 * @return
	 */
	public String dequeue( ) {
		String item;
		if(rear==0) {
			System.out.println("There is no task to be processed. Please add task first.");
			return "";
		}
		else {
			item=queue[front];
			for(int i=0;i<rear-1;i++) {
				queue[i]=queue[i+1];
			}
			rear--;
		}
		
		return item;
	}
	
	
	
	/**
	 * function to Return first job in the queue
	 */
	public String getFront( ) {
		String item;
		if(rear==0) {
			System.out.println("There is no task in the queue.");
			return "";
		}
		else {
			item=queue[front];
		}
		
		return item;
	}
	
}
