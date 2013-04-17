package combinatorics;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int si = -1;
    	int ei = -1;
    	for(int i=0; i<num.length-1; i++)
    		for(int j= i+1; j<num.length; j++){
    			if(num[i] < num[j]){
    				si = i;
    				ei = j;
    			}
    		}
    	if(si == -1 && ei == -1){
    		reverse(num, 0);
    		return;
    	}
    	int tmp = num[si];
		num[si] = num[ei];
		num[ei] = tmp;
		si++;
		reverse(num, si);
    }
    
    public void reverse(int[] num, int begini){
    	int si = begini;
    	int ei = num.length-1;
    	while(si<ei){
    		int tmp = num[si];
    		num[si] = num[ei];
    		num[ei] = tmp;
    		si++;
    		ei--;
    	}
    }
}
