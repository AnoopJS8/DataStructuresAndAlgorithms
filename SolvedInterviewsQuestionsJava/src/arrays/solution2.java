package arrays;

import java.util.Stack;

public class solution2 {
	
	public static void main(String[] args) {
		
		int[] array={12,15,1,2,3,10,6,7,19,20};
		int pivot=10;
		Stack<Integer> less=new Stack<Integer>();
		Stack<Integer> more=new Stack<Integer>();
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>10)
			{
				more.push(array[i]);
			}else if(array[i]<10)
			{
				less.push(array[i]);
			}
			
		}
		int i=0;
		while(!less.isEmpty()){
			//System.out.println(less.peek());
			array[i++]=less.pop();
		}
		array[i]=10;
		
		//System.out.println(more.peek());
		
		while(!more.isEmpty()){
			//System.out.println(more.peek());
			array[++i]=more.pop();
		}
		
		for(int a:array)
			System.out.print(a+" ");
		
		
	}
	public void swap(int a,int b){
		int t=a;
		a=b;
		b=t;
	}

}
