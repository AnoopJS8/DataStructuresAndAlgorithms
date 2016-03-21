package trees;

/* Construct Tree from given Inorder and Preorder traversals */
/*
 * Algorithm: buildTree() 1) Pick an element from Preorder. Increment a
 * Preorder Index Variable (preIndex in below code) to pick next element in
 * next recursive call. 2) Create a new tree node tNode with the data as
 * picked element. 3) Find the picked element’s index in Inorder. Let the
 * index be inIndex. 4) Call buildTree for elements before inIndex and make
 * the built tree as left subtree of tNode. 5) Call buildTree for elements
 * after inIndex and make the built tree as right subtree of tNode. 6)
 * return tNode.
 * 
 * Reference:http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 */
/*
 *  Inorder sequence: D B E A F C
	Preorder sequence: A B D E C F
 * */

public class ConstructBinaryTree {

	static Node root;
	static int preIndex = 0;

	public Node buildBinaryTree(char[] inorder, char[] preorder, int inStart, int inEnd) {
		
		if(inStart>inEnd){
			return null;
		}
		
		Node tNode=new Node(preorder[preIndex++]);
		if(inStart==inEnd){//If it doesnot have any children return the node
			return tNode;
		}
		//Else find the index in the inorder array
		int inIndex=search(inorder,inStart,inEnd,tNode.key);
		
		//Using the index in Iorder traversal construct the left and right subtrees
		tNode.left=buildBinaryTree(inorder, preorder, inStart, inIndex-1);
		tNode.right=buildBinaryTree(inorder, preorder, inIndex+1, inEnd);
		return tNode;
	}
	
	public int search(char[] arr,int start,int end,int value){
		int i;
		for(i=start;i<end;i++){
			if(arr[i]==value){
				return i;
			}
		}
		return i;
	}
	public void printInorder(Node node){//Test function
		if(node==null){
			return;
		}
		printInorder(node.left);
		System.out.print((char)(node.key)+" ");
		printInorder(node.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTree bt=new ConstructBinaryTree();
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node mynode = bt.buildBinaryTree(in, pre, 0, len - 1);
 
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        bt.printInorder(mynode);
	}

}
