package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegionsBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(board==null || board.length == 0)
			return;
		int rows = board.length;
		int cols = board[0].length;
		
		Queue<Integer> exploreList = new LinkedList<Integer>();
		for(int i=0; i< rows;i++){
			bfs(board, i, 0, rows, cols, exploreList);
			bfs(board, i, cols-1, rows, cols, exploreList);
		}
		
		for(int j=1; j< cols; j++){
			bfs(board, 0, j, rows, cols, exploreList);
			bfs(board, rows-1, j, rows, cols, exploreList);
		}
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(board[i][j] =='D')
					board[i][j] = 'O';
				else if(board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}
	
	public void bfs(char[][] board, int i, int j, int rows, int cols, Queue<Integer> exploreList){
		fill(board, i, j, rows, cols, exploreList);
		while(!exploreList.isEmpty()){
			int tmp =exploreList.poll();
			int m = tmp/rows;
			int n = tmp%rows;
			fill(board, m+1, n, rows, cols, exploreList);
			fill(board, m-1, n, rows, cols, exploreList);
			fill(board, m, n+1, rows, cols, exploreList);
			fill(board, m, n-1, rows, cols, exploreList);
		}
	}
	
	public void fill(char[][] board, int i, int j, int rows, int cols, Queue<Integer> exploreList){
		if(i<0 || i>= rows || j<0 || j>= cols || board[i][j] != 'O')
			return;
		exploreList.offer(i*rows + j);
		board[i][j] = 'D';
		
	}
}
