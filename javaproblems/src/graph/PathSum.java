package graph;

public class PathSum {

	/**
	 * 
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * 
	 * 
	 * only if the right node & left node of a root is null, that node is leaf. 
	 * the path root -> leaf, make the sum of that path at the node = remaining sum.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		n0.left = n1;
		System.out.println(hasPathSum(n0, 3));
	}

    public static boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
        	return false;
        if(root.left == null && root.right == null)
        {
        	return root.val == sum;
        }
        return hasPathSumRecur(root.left, sum - root.val) || hasPathSumRecur(root.right, sum-root.val);
    }
    
    public static boolean hasPathSumRecur(TreeNode root, int sum){
    	if(root != null && root.left == null && root.right == null)
    		return root.val == sum;
    	if(root == null)
    		return false;
    	return hasPathSumRecur(root.left, sum-root.val) || hasPathSumRecur(root.right, sum-root.val);
    }
	
}
