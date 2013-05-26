package dp;

import java.util.ArrayList;

public class Subset2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2};
		System.out.println(subsetsWithDup(num));
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> curList = new ArrayList<Integer>();
    	subsetsRecur(num, 0, curList, res);
        return res;
	}
	
	public static void subsetsRecur(int[] num, int si, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> res){
		if(si == num.length){
			ArrayList<Integer> tmp = (ArrayList<Integer>) curList.clone();
			res.add(tmp);
		}else{
				//if(si==0 || num[si] != num[si-1])
				{
					curList.add(num[si]);
					subsetsRecur(num, si+1, curList, res);
					curList.remove(curList.size()-1);
					subsetsRecur(num, si+1, curList, res);
				}
		}
	}
	
	public static boolean ifdup(int[] num, int si){
		for(int i=si+1; i<num.length; i++){
			if(num[si]==num[i])
				return false;
		}
		return true;
	}
	
    public static ArrayList<ArrayList<Integer>> subsetsWithoutDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> curList = new ArrayList<Integer>();
    	res.add(curList);
    	for(int i=0; i<num.length; i++){
    		ArrayList<ArrayList<Integer>> tmp = deepcpy(res);
    		for(ArrayList<Integer> single:tmp){
    			single.add(num[i]);
    		}
    		res.addAll(tmp);
    	}
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> deepcpy(ArrayList<ArrayList<Integer>> res)
    {
    	ArrayList<ArrayList<Integer>> cpy =  new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<res.size(); i++){
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		for(int j=0; j<res.get(i).size();j++){
    			single.add(res.get(i).get(j));
    		}
    		cpy.add(single);
    	}
    	return cpy;
    }
    
    public void swap(int num, int si, int ei){
    	
    }

}
