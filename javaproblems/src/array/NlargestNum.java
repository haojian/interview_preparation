package array;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class NlargestNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 3,  6,4,7,8,9};
		getNlargest(input, 3);
	}
	
	public static int getNlargest(int[] input, int n){
		PriorityQueue<Integer> heapQueue = new PriorityQueue<Integer>();
		for(int i:input){
			if(heapQueue.size() == n)
				heapQueue.poll();
			heapQueue.offer(i);
		}
		while(!heapQueue.isEmpty())
			System.out.println(heapQueue.poll());
		return 0;
	}
	
}

class HajiHeap{
	
}
