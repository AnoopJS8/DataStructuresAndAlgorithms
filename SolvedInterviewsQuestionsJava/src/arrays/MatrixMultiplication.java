package arrays;

public class MatrixMultiplication{
	//int[][] A=new int[2][2];
	//int[][] B=new int[2][2];
	//private char[][] table = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A={{1,2},{2,4}};
		int[][] B={{-16,2},{8,-1}};
		
		int[][] C=new int[2][2];
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				int sum=0;
				for(int k=0;k<2;k++)
				{
					sum+=A[i][k]*B[k][j];
				}
				C[i][j]=sum;
			}
		}
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++){
				System.out.printf("%2d",C[i][j]);
			}
			System.out.println();
		}
		
	}

}
