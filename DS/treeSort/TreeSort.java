package treeSort;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author Richa Mittal
 * Description: This class defines functions to create binary search tree, 
 * 				and its in order traversal. BST is created to impement Tree Sort
 */
public class TreeSort {
	
	Student student;
	List<Integer> sortedList=new ArrayList<Integer>();
	int i=0;
	
	
	
	/**
	 * This function inserts a new student into the tree according to the
	 * condition of BST and thereby implements Tree Sort
	 * @param value
	 */
	public void insertToBST(int value) {
			
		Student newStudent = new Student(value, null, null);
		if (student == null) {
			student = newStudent;
		} 
		else {
			Student currentStudent = student;
			Student parent;
			while (true) {
				parent = currentStudent;
				if (value < currentStudent.getData()) {
					currentStudent = currentStudent.getLeftNode();
					if (currentStudent == null) {
						parent.setLeftNode(newStudent);
						return;
					}
				}
				else {
					currentStudent = currentStudent.getRightNode();
					if (currentStudent == null) {
						parent.setRightNode(newStudent);
						return;
					}
				}
			}
		}
			
	}



	

	/**
	 * This function will traverse the BST in inorder way
	 */
	public void display(Student inorder) {
		if (inorder != null) {
			display(inorder.getLeftNode());
			//inorderList.add(inorder.getData());
			
			System.out.print(inorder.getData() + "\t");
			sortedList.add(inorder.getData());
			display(inorder.getRightNode());
		}
	
	
}
	
	
	
	

}
