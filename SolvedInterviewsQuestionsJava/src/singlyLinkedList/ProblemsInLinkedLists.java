package singlyLinkedList;

class Node {
	Integer data;
	Node next;

	public Node(Integer data) {
		this.data = data;
		this.next = null;
	}

}

class LinkedList {
	Node head;

	public LinkedList() {
		this.head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void setNext(int data) {
		if (this.head == null) {
			this.head = new Node(data);
		} else {
			Node temp = new Node(data);
			temp.next = head;
			this.head = temp;
		}
	}

	public Node findNode(int data) {
		Node start = this.head;
		while (start != null && start.data != data) {
			start = start.next;
		}
		if (start == null) {
			System.out.println("Node not found");
		}
		return start;
	}

	public void setCycleNode(Node toNode) {// It will be always from the tail to
											// the start of cycle
		Node end = this.head;
		while (end.next != null) {
			end = end.next;
		}
		end.next = toNode;
	}

}

public class ProblemsInLinkedLists {

	public static void printLinkedList(LinkedList list) {
		Node start = list.getHead();
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}

	public static Node startingNodeInCyclicLinkedList(LinkedList list) {
		Node slow = list.getHead();
		Node fast = list.getHead();
		// detect cycle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Cycle found");
				break;
			}
		}
		slow = list.getHead();
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void removeCycle(LinkedList list){
		Node slow = list.getHead();
		Node fast = list.getHead();
		// detect cycle
		//System.out.println(fast.data);
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				//System.out.println(">>Cycle found");
				break;
			}
		}
		slow = list.getHead();
		Node prev=null;
		while (slow != fast) {
			prev=fast;
			slow = slow.next;
			fast = fast.next;
			
		}
		prev.next=null;
		//System.out.println(fast.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.setNext(1);
		list.setNext(2);
		list.setNext(3);
		list.setNext(4);
		// System.out.println(list.head);
		Node find = list.findNode(3);
		//System.out.println(find.data);
		list.setCycleNode(find);
		// printLinkedList(list);
		System.out.println(startingNodeInCyclicLinkedList(list).data);
		removeCycle(list);
		printLinkedList(list);

	}

}

/*
 * Explanation: When tortoise and hare meet, tortoise has covered distance d =
 * p+q and hare has covered distance 2*d = p+q+r+q
 * 
 * 2*d = p + q + r + q 2(p+q) = p + 2q + r 2p + 2q = p + 2q + r p = r (It means
 * distance from head node to the start of loop node is same as distance between
 * meeting point of the pointers to the start of loop node)
 * 
 * So this shows after getting meeting point, if one pointer is placed at the
 * beginning of the list, then moving both pointer one node at a time then they
 * will meet at the start of loop.
 * 
 * 
 */
