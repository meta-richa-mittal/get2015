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
	int rear=-1;
	Jobs job=new Jobs();
	
	
	
	
	/**
	 * This function sets priorities of jobs
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
				rear++;
				queue[rear]=value;
				maxHeapify(rear);
			}
			catch(ArrayStoreException ase) {
				System.out.println(ase);
			}
			//rear++;
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
		for(int i=0;i<=rear;i++) {
			System.out.println(queue[i]+"\n");
		}
	}
	
	
	
	
	
	/**
	 *  Remove and process the first job in the queue
	 * @return
	 */
	public String dequeue( ) {
		String item;
		if(rear==-1) {
			System.out.println("There is no task to be processed. Please add task first.");
			return "";
		}
		else {
			
			item=queue[front];
			queue[front]=queue[rear];
			/*for(int i=0;i<rear-1;i++) {
				queue[i]=queue[i+1];
			}*/
			queue[rear]=null;
			rear=rear-1;
			shiftDown();
		}
		
		return item;
	}
	
	
	
	/**
	 * function to Return first job in the queue
	 */
	public String getFront( ) {
		String item;
		if(rear==-1) {
			System.out.println("There is no task in the queue.");
			return "";
		}
		else {
			item=queue[front];
		}
		
		return item;
	}
	
	
	
	
	
	/**
	 * This function will rearrange max heap after removing root
	 */
	public void shiftDown() {
		int k=0;
		int l=2*k+1;
		
		
		while(l<queue.length) {
			int leftPriority=0,parentPriority=0,rightPriority=0;
			int maxPriority=leftPriority;
			int max=l;
			int r=l+1;
			for(int i=0;i<job.jobs.length;i++){
				//System.out.println("******"+job.jobs[i]+"********");
				if(queue[l]!=null) {
					if(queue[l].compareToIgnoreCase(job.jobs[i])==0) {
						leftPriority=job.priority[i];	
					}
					
				}
				if(queue[r]!=null) {
					if(queue[r].compareToIgnoreCase(job.jobs[i])==0) {
						rightPriority=job.priority[i];	
					}
					
				}
				if(queue[k]!=null) {
					if(queue[k].compareToIgnoreCase(job.jobs[i])==0) {
						parentPriority=job.priority[i];	
					}
				}
				//System.out.println("******"+leftPriority+"*********"+rightPriority+"*******"+parentPriority);
				maxPriority=leftPriority;
			}
			if(r<queue.length) {
				if(rightPriority>leftPriority) {
					max++;
					maxPriority=rightPriority;
				}
			}
			if(parentPriority<maxPriority) {
				String temp=queue[k];
				queue[k]=queue[max];
				queue[max]=temp;
				k=max;
				l=2*k+1;
			}
			else {
				break;
			}
		}
	}
	
}
