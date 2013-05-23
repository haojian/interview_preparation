package graph;

import java.util.Arrays;

public class SpiralMatrix2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = generateMatrix(5);
		for(int i=0; i<res.length; i++){
			System.out.println(Arrays.toString(res[i]));
		}
	}

    public static int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        int[] counter = new int[1];
        counter[0] = 1;
        for(int i=0; i< (n+1)/2; i++){
        	updateValuebyDepth(matrix, i, counter);
        }
        return matrix;
    }
    
    public static void updateValuebyDepth(int[][] matrix, int depth, int[] counter ){
    	int width= matrix.length-depth*2;
    	int oneside = width-1;
    	if(oneside == 0)
    		matrix[depth][depth] = counter[0]++;
    	for(int offset =0; offset<oneside; offset++){
    		matrix[depth][depth+offset] = counter[0]++;
    	}
    	for(int offset =0; offset<oneside; offset++){
    		matrix[depth+offset][matrix.length-depth-1] = counter[0]++;
    	}
    	for(int offset =0; offset<oneside; offset++){
    		matrix[matrix.length-depth-1][matrix.length-depth-1-offset] = counter[0]++;
    	}
    	for(int offset =0; offset<oneside; offset++){
    		matrix[matrix.length-depth-1-offset][depth] = counter[0]++;
    	}
    }
}
