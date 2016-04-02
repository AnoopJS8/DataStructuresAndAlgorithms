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
	
	public void inOrderIterative(Node root){
		Node current=root;
		if(current ==  null){
			return;
		}
		Stack<Node> stck=new Stack<>();
		stck.push(root);
		while(!stck.isEmpty()&&current!=null){
			if(current.left!=null){
				current=current.left;
				stck.push(current);
			}else{
				current=stck.pop();
				System.out.print(current.key+" ");
				if(current.right!=null){
					current=current.right;
					stck.push(current);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
