package combinatorics;

import java.util.ArrayList;

public class Permutation {

	/**
	 * 
	 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3};
		System.out.println(permute(a));
	}
	
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> curPermu = new ArrayList<Integer>();
    	generatePermutation(num, 0, curPermu, res);
    	return res;
    }
    
    public static void generatePermutation(int[] num, int depth, ArrayList<Integer> curPermu, ArrayList<ArrayList<Integer>> res){
    	if(depth == num.length){
    		res.add(curPermu);
    	}else{
    		for(int i=depth; i<num.length; i++){
    			swap(num, depth, i);
    			ArrayList<Integer> tmp = (ArrayList<Integer>)curPermu.clone();
    			tmp.add(num[depth]);
    			generatePermutation(num, depth+1, tmp, res);
    			swap(num, depth, i);
    		}
    	}
    }
    
    public static void swap(int[] num, int si, int ei){
    	int tmp = num[si];
    	num[si] = num[ei];
    	num[ei] = tmp;
    }

}
