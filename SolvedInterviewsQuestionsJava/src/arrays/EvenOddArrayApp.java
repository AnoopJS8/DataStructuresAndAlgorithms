package arrays;

public class EvenOddArrayApp {

	/*
	 * generate a list of alternatively positioned odd and even number out of an
	 * array of unsorted integers input={1,3,2,4,6,5} output={1,2,3,4,5,6}
	 */

	public static int[] generateEvenOddArray(int[] arr) {
		int len = arr.length;

		int[] newArray = new int[len];
		int oddIndex = 0, evenIndex = 1;

		for (int i = 0; i < len; i++) {
			newArray[i] = -1;
		}
		if (len == 1) {
			newArray[0] = arr[0];
			return newArray;
		}

		for (int i = 0; i < len; i++) {// for(int
										// i=0;i<len&&evenIndex<len&&oddIndex<len;i++){
			if (arr[i] % 2 == 0 && evenIndex < len) { // and check for boundary
														// for indexes
				newArray[evenIndex] = arr[i];
				evenIndex += 2;
				// evenIndex=oddIndex+1;
			} else {
				if (oddIndex < len) {
					newArray[oddIndex] = arr[i];
					oddIndex += 2;
				}
				// oddIndex=evenIndex+1;
			}
		}

		/*
		 * int x=0; for(int i=0;i<len;i++){ if(newArray[i]==-1){ x++;
		 * if((i+x)<len) newArray[i]=newArray[i+x]; } }
		 */ return newArray;
	}

	/*
	 * move all even numbers on the first half and odd numbers to the second
	 * half in an integer array E.g. Input = {3,8,12,5,9,21,6,10}; Output =
	 * {12,8,6,10,3,5,9,21}. time complexity: O(n),space COmplexity O(1).
	 */
	public static int[] partitionEvenOddArray(int[] arr) {
		int oddPos, nextEvenPos;
		//int[] temp = new int[arr.length];
		for (nextEvenPos = 0;arr[nextEvenPos] % 2 == 0 && nextEvenPos < arr.length; nextEvenPos++);
		// nextEvenPos is now positioned at the first odd number in the array, 
	    // i.e. it is the next place an even number will be placed
		
		// We already know that items[nextEvenPos] is odd (from the condition of the 
	    // first loop), so we'll start looking for even numbers at nextEvenPos + 1
		
		for(oddPos=nextEvenPos+1;oddPos<arr.length;oddPos++){
			if(arr[oddPos]%2==0){//first even number found after the odd term.
				//Swap values
				int temp=arr[nextEvenPos];
				arr[nextEvenPos]=arr[oddPos];
				arr[oddPos]=temp;
				
				nextEvenPos++;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// int[] arr={1,3,2,4,6,5};
		int[] arr = { 1, 3, 2, 4, 6, 8 };
		int len = arr.length;
		int[] narr = new int[len];
		/*
		 * for(int i=0;i<len;i++){ narr[i]=-1; }
		 */
		narr = generateEvenOddArray(arr);
		// int x=0;
		arr=partitionEvenOddArray(arr);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
