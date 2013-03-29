package array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MedianofTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,3,4,5,7,8,9};
		int B[] = {6,10};
		System.out.println(findMedianofTwoSortedArrays(A, B));
	}
	/////////A1///////A2//////
	/////////B1///////B2//////
	
	public static double findMedianofTwoSortedArrays(int A[], int B[]){
 		if((A.length + B.length)%2 == 1){
 			return findKthInSortedArrays(A, B, (A.length+B.length)/2+1);
		}else{
			return (findKthInSortedArrays(A, B, (A.length+B.length)/2)  + findKthInSortedArrays(A, B, (A.length+B.length)/2+1))/2.0;
		}
	}
	
	//A should be shorter than B.
	//both pa & pb are not 0 based.
	public static int findKthInSortedArrays(int A[], int B[], int k){
		if(A.length>B.length) return findKthInSortedArrays(B, A, k);
		if(A.length == 0) return B[k-1];
		if(k==1) return A[0]<B[0]?A[0]:B[0];
		int pa = k/2< A.length?k/2:A.length; 
		int pb = k - pa;
		if(A[pa-1] < B[pb-1]) return findKthInSortedArrays(getSubArray(A, pa, A.length-1), B, k-pa);
		else return findKthInSortedArrays(A, getSubArray(B, pb, B.length-1), k-pb);
	}
	
	//si & ei is 0-based.
	public static int[] getSubArray(int input[], int si, int ei){
		int[] res = new int[ei-si+1];
		if(res.length == 0)
			System.out.println("debugged");
		int index = 0;
		for(int i =si; i<=ei; i++){
			res[index] = input[i];
			index++;
		}
		return res;
	}
	
	//si & ei is 0-based.
	public static int[] getSubArray_inplace(int input[], int si, int ei){
		int[] res = new int[ei-si+1];
		if(res.length == 0)
			System.out.println("debugged");
		int index = 0;
		for(int i =si; i<=ei; i++){
			res[index] = input[i];
			index++;
		}
		return res;
	}

}
