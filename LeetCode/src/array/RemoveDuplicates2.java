package array;

import java.util.Arrays;

public class RemoveDuplicates2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1, 1,2,3};
		removeDuplicates(input);
		System.out.println(Arrays.toString(input));
	}
	
	
	//case 1: new Character
	//case 2: old Character <=2;
	//case 3: old character >2;
    public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A==null || A.length ==0)
    		return 0;
    	int newi=0;
    	int oldi=1;
    	boolean ifvisited = false;
    	for(int i=oldi; i<A.length; i++){
    		//new character
    		if(A[newi] != A[i]){
    			newi++;
    			A[newi] = A[i];
    			ifvisited = false;
    		}else{
    			if(ifvisited == false){
    				ifvisited = true;
    	   			newi++;
        			A[newi] = A[i];
    			}else{
    				//donothing;
    			}
    		}
    	}
    	return newi+1;
    }
}
