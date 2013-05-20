package string;

import java.util.ArrayList;
import java.util.Arrays;

public class WildCardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String p = "*?*?*?*?";
		System.out.println(isMatch(s, p));
	}

    public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //return isMatchRecur(s, p, 0, 0);
    	//return isMatchDP(s, p);
    	return isMatchGreedy(s, p);
    }
    
    public static boolean isMatchGreedy(String s, String p){
    	if(p.length() == 0) return p.length() == s.length();
    	int psi = 0; 
    	int ssi = 0; 
    	
    	while(ssi<s.length() && psi<p.length() && p.charAt(psi)!='*'){
    		if(s.charAt(ssi) == p.charAt(psi) || p.charAt(psi) == '?')
    		{
    			ssi++;
    			psi++;
    		}else
    			return false;
    	}
    	s= s.substring(ssi);
    	p = p.substring(psi);
    	int sei = s.length()-1;
    	int pei = p.length()-1;
    	while(sei>=0 && pei>=0 && p.charAt(pei) != '*'){
    		if(s.charAt(sei) == p.charAt(pei) || p.charAt(pei) == '?')
    		{
    			sei--;
    			pei--;
    		}else
    			return false;
    	}
    	s= s.substring(0, sei+1);
    	p=p.substring(0, pei+1);
    	
    	System.out.println(s+"\n"+p);
    	String[] pstrs = p.split("[*]");
    	for(String pstr:pstrs){
    		if(pstr.length() == 0)
    			continue;
    		int index = findFirstIndex(s, pstr);
    		if(index == -1)
    			return false;
    		s = s.substring(index+pstr.length());
    	}
    	if(!p.endsWith("*") && s.length() != 0)
    		return false;
    	return true;

    }
    
    public static int findFirstIndex(String s, String p){
    	int si = 0;
    	int pi = 0;
    	while(si<=s.length()-p.length() && pi<p.length()){
    		int offset = 0;
    		for(offset = 0; offset <p.length(); offset++){
    			if(s.charAt(offset+si) != p.charAt(offset+pi) && p.charAt(offset+pi)!='?')
    				break;
    		}
    		if(offset==p.length())
    			return si;
    		si++;
    	}
    	return -1;
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
