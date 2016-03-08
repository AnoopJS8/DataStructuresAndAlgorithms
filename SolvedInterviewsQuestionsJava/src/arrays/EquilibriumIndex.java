package arrays;

public class EquilibriumIndex {
	
	public static int equilibriumIndex(int[] arr){
		int len=arr.length;
		int sum=0;
		int leftsum=0;
		for(int i=0;i<len;i++){
			sum+=arr[i];
		}
		for(int i=0;i<len;i++){
			sum-=arr[i];
			if(leftsum==sum){
				return i;
			}
			leftsum+=arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={-7,1,5,2,-4,3,0};
		System.out.println(equilibriumIndex(arr));
	}

}
