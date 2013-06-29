package graph;

public class ValidBSTPostOutput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {7,4,6,5};
		//int[] in = {5, 7, 6, 9,11,10,8};
		System.out.println(ifvalid(in, 0, in.length-1));
	}
	
	public static boolean ifvalid(int[] A, int si, int ei){
		if(si >= ei)
			return true;
		int root = A[ei];
		int i=si;
		for(; i<ei; i++){
			if(A[i]>root)
				break;
		}
		int tmp = i;
		for(; i<ei; i++){
			if(A[i]<root)
				return false;
		}
		return ifvalid(A, si, tmp-1) && ifvalid(A, tmp, ei-1); 
	}

}
