package graph;

public class ValidateBST {

	/**
	 * 
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return isValidBSTRecur(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean isValidBSTRecur(TreeNode root, int max, int min){
    	if(root != null){
    		if(root.left != null && (root.left.val >= root.val || root.left.val <= min || root.left.val >= max))
    			return false;
    		if(root.right != null && (root.right.val <= root.val || root.right.val <= min || root.right.val>=max))
    			return false;
    		return isValidBSTRecur(root.left, Math.min(max, root.val), min) && isValidBSTRecur(root.right, max, Math.max(root.val, min));
    	}
    	return true;
    }

}

class TreeNode {
	 int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      }