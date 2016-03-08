/*package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LowestCommonAncestor {
	// BinaryTree bst=new BinaryTree();
	// bst.root=new Node(5);
	public static List<Node> inorderList = new ArrayList<Node>();
	public static List<Node> postorderList = new ArrayList<Node>();

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		inorderList.add(root);
		inOrder(root.right);
	}
	public static void postOrder(Node root){
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		postorderList.add(root);
		
	}

	public static Node LCS(Node root, Node x, Node y) {

		if (root == null || root == x || root == y)
			return null;

		
		 * List<Node> inorderList=new ArrayList<Node>(); List<Node>
		 * postorderList=new ArrayList<Node>();
		 
		int inorderIndex1=inorderList.indexOf(x);
		int inorderIndex2=inorderList.indexOf(y);
		//elements between these indices
		List<Node> intersection=new ArrayList<Node>();
		for(int i=inorderIndex1+1;i<inorderIndex2;i++)
		{
			intersection.add(inorderList.get(i));
		}
		List<Integer> indexes=new ArrayList<Integer>();
		for(Node node:intersection){
			indexes.add(postorderList.indexOf(node));
		}
		Collections.sort(indexes,new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				// TODO Auto-generated method stub
				return -n1.compareTo(n2);
			}
			
		});
		
		
		
		return postorderList.get(indexes.get(0));
	}

	public static void main(String[] args) {

		BinaryTree bst = new BinaryTree();
		bst.root = new Node(5);

	}

}
*/