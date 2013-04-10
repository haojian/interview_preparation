package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {-1, 0, 1, 2, -1, -4};
		int[] input = {0, 0, 0, 0};
		System.out.println(threeSum(input));
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<num.length; i++){
			if(i>0 && num[i] == num[i-1])
				continue;
			int j = i + 1;
			int k = num.length - 1;
			while(j<k){
				if( num[j] + num[k] < -num[i]){
					j++;
				}else if(num[j] + num[k] > -num[i]){
					k--;
				}else{
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);
					res.add(tmp);
					while(j<num.length-1 && num[j] == num[j+1])
						j++;
					while(k<num.length-1 && num[k] == num[k-1])
						k--;
					j++;
					k--;
				}
			}
		}
		return res;
    }
	
	public static ArrayList<ArrayList<Integer>> threeSumBruteForce(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<num.length; i++){
			for(int j = 0; j<num.length;j++){
				for(int k = 0; k<num.length;k++){
					if(i!=j && i!=k && j!=k)
					{
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[k]);
						res.add(tmp);
					}
				}
			}
		}
		System.out.println(res.size());
		return null;
    }
	
	public static ArrayList<ArrayList<Integer>> threeSumHash(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Map<Integer, Map<Integer, Integer>> hash = new HashMap<Integer, Map<Integer, Integer>>();
		for(int i = 0; i<num.length; i++){
			Map<Integer, Integer> subMap;
			if(hash.containsKey(num[i])){
				subMap = hash.get(num[i]);
			}else{
				hash.put(num[i], new HashMap<Integer, Integer>());
			}
			for(int j=i;j<num.length;j++){
				//subMap.put(key, value)
			}
		}
		return null;
    }

}
