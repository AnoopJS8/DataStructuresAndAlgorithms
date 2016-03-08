package trees;

public class InorderSuccessor {

	public int inorderSuccessor(Node root, int data) {
		if (root == null) {
			System.out.println("Tree is empty");
			return -1;
		}
		Node current = findNode(root, data);
		if (current.right != null) {
			return findMin(current.right).key;
		}
		Node ancestor = root;
		Node successor = null;
		while (ancestor != current) {
			if (data < ancestor.key) {
				successor = ancestor;
				ancestor = ancestor.left;
			} else {
				ancestor = ancestor.right;
			}
		}

		return successor.key;
	}

	public Node findMin(Node root) {
		if (root == null)
			return null;
		return root.left == null ? root : findMin(root.left);
	}

	public Node findNode(Node root, int data) {
		if (root == null)
			return root;
		Node current = root;
		
		while (current != null) {
			//System.out.println(current.key);
			if (data < current.key) {
				current = current.left;
			} else if (data > current.key) {
				current = current.right;
			} else {
				break;
			}
		}
		//System.out.println(current.key);
		return current;
	}
}
