package string;

import java.util.ArrayList;

public class GnerateParanthesesV1 {

	/**
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
    	String tmp = "(";
    	generateParentheses(tmp, 1, 0, n, res);
    	return res;
    }
	 public static int counter =0;
	public static void generateParentheses(String s, int open, int close, int n, ArrayList<String> res){
		counter++;
		if(close == open && close == n){
			res.add(s);
		}
		if(close >open) return;
		if(close > n || open >n) return;
		generateParentheses(s + "(", open+1, close, n, res);
		generateParentheses(s + ")", open, close+1, n, res);
	}
}
