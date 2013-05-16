package dp;

public class JumpGame2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={2,3,1,1,4};
		System.out.println(jump(input));
	}
	
	//Time Limit Exceeded
    public static int jumpv1(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A == null || A.length == 0)
    		return 0;
        int[] dp = new int[A.length];
        dp[0] = 0;
        for(int i=1; i<A.length; i++)
        	dp[i] = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
        	for(int j=1; j<=A[i]; j++){
        		if(j+i < A.length)
        			dp[j+i] = Math.min(dp[j+i], dp[i]+1);
        	}
        }
    	return dp[A.length-1];
    }

	//Time Limit Exceeded
    public static int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A == null || A.length == 0)
    		return 0;
        int[] dp = new int[A.length];
        dp[0] = 0;
        for(int i=1; i<A.length; i++){
        	int min = Integer.MAX_VALUE;
        	for(int j=0; j<i; j++){
        		if(j+A[j]>= i)
        			min = Math.min(min, dp[j]+1);
        	}
        	dp[i] = min;
        }
    	return dp[A.length-1];
    }
}
