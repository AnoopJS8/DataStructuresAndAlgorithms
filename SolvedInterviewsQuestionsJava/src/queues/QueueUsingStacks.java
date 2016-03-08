package queues;

import java.util.Stack;

class Queue{
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	private int size;
	
	public Queue(){
		size=0;
		stack1=new Stack<Integer>();
		stack2=new Stack<Integer>();
	}
	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
	public int getSize() {
		return size;
	}
	public void enqueue(Integer data){
		stack1.push(data);
		size++;
	}
	public Integer dequeue(){
		if(size==0)
			return -1;
		if(stack2.isEmpty()){
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		size--;
		return stack2.pop(); 
		//return 1;
	}
	
}

public class QueueUsingStacks {
	
	public static void main(String[] args) {
		Queue queue=new Queue();
		System.out.println(queue.isEmpty());
		queue.enqueue(12);
		queue.enqueue(24);
		queue.enqueue(48);
		System.out.println(queue.getSize());
		System.out.println(queue.dequeue());
		System.out.println(queue.getSize());
		
		System.out.println(queue.dequeue());
		System.out.println(queue.getSize());
		System.out.println(queue.dequeue());
		System.out.println(queue.getSize());
		System.out.println(queue.dequeue());
		System.out.println(queue.getSize());
	}
	
}
