package trees;
 
public class UtilityFunctions {

	public int size(Node root) {
		if (root == null) {
			return 0;
		}
		int leftSize = size(root.left);
		int rightSize = size(root.right);
		return leftSize + rightSize + 1;
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int leftheight = height(root.left);
		int rightheight = height(root.right);
		return Math.max(leftheight, rightheight) + 1;
	}

	public Node addNodeBST(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		// Node
		if (root.key >= data) {
			root.left = addNodeBST(root.left, data);
		}
		/*
		 * double x=Math.PI; Double s; Long l;
		 * 
		 */
		// StringBuilder sb=new StringBuilder();
		return null;
	}

	public Node addNodeBSTRecursive(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}

		if (root.key >= data) {
			root.left = addNodeBST(root.left, data);
		} else {
			root.right = addNodeBST(root.right, data);
		}
		return root;
	}

	// recursive Method
	public Node findMin(Node root) {
		if (root == null)
			return null;
		else if (root.left == null)
			return root;
		return findMin(root.left);

	}

	// Iterative Method
	public Node findMinIter(Node root) {
		if (root == null) {
			System.out.println("Tree Empty");
			return root;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public Node findMax(Node root){
		if(root==null) return root;
		else if(root.right==null)
			return root;
		return findMax(root.right);
	}
	public Node deleteNode(Node root, int data) {
		if (root == null)
			return root;
		else if (root.key < data) {
			root.left = deleteNode(root.left, data);
		} else if (root.key > data) {
			root.right = deleteNode(root.right, data);
		} else {// root.key==data i.e. found it!!
				// Case 1: no child
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null) { // Case of 1 children
											// //if(root.left==null ||
											// root.right==null){
				root = root.right;// In java not required to store the root in a
									// temp var for freeing it later.
			} else if (root.right == null) {
				root = root.left;
			} else { // Case of 2 children
				Node minInRighttSubTree = this.findMin(root.right);
				root.key = minInRighttSubTree.key;
				//root.right = deleteNode(root.right, data);  it was wrrong it should'nt be data
				root.right = deleteNode(root.right, root.key);
			}
		}

		return root;
	}
	
	public int minimumHeight(Node root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null){
			return 1;
		}
		int leftH=minimumHeight(root.left);
		int rightH=minimumHeight(root.right);
		
		return Math.min(leftH, rightH)+1;
		//if (leftH==0||rightH==0)
			//return leftH!=0?leftH:rightH; 
		
		
		//return 0;
	}
	/*public int maxPathSum(Node root,int Sum,int MaxSum){ //pass MaxSum as Integer.MIN_VALUE at the start.and sum=0
		if(root==null)
			return 0;
		int val=root.key;
		Sum+=val;
		if(Sum>MaxSum){
			MaxSum=Sum;
		}
		int leftSum= maxPathSum(root.left, Sum, MaxSum);
		int righttSum= maxPathSum(root.right, Sum, MaxSum);
		MaxSum=leftSum+righttSum;
		return MaxSum;
		//return -1;
	}*/
	
	public int maxPathSum(Node root){
		int max[]=new int[1];
		max[0]=Integer.MIN_VALUE;
		calculateMaxSum(root,max);
		return max[0];
	}
	public int calculateMaxSum(Node root,int max[]){
		if(root==null){
			return 0;
		}
		
		int leftSum=calculateMaxSum(root.left,max);
		int rightSum=calculateMaxSum(root.right,max);
		
		int currentSum=Math.max(root.key,Math.max(leftSum+root.key,rightSum+root.key));
		//int currentSum=Math.max(root.key,leftSum+root.key+rightSum+root.key);
		
		//max[0]=Math.max(max[0],Math.max(currentSum,root.key+leftSum+rightSum));
		max[0]=Math.max(max[0],Math.max(currentSum,leftSum+rightSum+root.key));
		return currentSum;
		
	}
	
	public Node invertTree(Node root){
		if(root==null)
			return root;
		Node swap;
		root.left=invertTree(root.left);
		root.right=invertTree(root.right);
		swap=root.left;
		root.left=root.right;
		root.right=swap;
		return root;
		
	}
	
}
