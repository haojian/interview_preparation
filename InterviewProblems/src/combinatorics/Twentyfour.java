package combinatorics;

import java.util.Arrays;
import java.util.Random;

public class Twentyfour {

	/**
	 * 
	 * One proble need to clarify is how to define 7/6.
	 * 7/6 =1 in current case.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[4];
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(10)+1;
		}
		System.out.println(Arrays.toString(num));
		boolean res = false;
		for(int i=0; i<num.length; i++){
			swap(num, 0, i);
			res = combRecur(num, 1, num[0], 24);
			if(res){
				System.out.println("found");
				return;
			}
			swap(num, 0, i);
		}
		System.out.println("none");
	}
	
	public static boolean combRecur(int[] input, int si, int curres, int target){
		if(curres == target && si == input.length)
			return true;
		if(si == input.length)
			return false;
		for(int i=si; i<input.length; i++){
			swap(input, si, i);
			if(combRecur(input, si+1, curres + input[si], target) ||
			combRecur(input, si+1, curres - input[si], target) ||
			combRecur(input, si+1, curres * input[si], target) ||
			combRecur(input, si+1, curres / input[si], target))
				return true;
			swap(input, si, i);
		}
		return false;
	}
	
	public static void swap(int[] input, int si, int ei){
		int tmp = input[si];
		input[si] = input[ei];
		input[ei] = tmp;
	}

}
