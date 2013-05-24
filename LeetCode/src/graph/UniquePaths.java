package graph;

public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePathsRecurDP(10,10));
	}
	
	private static int[][] directions = {{1,0}, {0,1}};
	
    public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[m][n];
        int[] counter = new int[1];
        counter[0] = 0;
        uniquePathsRecur(matrix, 0, 0, counter);
        return counter[0];
    }
    
    public static void uniquePathsRecur(int[][] matrix, int x, int y, int[] counter) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==matrix.length-1 && y==matrix[0].length-1)
        	counter[0]++;
        else if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length){
        	return;
        }else{
        	for(int i=0; i<directions.length; i++){
            	uniquePathsRecur(matrix, x+directions[i][0], y+directions[i][1], counter);
        	}
        }
    }
    
    public static int uniquePathsRecurDP(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[][] dp = new int[m][n];
    	dp[0][0] = 1;
    	for(int i=0; i<m;i++){
    		for(int j=0; j<n; j++){
    			if(i>=1)
    				dp[i][j] +=dp[i-1][j];
    			if(j>=1)
    				dp[i][j] += dp[i][j-1];
    		}
    	}
    	return dp[m-1][n-1];
    }
}
