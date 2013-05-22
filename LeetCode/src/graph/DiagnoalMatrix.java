package graph;

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
		printMatrix(input);
	}
	
	public static void printMatrix(int[][] matrix){
		int n = matrix.length;
		for(int i=0; i<n; i++){
			int r = n-i;
		}
	}

}
