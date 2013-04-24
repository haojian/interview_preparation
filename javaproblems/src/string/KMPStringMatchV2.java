package string;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPStringMatchV2 {

	/**
	 * 
	 * Example for understanding "baabdbaabe"
	 * 
	 * 
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
        int hi = 0;
        int ni = 0;
        int[] next = getNext(needle);

        while(hi<haystack.length() && ni<needle.length()){
        	if(haystack.charAt(hi) == needle.charAt(ni)){
        		hi++;
        		ni++;
        	}
        	else{
        		if(ni==0)
        			hi++;
        		else
        			ni = next[ni-1]+1;
        	}
        }
        if(hi == haystack.length())
        	return null;
        return haystack.substring(hi-needle.length());
    }                                                                                                                                                
    
    public static int[] getNext(String pattern){
    	int[] res = new int[pattern.length()];
		res[0] = -1;
		for(int i=1; i<pattern.length(); i++){
			int k = res[i-1];
			while(pattern.charAt(i) != pattern.charAt(k+1) && k>=0){
				k = res[k];
			}
			if(pattern.charAt(i) == pattern.charAt(k+1))
				res[i] = k+1;
			else
				res[i] = -1;
		}
		return res;
    }
}
