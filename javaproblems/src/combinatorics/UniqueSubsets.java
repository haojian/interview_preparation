package combinatorics;

import java.util.ArrayList;

public class UniqueSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tmp ={1,2,3};
		System.out.println(subsets(tmp));
	}

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        subsetsRecur(S, S.length, res);
        
        return res;
    }
    
    public static void subsetsRecur(int[] S, int n, ArrayList<ArrayList<Integer>> res){
        if(n == 1){
            for(int i=0; i<S.length; i++){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(S[i]);
                res.add(tmp);
            }
        }else{
            subsetsRecur(S, n-1, res);
            for(int j=0; j<res.size(); j++){
            	ArrayList<Integer> tmp = res.get(j);
            	if(tmp.size() != n-1)
            		continue;
            //for(ArrayList<Integer> tmp: res){
                for(int i:S){
                    if(i>tmp.get(tmp.size()-1))
                    {
                        ArrayList<Integer> copy = (ArrayList<Integer>) tmp.clone();
                        copy.add(i);
                        res.add(copy);
                    }
                }
            }
        }
    }
}
