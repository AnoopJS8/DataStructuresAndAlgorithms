package doublyLinkedLists;
class DNode{
	int data;
	DNode prev;
	DNode next;
	public DNode(){
		
	}
	public DNode(int x){
		this.data=x;
		this.prev=this.next=null;
	}
}
class DoublyLinkedList{
	DNode head;
	
	public DoublyLinkedList(){
		this.head=null;
	}
	
	public void insertAtHead(int x){
		DNode newNode=new DNode(x);
		if(head==null){
			/*temp.next=head;
			temp.prev=head;*/
			head=newNode;
		}else{
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
		}
	}

	public void removeDNode(int x){
		DNode search=this.head;
		while(search!=null && search.data!=x){
			search=search.next;
		}
		//System.out.println(search.data);
		if(this.head==search){
			search.next.prev=search.prev;
			head=search.next;
		}else if(search!=null){
			search.prev.next=search.next;
		}
	}

	public void printAll(){
		DNode temp=this.head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null"+"\n");
	}
	public void reversePrint(){
		DNode temp=this.head;
		if(temp==null)
			return;
		while(temp.next!=null){
			temp=temp.next;
		}
		while(temp!=null){
			System.out.print(temp.data+"<-");
			temp=temp.prev;
		}
		System.out.print("null"+"\n");
	}
	
}

public class DoublyLinkedListImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.insertAtHead(5);
		dll.insertAtHead(15);
		dll.insertAtHead(25);
		dll.insertAtHead(35);
		dll.insertAtHead(45);
		dll.printAll();
		dll.reversePrint();
	}

}
