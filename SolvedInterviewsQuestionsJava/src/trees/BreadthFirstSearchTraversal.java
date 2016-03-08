package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTraversal {

	public void LevelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("No nodes present in the Binary Tree");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.key + " ");
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}

	}

	public void ReverseLevelOrderTraversal(Node root) {

	}

	public void LevelOrderPrintTraversal(Node root) {
		if (root == null) {
			System.out.println("No nodes present in the Binary Tree");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int LevelCount = 1;
		int LevelNodes = 0;
		while (!queue.isEmpty()) {
			while (LevelCount-- > 0) {
				Node current = queue.poll();
				System.out.print(current.key + " ");
				if (current.left != null) {
					queue.offer(current.left);
					LevelNodes++;
				}
				if (current.right != null) {
					queue.offer(current.right);
					LevelNodes++;
				}
			}
			System.out.println();
			LevelCount=LevelNodes;
			LevelNodes=0;
		}
	}

}
