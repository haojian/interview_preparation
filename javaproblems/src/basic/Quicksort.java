package basic;

import java.util.Arrays;

public class Quicksort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {7, 6, 5, 4, 3, 2, 1};
		quicksort(A, 0, (A.length-1));
		System.out.println(Arrays.toString(A));
	}

	
	public static void quicksort(int A[], int si, int ei){
		if(si < ei){
			int p = partition(A, si, ei);
			quicksort(A, si, p-1);
			quicksort(A, p+1, ei);
		}
	}
	
	public static int partition(int A[], int si, int ei){
		int x = A[ei];
		int i = si-1;
		for(int j = si; j < ei; j++){
			if(A[j] <= x){
				i++;
				exchange(A, j, i);
			}
		}
		exchange(A, i+1, ei);
		return i+1;
	}
	
	public static void exchange(int A[], int ai, int bi){
		if(A[ai] == A[bi])
			return;
		System.out.println("Before: " + A[ai] + "\t" + A[bi]);
		A[ai] = A[ai] ^ A[bi];
		A[bi] = A[ai] ^ A[bi];
		A[ai] = A[ai] ^ A[bi];
		System.out.println("After: " + A[ai] + "\t" + A[bi]);
		/*
		int tmp = A[ai];
		A[ai] = A[bi];
		A[bi] = tmp;
		*/
	}
}
