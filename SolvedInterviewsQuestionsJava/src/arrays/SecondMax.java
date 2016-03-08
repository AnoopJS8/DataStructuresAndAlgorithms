package arrays;

import java.util.Arrays;

public class SecondMax {

	//public int[] array=new int[10];
	//array={1,2,3,4,5,6,7};
	
	public static void findSecondMax(int arr[]){
		int max,secondMax,len=arr.length;
		//Arrays.sort(arr);
		max=secondMax=Integer.MIN_VALUE;
		/* There should be atleast two elements */
        if (len < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }
		for(int i=0;i<len;i++)
		{
			if(arr[i]>max){
				secondMax=max;
				max=arr[i];
			}else if(arr[i]>secondMax && arr[i]!=max){
				secondMax=arr[i];
			}
			
		}
		if(secondMax==Integer.MIN_VALUE)
		{
			System.out.println("No second Maximum Found");
		}else
		{
			System.out.println("second Maximum Found : "+secondMax);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={-1,-2,9,7,-5,-6};
		findSecondMax(array);
	}

}
