package graph;

import java.util.HashSet;

public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int[][] board = new int[9][9];
	
	public SudokuSolver(String dataText){
		
		
	}
	
	public void LoadSudokuBoard(String tmp){
		
	}

	
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	solveSudokuRecur(board);
    }
    
    public boolean solveSudokuRecur(char[][] board){
    	for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){
        		if(board[i][j] == '.'){
        			for(int k=0; k<9; k++){
        				board[i][j] = (char) ('1' + k);
        				if(checkifValid(board, i, j) && solveSudokuRecur(board)) return true;
        				board[i][j] = '.';
        			}
            		return false;
        		}
        	}
        }
    	return true;
    }
    
	
	public boolean checkifValid(char[][] board, int ri, int ci){
		HashSet<Character> container = new HashSet<Character>();
		for(int i = 0; i<9; i++){
			if(container.contains(board[i][ci]))
				return false;
			if(board[i][ci]>'0' && board[i][ci]<='9'){
				container.add(board[i][ci]);
			}
		}
		container.clear();
		for(int i=0; i<9; i++){
			if(container.contains(board[ri][i]))
				return false;
			if(board[ri][i]>'0' && board[ri][i]<='9'){
				container.add(board[ri][i]);
			}
		}
		container.clear();
		int m =ri/3 *3;
		int n =ci/3*3;
		for(int i=0; i<3;i++){
			for(int j=0; j<3;j++){
				if(container.contains(board[m+i][n+j]))
					return false;
				if(board[m+i][n+j]>'0' && board[m+i][n+j]<='9'){
					container.add(board[m+i][n+j]);
				}
			}
		}
		return true;
	}

}
