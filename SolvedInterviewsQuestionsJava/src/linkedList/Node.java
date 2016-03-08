package linkedList;

public class Node<T> {
	private T key;
	private Node<T> next;

	public Node(T data) {
		key = data;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> insertInFirst(Node<T> head,T data){
		Node<T> newNode=new Node<T>(data);
		newNode.setNext(head);
		return newNode;
	}
	public Node<T> find(Node<T> head,T data){
		while(head!=null&& head.getKey()!=data){
			head=head.getNext();
		}
		return head;
	}
}
