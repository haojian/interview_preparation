package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2V2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 2};
		System.out.println(subsetwithDup(num));
	}

	public static ArrayList<ArrayList<Integer>> subsetwithDup(int[] num){
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curList = new ArrayList<Integer>();
		subsetRecur(num, 0, curList, res);
		return res;
	}
	
	public static void subsetRecur(int[] num, int si, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> res){
		res.add((ArrayList<Integer>)curList.clone());
		for(int i= si;i<num.length; i++){
			if(i==si || num[i]!=num[i-1]){
				curList.add(num[i]);
				subsetRecur(num, i+1, curList, res);
				curList.remove(curList.size()-1);
			}
		}
	}
}
