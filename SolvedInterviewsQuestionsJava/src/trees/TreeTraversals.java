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
		stck.push(current);
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

	public void preOrderIterative(Node root){
		Node current=root;
		if(current==null){
			return;
		}
		Stack<Node> stck=new Stack<>();
		stck.push(current);
		while(!stck.isEmpty()){
			Node top=stck.pop();
			System.out.print(top.key+" ");
			if(top.right!=null){
				stck.push(top.right);
			}
			if(top.left!=null){
				stck.push(top.left);
			}
		}
	
	}
	
		public void postOrderIterative(Node root) {

		if (root == null) {
			return;
		}
		Stack<Node> stck1 = new Stack<>();
		Stack<Node> stck2 = new Stack<>();
		Node current = root;
		stck1.push(current);
		while (!stck1.isEmpty()) {
			current = stck1.pop();
			stck2.push(current);
			if (current.left != null) {
				stck1.push(current.left);	
			}
			if (current.right != null) {
				stck1.push(current.right);
			}
		}
		while(!stck2.isEmpty()){
			System.out.print(stck2.pop().key+" ");
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
