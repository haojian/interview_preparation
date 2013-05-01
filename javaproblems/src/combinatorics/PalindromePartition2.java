package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PalindromePartition2 {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCutv2("cdd"));
	}
	
	public static int minCutv2(String s){
		if(s==null || s.length()==0)
			return 0;
		int[] mincuts = new int[s.length()];
		int[] palindStartIndexEndhere = new int[s.length()];
		mincuts[0] =0;
		palindStartIndexEndhere[0] = 0;
		for(int i=1; i<s.length(); i++){
			if(isPalindrome(s.substring(0, i+1))){
				mincuts[i] = 0;
				palindStartIndexEndhere[i] = 0;
			}else{
				int min = Integer.MAX_VALUE;
				for(int j=0; j<i; j++){
					int curCut = Integer.MAX_VALUE;
					if(isPalindrome(s.substring(palindStartIndexEndhere[j], i+1))){
						curCut = mincuts[j];
					}
					if(curCut < min){
						min = curCut;
						palindStartIndexEndhere[i] = palindStartIndexEndhere[j];
						mincuts[i] = min;
					}
				}
				if(min == Integer.MAX_VALUE){
					mincuts[i] = mincuts[i-1]+1;
					palindStartIndexEndhere[i] = i;
				}
			}
			
		}
    	System.out.println(Arrays.toString(mincuts));
    	return mincuts[s.length()-1];
	}
	
    public static int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	int[] cuts = new int[s.length()];
    	int[] palindIndexEndhere = new int[s.length()];
    	cuts[0] = 0;
    	palindIndexEndhere[0] = 0;
    	for(int i=1; i<s.length(); i++){
    		String candidate = s.substring(palindIndexEndhere[i-1], i+1);
    		if(isPalindrome(candidate))
    			cuts[i] = cuts[i-1];
    		else{
    			int min = Integer.MAX_VALUE;
    			
    			for(int j=0; j<=i;j++){
    				if(j==0 && isPalindrome(s.substring(j, i+1))){
    						min = 0;
    						cuts[i] = min;
    						palindIndexEndhere[i] =  j;
    				}
    				else if(isPalindrome(s.substring(j+1, i+1))){
    					if(min > cuts[j]+1){
    						min = cuts[j]+1;
    		    			cuts[i] = min;
    		    			palindIndexEndhere[i] =  j;
    					}
    				}
    			}
    		}
    	}
    	System.out.println(Arrays.toString(cuts));
    	return cuts[s.length()-1];
    }
    

    
    public static boolean isPalindrome(String input){
    	if(input.length() == 0)
    		return false;
    	int si=0;
    	int ei = input.length()-1;
    	while(si<ei){
    		if(input.charAt(si) != input.charAt(ei))
    			return false;
    		else
    		{
    			si++;
    			ei--;
    		}
    	}
    	return true;
    }
}
