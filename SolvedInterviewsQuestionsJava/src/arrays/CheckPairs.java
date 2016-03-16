package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	public static int countPairHashMapMethod(int[] arr,int sum){
		//List<Integer> arrayList=new ArrayList<>();
		//Pairs pair=new Pairs();
		Map<Integer,Integer> pairs=new HashMap<>();
		int count=0;
		
		for(int i=0;i<arr.length;i++){
			if(pairs.containsKey(arr[i])){
				count++;
				System.out.println(arr[i]+","+pairs.get(arr[i]));
				pairs.remove(arr[i]);
			}else{
				pairs.put(sum-arr[i], arr[i]);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] A={1,4,45,6,10,-8,-8,10};
		//Pairs pairs=checkPairSortingMethod(A, 2);
		System.out.println("No. of Pairs are "+countPairHashMapMethod(A, 2));
		/*if(pairs!=null)
			System.out.println("Pairs are "+pairs.a+","+pairs.b);
		else
			System.out.println("No pairs found");
	*/}
}
