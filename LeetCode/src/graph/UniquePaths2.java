package graph;

public class UniquePaths2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[3][3];
		matrix[1][1] = 1;
		System.out.println(uniquePathsWithObstacles(matrix));
	}
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] == 1)
        	dp[0][0] = 0;
        else
        	dp[0][0] =1;
        for(int i=0; i<obstacleGrid.length; i++){
        	for(int j=0; j<obstacleGrid[0].length; j++){
        		if(obstacleGrid[i][j] == 1)
        			dp[i][j] = 0;
        		else{
        			if(i>=1)
        				dp[i][j] += dp[i-1][j];
        			if(j>=1)
        				dp[i][j] += dp[i][j-1];
        		}
        	}
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
