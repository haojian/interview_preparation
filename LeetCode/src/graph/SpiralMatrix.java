package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[1][2];
		int counter=1;
		for(int[] row:matrix){
			for(int i=0; i<row.length;i++){
				row[i] = counter++;
			}
		}
		System.out.println(spiralOrder(matrix));
	}

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
    		return res;
        int rsi = 0;
        int rei = matrix.length;
        int csi = 0;
        int cei = matrix[0].length;
        while(rsi<rei && csi < cei){
        	for(int i=csi; i<cei; i++){
        		res.add(matrix[rsi][i]);
        	}
        	rsi++;
        	for(int i=rsi; i<rei; i++){
        		res.add(matrix[i][cei-1]);
        	}
        	cei--;
        	if(rsi < rei){
        		for(int i=cei-1; i>=csi; i--){
        			res.add(matrix[rei-1][i]);
        		}
        		rei--;
        	}
        	if(csi < cei){
        		for(int i=rei-1; i>=rsi; i--){
        			res.add(matrix[i][csi]);
        		}
        		csi++;
        	}
        }
        return res;
    }
	
	
	/*
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0)
    		return res;
        int depth = (Math.min(matrix.length, matrix[0].length)+1)/2;
        for(int i=0; i<depth;i++){
        	spiralOrderbyDepth(matrix, i, res);
        }
        return res;
    }
    
    public static void spiralOrderbyDepth(int[][] matrix, int depth,  ArrayList<Integer> res){
    	int r = matrix.length - depth *2;
    	int c = matrix[0].length - depth *2;
    	
    	for(int offset=0; offset<c-1; offset++){
    		res.add(matrix[depth][depth+offset]);
    	}
    	for(int offset=0; offset<r-1; offset++)
    		res.add(matrix[depth+offset][matrix[0].length-1-depth]);
    	if(c != 1 && c!=1){
    		for(int offset=0; offset<c-1; offset++){
    			res.add(matrix[matrix.length-1-depth][matrix[0].length-1-depth-offset]);
    		}

    		for(int offset=0; offset<r-1; offset++)
    			res.add(matrix[matrix.length-1-depth-offset][depth]);
    	}
    }
    */
}
