package dp;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("sea","eat"));
	}
	
    public static int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[][] dp = new int[word1.length()+1][word2.length()+1];  //transfer A[1..i] => B[1..j]
    	dp[0][0]=0;
    	for(int i=0; i<word2.length(); i++){
    		dp[0][i+1] = i+1;
    	}
    	for(int i=0; i<word1.length(); i++){
    		dp[i+1][0] = i+1;
    	}
    	for(int i=1; i<=word1.length(); i++){
    		for(int j=1; j<=word2.length(); j++){
    			int replace = dp[i-1][j-1]+ (word1.charAt(i-1) == word2.charAt(j-1)?0:1);
    			int add = dp[i-1][j]+1;
    			int del = dp[i][j-1]+1;
    			dp[i][j] = Math.min(Math.min(replace, add), del);
    		}
    	}
    	return dp[word1.length()][word2.length()];
    }
}
