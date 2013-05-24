package basic;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] colors = new int[3];
    	for(int i=0; i<A.length; i++){
    		if(A[i] == 0)
    			colors[0]++;
    		if(A[i] == 1)
    			colors[1]++;
    		if(A[i] == 2)
    			colors[2]++;
    	}
    	for(int i=0; i<A.length; i++){
    		if(colors[0]>0){
    			A[i] = 0;
    			colors[0]--;
    		}else if (colors[1]>0){
    			A[i] = 1;
    			colors[1]--;
    		}else if(colors[2]>0){
    			A[i] = 2;
    			colors[2]--;
    		}
    	}
    }
}
