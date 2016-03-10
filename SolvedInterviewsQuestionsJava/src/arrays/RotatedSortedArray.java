package arrays;

//Searching an Element in a Rotated Sorted Array

public class RotatedSortedArray {
	
	public static int rotatedBinarySearch(int[] A,int key){
		//int len=A.length;
		int L=0,R=A.length-1;
		while(L<=R){//here we have to use <= because every time we are changing the limits by 1.So it should merge.
			int M=L+((R-L)/2);
			if(A[M]==key){
				return M;
			}
			//bottom half is sorted
			if(A[L]<=A[M]){
				if(key>=A[L] && key<A[M]){//key lies in this partition
					R=M-1;
				}else{
					L=M+1;
				}
				
			}else{//upper half is sorted
				if(key>A[M]&&key<=A[R]){
					L=M+1;
				}else{
					R=M-1;
				}
				
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,5,6,7,0,1,2};
		System.out.println(rotatedBinarySearch(arr, 0));

	}

}
