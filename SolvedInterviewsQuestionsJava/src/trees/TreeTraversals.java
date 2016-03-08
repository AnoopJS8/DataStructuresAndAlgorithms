package trees;


public class TreeTraversals {

	
	public void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	public void preOrder(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.key+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public void postOrder(Node root){
		if(root==null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key+" ");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
