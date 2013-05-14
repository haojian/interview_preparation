package combinatorics;

import java.util.ArrayList;

public class PermutationWithDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 2};
		System.out.println(permuteUnique(a));
	}

	
	 public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
		 ArrayList<Integer> tmp = new ArrayList<Integer>();
		 permuteGeneration(num, 0, tmp, res);
		 return res;
	 }
	 
	 public static void permuteGeneration(int[] num, int depth, ArrayList<Integer> curPermu, ArrayList<ArrayList<Integer>> res){
		 if(depth == num.length){
			 res.add(curPermu);
		 }else{
			 for(int i=depth; i<num.length; i++){
				if(checkIfSwap(num, depth, i)){
					swap(num, depth, i);
					ArrayList<Integer> tmp = (ArrayList<Integer>)curPermu.clone();
					tmp.add(num[depth]);
					permuteGeneration(num, depth+1, tmp, res);
					swap(num, depth, i);
				}
			 }
		 }
	 }
	 
	 public static boolean checkIfSwap(int []num, int si, int ei){
		 for(int i=si; i<ei; i++){
				if(num[i] == num[ei])
					return false;
			}
		return true;
	 }
	 
	 public static void swap(int[] num, int si, int ei){
		int tmp = num[si];
		num[si] = num[ei];
		num[ei] = tmp;
	 }
}
