package string;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("]"));
	}
	
    public static boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
        	switch( s.charAt(i)){
        	case '(':
        		stack.push(')');
        		break;
        	case '[':
        		stack.push(']');
        		break;
        	case '{':
        		stack.push('}');
        		break;
        	default:
        		if(stack.isEmpty() || s.charAt(i) != stack.pop())
        			return false;
        	}
        }
        if(stack.isEmpty())
        	return true;
        return false;
    }

}
