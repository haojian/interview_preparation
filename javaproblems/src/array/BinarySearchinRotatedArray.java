package array;

public class BinarySearchinRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1};
		System.out.println(search(A, 2));
	}

	public static int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[] tmp = new int[A.length *2];
		for(int i=0; i<A.length; i++){
			tmp[i] = A[i];
			tmp[i+A.length] = A[i];
		}
		int si=0;
		int lastVal = tmp[si];
		for(int i=1; i<tmp.length-1;i++){
			if(tmp[i]<lastVal){
				si = i;
				break;
			}
			lastVal = tmp[i];
		}
		int ei = si+A.length;
		System.out.println(si);
        int index = binarySearch(tmp, si, ei, target);
        if(index>=A.length)
        	return index%A.length;
        return index;
    }
    
	//end point not included.
    public static int binarySearch(int A[], int si, int ei, int target){
    	if(si<ei){
    		int mid = si+(ei-si)/2;
    		if(A[mid]<target)
    			return binarySearch(A, mid+1, ei, target);
    		else if(A[mid] == target)
    			return mid;
    		else
    			return binarySearch(A, si, mid, target);
    	}
       return -1;
    }
}
