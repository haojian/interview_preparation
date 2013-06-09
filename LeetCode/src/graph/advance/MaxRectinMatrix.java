package graph.advance;

import java.util.Stack;

public class MaxRectinMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(matrix.length ==0 || matrix[0].length == 0)
    		return 0;
        int[][] counter = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix[0].length; i++){
        	if(matrix[0][i] == '1')
        		counter[0][i] = 1;
        }
        
        for(int i=1; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j] == '1'){
        			counter[i][j] = counter[i-1][j]+1;
        		}
        	}
        }
        int max = 0;
        for(int i=matrix.length-1; i>=0; i--){
        	max = Math.max(max, maxRectangleinOnedimension(counter[i]));
        	if(max > (i+1) * matrix[0].length)
        		break;
        }
        return max;
    }
    
    public int maxRectangleinOnedimension(int[] input){
    	if(input.length == 0)
    		return 0;
    	int max = 0;
    	Stack<Integer> s = new Stack<Integer>();
    	for(int i=0; i<input.length; i++){
    		if(s.isEmpty() || input[i]>=s.peek()){
    			s.push(input[i]);
    		}else{
    			int counter = 0;
    			while(!s.isEmpty() && s.peek() > input[i]){
    				counter++;
    				int left = s.pop();
    				max = Math.max(counter * left, max);
    			}
    			for(int j=0; j<=counter; j++){
    				s.push(input[i]);
    			}
    		}
    	}
    	
    	int counter = 0;
    	while(!s.isEmpty()){
    		counter++;
    		int left = s.pop();
			max = Math.max(counter * left, max);
    	}
    	return max;
    }
}
