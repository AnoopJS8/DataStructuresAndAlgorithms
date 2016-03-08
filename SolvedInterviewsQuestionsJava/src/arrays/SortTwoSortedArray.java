package arrays;


public class SortTwoSortedArray {
	
	public static void main(String[] args) {
		
		//System.out.println("Enter two Sorted Arrays");
		//Scanner sc=new Scanner(System.in);
		int[] arr1={2,4,7,12,34,45,78,90,95};
		int[] arr2={3,4,8,10,39,55};
		
		int len1=arr1.length;
		int len2=arr2.length;
		int[] sorted=new int[len1+len2];
		int j=0,k=0,n=0;
		while(j<len1&&k<len2)
		{
			if(arr1[j]<arr2[k])
			{
				sorted[n++]=arr1[j++];
			}else{
				sorted[n++]=arr2[k++];
			}
		}
		while(j<len1)
		{
			sorted[n++]=arr1[j++];
		}
		while(k<len2)
		{
			sorted[n++]=arr2[k++];
		}
		
		for(int i:sorted)
		{
			System.out.print(i+" ");
		}
	}

}
