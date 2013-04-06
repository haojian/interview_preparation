package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSumBruteForce(input));
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return null;
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
