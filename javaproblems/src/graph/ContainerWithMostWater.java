package graph;

public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4};
		System.out.println(maxArea(input));
	}
	
    public static int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int res = 0;
    	int si =0;
    	int ei = height.length-1;
    	while(si<ei){
    		int tmp = Math.min(height[si], height[ei]) * (ei-si);
    		if(tmp>res)
    			res = tmp;
    		if(height[si]<height[ei]){
    			si++;
    		}else{
    			ei--;
    		}
    	}
    	return res;
    }
	
    public static int maxAreaBruteForce(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int max = 0;
    	for(int i=0; i<height.length; i++){
    		for(int j = i+1;j<height.length; j++){
    			int minheight = Math.min(height[i], height[j]);
    			int tmp = (j-i) * minheight;
    			if(tmp>max)
    				max =tmp;
    		}
    	}
    	return max;
    }
    
    
    
}
