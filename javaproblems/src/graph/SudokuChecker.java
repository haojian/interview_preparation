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
	
	//all of the i should be from 0
	public boolean rowCheck(int i){
		return false;
	}
	
	public boolean columnCheck(int i){
		return false;
	}
	
	public boolean boxCheck(int i){
		int sum = 0;
		int startColum = (i%3) *3;
		int startRow = ((int) (i/3)) * 3;
		for(int k =0; k< 3; k++)
			for(int j = 0; j<3; j++){
				sum += sudoku[startRow+k][startColum+j];
			}
		if(sum != 45)
			return false;
		else
			return true;
	}
	
	public boolean duplicateInRow(int i){
		return false;
	}
	
	public boolean duplicateInColum(int i){
		return false;
	}
	
	public boolean duplicateInBox(int i){
		return false;
	}
}
