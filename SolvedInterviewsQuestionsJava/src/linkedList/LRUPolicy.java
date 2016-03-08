package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Cache {
	LinkedList<Integer> doublyLinkedList;
	int capacity;
	int currentSize;

	public Cache(int capacity) {
		doublyLinkedList = new LinkedList<>();
		this.capacity = capacity;
		this.currentSize = 0;
	}

	public void addElement(Integer value) {// head
		if (this.currentSize <= this.capacity) {
			if (!doublyLinkedList.contains(value)) {
				doublyLinkedList.addFirst(value);
			}else{
				doublyLinkedList.remove(value);
				doublyLinkedList.addFirst(value);
			}
			this.currentSize++;
		}else{
			doublyLinkedList.removeLast();
			doublyLinkedList.addFirst(value);
			System.out.println(currentSize);
		}
	}
	public void printCache(){
		Iterator iter=doublyLinkedList.listIterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+"->");
		}
		System.out.print("Null"+"\n");
	}

}

public class LRUPolicy {
	public static void main(String[] args) {
		
	Cache cache=new Cache(4);
	cache.addElement(2);
	cache.addElement(3);
	cache.addElement(2);
	cache.addElement(4);
	cache.addElement(5);
	cache.addElement(6);
	cache.addElement(7);
	cache.addElement(8);
	cache.printCache();
	
	}
	

}
