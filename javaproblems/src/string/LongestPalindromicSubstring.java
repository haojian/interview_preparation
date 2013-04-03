package string;


/*Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "bananas";
		System.out.println(longestPalindrome(test));
		reverseString(test);
	} 
	
	public static String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String maxsubstr = "";
    	String reverse = reverseString(s);
    	
    	String longestCommon[][] = new String[s.length()+1][s.length()+1];
    	for(int i = 0 ; i<s.length();i++){
    		for(int j = 0 ; j<reverse.length(); j++){
    			if(longestCommon[i][j] == null)
    				longestCommon[i][j] = "";
    			if(s.charAt(i) == reverse.charAt(j)){
    				longestCommon[i+1][j+1] = longestCommon[i][j] + s.charAt(i);
    				
    				if(longestCommon[i+1][j+1].length()>maxsubstr.length() && ifPalindrome(longestCommon[i+1][j+1]) ){
    					maxsubstr = longestCommon[i+1][j+1];
    				}
    			}
    		}
    	}
    	return maxsubstr;
    }
    
	
	public static boolean ifPalindrome(String s){
		int si = 0;
    	int ei = s.length()-1;
		while(si < ei){
			if(s.charAt(si) != s.charAt(ei))
				return false;
			si++;
			ei--;
		}
		return true;
	}
	
    
    public static String reverseString(String s){
    	char[] sarray = s.toCharArray();
    	int si = 0;
    	int ei = s.length()-1;
    	while(si<ei){
    		if(sarray[si] != sarray[ei]){
        		sarray[si] = (char) (sarray[si] ^ sarray[ei]);
        		sarray[ei] = (char) (sarray[si] ^ sarray[ei]);
        		sarray[si] = (char) (sarray[si] ^ sarray[ei]);
    		}
    		si++;
    		ei--;
    	}
    	return new String(sarray);
    }
}
