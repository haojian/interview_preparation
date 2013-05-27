package graph;

import java.util.Arrays;

public class UniqueBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(2));
	}

	
    public static int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        for(int i=0; i<n; i++){
        	num[i] = i+1;
        }
        int[] counter = new int[1];
        for(int i=0; i<n; i++){
            swap(num, 0, i);
            buildTreeRecur(num, 1, num[0], Integer.MAX_VALUE, Integer.MIN_VALUE, counter);
            swap(num, 0, i);
        }
        return counter[0];
    }

    public static void buildTreeRecur(int[] num, int si, int curroot, int max, int min,int[] counter){
        if(si == num.length){
        	System.out.println(Arrays.toString(num));
            counter[0]++;
            return;
        }
        else{
            for(int i=si; i<num.length; i++){
                if(num[i] > min && num[i] <max){
                    swap(num, si, i);
                    //have two ways to connect: old node or recently added node.
                    if(num[i] > curroot){
                    	buildTreeRecur(num, si+1, num[si], max, curroot, counter);
                    	buildTreeRecur(num, si+1, curroot, curroot, min, counter);
                    }
                    else{
                    	buildTreeRecur(num, si+1, num[si], curroot, min, counter);
                    	buildTreeRecur(num, si+1, curroot, max, curroot, counter);
                    }
                    swap(num, si, i);
                }
                
            }
        }
    }
    
    public static void swap(int[] num, int si, int ei){
        int tmp = num[si];
        num[si] = num[ei];
        num[ei] = tmp; 
    }
}
