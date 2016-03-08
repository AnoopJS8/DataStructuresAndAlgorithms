package parentbinarytree;

public class App {

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		BinaryTree root=null;
		root=tree.addNode(root, 20);
		//System.out.println(root.getKey());
		root=tree.addNode(root, 8);
		//System.out.println(root.getKey());
		root=tree.addNode(root, 22);
		root=tree.addNode(root, 4);
		root=tree.addNode(root, 12);
		root=tree.addNode(root, 10);
		root=tree.addNode(root, 14);
		
		//System.out.println(tree.findNode(root, 22));
		//**BinaryTree leaf=tree.findNode(root, 22);
		//System.out.println(root.getLeft().getLeft().getParent());
		//tree.printLeafToRoot(leaf);
		//**int ancs=tree.lowestCommonAncestor(tree.findNode(root, 10), tree.findNode(root, 20));
		//**System.out.println(ancs);
		//System.out.println(tree.min(root).getKey());
		
		System.out.println(tree.inorderSuccessor(tree.findNode(root, 14)).getKey());
	}
}


/*
 * 			20
 * 		   /  \
 * 		  8   22
 * 		 / \
 * 		4  12
 * 		   / \
 *		  10 14
 */