package array;

public class SearchForRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1};
		int target =1;
         searchRangeRecur(A, target, 0, A.length);

	}

	
    public static int[] searchRangeRecur(int[] A, int target, int si, int ei){
        if(si<ei){
            int mid = si+(ei-si)/2;
            if(A[mid] < target)
                return searchRangeRecur(A, target, mid+1, ei);
            else if(A[mid] == target){
                int rsi = mid;
                int rei = mid;
                while(rsi >=si && A[rsi] == target){
                    rsi--;
                }
                while(rei<ei && A[rei] == target){
                    rei++;
                }
                
                int[] res = {rsi, rei};
                return res;
            }else
                return searchRangeRecur(A, target, si, mid);
        }
        int[] res = {-1, -1};
        return res;
    }
}
