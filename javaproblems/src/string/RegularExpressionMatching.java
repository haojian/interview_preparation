package string;

public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("aa",".*"));
		System.out.println(isMatch("ab",".*"));
		System.out.println(isMatch("aab","c*a*b"));

	}

    public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
     
    	int si = 0;
    	int pi = 0;
    	while(si != s.length()-1 && pi != s.length()-1){
    		if(pi< p.length()-1 && p.charAt(pi+1) == '*'){
    			if(p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.')
    				si++;
    			else
    				pi+=2;
    		}
    		else{
    			if(p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.')
    			{
    				pi++;
    				si++;
    			}else
    				return false;
    		}
    	}
    	
    	if(si == s.length() -1 && pi == p.length() -1)
    		return true;
    	else
    		return false;
    }
}
