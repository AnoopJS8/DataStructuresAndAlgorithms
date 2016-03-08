package dynamicProgramming;

/*Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
* to given total. 
* Another variation is given an array is it possible to split it up into 2 equal sum partitions. Partition need
*  not be equal sized. Just equal sum.
*
* Time complexity - O(input.size * total_sum)
* Space complexity - O(input.size*total_sum)
*/

/* if (j<input[i])
 * 		T[i][j]=T[i-1][j];
 * else
 * 		T[i][j]=T[i-1][j] || T[i-1][j-input[i]]
 * * 
 */

public class SubsetSumProblemDP {

	public static boolean subsetSum(int[] input,int total){
		
		boolean[][] T=new boolean[input.length+1][total+1]; 
		
		for(int i=0;i<=input.length;i++){
			T[i][0]=true;//making the first column true as the first column sum is zero and every elemnt can have an empty set.
		}
		for(int i=1;i<=input.length;i++){
			for(int j=1;j<=total;j++){
				if(input[i-1]>j){ //since j value is the sum value.
					T[i][j]=T[i-1][j];
				}else{
					T[i][j]=T[i-1][j]||T[i-1][j-input[i-1]];//value in the top cell minus the sum
				}
			}
		}
		for(int i=0;i<=input.length;i++){
			for(int j=0;j<=total;j++){
				System.out.print(T[i][j]+"->");System.out.print(i+","+j+" ");
			}System.out.println();
		}
		return T[input.length][total];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SubsetSum ss = new SubsetSum();
        int arr[] = {2, 3, 7, 8};
        System.out.println("Ans->"+subsetSum(arr, 11));
	}

}
