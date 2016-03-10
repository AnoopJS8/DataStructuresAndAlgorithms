package linkedList;

public class AddTwoLists {
	
	static LNode head1,head2; 
	static class LNode{
		int data;
		LNode next;
		LNode(int d){
			this.data=d;
			this.next=null;
		}
	}
	
	LNode addTwoLinkedList(LNode head1,LNode head2){
		LNode headResult=null;
		LNode temp=null;
		LNode prev=null;
		int carry=0,sum=0;
		
		while(head1!=null || head2!=null){
			sum=(head1!=null?head1.data:0) + (head2!=null?head2.data:0)+carry;//%10;
			carry=sum>=10?1:0;
			sum=sum%10;
			temp=new LNode(sum);
			//if this is the first node i.e headResult is null create the  node and point it to headNode
			if(headResult==null){
				headResult=temp;
			}else{//attach it to the rest
				prev.next=temp;
			}
			prev=temp;
			if(head1!=null)
				head1=head1.next;
			if(head2!=null)
				head2=head2.next;
			
		}
		
		if(carry>0){
			temp.next=new LNode(carry);
		}
		
		return headResult;
	}
	
	public void printList(LNode h){
		while(h!=null){
			System.out.print(h.data+" ");
			h=h.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddTwoLists list=new AddTwoLists();
		list.head1 = new LNode(7);
        list.head1.next = new LNode(5);
        list.head1.next.next = new LNode(9);
        list.head1.next.next.next = new LNode(4);
        list.head1.next.next.next.next = new LNode(6);
        System.out.print("First List is ");
        list.printList(head1);
 
        // creating seconnd list
        list.head2 = new LNode(8);
        list.head2.next = new LNode(4);
        System.out.print("Second List is ");
        list.printList(head2);
 
        // add the two lists and see the result
        LNode rs = list.addTwoLinkedList(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
		
	}

}
