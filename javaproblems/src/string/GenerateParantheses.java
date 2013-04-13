package string;

import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParantheses {

	/**
	 * 
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(8).size());
		System.out.println(counter);
	}
	
    public static ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> res = new ArrayList<String>();
    	String tmp = "()";
    	generateParenthesis(n-1, tmp, res);
    	return res;
    }
    public static int counter =0;
    
    
    public static void generateParenthesis(int n, String tmp, ArrayList<String> list){
    	if(n==0){
    		counter++;
    		 if(!list.contains(tmp))
    			 list.add(tmp);
    	}
    	else{
    		for(int i=0; i<tmp.length(); i++){
    			generateParenthesis(n-1, tmp.substring(0, i) + "()"+tmp.substring(i,tmp.length()), list);
    		}
    	}
    }

}
