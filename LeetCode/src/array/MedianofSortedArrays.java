package array;

public class MedianofSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1};
		int[] B = {1};
		MedianofSortedArrays s = new MedianofSortedArrays();
		System.out.println(s.findMedianSortedArrays(A, B));
	}

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int la = A.length;
        int lb = B.length;
        if((la+lb)%2 == 1)
            return getKthSortedArrays(A, B, (la+lb)/2+1);
        else
            return (getKthSortedArrays(A, B, (la+lb)/2) + getKthSortedArrays(A, B, (la+lb)/2+1))/2.0;
    }
    
    // both k, pa, pb is not 0-based
    public int getKthSortedArrays(int A[], int B[], int k){
        if(A == null || A.length == 0) return B[k-1];
        if(A.length > B.length) return getKthSortedArrays(B, A, k);
        if(k==1)    return A[0]<B[0]?A[0]:B[0];
        
        int pa = k/2>A.length?A.length:k/2;
        int pb = k-pa;
        if(A[pa-1] < B[pb-1])   return getKthSortedArrays(getSubArray(A, pa, A.length), B, k-pa);
        else    return getKthSortedArrays(A, getSubArray(B, pb, B.length), k-pb);
    }
    
    //ei is not included.
    public int[] getSubArray(int A[], int si, int ei){

        int[] res = new int[ei-si];
        if(si >=ei)
            return res;
        for(int i=si; i<ei; i++){
            res[i-si] = A[i];
        }
        return res;
    }
}
