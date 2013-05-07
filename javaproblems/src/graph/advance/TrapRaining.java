package graph.advance;

public class TrapRaining {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        int[] leftMaxHeight = new int[A.length];
        int[] rightMaxHeight = new int[A.length];
        int tmp = 0;
        for(int i=0; i<A.length; i++){
            leftMaxHeight[i] = Math.max(tmp, A[i]);
            tmp = leftMaxHeight[i];
        }
        tmp = 0;
        for(int i=A.length-1; i>=0; i--){
            rightMaxHeight[i] = Math.max(tmp, A[i]);
            tmp = rightMaxHeight[i];
        }
        for(int i=1; i<A.length; i++){
            if(A[i] < Math.min(leftMaxHeight[i], rightMaxHeight[i])){
                res += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - A[i];
            }
        }
        return res;
    }
}
