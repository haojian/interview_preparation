package graph;

import java.util.ArrayList;

public class NQueen2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(4));
	}
	
    public static int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n==0)
    		return 0; 
        char[][] matrix = new char[n][n];
        for(int i=0; i<n; i++){
        	for(int j=0; j<n; j++)
        		matrix[i][j] = '.';
        }
        int[] counter=new int[1];
        solveNQueensRecur(matrix, 0, counter);
        return counter[0];
    }

	   public static void solveNQueensRecur(char[][] matrix, int row, int[] counter){
	    	if(row >= matrix.length){
	    		counter[0]++;
	    	}else{
	    		for(int i=0; i<matrix[row].length; i++){
	    			if(placequeen(matrix, row, i)){
	    				matrix[row][i] = 'Q';
	    				solveNQueensRecur(matrix, row+1, counter);
	    				matrix[row][i] = '.';
	    			}
	    		}
	    	}
	    }
	    
		
	    public static boolean placequeen(char[][] matrix, int x, int y){
	    	int offset = 1;
	    	while(x-offset >=0 && y-offset >=0){
	    		if(matrix[x-offset][y-offset] != '.'){
	    			return false;
	    		}
	    		offset++;
	    	}
	    	offset =1;
	    	while(x+offset <matrix.length && y+offset <matrix.length){
	    		if(matrix[x+offset][y+offset] != '.'){
	    			return false;
	    		}
	    		offset++;
	    	}
	    	offset =1;
	    	while(x-offset >=0 && y+offset <matrix.length){
	    		if(matrix[x-offset][y+offset] != '.'){
	    			return false;
	    		}
	    		offset++;
	    	}
	    	offset =1;
	    	while(x+offset <matrix.length && y-offset >=0 ){
	    		if(matrix[x+offset][y-offset] != '.'){
	    			return false;
	    		}
	    		offset++;
	    	}
	    	
	    	for(int i=0; i<matrix.length; i++){
	    		if(matrix[x][i] != '.' && i !=y)
	    			return false;
	    		if(matrix[i][y] != '.' && i !=x)
	    			return false;
	    	}
	    	return true;
	    }
		
	    public static String[] matrixToString(char[][] matrix){
	    	String[] res = new String[matrix.length];
	    	for(int i=0; i<matrix.length; i++){
	    		res[i] = "";
	    		for(int j=0; j<matrix[0].length; j++){
	    			if(matrix[i][j] == 'Q')
	    				res[i]+='Q';
	    			else
	    				res[i]+='.';
	    		}
	    	}
	    	return res;
	    }
}
