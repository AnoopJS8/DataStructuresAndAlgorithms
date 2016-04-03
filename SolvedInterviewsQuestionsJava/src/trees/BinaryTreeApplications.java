package trees;
class Node{
	int key;
	Node left;
	Node right;
	
	public Node(int _key)
	{
		this.key=_key;
		this.left=null;
		this.right=null;
	}
}

//Binary Tree Class for instantiation of Binary Tree Objects.
class BinaryTree{
	//
	Node root;
	
	//Constructors
	public BinaryTree(int _key)
	{
		root=new Node(_key);
	}
	public BinaryTree()
	{
		root=null;
	}
	
	/*public static void main(String[] args) {
		
		BinaryTree binaryTree=new BinaryTree();
		
	}*/
	
	
}

public class BinaryTreeApplications {
	
	//Cannot keep in this class	
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree=new BinaryTree();
		binaryTree.root=new Node(10);
		//System.out.println(binaryTree.root.key);
		binaryTree.root.left=new Node(5);
		binaryTree.root.right=new Node(8);
		binaryTree.root.right.right=new Node(4);
		binaryTree.root.right.left=new Node(6);
		binaryTree.root.left.left=new Node(9);
		//binaryTree.root.left.right=new Node(3);
		//binaryTree.root.left.right.left=new Node(4);
		//binaryTree.root.left.right.right=new Node(2);
		//*/
		//BreadthFirstSearchTraversal bfs=new BreadthFirstSearchTraversal();
		//bfs.LevelOrderTraversal(binaryTree.root);
		//System.out.println();
		//bfs.LevelOrderPrintTraversal(binaryTree.root);
		
		//InorderSuccessor ios=new InorderSuccessor();
		//System.out.println(ios.inorderSuccessor(binaryTree.root, 10));//This wont work as the given tree is not bst
		
		///UtilityFunctions uf=new UtilityFunctions();
		//System.out.println(uf.minimumHeight(binaryTree.root));
		///System.out.println(uf.maxPathSum(binaryTree.root));
		TreeTraversals tv=new TreeTraversals();
		tv.inOrder(binaryTree.root);
		System.out.println();
		tv.inOrderIterative(binaryTree.root);
		System.out.println();
		tv.preOrder(binaryTree.root);
		System.out.println();
		tv.preOrderIterative(binaryTree.root);
	}
	
	
}


/*
 * 			 10
 * 		   /    \
 * 		  5      8
 * 		 / \    /  \
 * 		9   3  6    4
 * 		   / \
 *		  4   2
 */