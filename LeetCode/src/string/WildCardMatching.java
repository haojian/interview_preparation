package string;

public class WildCardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		String p = "a*";
		System.out.println(isMatch(s, p));
	}

    public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //return isMatchRecur(s, p, 0, 0);
    	return isMatchDP(s, p);
    }
    
    
    //Memory Limit Exceeded
    public static boolean isMatchDP(String s, String p){
    	//dp[i][j] means the if the subString 0-i match with 0-j (i & j are not included).
    	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    	dp[0][0] = true;
    	boolean flag = true;
    	for(int i=1; i<p.length()+1; i++){
    		if(flag && p.charAt(i-1) == '*'){
    			dp[0][i] = true;
    		}
    		else
    			flag = false;
    	}
    	for(int i=1; i<s.length()+1; i++){
    		dp[i][0] = false;;
    	}
    	
    	for(int j=1; j<p.length()+1;j++){
    		for(int i=1; i<s.length()+1; i++){
    			if((s.charAt(i-1) == p.charAt(j-1) ||p.charAt(j-1) =='?') && dp[i-1][j-1] == true)
    				dp[i][j] = true;
    			else if(p.charAt(j-1) == '*'){
    				dp[i][j] = dp[i-1][j] || dp[i][j-1];
    			}
    			else{
    				dp[i][j] = false;
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
    
    
    //time limit exceedid
    public static boolean isMatchRecur(String s, String p, int si, int pi){
    	if(si >= s.length() && pi >= p.length())
    		return true;
    	else if(si >= s.length() || pi >= p.length()){
    		if(pi!=p.length()){
    			for(int i=pi; i<p.length(); i++){
    				if(p.charAt(i)!= '*')
    					return false;
    			}
    			return true;
    		}
    		return false;
    	}
    	else{
    		if(p.charAt(pi) == '*'){
    			return isMatchRecur(s, p, si+1, pi+1) || isMatchRecur(s, p, si+1, pi) || isMatchRecur(s, p, si, pi+1);
    		}else if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'){
    			return isMatchRecur(s, p, si+1, pi+1);
    		}else
    			return false;
    	}
    }
}
