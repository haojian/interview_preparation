package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSum {

	/**
	 * 
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, , ak) must be in non-descending order. (ie, a1 ? a2 ?? ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2, 3, 6, 7};
		System.out.println(combinationSum(candidates, 7));
	}

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Arrays.sort(candidates);
    	HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
        combinationSumRecursive(candidates, target, tmp, hash, 0);
        return new ArrayList<ArrayList<Integer>>(hash);
    }
    
    
    public static void combinationSumRecursive(int[] candidates, int target, ArrayList<Integer> result, HashSet<ArrayList<Integer>> hash, int startIndex) {
    	if(target == 0){
    		ArrayList<Integer> tmp = (ArrayList<Integer>) result.clone();
    		hash.add(tmp);
    	}else if(target < 0)
    	{
    		return;
    	}
    	else{
    		for(int i=startIndex; i< candidates.length; i++){
    			result.add(candidates[i]);
    			combinationSumRecursive(candidates, target-candidates[i], result, hash, i);
    			result.remove(result.size()-1);
    		}
    	}
    }
}
