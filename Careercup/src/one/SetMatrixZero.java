package one;

import java.util.Arrays;

public class SetMatrixZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[5][5];
		int counter=1;
		for(int[] row:matrix){
			for(int i=0; i<row.length;i++){
				row[i] = counter++;
			}
		}
		matrix[0][3] =0;
		matrix[3][1] = 0;
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
		setZero(matrix);
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void setZero(int[][] matrix){
		boolean row0 = false;
		boolean col0 = false;
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][0] == 0){
				row0 = true;
				break;
			}
		}
		for(int i=0; i<matrix[0].length; i++){
			if(matrix[0][i] == 0){
				row0 = true;
				break;
			}
		}
	
		//start from 1.
		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][0] == 0){
				for(int j=0; j<matrix[0].length;j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j=0; j<matrix[0].length; j++){
			if(matrix[0][j] == 0){
				for(int i=0; i<matrix.length; i++){
					matrix[i][j] = 0;
				}
			}
		}
		
		
		if(row0)
			for(int j=0; j<matrix[0].length;j++){
				matrix[0][j] = 0;
			}
		
		if(col0)
			for(int i=0; i<matrix.length; i++){
				matrix[i][0] = 0;
			}
	}
}
