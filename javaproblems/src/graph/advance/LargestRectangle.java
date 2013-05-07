package graph.advance;

public class LargestRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 1, 5, 6, 2 ,3};
		System.out.println(largestRectangleArea(input));
	}
	
	public static int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] minRight = new int[height.length];	//right ->left
        int[] minLeft = new int[height.length];   //left ->right
        int tmp = Integer.MAX_VALUE;
        for(int i=0; i< height.length; i++){
            minLeft[i] = Math.min(height[i], tmp);
            tmp = minLeft[i];
        }
        tmp = Integer.MAX_VALUE;
        for(int i=height.length-1; i>=0; i--){
            minRight[i] = Math.min(height[i], tmp);
            tmp = minRight[i];
        }
        
        int si = 0;
        int ei = height.length-1;
        int res = 0;
        while(si<ei){
            int curheight = Math.min(minRight[si], minLeft[ei]);
            int curArea = (ei-si+1) * curheight;
            res = Math.max(res, curArea);
            int offset = 0;
            while(si+offset<ei && height[si+offset] <= curheight){
                offset++;
            }
            si+= offset;
            if(offset == 0){
            	while(ei-offset> si && height[ei-offset] <= curheight){
            		offset++;
            	}
            	ei-= offset;
            }
            if(offset == 0){
            	ei--;
            }
        }
        
        return res;
    }
}
