package basic;

import java.util.Arrays;

public class ThreeClosestSum {

	/** 
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.

    	The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(num, 1));
	}
	
    public static int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Arrays.sort(num);
    	int minDistance = Integer.MAX_VALUE;
    	int res = Integer.MAX_VALUE;
    	for(int i = 0 ; i< num.length; i++){
    		
    		
    		int j = i+1;
    		int k = num.length-1;
    		while(j<k){
    			int distance = num[i]+num[j]+num[k]-target;
    			if(distance<0){
    				j++;
    			}else if(distance>0){
    				k--;
    			}else if(distance ==0)
    				return num[i]+num[j]+num[k];
    			if(minDistance > Math.abs(distance)){
    				minDistance = Math.abs(distance);
    				res =  num[i]+num[j]+num[k];
    			}
    			j++;
    			k--;
    		}
    	}
        return res;
    }

}
