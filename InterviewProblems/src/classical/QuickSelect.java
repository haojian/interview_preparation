package classical;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 3, 4, 5, 1};
		QuickSelect qs = new QuickSelect();
		System.out.println(qs.quickselect(input, 0, input.length-1, 4));
	}
	
	Random rand = new Random();
	public int quickselect(int[] in, int si, int ei, int k){
		if(si==ei && k ==0) return in[si];
		int pivot = si+rand.nextInt(ei-si+1);
		swap(in, pivot, ei);
		pivot = partition(in, si, ei);
		if(k==pivot) return in[pivot];
		else if(k<pivot) return quickselect(in, si, pivot-1, k);
		else return quickselect(in, pivot+1, ei, k);
	}
	
	public int partition(int[] in, int si, int ei){
		int x = in[ei];
		int i=si-1;
		for(int j=si;j<ei; j++){
			if(in[j]<x){
				i++;
				swap(in, i, j);
			}
		}
		swap(in, i+1, ei);
		return i+1;
	}
	
	public static void swap(int[] in, int si, int ei){
		int tmp = in[si];
		in[si] = in[ei];
		in[ei] = tmp;
	}
}
