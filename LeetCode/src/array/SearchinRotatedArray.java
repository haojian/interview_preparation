package array;

public class SearchinRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6};
		int[] input1 = {5,1,3};
		System.out.println(search(input1, 3));
	}
	
	// 1 2 3 4 5 6 7     6
	// 5 6 7 1 2 3 4     6
    public static boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A ==null || A.length == 0)
    		return false;
    	int si = 0;
    	int ei = A.length-1;
    	while(si<=ei){
    		int mid = si+(ei-si)/2;
    		if(A[mid] == target)
    			return true;
    		if(A[si] < A[mid]){
    			if(target>=A[si] && target < A[mid]){
    				ei = mid-1;
    			}else{
    				si = mid;
    			}
    		}else if(A[si]>A[mid]){
    			if(target > A[mid] && target<=A[ei]){
    				si = mid+1;
    			}else{
    				ei = mid;
    			}
    		}else{
    			si++;
    		}
    	}
    	return false;
    }
    
    public static int getStart(int[] A){
    	if(A==null || A.length == 0)
    		return 0;
    	int si = 0;
    	int ei = A.length -1;
    	while(si<ei){
    		int mid = si+(ei-si)/2;
    		if(A[si]>=A[ei]){
    			ei = mid;
    		}else{
    			si = mid+1;
    		}
    	}
    	return (si+1)%A.length;
    }
}
