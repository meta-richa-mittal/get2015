package tree;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class defines the main function
 */
public class Main {
	private static Scanner scanner;

	
	
	/**
	 * main function
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		BinaryTree bTree=new BinaryTree();
		int ch;
		try {
			do {
				System.out
						.println("1. Create Tree\n2. Inorder Traverse\n3. Preorder Traverse\n4. Postorder Traverse\n5. check if Mirror image\n6. Exit\n");
				System.out.println("Enter your choice: ");
				scanner = new Scanner(System.in);
				int choice = 0;

				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the node value: ");
					int value = scanner.nextInt();
					binaryTree.insertNode(value);
					break;
				case 2:
					binaryTree.inorderTraverse(binaryTree.root);
					System.out.println();
					
					break;
				case 3:
					binaryTree.preorderTraverse(binaryTree.root);
					break;
				case 4:
					binaryTree.postorderTraverse(binaryTree.root);
					break;
				case 5:
					System.out.println("Enter no of nodes in binary tree:");
					int noOfNodes=scanner.nextInt();
					for(int i=0;i<noOfNodes;i++) {
						System.out.println("Enter node value:");
						int nodeValue=scanner.nextInt();
						bTree.insertImageNode(nodeValue);
					}
					boolean isMirror=binaryTree.isMirrorImage(binaryTree,bTree);
					System.out.println("Two binary trees are mirror images of each other: "+isMirror);
				case 6:
					System.exit(0);
				default:
					System.out.println("Enter the correct option");
				}
				System.out.println("\nDo you want to continue(1/0) ");
				ch = scanner.nextInt();
			} while (ch == 1);
		} 
		catch (InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
	}

}
