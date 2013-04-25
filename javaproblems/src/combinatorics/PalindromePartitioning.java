package combinatorics;

import java.util.ArrayList;
import java.util.Collections;

public class PalindromePartitioning {

	/**
	 * 
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("cdd"));
	}
	
	
    public static ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	partitionRecur(s, s.length(), new ArrayList<String>(), res);
    	return res;
    }

    public static void partitionRecur(String s, int si, ArrayList<String> curList, ArrayList<ArrayList<String>> res){
    	if(si == 0){
    		ArrayList<String> copy = (ArrayList<String>)curList.clone();
    		Collections.reverse(copy);
    		res.add(copy);
    		return;
    	}
    	else{
    		for(int i = 0; i<si; i++){
    			if(isPalindrome(s.substring(i, si))){
    				curList.add(s.substring(i,si));
    				//ArrayList<String> tmp = (ArrayList<String>)curList.clone();
    				//tmp.add(s.substring(i,si));
    				partitionRecur(s, i, curList, res);
    				curList.remove(curList.size()-1);
    			}
    		}
    	}
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
