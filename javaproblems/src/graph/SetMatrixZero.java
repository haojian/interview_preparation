package graph;

public class SetMatrixZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(matrix == null || matrix.length == 0 )
    		return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean zerorow0 = false;
        boolean zerocol0 = false;
        
        for(int i=0; i<rows; i++){
        	if(matrix[i][0] == 0)
        		zerocol0 = true;
        }
        
        for(int j=0 ; j< cols; j++){
        	if(matrix[0][j] == 0)
        		zerorow0 = true;
        }
        
        for(int i=0; i<rows; i++){
        	for(int j=0; j<cols; j++){
        		if(matrix[i][j]  == 0){
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        
        for(int i=1; i<rows; i++){
        	if(matrix[i][0] == 0)
        		for(int j=0; j<cols; j++){
        			matrix[i][j] = 0;
        		}
        }
        
        for(int j=1;j<cols; j++){
        	if(matrix[0][j] == 0){
        		for(int i=0; i<rows; i++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if(zerocol0){
        	 for(int i=0; i<rows; i++){
             	matrix[i][0] = 0;
             }
        }
        
        if(zerorow0){
        	for(int i=0; i<cols; i++){
             	matrix[0][i] = 0;
             }
        }
    }
}
