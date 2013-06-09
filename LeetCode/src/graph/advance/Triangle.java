package graph.advance;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(new ArrayList<Integer>());
		input.add(new ArrayList<Integer>());
		input.add(new ArrayList<Integer>());
		input.get(0).add(-1);
		input.get(1).add(2);
		input.get(1).add(3);
		input.get(2).add(1);
		input.get(2).add(-1);
		input.get(2).add(-3);
		System.out.println(minimumTotal(input));
	}

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(triangle.size() == 0)
    		return 0;
    	if(triangle.size() == 1)
    		return triangle.get(0).get(0);
    	int n = triangle.size();
    	int[] tmp = new int[n];
    	tmp[0] = triangle.get(0).get(0);
    	for(int i=1; i<triangle.size(); i++){
    		for(int j=triangle.get(i).size()-1; j>=0; j--){
    			int leftparent = Integer.MAX_VALUE;
    			int rightparent = Integer.MAX_VALUE;
    			if(j<i)
    				rightparent = tmp[j];
    			if(j>=1)
    				leftparent = tmp[j-1];
    			tmp[j] = Math.min(rightparent, leftparent) + triangle.get(i).get(j);
    		}
    	}
    	System.out.println(Arrays.toString(tmp));
    	int min = Integer.MAX_VALUE;
    	for(int i=0; i<triangle.size(); i++){
    		min = Math.min(min, tmp[i]);
    	}
		return min;
    }
}
