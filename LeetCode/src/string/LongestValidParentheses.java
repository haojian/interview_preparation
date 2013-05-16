package string;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "()(())";
		System.out.println(longestValidParentheses(input));
	}

	
	public static int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s== null || s.length() == 0)
			return 0;
        int[] dpLenEndHere = new int[s.length()];
        dpLenEndHere[0] = 0;
        for(int i=1; i<s.length(); i++){
        	if(dpLenEndHere[i-1] == 0){
        		if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
        			int past = i<2?0:dpLenEndHere[i-2];
        			dpLenEndHere[i] =2+past;
        		}
        		else
        			dpLenEndHere[i] = 0;
        	}
        	else{
        		if(i-1-dpLenEndHere[i-1]>=0 && s.charAt(i)==')' && s.charAt(i-1-dpLenEndHere[i-1]) == '('){
        			int past = i-2-dpLenEndHere[i-1]>=0?dpLenEndHere[i-2-dpLenEndHere[i-1]]:0;
        			dpLenEndHere[i] =2+dpLenEndHere[i-1] + past;
        		}
        		else{
        			dpLenEndHere[i] = 0;
        		}
        	}
        }
        int max = 0;
        for(int i=0; i<s.length(); i++){
        	max = Math.max(max, dpLenEndHere[i]);
        }
        return max;
    }
}
