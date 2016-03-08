package arrays;


//offset=last-i

public class RotateMatrix {
	
	/*
	 * 1 2 3
	 * 1 2 2
	 * 3 2 1
	 * 
	 * 3 1 1
	 * 2 2 2
	 * 1 2 3
	*/
	/*int[][] mat={{1,2,3},{1,2,2},{3,2,1}};*/
	//It is not public void static
	
	//Rotating a Matrix in-place is only possible when it's a square matrix.
	public static void rotateMatrix(int[][] matrix,int n){
		for(int layer=0;layer<n/2;layer++){
			int firstCellIndex=layer;
			int lastCellIndex=n-layer-1;
			for(int i=firstCellIndex;i<lastCellIndex;i++){
				//int offset=i-firstCellIndex;
				int offset=lastCellIndex-i;
				int topCell=matrix[firstCellIndex][i];
				//left->top
				matrix[firstCellIndex][i]=matrix[offset][firstCellIndex];//matrix[offset][i];
				//bottom->left
				matrix[offset][firstCellIndex]=matrix[lastCellIndex][offset];/////
				//right->bottom
				matrix[lastCellIndex][offset]=matrix[i][lastCellIndex];//matrix[firstCellIndex][offset];
						
				//top->right
				//matrix[firstCellIndex][offset]=topCell;
				matrix[i][lastCellIndex]=topCell;		
			}
			
		}
	}
	
	public static void rotateMatrixBook(int[][] matrix,int n){
		for(int layer=0;layer<n/2;layer++){
			int firstCellIndex=layer;
			int lastCellIndex=n-layer-1;
			for(int i=firstCellIndex;i<lastCellIndex;i++){
				int offset=i-firstCellIndex;
				//int offset=lastCellIndex-i;
				//save top
				int topCell=matrix[firstCellIndex][i];
				//left->top
				matrix[firstCellIndex][i]=matrix[lastCellIndex-offset][firstCellIndex];
				//bottom->left
				matrix[lastCellIndex-offset][firstCellIndex]=matrix[lastCellIndex][lastCellIndex-offset];
				//right->bottom
				matrix[lastCellIndex][lastCellIndex-offset]=matrix[i][lastCellIndex];
						
				//top->right
				matrix[i][lastCellIndex]=topCell;
				
			}
			
		}
	}
	
	public static void printMatrix(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] mat={{1,2,3,4},{1,2,2,3},{4,3,2,1},{1,1,1,1}};
		int[][] mat1={{1,2,3,4},{1,2,2,3},{4,3,2,1},{1,1,1,1}};
		rotateMatrix(mat, mat[0].length);
		printMatrix(mat);
		System.out.println("-----End of First Method-----");
		rotateMatrixBook(mat1, mat1[0].length);
		System.out.println("-----Start of Book Method-----");
		printMatrix(mat1);
		
	}
}
