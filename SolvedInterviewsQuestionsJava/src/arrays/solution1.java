package arrays;
/*
 * 1. Find number of pairs with sum S in an array
Sample input: [3,4,5,6,1,2] o/p=3
 * */
public class solution1 {

	public static void main(String[] args) {
		
	int[] array={3,4,5,6,1,2};
	int count=0;
	for(int i=0;i<array.length-1;i++)
	{
		int sum=0;
		for(int j=i+1;j<array.length;j++)
		{
			sum+=array[i]+array[j];
			if(sum==7){
				count++;
				System.out.println("{"+array[i]+" "+array[j]+"}");
			}
			sum=0;
		}
		
	}
		System.out.println(count);
	}
}
