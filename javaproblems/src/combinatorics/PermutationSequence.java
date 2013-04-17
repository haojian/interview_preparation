package combinatorics;

public class PermutationSequence {

	/**
	 * 
	 * The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String getPermutation(int n, int k) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        String tmp = "";
	        for(int i=0; i<n; i++){
	        	tmp += '1'+i;
	        }
	        String res = tmp;
	        for(int i=0; i<k; i++){
	        	res = getNextPermutation(res);
	        }
	        return res;
	}
	
	public static String getNextPermutation(String input) {
        
    }
}
