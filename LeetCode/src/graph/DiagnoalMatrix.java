package graph;

import java.util.Arrays;

public class DiagnoalMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[5][5];
		int counter =1;
		for(int i=0; i<5;i++){
			for(int j=0; j<5; j++){
				input[i][j] = counter++;
			}
		}
		for(int i=0; i<input.length; i++){
			System.out.println(Arrays.toString(input[i]));
		}
		printMatrix(input);
	}
	
	public static void printMatrix(int[][] matrix){
		int n= matrix.length;
		int curXYSum = 0;
		for(; curXYSum<n; curXYSum++){
			for(int row=0; row<=curXYSum; row++){
				System.out.println(matrix[row][curXYSum-row]);
			}
		}
		for(; curXYSum<2*n-1; curXYSum++){
			for(int j=n-1; j>=0; j--)  // j is the column
			{
				if(matrix[i][j])
			}
		}
		for(int i=0; i<n;i++){
			for(int j=0; j<=i; j++){ // j is the row
				System.out.println(matrix[j][curXYSum-j]);
			}
			curXYSum++;
		}
		for(int i=2; i<n; i++){ //i is the row
			for(j=)
			
		}
	}
	
	
	public static void printMatrixv1(int[][] matrix){
		int n = matrix.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<=i; j++){
				System.out.print(matrix[j][i-j]+" ");
			}
			System.out.println("");
		}
		int cursum = n;
		for(int i=n-2; i>=0; i--){
			cursum++;
			for(int j=n-1; j>=0; j--){
				System.out.print(matrix[i-j][j]+" ");
			}
			System.out.println("");
		}
	}

}
