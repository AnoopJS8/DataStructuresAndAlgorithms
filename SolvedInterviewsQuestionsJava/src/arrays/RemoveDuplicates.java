package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr={8,4,4,3,1,3,3,4};
		int len=arr.length;
		List<Integer> list= new ArrayList<>();
		Set<Integer> set=new HashSet<Integer>();
		//Iterator<Integer> itr=list.iterator();
		for(int i=0;i<len;i++){
			if(set.contains(arr[i])){
				for(int j=i;j<len-1;j++){
					arr[j]=arr[j+1];
				}
				len--;
				i--;
			}else{
				set.add(arr[i]);
			}
			
		}
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}

	}

}
