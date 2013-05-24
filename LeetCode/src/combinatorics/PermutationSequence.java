package combinatorics;

import java.util.ArrayList;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=6; i++){
			System.out.println(getPermutation(3, i));
		}
	}

	
	//5 =>3 1
    public static String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	k--;
        ArrayList<Integer> cands = new ArrayList<Integer>();
        String res = "";
        for(int i=1; i<=n; i++){
        	cands.add(i);
        }
        int factorial = 1;
        for(int i=1; i<n; i++){
        	factorial *= i;
        }
        int curfact = n-1;
        for(int i=0; i<n; i++){
        	int index = k/factorial;
        	res += cands.get(index);
        	cands.remove(index);
        	k %= factorial;
        	if(k==0)
        		continue;
        	factorial /= curfact;
        	curfact--;
        }
        return res;
    }
}
