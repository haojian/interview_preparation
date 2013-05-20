package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen1v2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String[] tmp : solveNQueens(4))
			System.out.println(Arrays.toString(tmp));
	}
	
    public static ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	if(n==0)
    		return res; 
        char[][] matrix = new char[n][n];
        for(int i=0; i<n; i++){
        	for(int j=0; j<n; j++)
        		matrix[i][j] = '.';
        }
       
        solveNQueensRecur(matrix, 0, res);
        return res;
    }
    
    public static void solveNQueensRecur(char[][] matrix, int row, ArrayList<String[]> res){
    	if(row >= matrix.length){
    		res.add(matrixToString(matrix));
    	}else{
    		for(int i=0; i<matrix[row].length; i++){
    			if(placequeen(matrix, row, i)){
    				matrix[row][i] = 'Q';
    				solveNQueensRecur(matrix, row+1, res);
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
