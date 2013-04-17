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
	        			if(num[si]+num[ei] + num[i]+num[j]> target){
	        				ei--;
	        			}
	        			else if(num[si] + num[ei]+ num[i]+num[j] < target){
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

}
