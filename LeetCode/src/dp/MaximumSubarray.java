package dp;

public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,-3,5,-2,9,-8};
		System.out.println(maxSubArrayInplace(input));
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
    
    
    //inplace solution.
    public static int maxSubArrayInplace(int[] A){
        if(A== null ||A.length ==0)
            return 0;
        int max = A[0];
        int last = A[0];
        for(int i=1; i<A.length; i++){
            int cur = Math.max(last+A[i], A[i]);
            max = Math.max(cur, max);
            last = cur;
        }
        return max;
   }

}
