package tree;

/**
 * 
 * @author Richa Mittal
 * Description: This class defines functions to create binary tree, 
 * 				pre order, post order and in order traversal, to find 
 * 				whether two trees are mirror images of each other
 */
public class BinaryTree {
	
	Node root;
	int i=0,j=0;
	int preOrder[]=new int [20];
	int sizePre=0,sizePost=0;
	int postOrder[]=new int[20];

	
	/**
	 * inserts a new node to the tree
	 */
	void insertNode(int data) {
		Node newNode = new Node(data, null, null);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node currentNode = root;
			Node parent;
			while (true) {
				parent = currentNode;
				if (data < currentNode.getData()) {
					currentNode = currentNode.getLeftNode();
					if (currentNode == null) {
						parent.setLeftNode(newNode);
						return;
					}
				}
				else {
					currentNode = currentNode.getRightNode();
					if (currentNode == null) {
						parent.setRightNode(newNode);
						return;
					}
				}
			}
		}
	}
	
	
	/**
	 * inserts node to the tree for finding mirror image
	 */
	void insertImageNode(int data) {
		Node newNode = new Node(data, null, null);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node currentNode = root;
			Node parent;
			while (true) {
				parent = currentNode;
				if (data < currentNode.getData()) {
					currentNode = currentNode.getRightNode();
					if (currentNode == null) {
						parent.setRightNode(newNode);
						return;
					}
				}
				else {
					currentNode = currentNode.getLeftNode();
					if (currentNode == null) {
						parent.setLeftNode(newNode);
						return;
					}
				}
			}
		}
	}
	
	
	
	
	/*void addNode(int data) {
		Node newNode = new Node(data, null, null);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node currentNode = root;
			Node parent,parentLeft,parentRight;
			
			while (true) {
				parentLeft = currentNode;
				parentRight = currentNode;
					if (parentLeft.getLeftNode() == null) {
						parentLeft.setLeftNode(newNode);
						return;
					}
				else if (parentLeft.getRightNode() == null) {
					parentLeft.setRightNode(newNode);
						return;
					}
				else if (parentRight.getLeftNode() == null) {
					parentLeft.setLeftNode(newNode);
						return;
					}
				else if (parentRight.getRightNode() == null) {
					parentLeft.setRightNode(newNode);
						return;
					}
					currentNode=currentNode.getLeftNode();
				}
			}
	}*/
	
	

	/**
	 * in order traversal of a tree
	 */
	public void inorderTraverse(Node inorder) {
		if (inorder != null) {
			inorderTraverse(inorder.getLeftNode());
			//inorderList.add(inorder.getData());
			
			System.out.print(inorder.getData() + "\t");
			inorderTraverse(inorder.getRightNode());
		}
	}

	
	
	/**
	 * pre order traversal of a tree
	 */
	public void preorderTraverse(Node preorder) {
		if (preorder != null) {
			System.out.print(preorder.getData() + "\t");
			preOrder[i++]=preorder.getData();
			sizePre++;
			preorderTraverse(preorder.getLeftNode());
			preorderTraverse(preorder.getRightNode());
		}
	}

	
	
	/**
	 * post order traversal of a tree
	 */
	public void postorderTraverse(Node postorder) {
		if (postorder != null) {
			postorderTraverse(postorder.getLeftNode());
			postorderTraverse(postorder.getRightNode());
			System.out.print(postorder.getData() + "\t");
			postOrder[j++]=postorder.getData();
			sizePost++;
		}
	}
	
	
	
	/**
	 * function to find whether two trees are mirror images of each other or not
	 * @return: true or false
	 */
	public boolean isMirrorImage(BinaryTree binaryTree, BinaryTree bTree) {
		boolean isMirror=false;
		if ( binaryTree == null && bTree == null) {
	        isMirror= true;
	        return isMirror;
	    }
	    if (binaryTree == null || bTree == null) {
	       isMirror= false;
	       return isMirror;
	    }
		binaryTree.preorderTraverse(binaryTree.root);
		System.out.println();
		bTree.postorderTraverse(bTree.root);
		
		int flag=0;
		int j=bTree.sizePost-1;
		if(binaryTree.sizePre!=bTree.sizePost) {
			isMirror=false;
			return isMirror;
		}
		for (int i = 0; i <binaryTree.sizePre; i++) {
			if(binaryTree.preOrder[i]==bTree.postOrder[j])
			{
				flag=0;
				j--;
			}
			else
			{
				flag=1;
				break;
			}
		}
		if(flag==0) {
			isMirror= true;
			return isMirror;
		}
		else {
			isMirror= false;
			return isMirror;
		}
		
	}
}
