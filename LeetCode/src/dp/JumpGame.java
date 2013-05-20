package dp;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3};
		System.out.print(canJump(input));
	}
	
	
	public static boolean canJump(int[] A){
		if(A == null || A.length == 0 )
    		return false;
		if(A.length == 1)
			return true;
		int si = 1;
		int ei = A[0];
		while(ei<A.length-1){
			int max = ei;	//very important
			for(int i=si; i<=ei; i++){
				max = Math.max(max, A[i]+i);
			}
			si = ei+1;
			ei = max;
			if(si>ei)
				return false;
		}
		return true;
	}
	
	//with error
    public static boolean canJump_v1(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A == null || A.length == 0 )
    		return false;
    	int si = 0;
    	int ei = A[0];
    	while(ei<A.length){
    		int curmax = ei;
    		for(int i=si; i<=ei; i++){
    			curmax = Math.max(curmax, A[i]+i);
    		}
    		si = ei+1;
    		ei = curmax;
    		if(si > ei)
    			return false;
    	}
    	return true;
    }
}
