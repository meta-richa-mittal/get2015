package binarySearch;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains function to implement binary search on sorted array
 *
 */
public class BinarySearch {
	
	
	/**
	 * function for binary search
	 * @param array: array containing elements
	 * @param lb: lower bound of array to be searched
	 * @param ub: upper bound of array to be searched
	 * @param element: element to be searched in the array
	 * @return position of element if present else -1
	 */
	public static int binarySearch(int array[],int lb,int ub,int element) {
		int position=-1;
		
		int mid=(lb+ub)/2;
		while(!(lb>ub)) {
			if(array[mid]==element) {
				if(mid!=0) {
					if(array[mid-1]!=array[mid]) {
						if(mid!=(array.length)-1) {
							if(array[mid+1]!=array[mid]) {
								return mid;
							}
							else if(array[mid+1]==array[mid]) {
								return mid;
							}
						}
					}
					else if(array[mid-1]==array[mid] ) {
						while(array[mid-1]==array[mid]) {
							mid--;
							if(mid==0) {
								break;
							}
						}
						return mid;
					}
				}
				return mid;
				
			}
			else if(array[mid]<element) {
				return binarySearch(array, mid+1, ub, element);
			}
			else if(array[mid]>element) {
				return binarySearch(array,lb, mid-1, element);
			}
		}
		
		return position;
	}

}
