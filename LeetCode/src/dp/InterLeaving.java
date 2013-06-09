package dp;

public class InterLeaving {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleavedp("aabcc", "dbbca", "aadbbcbcac"));
	}

	public static boolean isInterleavedp(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((s1.length() + s2.length()) != s3.length())
        	return false;
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=1; i<=s1.length(); i++){
        	if(s1.charAt(i-1) == s3.charAt(i-1))
        		dp[i][0] = true;
        	else
        		break;
        }
        for(int i=1; i<=s2.length(); i++){
        	if(s2.charAt(i-1) == s3.charAt(i-1))
        		dp[0][i] = true;
        	else
        		break;
        }
        
        for(int i=1; i<=s1.length(); i++){
        	for(int j=1; j<=s2.length(); j++){
        		dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
        				|| (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
        	}
        }
        return dp[s1.length()][s2.length()];
    }
	
    public static boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((s1.length() + s2.length()) != s3.length())
        	return false;
        return isInterleaveRecur(s1, s2, s3, 0, 0, 0);
    }
    
    public static boolean isInterleaveRecur(String s1, String s2, String s3, int s1i, int s2i, int s3i){
    	if(s1i == s1.length() && s2i == s2.length() && s3i == s3.length())
    		return true;
    	
    	boolean res = false;
    	if(s1i<s1.length() && s1.charAt(s1i) == s3.charAt(s3i)){
    		 res = isInterleaveRecur(s1, s2, s3, s1i+1, s2i, s3i+1);
    	}
    	if(s2i <s2.length() && s2.charAt(s2i) == s3.charAt(s3i)){
    		res = res || isInterleaveRecur(s1, s2, s3, s1i, s2i+1, s3i+1);
    	}
    	return res;
    }
	
}
