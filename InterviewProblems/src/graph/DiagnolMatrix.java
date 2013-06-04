package graph;

import java.util.Arrays;
import java.util.Random;

public class DiagnolMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int m = rand.nextInt(5)+1;
		int n = rand.nextInt(3)+1;
		int[][] input = new int[m][n];
		for(int i =0;i<m; i++){
			for(int j=0; j<n;j++)
				input[i][j] = rand.nextInt(100);
		}
		for(int[] array:input){
			System.out.println(Arrays.toString(array));
		}
		pDMatrix(input);
	}
	
	public static void pDMatrix(int[][] m){
		int r = m.length;
		int c = m[0].length;
		for(int i=0; i<c; i++){
			int roffset = 0;
			while(roffset < r && i-roffset>=0){
				System.out.println(m[roffset][i-roffset]);
				roffset++;
			}
		}
		for(int i=1; i<r; i++){
			int coffset = 0; //offset to right
			while(coffset <c && (i-coffset) >=0 && (i+coffset) < r){
				System.out.println(m[i+coffset][c-coffset-1]);
				coffset++;
			}
		}
	}

}
