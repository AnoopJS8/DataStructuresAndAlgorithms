package arrays;
//Create an app letting how similar you are


/**
 * 
 * @author Anoop
 * 
 * What is the largest possible number of inversions that a 6-element array can have?
 * 
 * Suppose every element in the array is in the descending order.THen the first element has to make 5 inversions
 * similarly second element has to make 4 and so on.
 * Ans -15
 *
 */

public class CountingInversions {
	
	//check the number of elements after it smaller than it in the array.
	public static int countInversionsMethodI(int[] arr){
		int inv_count=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j])
				{
					inv_count++;
				}
			}
		}
		
		return inv_count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={1,3,5,2,4,6};
		System.out.println(countInversionsMethodI(arr));
	}

}
