package array;

public class BinarySearchV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(bs_iterative(A, 0, A.length, 2));
		System.out.println(bs_iterative(A, 0, A.length, 7));
	}

	//end index was not included
	public static int bs_iterative(int[] A, int si, int ei, int target){
		int res = -1;
		while(si<ei){
			int mid = si+(ei-si)/2;
			if(A[mid] == target)
				return mid;
			else if(A[mid] < target){
				si = mid+1;
			}else{
				ei = mid;
			}
		}
		return res;
	} 
}
