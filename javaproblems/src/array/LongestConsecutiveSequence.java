package array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input  = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(input));
	}
	
    public static int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(num == null || num.length == 0)
    		return 0;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i:num){
    		map.put(i, 1);
    	}
    	int res =0;
    	for(int i:num){
    		int max = 1;
    		int offset = 1;
    		while(map.containsKey(i+offset)){
    			map.remove(i+offset);
    			offset++;
    		}
    		offset--;
    		max += offset;
    		offset = -1;
    		while(map.containsKey(i+offset)){
    			map.remove(i+offset);
    			offset--;
    		}
    		offset++;
    		max -= offset;
    		res = Math.max(res, max);
    	}
    	
    	return res;
    }

}
