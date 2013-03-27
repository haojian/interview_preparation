package stackqueue;

import java.util.Stack;

public class StacksToQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Stack<Integer> newStack;
	public Stack<Integer> oldStack;

	public StacksToQueue(){
		newStack = new Stack<Integer>();
		oldStack = new Stack<Integer>();
	}

	public void push(int val){
		//if the stack has size capacity limitation, we need to do shift right in this case.
		newStack.push(val);
	}
	
	public int peek(int val){
		checkShift();
		return oldStack.peek();
	}
	
	public int pop(){
		checkShift();
		return oldStack.pop();
	}


	public void checkShift(){
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				int tmp = newStack.pop();
				oldStack.push(tmp);
			}
		}
	}
}
