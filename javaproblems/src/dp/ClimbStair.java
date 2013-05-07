package dp;

public class ClimbStair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1)
            return 0;

        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
