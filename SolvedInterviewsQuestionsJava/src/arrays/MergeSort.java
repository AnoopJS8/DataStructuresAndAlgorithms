package arrays;

import java.util.ArrayList;

public class MergeSort {
	
	
	public static void mergeSort(ArrayList<Integer> A,int p,int r){
		if(p<r)
		{
			//System.out.println("Inside mergeSort");
			int q=(int)Math.floor((p+r)/2);//System.out.println(q);
			mergeSort(A,p,q);
			////System.out.println(p+","+q+","+r+"\n");
			mergeSort(A,q+1,r);
			////System.out.println(p+","+q+","+r+"\n");
			merge(A,p,q,r);
			////System.out.println("---\n");
			//System.exit(1);
			//System.out.println("Inside mergeSort");
		}
	}
	
	
	public static void merge(ArrayList<Integer> A,int p,int q,int r)
	{
		ArrayList<Integer> Left=new ArrayList<Integer>();
		ArrayList<Integer> Right=new ArrayList<Integer>();
		//System.out.println("Inside merge");
		for(int i=p;i<=q;i++)
		{
			Left.add(A.get(i));
		}
		////System.out.println(Left);
		for(int i=q+1;i<=r;i++)
		{
			Right.add(A.get(i));
		}
		////System.out.println(Right);
		int i=0,j=0,k=p;
	//	System.out.println(k);
		while(i<Left.size() && j<Right.size())
		{
			if(Left.get(i)<=Right.get(j))
			{
				A.set(k, Left.get(i));
		//		System.out.println(k);
				i++;
			}else
			{
				A.set(k, Right.get(j));
				j++;
		//		System.out.println(k);
			}
			k++;
						
		}
	//	System.out.println(i);
	//	System.out.println(j);
		while(i<Left.size())
		{
			//System.out.println(Left.get(i));
			A.set(k++, Left.get(i));
			i++;
		}
		while(j<Right.size())
		{
			//System.out.println(Left.get(i));
			A.set(k++, Right.get(j));
			j++;
		}
		
		/////System.out.println("========= \n"+A);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A=new ArrayList<Integer>();
		A.add(5);A.add(2);A.add(4);A.add(7);A.add(1);A.add(3);A.add(2);A.add(6);A.add(0);
		//A.add(2);A.add(4);A.add(1);A.add(6);A.add(8);A.add(5);A.add(3);A.add(7);
		//A.add(8);A.add(7);A.add(6);A.add(5);A.add(4);A.add(3);A.add(2);A.add(1);A.add(0);
		System.out.println("Before Sorting \n"+A);
		mergeSort(A, 0, A.size()-1);
		//System.out.println("Hi");
		System.out.println("After Sorting \n"+A);
		
	}

}
