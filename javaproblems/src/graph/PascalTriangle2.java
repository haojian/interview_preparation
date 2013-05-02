package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(4));
	}

    public static ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	rowIndex++;
    	if(rowIndex <= 0)
    		return new ArrayList<Integer>();
    	int[] res = new int[rowIndex];
    	getRowRecur(rowIndex, res);
    	
    	ArrayList<Integer> resAL = new ArrayList<Integer>();
    	for(int i=0; i<res.length; i++){
    		resAL.add(res[i]);
    	}
    	return resAL;
    }
    
    public static void getRowRecur(int rowIndex, int[] res) {
    	if(rowIndex == 1){
    		res[0] = 1;
    		return;
    	}
    	getRowRecur(rowIndex-1, res);
        res[0] = 1;
        int tmp = res[0];
        for(int i=1; i<rowIndex-1;i++){
        	int tmp1 = res[i];
        	res[i] = tmp+res[i];
        	tmp = tmp1;
        }
        res[rowIndex-1] = 1;
    }
}
