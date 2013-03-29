package string;

import java.util.Arrays;

public class LongestUniqueSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(test));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		 int[] hash = new int[256];
	     Arrays.fill(hash, -1);
	     int maxres = 0;
	        int curmax = 0;
	        int cursi = 0;
	        for(int i = 0; i<s.length();i++){
	            int val = s.charAt(i);
	            if(hash[val] == -1){
	                hash[val] = i;
	            	curmax++;
	            }else{
	            	maxres = maxres>curmax?maxres:curmax;
	            	curmax = i-hash[val];
	            	for(int j = cursi; j<hash[val];j++){
	            		hash[s.charAt(j)] = -1;
	            	}
	                cursi = hash[val]+1;
	            	hash[val] = i;
	            }
	        }
	        maxres = maxres>curmax?maxres:curmax;
			return maxres;
	}
}
