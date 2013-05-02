package graph;

public class BTMaxSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root==null)
    		return 0;
    	int[] max = new int[1];
    	max[0] = Integer.MIN_VALUE;
    	dfsSum(root, max);
    	return max[0];
    }
    
    //return the max leaf->root sum, and update max in max[];
    public int dfsSum(TreeNode root, int[] max){
    	if(root == null)
    		return 0;
    	int l = dfsSum(root.left, max);
    	int r = dfsSum(root.right, max);
    	
    	if(l<0) l = 0;
    	if(r<0) r = 0;
    	
    	if(l+r + root.val > max[0]){
    		max[0] = l+r + root.val;
    	}
    	
    	return 	Math.max(r, l)+root.val;
    }
}
