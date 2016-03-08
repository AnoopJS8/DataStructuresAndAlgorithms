package arrays;
/*
 * To find the number of squares in an NXN chessboard.
 * i.e for 8X* =204
 * 
 * Mathematical formula= n(n+1)(2n+1)/6
 * */

public class NumberOfSquares {
	
	public static int numberOfSquares(int N){
		int sum=0;
		for(int i=0;i<N;i++){
			sum+=(N-i)*(N-i);
		}
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numberOfSquares(16));
	}

}
