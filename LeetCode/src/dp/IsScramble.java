package dp;

import java.util.HashMap;
import java.util.Map;

public class IsScramble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("rgtae", "great"));
	}

	
    public static boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s1.length() != s2.length()) return false;
    	int[] map = new int[256];
    	for(int i=0; i<s1.length(); i++)
    		map[s1.charAt(i)-'a']++;
    	for(int i=0; i<s1.length(); i++)
    		map[s2.charAt(i)-'a']--;
    	for(int i=0; i<256; i++){
    		if(map[i] != 0)
    			return false;
    	}
    	if(s1.length() == 1 && s2.length() ==1)	return true;
    	for(int i=1; i<s1.length(); i++){
    		boolean case1 = isScramble(s1.substring(0,i), s2.substring(0, i))
    				&& isScramble(s1.substring(i,s1.length()), s2.substring(i, s2.length()));
    		case1 = case1 || (isScramble(s1.substring(0,i), s2.substring(s2.length()-i, s2.length()))
    				&& isScramble(s1.substring(i,s1.length()), s2.substring(0,s2.length()-i)));
    		if(case1)
    			return true;
    	}
    	return false;
    }
    

}
