package graph;

public class ConvertSortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return arrayToBSTRecur(num, 0, num.length);
    }
    
    //ei was not included
    public TreeNode arrayToBSTRecur(int[] num, int si, int ei){
    	if(si >= ei)
    		return null;
    	int mid = si+(ei-si)/2;
    	TreeNode curRoot = new TreeNode(num[mid]);
    	curRoot.left = arrayToBSTRecur(num, si, mid);
    	curRoot.right = arrayToBSTRecur(num, mid+1, ei);
    	return curRoot;
    }

}
