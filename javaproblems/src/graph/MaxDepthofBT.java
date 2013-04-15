package graph;

public class MaxDepthofBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return 0;
        if(root !=null && root.left == null && root.right == null){
            return 1;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
