package dynamicProgramming;

/*Formula:
 * For a given Array, A[]; 
 * Let, S[i]= Max continuous SubSequence sum till ith element.
 * 
 * S[i]=Max{(S(i-1)+A[i]),A[i]}
 * 
 * */

public class MaximumSubSequenceSum {
	
	public static int maxSubSequenceSum(int[]arr){
		int[] Sum=new int[arr.length];
		/*for(int i=0;i<Sum.length;i++){
			Sum[i]=Integer.MIN_VALUE;
		}*/
		int max=Integer.MIN_VALUE;
		int startIdx=0;
		int lastIndx=0;
		Sum[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			//Sum[i]=Math.max(Sum[i-1]+arr[i], arr[i]);
			if((Sum[i-1]+arr[i])>arr[i]){
				Sum[i]=Sum[i-1]+arr[i];
			}else{
				startIdx=i;
				Sum[i]=arr[i];
			}
		}
		for(int i=0;i<arr.length;i++){
			if(max<Sum[i]){
				max=Sum[i];
				lastIndx=i;
			}
		}
		for(int i=startIdx;i<=lastIndx;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input={-2,-3,4,-1,-2,1,5};
		//int[] input={1};
		int[] input={-3,-1};
		//int[] input={1,-3,2,-5,7,6,-1,-4,11,-23};
		System.out.println(maxSubSequenceSum(input));
		
	}

}
