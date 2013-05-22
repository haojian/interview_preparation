package array;

public class RotatedDistance {

	/**
	 * You are given a sorted integer array that is shifted N positions to the right. Determine N.
Example: [9, 11, 1, 5, 7, 8]: N = 2 

	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {9, 11, 1, 5, 7, 8};
		System.out.println(getNBinarySearch(input, 0, input.length));
	}

	public int getN(int[] A){
		if(A==null || A.length == 0)
			return -1;
		int sp = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i]<A[i-1])
				return i;
		}
		return 0;
	}
	
	public static int getNBinarySearch(int[] A, int si, int ei){
		if(A== null || A.length == 0)
			return -1;
		if(si == ei-1)
			return si;
		if(si == ei-2)  //important. don't forget
	        return A[si]>A[ei-1]?ei-1:si;
		if(A[si]<A[ei-1])
			return si;
		int mid = si+(ei-si)/2;
		if(A[si] <= A[mid]){
			return getNBinarySearch(A, mid, ei);
		}else
			return getNBinarySearch(A, si, mid+1);
	}
}
