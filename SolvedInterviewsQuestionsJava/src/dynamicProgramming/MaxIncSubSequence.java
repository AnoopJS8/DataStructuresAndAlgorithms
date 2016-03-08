package dynamicProgramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 */

public class MaxIncSubSequence {
	
	
	public int maxSum(int[] arr){
		int[] maxValue=new int[arr.length];
		int[] actualSequence=new int[arr.length];
		
		if(arr.length==1)
			return arr[0];
		for(int i=0;i<arr.length;i++){
			maxValue[i]=arr[i];	//Initially the value is max for the given position.
			actualSequence[i]=i; //Intially it stores the value from where it is coming from.
		}
		
		//int j=0,i=1;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					if(maxValue[j]+arr[i]> maxValue[i])
					{
						actualSequence[i]=j;
					}
					
					maxValue[i]=Math.max(maxValue[j]+arr[i], maxValue[i]);
					//System.out.print(j+" ");
					//if()
					//actualSequence[i]=j;
				}
			}
		}
		int max=0;
		
		for(int i=1; i < arr.length; i++){
            if(maxValue[i] > max){
                max = maxValue[i];
            }
        }
		System.out.println();
		//print Sub Sequence
		int k;
		for(k=0;k<maxValue.length;k++){
			if(maxValue[k]==max)
				break;
		}
		
		/*for(int i=0;i<actualSequence.length;i++){
			 System.out.print(actualSequence[i]+" ");
			
		} System.out.println();
		*/
		//int z=arr.length;
		while(k>0){
			System.out.print(arr[k]+" ");
			k=actualSequence[k];
			/*if(k==0)
				break;
			*/
			//z--;
		}
		if(k==0)
			System.out.print(arr[k]+" ");
		System.out.println();
        return max;
		
		
	}
/*	
	
	public int maxSum(int arr[]){
        int T[] = new int[arr.length+1];
        
        for(int i=1; i < T.length; i++){
            T[i] = arr[i-1];
        }
        
        for(int i=1; i < T.length; i++){
            for(int j = 1; j <i; j++){
                if(arr[i-1] > arr[j-1]){
                    T[i] = Math.max(T[i], T[j] + arr[i-1]);
                }
            }
        }
        
        int max = 0;
        for(int i=1; i <= arr.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }
        return max;
    }
	*/
	public static void main(String args[]){
        MaxIncSubSequence mss = new MaxIncSubSequence();
        //int arr[] = {1,101,10,2,3,100,4};
        int arr[] = {4,6,1,3,8,4,6};
        int r = mss.maxSum(arr);
        System.out.print(r);
    }
}
