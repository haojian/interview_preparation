package combinatorics;

import java.util.ArrayList;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 2));
	}
	
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> singleRes = new ArrayList<Integer>();
    	combineRecur(n, k, singleRes, res);
    	return res;
    }
    
    
    public static void combineRecur(int n, int k, ArrayList<Integer> singleRes, ArrayList<ArrayList<Integer>> res){
    	if(k == 0){
    		res.add((ArrayList<Integer>)singleRes.clone());
    		return;
    	}
    	int minValue = singleRes.size()==0? 1:singleRes.get(singleRes.size()-1) + 1;
    	for(int i=minValue; i<=n; i++){
    		singleRes.add(i);
    		combineRecur(n, k-1, singleRes, res);
    		singleRes.remove(singleRes.size()-1);
    	}
    }

}
