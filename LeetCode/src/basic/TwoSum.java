package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/**
	 *     //start: 6:02 pm.
    //end: 6:15 pm
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {150,24,79,50,88,345,3};
		System.out.println(Arrays.toString(twoSum(input, 200)));
	}
	
    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] res = new int[2];
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i=0; i<numbers.length; i++){
    	   if(map.containsKey(target - numbers[i])){
    		   res[0] = map.get(target-numbers[i]);
    		   res[1] = i;
    	   }
    	   map.put(numbers[i], i);
       }
       return res;
    }
	
	//the index was not included in this solution.
    public static int[] twoSumV1(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int[] res  = new int[2];
        int si = 0; 
        int ei = numbers.length-1;
        while(si<ei){
            if(numbers[si]+numbers[ei]>target){
                ei--;
            }else if(numbers[si] + numbers[ei] <target){
                si++;
            }else{
                res[0] = si+1;
                res[1] = ei+1;
                return res;
            }
        }
        return res;
    }
}
