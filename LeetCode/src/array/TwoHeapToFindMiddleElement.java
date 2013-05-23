package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class TwoHeapToFindMiddleElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[100];
		Random rand = new Random();
		for(int i=0; i<input.length; i++){
			//input[i] = rand.nextInt(100);
			input[i] = i;
		}
		getMiddleElement(input);
	}
	
	public static int getMiddleElement(int[] A){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		Comparator<Integer> maxcomp = new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1-arg0;
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, maxcomp);
		int max = A[0];
		System.out.println(max + " " + 0);

		for(int i=1; i<A.length; i++){
			if(A[i]>max){
				minHeap.offer(A[i]);
			}else{
				maxHeap.offer(A[i]);
			}
			if(Math.abs(maxHeap.size() - minHeap.size())>=2){
				PriorityQueue<Integer> largerQueue = maxHeap.size() > minHeap.size()?maxHeap:minHeap;
				PriorityQueue<Integer> smallerQueue = maxHeap.size() < minHeap.size()?maxHeap:minHeap;
				smallerQueue.offer(max);
				max = largerQueue.poll();
			}
			double curmax = 0;
			if(maxHeap.size() == minHeap.size())
				curmax = max;
			else{
				PriorityQueue<Integer> largerQueue = maxHeap.size() > minHeap.size()?maxHeap:minHeap;
				curmax = (max+largerQueue.peek())/2.0;
			}
			System.out.println(curmax + " " + i);
		}
		return max;
	}
	
	public static int TestMaxMinHeap(int[] A){
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		Comparator<Integer> maxcomp = new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1-arg0;
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, maxcomp);
		for(int i=0; i<A.length; i++){
			minHeap.offer(A[i]);
			maxHeap.offer(A[i]);
		}
		for(int i=0; i<A.length; i++)
			System.out.print(minHeap.poll() + " ");
		System.out.print("\n");
		for(int i=0; i<A.length; i++)
			System.out.print(maxHeap.poll() + " ");
		return 0;
	}

}
