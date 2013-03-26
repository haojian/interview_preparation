package graph;

public class MatrixRotate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] abc = {{1,2,3,4},{5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		output(abc);
		RotateMatrix(abc, 4);
		output(abc);
	}

	public static void RotateMatrix(int[][] matrix, int N){
		for(int i =0; i<N/2; i++){
			
			SubRotateV1(matrix, N, i);
			output(matrix);
			System.out.println(i + "depth");
		}
	}
	
	
	public static void SubRotateV1(int[][] matrix, int N, int depth){
		int startIndex = depth;
		int endIndex = N-1-depth;
		for(int i = startIndex; i<endIndex; i++){
			int offset = i-startIndex;
			int tmp = matrix[startIndex][startIndex + i];
			matrix[startIndex][i] = matrix[endIndex-offset][startIndex];
			matrix[endIndex-offset][startIndex] = matrix[endIndex][endIndex-offset];
			matrix[endIndex][endIndex-offset] = matrix[i][endIndex];
			matrix[i][endIndex] = tmp;
		}
	}
	
	//within error
	public static void SubRotate(int[][] matrix, int N, int depth){
		for(int i = 0; i<N-depth*2-1; i++){
			int tmp = matrix[depth][depth+i];
			matrix[depth][depth+i] = matrix[N-depth-i-2][depth];
			matrix[N-depth-i-2][depth] = matrix[N-depth-2][N-depth-i-2];
			matrix[N-depth-2][N-depth-i-2] = matrix[depth][N-depth-i-2];
			matrix[depth][N-depth-i-2] = tmp;
		}
	}
	
	public static void output(int[][] matrix){
		for(int[] tmp:matrix){
			for(int integ:tmp){
				System.out.print(integ + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
