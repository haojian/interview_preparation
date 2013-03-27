package stackqueue;

public class ArrayToStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[] stacks_holder;
	private int[] fixedDivisionNextAvailableTracker;
	private int[] dynamicDivisionNextAvailableTracker;

	public ArrayToStacks(){
		fixedDivisionNextAvailableTracker = new int[3];
		fixedDivisionNextAvailableTracker[0] = 0;
		fixedDivisionNextAvailableTracker[1] = 33;
		fixedDivisionNextAvailableTracker[2] = 66;
		stacks_holder = new int[100];
	}

	void push(int n, int val){
		if(fixedDivisionNextAvailableTracker[n] <33 * n){ 
			stacks_holder[fixedDivisionNextAvailableTracker[n]] = val;
			fixedDivisionNextAvailableTracker[n]++;
		}else{
			//print already full.
		}
	}

	int pop(int n){
		if(fixedDivisionNextAvailableTracker[n] >= (n-1) * 33){
			int val = stacks_holder[--fixedDivisionNextAvailableTracker[n]];
			return val;
		}else{
			return -1;
		}
	}

	int peek(int n){
		return stacks_holder[fixedDivisionNextAvailableTracker[n]-1];
	}
}
