package one;

import java.util.Arrays;

public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		int counter=1;
		for(int[] row:matrix){
			for(int i=0; i<row.length;i++){
				row[i] = counter++;
			}
		}
		rotate(matrix);
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void rotate(int[][] matrix){
		for(int i=0; i<matrix.length/2;i++){
			rotatewithdepth(matrix, i);
		}
	}
	
	public static void rotatewithdepth(int[][] matrix, int depth){
		for(int offset = 0; offset<matrix.length-depth*2-1;offset++){
			int tmp = matrix[depth][depth+offset];
			matrix[depth][depth+offset] = matrix[matrix.length-depth-offset-1][depth];
			matrix[matrix.length-depth-offset-1][depth] = matrix[matrix.length-1-depth][matrix.length-1-depth-offset];
			 matrix[matrix.length-1-depth][matrix.length-1-depth-offset] = matrix[offset+depth][matrix.length-1-depth];
			 matrix[offset+depth][matrix.length-1-depth] = tmp;
		}
	}
}
