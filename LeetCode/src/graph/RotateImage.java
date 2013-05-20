package graph;

import java.util.Arrays;

public class RotateImage {

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

    public static void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0; i<matrix.length/2; i++){
        	rotatebyDepth(matrix, i);
        }
    }
    
    public static void rotatebyDepth(int[][] matrix, int depth){
    	int n =  matrix.length;
    	int w = n-depth*2;
    	for(int offset = 0; offset < w-1; offset++){
    		int tmp = matrix[depth][depth +offset];
    		matrix[depth][depth+offset] = matrix[n-1-depth-offset][depth];
    		matrix[n-1-depth-offset][depth] = matrix[n-1-depth][n-1-depth-offset];
    		matrix[n-1-depth][n-1-depth-offset] = matrix[depth+offset][n-1-depth];
    		matrix[depth+offset][n-1-depth] = tmp;
    	}
    }
}
