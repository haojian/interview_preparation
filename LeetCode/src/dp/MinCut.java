package dp;

import java.util.HashMap;
import java.util.Map;

public class MinCut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
	}
	
    public static int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] counter = new int[1];
    	Map<String, Boolean> map = new HashMap<String, Boolean>();
    	counter[0]= Integer.MAX_VALUE;
    	minCutRecur(s, 0, 0, counter, map);
    	return counter[0];
    }
    
    public static void minCutRecur(String s, int si, int curcut, int[] counter, Map<String, Boolean> map) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(curcut > counter[0])
    		return;
    	if(si == s.length()){
    		counter[0] = Math.min(counter[0], curcut-1);
    	}
    	/*
    	for(int i=s.length()-1; i>=si; i--){
    		if(isPalindrome(s, si, i, map))
        		minCutRecur(s, i+1, curcut+1, counter, map);
    	}
    	*/
    	
    	
    	for(int i=si; i<s.length(); i++){
        	if(isPalindrome(s, si, i, map))
        		minCutRecur(s, i+1, curcut+1, counter, map);
        }

    }
    
    //ei included
    public static boolean isPalindrome(String s, int si, int ei, Map<String, Boolean> map){
    	if(si>ei) return false;
    	String key = si + "_" + ei;
    	if(map.containsKey(key))	return map.get(key);
    	while(si<ei){
    		if(s.charAt(si) != s.charAt(ei)){
    			map.put(key, false);
    			return false;
    		}
    		si++;
    		ei--;
    	}
    	map.put(key, true);
    	return true;
    }
}
