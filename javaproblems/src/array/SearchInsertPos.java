package array;

public class SearchInsertPos {

	/**
	 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 =2
[1,3,5,6], 2 = 1
[1,3,5,6], 7 = 4
[1,3,5,6], 0 = 0
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3};
		System.out.println(searchInsertStupid(A, 0));
	}

	public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int si =0;
        int ei = A.length;
        while(si<ei){
        	
        	int mid = si + (ei-si)/2;
        	if(A[mid]<target){
        		si = mid+1;
        	}else if(A[mid]>target){
        		ei = mid;
        	}else
        		return mid;
        }
        return si;
    }
	
    public static int searchInsertStupid(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = 0; 
        boolean flag = true;
        for(int i=0; i<A.length; i++){
        	if(A[i] == target)
        		return i;
        	if(A[i] < target && flag){
        		index = i+1;
        	}
        	if(A[i]>target){
        		flag = false;
        	}
        }
        
        return index;
    }
}
