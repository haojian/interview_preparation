package predict;

public class LargestContiguousSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-10, 2, 3, -2, 5, -15};
		System.out.println(largestContiguousSum(input));
	}

	public static int largestContiguousSum(int[] A){
		if(A== null || A.length == 0)
			return 0;
		
		int[] dp = new int[A.length];
		int max = A[0];
		dp[0] = A[0];
		for(int i=1; i<A.length; i++){
			dp[i] = Math.max(dp[i-1]+A[i], A[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
