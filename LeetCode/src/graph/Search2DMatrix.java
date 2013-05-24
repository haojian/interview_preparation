package graph;

public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		//int[][] matrix = {{1}};
		System.out.println(searchMatrix(matrix, 100));
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	//binary search to find the line
    	if(matrix == null || matrix.length ==0)
    		return false;
    	int si=0;
    	int ei=matrix.length-1;
    	while(si<=ei){
    		int mid = si+(ei-si)/2;
    		if(matrix[mid][0]<target){
    			si= mid+1;
    		}else if(matrix[mid][0]>target){
    			ei = mid-1;
    		}else
    			return true;
    	}
    	//System.out.println(si +" "+ ei);
    	if(ei<0)
    		return false;
    	int row = ei;
    	si =0;
    	ei = matrix[row].length-1;
    	while(si <=ei){
    		int mid = si+(ei-si)/2;
    		if(matrix[row][mid]<target){
    			si= mid+1;
    		}else if(matrix[row][mid]>target){
    			ei = mid-1;
    		}else
    			return true;
    	}
        return false;
    }
}
