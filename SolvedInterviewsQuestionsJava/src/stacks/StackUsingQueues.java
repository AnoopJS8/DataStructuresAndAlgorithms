package stacks;

import java.util.LinkedList;
import java.util.Queue;

class Stacks {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private Queue<Integer> temp;
	private int maxSize;
	private int currsize;
	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getCurrsize() {
		return currsize;
	}

	public void setCurrsize(int currsize) {
		this.currsize = currsize;
	}

	

	public Stacks(int msize) {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		temp = null;
		maxSize = msize;
		currsize = 0;
	}

	public void push(Integer num) {
		if (this.getCurrsize() >= this.getMaxSize()) {
			System.out.println("Stack Overflow");
			// return;
		} else {
			q1.add(num);
			this.setCurrsize(this.getCurrsize() + 1);
		}

	}

	public Integer pop() {
		Integer res = null;
		if (this.getCurrsize() <= 0) {
			System.out.println("Stack Underflow");
		    //return -1;
		} else {
			while (q1.size() != 1) {
				q2.add(q1.poll());
			}
			res = q1.poll();
			temp = q1;
			q1 = q2;
			q2 = temp;
			this.setCurrsize(this.getCurrsize()-1);
		}
		//this.setCurrsize(this.getCurrsize()-1);
		return res;
	}

}

public class StackUsingQueues {

	public static void main(String[] args) {
		
		Stacks stck=new Stacks(10);
		stck.push(1);
		stck.push(2);
		stck.push(3);
		stck.push(4);
		stck.push(5);
		stck.push(6);
		stck.push(7);
		stck.push(8);
		stck.push(9);
		stck.push(10);
		stck.push(11);
		
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		//System.out.println();
		//System.out.println(stck.getCurrsize());
		//System.out.println(stck.getMaxSize());
		/*System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println(stck.pop());
		System.out.println();
		System.out.println(stck.getCurrsize());
		*/
		

	}
}