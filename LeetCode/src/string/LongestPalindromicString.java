package string;

import java.util.Arrays;

public class LongestPalindromicString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abaaba"));
	}

    public static String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String scpy = encode(s);
    	int C = 0;
        int R = 0;
        int[] P = new int[scpy.length()];
        P[0] = 0;
        P[scpy.length()-1] = 0;
        for(int i=1;i<scpy.length()-1; i++){
        	int i_mirror = C*2-i;
        	P[i] = (R>i)? Math.min(R-i, P[i_mirror]):0;
        	while(i-P[i]-1>=0 && i+P[i]+1<=scpy.length()-1 && scpy.charAt(i-P[i]-1) == scpy.charAt(i+P[i]+1))
        	{
        		P[i]++;
        	}
        	if(i+P[i]>R){
        		C=i;
        		R = i+P[i];
        	}
        }
        System.out.println(Arrays.toString(P));
        int centeri = -1;
        int max = -1;
        for(int i=0; i<P.length; i++){
        	if(P[i]>max){
        		max = P[i];
        		centeri = i;
        	}
        }
        int si = (centeri-max)/2;
        
        return s.substring(si, si+max);
    }
    
    public static String encode(String s){
    	String res = "#";
    	for(int i=0; i<s.length(); i++){
    		res += s.charAt(i)+"#";
    	}
    	return res;
    }
}
