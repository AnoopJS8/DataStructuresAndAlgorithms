package linkedList;

import java.util.HashMap;
import java.util.Map;

class NodeC{
	int key;
	int value;
	NodeC next;
	NodeC prev;
	public NodeC(int key,int value){
		this.key=key;
		this.value=value;
		this.next=this.prev=null;
	}
}
public class LRUCache {
	int capacity;
	NodeC front;
	NodeC rear;
	Map<Integer,NodeC> hashMap;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
		this.front=this.rear=null;
		hashMap=new HashMap<Integer,NodeC>();
	}
	
	public int get(int key){
		if(hashMap.get(key)!=null){
			NodeC nc=hashMap.get(key);
			remove(nc);
			setFront(nc);
			return nc.value;
		}
		return -1;
	}
		
	public void set(int key,int value){
		/*if(hash.get(key)==null && hash.size()==capacity){
			
		}*/
		if(hashMap.containsKey(key)){
			NodeC old=hashMap.get(key);
			old.key=key;
			old.value=value;
			remove(old);
			setFront(old);
		}else{
			NodeC newNode=new NodeC(key,value);
			if(hashMap.size()>=capacity){
				hashMap.remove(rear.key);
				remove(rear);
				setFront(newNode);
			}else{
				setFront(newNode);
			}
			hashMap.put(key, newNode);
		}
		
	}
	
	public void remove(NodeC n){
		/*NodeC temp=front;
		
		while(temp.next!=n){
			temp=temp.next;
		}
		temp.prev.next=temp.next;
		*/
		if(n.prev!=null){
			n.prev.next=n.next;
		}else{
			front=n.next;
		}
		if(n.next!=null){
			n.next.prev=n.prev;
		}else{
			rear=n.prev;
		}
		
		
	}
	public void setFront(NodeC n){
		if(front==null && rear==null){
			front=rear=n;	
		}else{
			n.next=front;
			n.prev=null;
			n.next.prev=n;
			front=n;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
