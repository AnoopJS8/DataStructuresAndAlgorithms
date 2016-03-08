package parentbinarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTree{

	private Integer key;
	private BinaryTree parent;
	private BinaryTree left;
	private BinaryTree right;
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public BinaryTree getParent() {
		return parent;
	}
	public void setParent(BinaryTree parent) {
		this.parent = parent;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	public BinaryTree(){
		key=null;
		parent=null;
		left=right=null;//left=right=this;
	}
	public BinaryTree(Integer key){
		this.key=key;
		parent=left=right=null;
	}
	
	public BinaryTree addNode(BinaryTree root,int key){
		if(root==null){
			return new BinaryTree(key);
			/*BinaryTree newNode=new BinaryTree(key);
			newNode.parent=root;  //This wont work
			return newNode;*/
		}
		if(key<=root.key){
			root.left=addNode(root.left,key);
			root.left.parent=root;
		}else{
			root.right=addNode(root.right,key);
			root.right.parent=root;
		}
		
		return root;
	}
	public void printBinaryTree(BinaryTree root){
		
	}
	public void printLeafToRoot(BinaryTree leaf){
		//BinaryTree bst=root.findNode(root, key)
		while(leaf!=null){
			System.out.println(leaf.key);
			leaf=leaf.parent;
		}
	}
	public BinaryTree findNode(BinaryTree root,int key){
		//BinaryTree node;
		if (root==null)
			return null;
		if(key<root.getKey()){
			root=findNode(root.getLeft(), key);
		}else if(key>root.getKey()){
			root=findNode(root.getRight(), key);
		}else{
			return root;
		}
		return root;
	}
	public BinaryTree inorderSuccessor(BinaryTree node){
		/*Algo-
		 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
		 *    Go to right subtree and return the node with minimum key value in right subtree.
		 *2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
		 *   Travel up using the parent pointer until you see a node which is left child of it’s parent.
		 *   The parent of such a node is the succ.
		 */
		//BinaryTree inorderSuccesor=min(node.right);
		//if(inorderSuccesor==null){
		//	return node.parent;
		//}
		//return inorderSuccesor;
		if(node.getRight()!=null){
			return min(node.getRight());
		}
		BinaryTree parent=node.getParent();
		while(parent!=null&&parent.left!=node){//while(parent!=null&&parent.getRight()==node){
			node=parent;
			parent=node.getParent();
		}
		return parent;
		
	}
	public BinaryTree min(BinaryTree root){
		if(root==null)
			return null;
		return root.left==null?root:min(root.left);
				
	}
	public Integer lowestCommonAncestor(BinaryTree node1,BinaryTree node2){
		//if(node1==null)
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		while(node1!=null){
			list1.add(0,node1.getKey());
			node1=node1.parent;
		}
		while(node2!=null){
			list2.add(0,node2.getKey());
			node2=node2.parent;			
		}
		Iterator<Integer> itr1=list1.listIterator();
		Iterator<Integer> itr2=list2.listIterator();
		int ans=-1;
		Integer temp=null;
		//while(itr1.hasNext() && itr2.hasNext() && itr1.next()==itr2.next()){
		while(itr1.hasNext() && itr2.hasNext()){
			int x=itr1.next();int y=itr2.next();
			//if(itr1.next()!=itr2.next()){
			if(x!=y){
				//System.out.println(x+"--"+y);
				break;
			}
			//temp=itr1.next();
			temp=x;
		}
		/*  */
		/*while(itr1.hasNext() && itr2.hasNext()){
			int x=itr1.next();int y=itr2.next();
			//if(itr1.next()!=itr2.next()){
			if(x==y){
				//System.out.println(x+"--"+y);
				ans=x;
				break;
			}
			//temp=itr1.next();
			//temp=x;
		}*/
		
		if(temp!=null)
			return temp;
		else
			return -1;
		//return ans;//itr1.next();
	}
	
	
}
