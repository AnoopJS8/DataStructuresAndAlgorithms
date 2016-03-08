package strings;

public class permutationString {

	public static void permute(int[] arr, int iStart, int iLast) {
		if (iStart == iLast) {
			for (int k = 0; k < iLast; k++)
				System.out.print(arr[k]);
			System.out.println();
		} else {// has more than one perm.
			for (int i = iStart; i < iLast; i++) {
				int t = arr[iStart];
				arr[iStart] = arr[i];
				arr[i] = t;
				permute(arr, iStart + 1, iLast);
				t = arr[iStart];
				arr[iStart] = arr[i];
				arr[i] = t;// recover the old array again or backtrack
			}
		}

	}

	public static void main(String[] args) {

		permute(new int[] { 1, 1, 3,4 }, 0, 4);
	}

}
