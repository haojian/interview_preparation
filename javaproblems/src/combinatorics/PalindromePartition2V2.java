package combinatorics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartition2V2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		System.out.println(minCutV2("ababbbabbababa"));
		//System.out.println(minCutV2("ababbbabbaba"));
		//System.out.println(minCutV2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	
	
	public static int minCutV2(String s){
		long time = System.currentTimeMillis();
		if(s==null || s.length() == 0)
			return 0;
    	Map<Integer, Map<Integer, Boolean>> palindromeMap = new HashMap<Integer, Map<Integer, Boolean>>();

    	int[] minCuts = new int[s.length()];
    	minCuts[0] = 0;
    	for(int i=1; i<s.length();i++){
    		if(isPalindromeV1(s, 0, i+1, palindromeMap)){
    			minCuts[i] = 0;
    			continue;
    		}
    		int min = Integer.MAX_VALUE;
    		for(int j=1; j<=i; j++){
    			if(isPalindromeV1(s, j, i+1,palindromeMap)){
    				if(min> minCuts[j-1]+1){
    					min = minCuts[j-1]+1;
    					minCuts[i] = min;
    					if(minCuts[j-1] == 0)
    						break;
    				}
    			}
    		}
    	}
    	time = System.currentTimeMillis()-time;
    	System.out.println(Arrays.toString(minCuts));
    	System.out.println(counter);
    	System.out.println(time);
    	return minCuts[s.length()-1];
	}

    public static int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	Map<Integer, Map<Integer, Boolean>> palindromeMap = new HashMap<Integer, Map<Integer, Boolean>>();
    	int[] minCuts = new int[s.length()];
    	int[] palindrStartIndexEndingHere = new int[s.length()];
    	minCuts[0] = 0;
    	palindrStartIndexEndingHere[0] = 0;
    	boolean ifFounded = false;
    	for(int i=1; i<s.length(); i++){
    		if(i==3)
    			System.out.println("debugged");
    		int min = Integer.MAX_VALUE;
    		for(int j=i-1; j>=0; j--){
    	    	int curCut = Integer.MAX_VALUE;
    			if(isPalindrome(s, palindrStartIndexEndingHere[j], i+1, palindromeMap)){
    				curCut = minCuts[j];
    				ifFounded = true;
    			}
    			if(curCut<min){
    				min = curCut;
    				minCuts[i] = curCut;
    				palindrStartIndexEndingHere[i] = palindrStartIndexEndingHere[j];
    			}
    				
    		}
    		if(!ifFounded){
    			minCuts[i] = minCuts[i-1]+1;
    			palindrStartIndexEndingHere[i] = i;
    		}
    		ifFounded = false;
    	}
    	System.out.println(Arrays.toString(minCuts));
    	System.out.println(Arrays.toString(palindrStartIndexEndingHere));
    	return minCuts[s.length()-1];
    }
    
    static int counter = 0;
    //ei is not included.
    public static boolean isPalindromeV1(String s, int si, int ei, Map<Integer, Map<Integer, Boolean>> palindromeMap){
    	if(ei-si == 1|| ei<=si)
    		return true;
    	if(palindromeMap.containsKey(si) && palindromeMap.get(si).containsKey(ei)){
    		//System.out.println(si+" "+ ei);
    		counter++;
    		return palindromeMap.get(si).get(ei);
    	}
    	
    	if(!palindromeMap.containsKey(si)){
			palindromeMap.put(si, new HashMap<Integer, Boolean>());
		}
    	if(isPalindromeV1(s, si+1, ei-1, palindromeMap)){
    		if(s.charAt(si) == s.charAt(ei-1)){
    			palindromeMap.get(si).put(ei, true);
    	    	return true;
    			
    		}else{
    			palindromeMap.get(si).put(ei, false);
    			return false;
    		}
    		
    	}
    	palindromeMap.get(si).put(ei, false);
    	return false;
    }
    
    
    //ei is not included.
    public static boolean isPalindrome(String s, int si, int ei, Map<Integer, Map<Integer, Boolean>> palindromeMap){
    	if(palindromeMap.containsKey(si) && palindromeMap.get(si).containsKey(ei)){
    		System.out.println(si+" "+ ei);
    		return palindromeMap.get(si).get(ei);
    	}
    	int sicpy = si;
    	int eicpy = ei;
    	if(!palindromeMap.containsKey(sicpy)){
			palindromeMap.put(sicpy, new HashMap<Integer, Boolean>());
		}
    	ei--;
    	while(si<ei){
    		if(s.charAt(si) == s.charAt(ei)){
    			si++;
    			ei--;
    		}
    		else{
    			palindromeMap.get(sicpy).put(eicpy, false);
    			return false;
    		}
    	}
    	palindromeMap.get(sicpy).put(eicpy, true);
    	return true;
    }
}
