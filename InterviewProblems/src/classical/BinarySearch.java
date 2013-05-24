package classical;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 6, 7, 10};
		System.out.println(binarySearchIter(input, 4));
		System.out.println(binarySearchRecur(input, 4, 0, input.length-1 ));
	}

	public static int binarySearchIter(int[] A, int target){
		int si =0;
		int ei = A.length-1;
		while(si<=ei){
			int mid = si+(ei-si)/2;
			if(target > A[mid]){
				si = mid+1;
			}else if(target < A[mid]){
				ei = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	public static int binarySearchRecur(int[] A, int target, int si, int ei){
		if(ei<si)
			return -1;
		int mid = si +(ei-si)/2;
		if(A[mid]<target)
			return binarySearchRecur(A, target, mid+1, ei);
		else if(A[mid] > target)
			return binarySearchRecur(A, target, si, mid-1);
		else
			return mid;
	}
}
