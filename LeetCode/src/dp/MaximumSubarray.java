package dp;

public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(input));
	}
	
	
	
    public static int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] dp = new int[A.length];
        dp[0] = A[0];
    	int max = dp[0];
        for(int i=1; i<A.length; i++){
        	dp[i] = Math.max(A[i]+dp[i-1], A[i]);
        	max = Math.max(dp[i], max);
        }
    	return max;
    }

    //additional approach
	//divide and conquer approach

}
