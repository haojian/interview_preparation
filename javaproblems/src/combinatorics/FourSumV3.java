package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSumV3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(fourSum(input, -1));
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
        				sum = num[si]+num[ei] + num[i]+num[j];
        				int aggresiveEi = ei;
        				while(sum>target){
        					ei = aggresiveEi;
        					aggresiveEi = si+(ei-si)/2;
        					sum = num[si]+num[aggresiveEi] + num[i]+num[j];
        					if(aggresiveEi <= si+1)
        						break;
        				}
        				//ei--;
        			}
        			else if(sum< target){
        				si++;
        				sum = num[si]+num[ei] + num[i]+num[j];
        				int aggresiveSi = si;
        				while(sum < target){
        					si = aggresiveSi;
        					aggresiveSi = si+(ei-si)/2;
        					sum = num[aggresiveSi]+num[ei] + num[i]+num[j];
        					if(aggresiveSi>=ei-1)
        						break;
        				}
        				//si++;
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
