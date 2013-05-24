package dp;

public class MinmumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[][] dp = new int[grid.length][grid[0].length];
    	for(int i=0; i<grid.length; i++){
    		for(int j=0; j<grid[0].length; j++){
    			dp[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	dp[0][0] = grid[0][0];
    	for(int i=0; i<grid.length; i++){
    		for(int j=0; j<grid[0].length; j++){
    			if(i>=1)
    				dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j]);
    			if(j>=1)
    				dp[i][j] = Math.min(dp[i][j-1]+grid[i][j], dp[i][j]);
    		}
    	}
    	return dp[grid.length-1][grid[0].length-1];
    }
}
