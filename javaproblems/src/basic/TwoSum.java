package basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	
	/**
	 * 
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5, 75, 25};
		int[] res = twoSum(a, 100);
		System.out.println(res[0] + "\t" + res[1]);
	}

    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for(int tmp:numbers){
            index++;
            if(map.containsKey(target-tmp)){
                int []res = new int[2];
                res[0] = map.get(target-tmp);
                res[1] = index;
                    
                return res;
            }
            else{
                map.put(tmp, index);
            }
        }
        return null;
    }
}
