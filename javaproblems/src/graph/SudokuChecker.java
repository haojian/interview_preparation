package graph;

public class SudokuChecker {

	/*
check the sum on each row
check the sum on each column
check for sum on each box
check for duplicate numbers on each row
check for duplicate numbers on each column
check for duplicate numbers on each box
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
	private int sudoku[][] = {
			{7, 5, 1,  8, 4, 3,  9, 2, 6},
			{8, 9, 3,  6, 2, 5,  1, 7, 4}, 
			{6, 4, 2,  1, 7, 9,  5, 8, 3},
			{4, 2, 5,  3, 1, 6,  7, 9, 8},
			{1, 7, 6,  9, 8, 2,  3, 4, 5},
			{9, 3, 8,  7, 5, 4,  6, 1, 2},
			{3, 6, 4,  2, 9, 7,  8, 5, 1},
			{2, 8, 9,  5, 3, 1,  4, 6, 7},
			{5, 1, 7,  4, 6, 8,  2, 3, 9}	
	};
	
	public SudokuChecker(){
		
	}
	
	
	
}
