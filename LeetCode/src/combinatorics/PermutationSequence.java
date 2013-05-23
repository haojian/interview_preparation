package combinatorics;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//5 =>3 1
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pos = 1;
        for(int i=1; i<n; i++){
        	pos *= i;
        }
        String res = "";
        int tmp = k/pos;
        while(tmp>0){
        	res=tmp+res;
        	k = k-k/pos *tmp;
        	//pos/
        	tmp = tmp/
        }
    }
}
