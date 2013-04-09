package basic;

public class RemoveDuplicateinSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
            return 0;

        int resindex = 0;
        for(int i = resindex+1; i<A.length; i++){
            if(A[i] != A[resindex]){
                resindex++;
                A[resindex] = A[i];
            }
        }
        return ++resindex;
    }
}
