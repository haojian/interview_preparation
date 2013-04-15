package array;

public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ri = m+n-1;
        int ai = m-1;
        int bi = n-1;
        while(ai>=0 && bi>=0){
            A[ri--] = A[ai]>B[bi]?A[ai--]:B[bi--];
        }
        if(ai<0){
            for(int i=bi; i>=0; i--){
                A[ri--] = B[i];
            }
        }
        if(bi<0){
            for(int i=ai; i>=0; i--){
                A[ri--] = A[i];
            }
        }
    }

}
