package dynamicProgramming;

public class PrintLIS {
	
	public static void printLIS(int[] arr){
		int[] sizes=new int[arr.length];
		String[] seq=new String[arr.length];
		
		//Initially every position is the longest i=sybsequence of size 1.
		for(int i=0;i<arr.length;i++){
			sizes[i]=1;
			seq[i]=arr[i]+" ";
		}
		
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && sizes[i]<sizes[j]+1){
					sizes[i]=sizes[j]+1;
					seq[i]=seq[j]+arr[i]+" ";
				}
			}
		}
		
		int maxLength=1;
		for(int i=0;i<arr.length;i++){
			if(maxLength<sizes[i]){
				maxLength=sizes[i];
				
			}
		}
		System.out.println(maxLength);
		System.out.println(seq[maxLength]);
		/*for(String s:seq){
			System.out.println(s);
		}*/
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr={3,4,-1,0,6,2,3};
		int[] arr={2,6,4,5,1,3};
		printLIS(arr);
	}

}
