package graph;

import java.util.ArrayList;

public class Triangle {

	/**
	 * 
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(triangle.size() == 0)
    		return 0;
    	ArrayList<Integer> indexPath = new ArrayList<Integer>();
    	int[] minsum = new int[1];
    	indexPath.add(0);
    	minsum[0] = Integer.MAX_VALUE;
    	minimumTotalRecur(triangle, indexPath, triangle.get(0).get(0), minsum);
        return minsum[0];
    }
    
    public void minimumTotalRecur(ArrayList<ArrayList<Integer>> triangle, ArrayList<Integer> indexPath, int cursum, int[] minsum){
    	if(triangle.size() == indexPath.size()){
    		minsum[0] = Math.min(cursum, minsum[0]);
    		return;
    	}else{
    		int lastIndex = indexPath.get(indexPath.size()-1);
    		ArrayList<Integer> curRow = triangle.get(indexPath.size());
    		for(int i=lastIndex; i<=lastIndex+1;i++){
    			indexPath.add(i);
    			int tmp = curRow.get(i)+cursum;
    			minimumTotalRecur(triangle, indexPath, tmp, minsum);
    			indexPath.remove(indexPath.size()-1);
    		}
    	}
    }
}
