package array;

public class NextPermutation {

	/**
	 * 
	 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3  1,3,2
3,2,1  1,2,3
1,1,5  1,5,1
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int lastIndex1 = -1;
       int lastIndex2 = -1;
       for(int i=0; i<num.length; i++){
    	   for(int j=i+1; j<num.length; j++){
    		   if(num[i]<num[j]){
    			   lastIndex1 = i;
    			   lastIndex2 = j;
    		   }
    	   }
       }
       if(lastIndex1 == -1 && lastIndex2 == -1){
    	   int si=0;
    	   int ei=num.length-1;
    	   while(si<ei){
    		   int tmp = num[si];
    		   num[si] = num[ei];
    		   num[ei] = tmp;
    		   si++;
    		   ei--;
    	   }
       }else{
    	   int tmp = num[lastIndex1];
		   num[lastIndex1] = num[lastIndex2];
		   num[lastIndex2] = tmp;
       }
    }

}
