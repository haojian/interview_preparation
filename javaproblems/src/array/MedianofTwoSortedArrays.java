package array;

public class MedianofTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 5, 6, 7};
	}
	
	public int findMedianofTwoSortedArrays(int A[], int B[]){
		int rangeA[] = new int[2];
		int rangeB[] = new int[2];
		int k = (A.length+B.length-1)/2;
 		if((A.length + B.length)%2 == 1){
			return (findKthInSortedArrays(A, B, rangeA, rangeB, k)  + findKthInSortedArrays(A, B, rangeA, rangeB, k+1))/2;
		}else{
			return findKthInSortedArrays(A, B, rangeA, rangeB, k);
		}
	}

	public int findKthInSortedArrays(int A[], int B[], int rangeA[], int rangeB[], int k){
		return -1;
	}
}
