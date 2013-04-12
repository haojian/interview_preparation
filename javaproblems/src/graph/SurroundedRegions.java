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

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] statusboard = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(board[i][j] == 'X'){
        			statusboard[i][j] = true;
        		}else if(board[i][j] =='0' && statusboard[i][j] == false){
        			//do exploratory search.
        			ArrayList<int[]> res = new ArrayList<int[]>();
        			if(exploratorySearch(board, statusboard, i, j, res)){
        				//flip value.
        				for(int[] tmp : res){
        					board[tmp[0]][tmp[1]] = 'X';
        				}
        			}
        		}
        	}
        }
    }
    
    //if this area could touch the boundary, return false;
    //else return true;
    public boolean exploratorySearch(char[][] board, boolean[][] statusboard, int startX, int startY, ArrayList<int[]> grids){
    	statusboard[startX][startY] = true; // mark grid been explored.
    	if(board[startX][startY] == '0'){
    		if(startX == 0 || startX == board.length-1 || startY  == 0 || startY==board.length-1){
    			grids.clear();
    			return false;
    		}
    		else{
    			int[] tmp = new int[2];
    			tmp[0] = startX;
    			tmp[1] = startY;
    			grids.add(tmp);
    			if(exploratorySearch(board, statusboard, startX-1, startY-1, grids) &&
    					exploratorySearch(board, statusboard, startX-1, startY+1, grids) &&
    					exploratorySearch(board, statusboard, startX+1, startY+1, grids) &&
    					exploratorySearch(board, statusboard, startX+1, startY-1, grids))
    			{
    				return true;
    			}else{
    				grids.clear();
    				return false;
    			}
    		}	
    	}
    	else{
        	return true;
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
}
