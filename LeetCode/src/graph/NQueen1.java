package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen1 {

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
       
        solveNQueensRecur(matrix, 0, 0, 0, res);
        return res;
    }
    
    public static void solveNQueensRecur(char[][] matrix, int x, int y, int qc, ArrayList<String[]> res){
    	if(x >= matrix.length){
    		if(qc == matrix.length)
    			res.add(matrixToString(matrix));
    	}else{
    		int[] p = getnextPoint(matrix, x, y);
    		if(placequeen(matrix, x, y)){
    			matrix[x][y] = 'Q';
    			solveNQueensRecur(matrix, p[0], p[1], qc+1, res);
    			matrix[x][y] = '.';
    		}
			solveNQueensRecur(matrix, p[0], p[1], qc, res);
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
    
    public static int[] getnextPoint(char[][] matrix, int x, int y){
    	int counter = x*matrix.length+y+1;
    	int[] res = new int[2];
    	res[0] = counter / matrix.length;
    	res[1] = counter % matrix.length;
    	return res;
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
