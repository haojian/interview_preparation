package array;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(bs_iterative(A, 0, A.length-1, 2));
		System.out.println(bs_iterative(A, 0, A.length-1, 7));
	}
	
	public static int bs_iterative(int input[], int si, int ei, int val){
		int mi = (si+ei)/2;
		while(input[mi] != val){
			if(si == ei){
				return -1;
			}
			if(input[mi]<val){
				si = mi+1;
			}
			else{
				ei = mi-1;
			}
			mi = (si+ei)/2;
		}
		return mi;
	}
	
	public static int bs_recursive(int input[], int si, int ei, int val){
		if(si == ei && input[si] != val)
			return -1;
		int mi = (si+ei)/2;
		if(input[mi] > val)
			return bs_recursive(input, si, mi-1, val);
		else if(input[mi] < val)
			return bs_recursive(input, mi+1, ei, val);
		else
			return mi;
	}
}
