package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSumV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(s, 0));
	}
	
	 public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 	HashSet<ArrayList<Integer>> map = new HashSet<ArrayList<Integer>>();
	        Arrays.sort(num);
	        for(int i=0; i<num.length; i++){
	        	for(int j=i+1; j<num.length; j++){
	        		int si = j+1; 
	        		int ei = num.length-1;
	        		while(si < ei){
	        			int sum = num[si]+num[ei] + num[i]+num[j];
	        			if(sum> target){
	        				ei--;
	        			}
	        			else if(sum< target){
	        				si++;
	        			}else{
	        				ArrayList<Integer> curList = new ArrayList<Integer>();
	        				curList.add(num[i]);
	        				curList.add(num[j]);
	        				curList.add(num[si]);
	        				curList.add(num[ei]);
	        				si++;
	        				ei--;
	        				if(!map.contains(curList)){
	        					map.add(curList);
	        					res.add(curList);
	        				}
	        			}
	        		}
	        	}
	        }
	        return res;
	}
	 
	 public ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	                Arrays.sort(num);
	        HashSet<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        for (int i = 0; i < num.length; i++) {
	            for (int j = i + 1; j < num.length; j++) {
	                for (int k = j + 1, l = num.length - 1; k < l;) {                     
	                	int sum = num[i] + num[j] + num[k] + num[l];                     
	                	if (sum > target) {
	                        l--;
	                    }
	                    else if (sum < target) {
	                        k++;
	                    }
	                    else if (sum == target) {
	                        ArrayList found = new ArrayList();
	                        found.add(num[i]);
	                        found.add(num[j]);
	                        found.add(num[k]);
	                        found.add(num[l]);
	                        if (!hSet.contains(found)) {
	                            hSet.add(found);
	                            result.add(found);
	                        }
	 
	                        k++;
	                        l--;
	 
	                    }
	                }
	            }
	        }
	        return result;
	    }

}
