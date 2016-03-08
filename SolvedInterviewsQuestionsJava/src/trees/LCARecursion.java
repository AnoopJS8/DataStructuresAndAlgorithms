package trees;

//Least common Ancestor in Binary Tree
public class LCARecursion {
	
	public static Node lowestCommonAncestor(Node root,Node n1,Node n2){
		if(root==null)
			return root;
		if(root==n1||root==n2){
			return root;
		}
		Node inLeft=lowestCommonAncestor(root.left, n1, n2);
		Node inRight=lowestCommonAncestor(root.right, n1, n2);
		if(inLeft!=null && inRight!=null){
			return root;
		}
		
		return inLeft!=null?inLeft:inRight;
	}
	
}
