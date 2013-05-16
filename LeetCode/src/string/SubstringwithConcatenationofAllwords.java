package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllwords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		System.out.println(findSubstring(S, L));
	}

	
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(L == null || L.length == 0)
    		return res;
        Map<String, Integer> wordsCounter = new HashMap<String, Integer>();
        for(String tmp:L){
        	if(!wordsCounter.containsKey(tmp))
        		wordsCounter.put(tmp, 0);
        	wordsCounter.put(tmp, wordsCounter.get(tmp)+1);
        }
        int n = L.length;
        int m = L[0].length();
        int si = 0;
        while(si<=S.length()-n*m){
        	Map<String, Integer> tmpCpy = new HashMap<String, Integer>(wordsCounter);
        	for(int j=0; j<n;j++){
        		String curFrag = S.substring(si+j*m, si+j*m+m);
        		if(tmpCpy.containsKey(curFrag)){
        			tmpCpy.put(curFrag, tmpCpy.get(curFrag)-1);
        			if(tmpCpy.get(curFrag) == 0)
        				tmpCpy.remove(curFrag);
        		}else
        			break;
        	}
        	if(tmpCpy.size() == 0)
        		res.add(si);
        	si++;
        }
        return res;
    }
}
