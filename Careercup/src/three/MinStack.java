package three;

import java.util.Stack;

public class MinStack extends Stack<Integer>{

	/**
	 * 3 points:
	 * 	1. push  i<= min(); also need to be equal for all the possible cases
 	 *  2. Use min rather than peek. Since the minStack could be empty;
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int i){
		if(i<= min())   // also need =
		{
			minStack.push(i);
		}
		super.push(i);
	}
	
	public Integer pop()
	{
		int pop = super.pop();
		if(pop == min()){
			minStack.pop();
		}
		return pop;
	}
	
	public int min(){
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		return minStack.peek();
	}
}
