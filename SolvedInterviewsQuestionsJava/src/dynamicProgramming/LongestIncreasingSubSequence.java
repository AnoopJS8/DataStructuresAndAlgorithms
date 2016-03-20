package dynamicProgramming;

public class LongestIncreasingSubSequence {
	
	public int longestIncreasingSubSequenceDP(int[] arr){
		if(arr.length==1){
			return 1;
		}
		int[] T=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			T[i]=1;//initially each element is the longest increasing subsequence of size 1.
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					T[i]=Math.max(T[i], T[j]+1);
				}
			}
		}
		
		int max=0;
		for(int i=0;i<T.length;i++)
		{
			if(max<T[i]){
				max=T[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LongestIncreasingSubSequence lis=new LongestIncreasingSubSequence();
		int[] arr={3,4,-1,0,6,2,3};
		System.out.println(lis.longestIncreasingSubSequenceDP(arr));
		
	}
	
}
