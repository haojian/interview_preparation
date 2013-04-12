package graph;

import java.util.ArrayList;

public class SurroundedRegions {

	/**
	 * 
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X


This solution passed the small data set test, but couldn't pass the large data set test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] statusboard = {{'O','X','X', 'O', 'X'},{'X','O','O','X','O'},{'X','O', 'X','O','X'}, {'O','X', 'O','O','O'}, {'X','X', 'O','X','O'}};
		//char[][] statusboard = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X','O','X'}}; 
		solve(statusboard);
	}

    public static void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(board.length == 0)
    		return;
        boolean[][] statusboard = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(board[i][j] == 'X'){
        			statusboard[i][j] = true;
        		}else if(board[i][j] =='O' && statusboard[i][j] == false){
        			//do exploratory search.
        			ArrayList<int[]> res = new ArrayList<int[]>();
        			exploratorySearch(board, statusboard, i, j, res);
        		}
        	}
        }
    }
    
    //if this area could touch the boundary, return false;
    //else return true;
    public static boolean exploratorySearch(char[][] board, boolean[][] statusboard, int startX, int startY, ArrayList<int[]> grids){
    	int[] tested = new int[2];
    	tested[0] = startX;
    	tested[1] = startY;
    	for(int[] tmp:grids){
    		if(tmp[0] == tested[0] && tmp[1] == tested[1]){
    			//System.out.println(tmp[0] +"\t" +tmp[1]);
    			return true;
    		}
    	}

    	if(board[startX][startY] == 'O' && statusboard[startX][startY] == false){
    		statusboard[startX][startY] = true;
    		if(startX == 0 || startX == board.length-1 || startY  == 0 || startY ==board.length-1){
    			grids.clear();
    			return false;
    		}
    		else{
    			int[] tmp = new int[2];
    			tmp[0] = startX;
    			tmp[1] = startY;
    			grids.add(tmp);
    			
    			if(exploratorySearch(board, statusboard, startX-1, startY, grids) &&
    					exploratorySearch(board, statusboard, startX+1, startY, grids) &&
    					exploratorySearch(board, statusboard, startX, startY+1, grids) &&
    					exploratorySearch(board, statusboard, startX, startY-1, grids))
    			{
    				for(int[] point : grids){
    					board[point[0]][point[1]] = 'X';
    					//System.out.println(point[0]+ "\t" + point[1]);
    				}
    				return true;
    			}else{
    				grids.clear();
    				return false;
    			}
    		}	
    	}
    	else if(board[startX][startY] == 'O' && statusboard[startX][startY] ){
    		grids.clear();
    		return false;
    	}
    	else{
        	return true;
    	}
    }
}
