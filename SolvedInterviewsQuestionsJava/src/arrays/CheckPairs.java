package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pairs{
	int a;
	int b;
}

public class CheckPairs {
	
	public static Pairs checkPairSortingMethod(int[] arr,int sum){
		Pairs pair=new Pairs();
		Arrays.sort(arr);
		int l=0;int r=arr.length-1;
		
		while(l<r){
			if((arr[l]+arr[r])==sum){
				pair.a=arr[l];pair.b=arr[r];
				return pair;
			}else if(arr[l]+arr[r]<sum){
				l++;
			}else{
				r--;
			}
		}
		return pair;
	}
	public static Pairs checkPairHashMapMethod(int[] arr,int sum){
		List<Integer> arrayList=new ArrayList<>();
		Pairs pair=new Pairs();
		for(int i=0;i<arr.length;i++){
			arrayList.add(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++){
			if(arrayList.contains(sum-arr[i])){
				System.out.println(arr[i] + "," + (sum-arr[i]));
				pair.a=arr[i];pair.b=arrayList.lastIndexOf(sum-arr[i]);
				break;
			}
		}
		
		return pair;
	}
	
	public static void main(String[] args) {
		int[] A={1,4,45,6,10,-8};
		//Pairs pairs=checkPairSortingMethod(A, 2);
		Pairs pairs=checkPairHashMapMethod(A, 2);
		if(pairs!=null)
			System.out.println("Pairs are "+pairs.a+","+pairs.b);
		else
			System.out.println("No pairs found");
	}
}
