package string;

import java.util.Queue;

public class CountAndSay {

	/**
	 * 
	 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countString("111221"));
		//System.out.println(countAndSay(6));
	}

    public static String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1)
        	return "1";
        else{
        	return countString(countAndSay(n-1));
        }
    }
    
    public static String countString(String input){
    	if(input.length() == 0)
    		return "";
    	String res = "";
    	char last = input.charAt(0);
    	char[] charlist = new char[input.length()];
    	int[] countlist = new int[input.length()];
    	int tracker = 0;
    	charlist[tracker] = input.charAt(0);
    	countlist[tracker] = 1;
    	for(int i=1; i<input.length(); i++){
    		if(input.charAt(i) == last){
    			charlist[tracker] = last;
    			countlist[tracker]++;
    		}
    		else{
    			tracker++;
    			charlist[tracker] = input.charAt(i);
    			countlist[tracker] = 1;
    			last = charlist[tracker];
    		}
    	}
    	for(int i=0; i< input.length(); i++){
    		if(countlist[i]!=0)
    			res += countlist[i]+ "" +charlist[i];
    	}
    	return res;
    }
}
