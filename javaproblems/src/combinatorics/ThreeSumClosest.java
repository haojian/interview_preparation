package combinatorics;

public class ThreeSumClosest {

	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {-1, 2, 1, -4};
		System.out.println(threeSumClosestBruteForce(s, 1));
	}

    public static int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return 0;
    }
    
    public static int threeSumClosestV1(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return 0;
    }
	
    
    public static int threeSumClosestBruteForce(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(num==null || num.length == 0)
    		return 0;
    	int dist = Integer.MAX_VALUE;
    	int sum = 0;
    	for(int i=0; i<num.length;i++){
    		for(int j=i+1; j<num.length; j++){
    			for(int k=j+1; k<num.length;k++)
    			{
    				if(Math.abs(num[i]+num[k]+num[j]-target)<dist){
    					dist = Math.abs(num[i]+num[k]+num[j]-target);
    					sum = num[i]+num[k]+num[j];
    				}
    			}
    		}
    	}
        return sum;
    }
}
