package combinatorics;

public class DistinctSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinctDP("rabbbit", "rabbit"));
	}

    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] counter= new int[1];
        numDistRecur(S, T, 0 , 0, counter);
        return counter[0];
    }
    
    public void numDistRecur(String s, String t, int si, int ti, int[] counter){
    	if(ti == t.length()){
    		counter[0]++;
    		return;
    	}
    	if(s.length()-si < t.length()- ti)
    		return;
    	if(s.charAt(si) != t.charAt(ti)){
    		numDistRecur(s, t, si+1, ti, counter);
    	}else{
    		numDistRecur(s, t, si+1, ti+1, counter);
    		numDistRecur(s, t, si+1, ti, counter);
    	}
    }
    
    
    public int numDistinctDP(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(S.length() == 0)
    		return 0;
    	if(T.length() == 0)
    		return 1;
    	int[][] dp = new int[T.length()+1][S.length()+1];
    	for(int i=0; i<T.length(); i++){
    		dp[i][0] = 0;
    	}
    	for(int j=0; j<S.length(); j++){
    		dp[0][j] = 1;
    	}
    	for(int i=1; i<=T.length(); i++){
    		for(int j=1; j<=S.length(); j++){
    			if(S.charAt(j-1) == T.charAt(i-1))
    				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
    			else
    				dp[i][j] = dp[i][j-1];
    		}
    	}
        return dp[T.length()][S.length()];
    }
}
