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
		System.out.println(isMatch("a", "ab*"));
		System.out.println(isMatch("ab", ".*c"));
	}

	public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return isRecursiveMatch(s, p, 0, 0);
    }
	
	public static boolean isRecursiveMatch_v1(String s, String p, int si, int pi){
		return false;
	}
	
	
	//four cases:
	//1. s finished; p processed => true
	//2. s not finish; p finished => false;
	//3. s finished; p not finished => depends on if p end with *
	//4. s not finish and p not finish => depends on if match. and write recursive function for "*";
	public static boolean isRecursiveMatch(String s, String p, int si, int pi){
		if(s.length() == si && pi == p.length())
			return true;
		if(pi == p.length() && si != s.length())
			return false;
		if(pi != p.length() && si == s.length()){
			if(pi<p.length()-1 && p.charAt(pi+1) == '*')
				return isRecursiveMatch(s, p, si, pi+2);
			else
				return false;
		}
		 if(pi<p.length()-1 && p.charAt(pi+1) == '*'){
			 while( si< s.length()  && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) =='.')){
				 if(isRecursiveMatch(s, p, si, pi+2))
					 return true;
				 si++;
			 }
			 return isRecursiveMatch(s, p, si, pi+2);
		 }else{
			 if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) =='.'){
				 pi++;
				 si++;
				 return isRecursiveMatch(s, p, si, pi);
			 }else
				 return false;
		 }
	}
	
	/*
    public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int si = 0;
    	int pi = 0;
    	while(si < s.length() && pi < p.length()){
    		if(pi<p.length()-1 && p.charAt(pi+1) == '*')
    		{
    			while(si <s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) =='.'))
    				si++;
    			pi+=2;
    		}else{
    			if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) =='.')
    			{
    				pi++;
    				si++;
    			}else{
    				return false;
    			}
    		}
    	}
    	if(si==s.length() && pi==p.length())
    		return true;
    	return false;
    }*/
}
