package basic;

import java.util.Stack;

public class PeakValueStack {

	/** this version contains bugs. check the right version in careercup project.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<Integer> originalStack;
	private Stack<Integer> minStack;
	private int minValue;
	
	public PeakValueStack(){
		originalStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public int pop(){
		minStack.pop();
		return originalStack.pop();
	}
	
	public void push(int i){
		originalStack.push(i);
		if(minValue > i){
			minStack.push(i);
			minValue = i;
		}else{
			minStack.push(minValue);
		}
	}
	
	public int getMinValue(){
		return minValue;
	}

}


/* A more general implementation.
 * using System.Collections.Generic;

public class FastMinStack<T>
{
    private readonly Stack<T> stack = new Stack<T>();
    // Could pass this in to the constructor
    private readonly IComparer<T> comparer = Comparer<T>.Default;

    private T currentMin;

    public T Minimum
    {
        get { return currentMin; }
    }

    public void Push(T element)
    {
        if (stack.Count == 0 ||
            comparer.Compare(element, currentMin) <= 0)
        {
            stack.Push(currentMin);
            stack.Push(element);
            currentMin = element;
        }
        else
        {
            stack.Push(element);
        }
    }

    public T Pop()
    {
        T ret = stack.Pop();
        if (comparer.Compare(ret, currentMin) == 0)
        {
            currentMin = stack.Pop();
        }
        return ret;
    }
}
 * */
