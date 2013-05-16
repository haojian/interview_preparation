package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(num, 8));
	}

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	combRecur(num, new ArrayList<Integer>(), res, target, 0);
    	return res;
    }
    
    public static void combRecur(int[] num, ArrayList<Integer> curList,  ArrayList<ArrayList<Integer>> res, int target, int si){
    	if(target == 0){
    		ArrayList<Integer> cpy = (ArrayList<Integer>)curList.clone();
    		if(!res.contains(curList))
    			res.add(cpy);
    	}
    	else if(target  <0){
    		return;
    	}else{
    		for(int i=si; i<num.length; i++){
    			curList.add(num[i]);
    			combRecur(num, curList, res, target-num[i], i+1);
    			curList.remove(curList.size()-1);
    		}
    	}
    }
}
