package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {-3,-1,0,2,4,5};
		System.out.println(fourSum(s, 1));
	}
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        for(int i=0; i<num.length;i++){
        	if(!map.containsKey(num[i])){
        		map.put(num[i], new ArrayList<Integer>());
        	}
        	map.get(num[i]).add(i);
        }
        	
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        fourSumRecur(num, 0, num.length, tmp, res, target);
        return res;
    }
    
	static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    public static boolean ifInRange(ArrayList<Integer> list, int si, int ei){
    	for(int i:list){
    		if(i>=si && i<ei)
    			return true;
    	}
    	return false;
    }
    
    public static void fourSumRecur(int[] num, int si, int ei,ArrayList<Integer> curList,ArrayList<ArrayList<Integer>> res, int target){
    	if(curList.size() == 3){
    		int sum = getSum(curList);
    		if(map.containsKey(target - sum) && ifInRange( map.get(target - sum), si, ei)){
    			curList.add(target - sum);
    			res.add(curList);
    		}
    	}
    	else{
    		if(getSum(curList)>target)
    			return;
    		for(int i = si;i<ei;i++){
    			ArrayList<Integer> tmp = (ArrayList<Integer>)curList.clone();
    			tmp.add(num[i]);
    			fourSumRecur(num, i+1, ei, tmp, res, target);
    		}
    	}
    }
    
    public static int getSum(ArrayList<Integer> input){
    	int res = 0; 
    	for(Integer i: input)
    		res += i;
    	return res;
    }
}
