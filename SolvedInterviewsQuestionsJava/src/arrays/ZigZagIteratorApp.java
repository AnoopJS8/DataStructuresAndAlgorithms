package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * Suppose you have a Iterator class with has_next() and get_next() methods.
 * Please design and implement a ZigzagIterator class as a wrapper of two iterators.
 * 
 * For example, given two iterators:
	i0 = [1,2,3,4]
	i1 = [5,6]
	
	ZigzagIterator it(i0, i1);
	while(it.has_next()) {
    	print(it.get_next());
	}
	The output of the above pseudocode would be [1,5,2,6,3,4].
 * */

class ZigZagIterator<T> {
	Iterator<T> i0,i1;
	Iterator<T> itr;
	
	public ZigZagIterator(Iterator<T> i0,Iterator<T> i1){
		this.i0=i0;
		this.i1=i1;
		this.itr=i0.hasNext()?i0:i1;
	}
	public boolean has_Next(){
		return itr.hasNext();
	}
	public T get_Next(){
		T value=(T)itr.next();
		if(itr==i0&&i1.hasNext()){
			itr=i1;
		}else if(itr==i1&&i0.hasNext()){
			itr=i0;
		}
		//System.out.println(value);
		return value;
	}
}


public class ZigZagIteratorApp{
		
	public static void main(String[] args) {
		List<Integer> arr1=new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List<Integer> arr2=new ArrayList<Integer>(Arrays.asList(5,6));
			
		Iterator<Integer> i0=arr1.iterator();
		Iterator<Integer> i1=arr2.iterator();
		ZigZagIterator<Integer> zigZag=new ZigZagIterator(i0, i1);
		while(zigZag.has_Next()){
			//zigZag.get_Next();
			System.out.print(zigZag.get_Next()+" ");
		}
		
	}
	
}

