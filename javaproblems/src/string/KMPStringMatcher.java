package string;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPStringMatcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(getNext("issip")));
		System.out.println(strStr("mississippi", "issip"));
	}
	
	public static String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle == null || needle.length() == 0)
        	return haystack;
        if(haystack == null)
        	return null;
        int hi = 0;
        int ni = 0;
        int[] next = getNext(needle);
        while(hi<haystack.length() && ni<needle.length()){
        	if(haystack.charAt(hi) == needle.charAt(ni)){
        		hi++;
        		ni++;
        	}	
        	else{
        		if(ni == 0)
        			hi++;
        		else
        			ni = next[ni-1]+1;
        	}
        }
        if(hi == haystack.length())
        	return null;

        
        else
        	return haystack.substring(hi-needle.length());
    }
    
    public static int[] getNext(String pattern){
    	int[] next =new int[pattern.length()];
    	next[0] = -1;
    	for(int i=1; i<next.length; i++){
    		int k = next[i-1];
    		while(pattern.charAt(k+1) != pattern.charAt(i) && k>=0){
    			k = next[k];
    		}
    		if(pattern.charAt(i) == pattern.charAt(k+1))
    			next[i] = k +1;
    		else
    			next[i] = -1;
    	}
    	return next;
    }
}
