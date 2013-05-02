package graph;

import java.util.ArrayList;

public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(4));
	}

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	 ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
    	 if(numRows <= 0)
    		 return res;
    	 generateRecur(numRows, res);
    	 return res;
    }
    
    public static void generateRecur(int numRows,  ArrayList<ArrayList<Integer>> res){
    	if(numRows ==1){
    		ArrayList<Integer> singRes = new ArrayList<Integer>();
    		singRes.add(1);
    		res.add(singRes);
    	}else{
    		generateRecur(numRows-1, res);
    		ArrayList<Integer> singRes = new ArrayList<Integer>();
    		singRes.add(1);
    		for(int i=0; i<res.get(res.size()-1).size()-1;i++){
    			int num = res.get(res.size()-1).get(i)+res.get(res.size()-1).get(i+1);
    			singRes.add(num);
    		}
    		singRes.add(1);
    		res.add(singRes);
    	}
    }
}
