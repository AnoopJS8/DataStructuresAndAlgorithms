package arrays;

/*
 * http://stackoverflow.com/questions/726756/print-two-dimensional-array-in-spiral-order
 * 
 * */
public class SpiralMatrixPrint {

	public static void printTopRight(int arr[][], int startCol, int startRow, int endCol, int endRow) {
		for (int i = startCol; i < endCol; i++) {
			System.out.print(arr[startRow][i] + " ");
		}
		for(int j=startRow+1;j<endRow;j++){
			System.out.println(arr[j][endCol]);
		}
		
		//CHeck if more no of layers to be printed
		if(endCol-startCol){
			
		}

	}

}
