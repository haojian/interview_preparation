package graph;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {{'a'}};
		
		System.out.println(exist(board, "a"));
	}
	
    public static boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(board[i][j]==word.charAt(0)){
        			boolean[][] statusboard = new boolean[board.length][board[0].length];
        			if(bruteforceRecur(board, statusboard, i, j, word, 0))
        				return true;
        		}
        	}
        }
        return false;
    }
    
    public static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static boolean bruteforceRecur(char[][] board, boolean[][] statusboard, int x, int y, String word, int wi){
    	if(wi==word.length())
    		return true;
    	if(x<0 || x>=board.length || y<0 || y>=board[0].length || statusboard[x][y]==true)
    		return false;
    	for(int i=0; i<directions.length; i++){
    		if(board[x][y] != word.charAt(wi))
    			return false;
    		statusboard[x][y] = true;
    		if(bruteforceRecur(board, statusboard, x+directions[i][0], y+directions[i][1], word, wi+1))
    			return true;
    		statusboard[x][y] = false;
    	}
    	return false;
    }

}
