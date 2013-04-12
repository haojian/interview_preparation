package basic;

public class FindFirstMissingPositive {

	/**
	 * 
The key idea is to put every element in A such that A[i]=i
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	//the first missing positive couln't be larger than (A.length+1).
    	// even if we stored all the value from 1 to A.length in that array, the missing on is A.length +1;
    	// 
    	for(int i =0;i<A.length; i++){
    		while(A[i] != i+1){
    			if(A[i]<=0 || A[i]>A.length || A[i] == A[A[i]-1]) break;
    			swap(A, i, A[i]-1);
    		}
    	}
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)   return i+1;
        }
        return A.length+1;
    }

    public static void swap(int[] A, int i1, int i2){
    	int tmp = A[i1];
    	A[i1] = A[i2];
    	A[i2] = tmp;
    }
}
