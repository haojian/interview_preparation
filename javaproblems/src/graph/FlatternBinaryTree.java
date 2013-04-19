package graph;

public class FlatternBinaryTree {

	/**
	 * 
	 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public static void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null)
    		return;
    	TreeNode head = root;
    	TreeNode originalleft = root.left;
    	TreeNode originalright = root.right;
    	root.left = null;
    	root.right = originalleft;
    	while(root.right!=null){
    		root = root.right;
    	}
    	root.right = originalright;
        flatten(head.right);
    }
}

