package graph;

import java.util.Stack;

public class MaxRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[1][2];
		matrix[0][0] = '1';
		matrix[0][1] = '0';
		MaxRectangle mr = new MaxRectangle();
		//mr.maximalRectangle(matrix);
		//01010101
		//01110010
		int[] input = {0, 2, 1, 2, 0 ,0, 1, 0};

		System.out.println(mr.getMaxRectangle(input));
	}
	
	
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0)
            return 0;
        int[][] counter = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] =='0')
                    counter[i][j] = 0;
                else{
                    if(i == 0)
                        counter[i][j] = 1;
                    else
                        counter[i][j] = counter[i-1][j]+1;
                }
            }
        }
        int res = 0;
        for(int i=matrix.length-1; i>=0; i--){
        	if(matrix[0].length*(i+1) < res)
        		break;
            int curmax = getMaxRectangle(counter[i]);
            res = Math.max(res, curmax);
        }
        return res;
    }
    
    public int getMaxRectangle(int[] array){
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<array.length; i++){
            if(s.isEmpty() || array[i] >= s.peek()){
                s.push(array[i]);
            }else{
                int counter = 0;
                while(!s.isEmpty() && s.peek() > array[i]){
                    counter++;
                    int top = s.pop();
                    max = Math.max(top*counter, max);
                }
                for(int j=0; j<=counter; j++)
                    s.push(array[i]);
            }
        }
        int counter = 0;
        while(!s.isEmpty()){
            counter++;
            int top = s.pop();
            max = Math.max(top*counter, max);
        }
        return max;
    }
}
