package graph;

public class IfBalanceBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return true;
        int heightleft = getHeight(root.left);
        int heightright = getHeight(root.right);
        if(Math.abs(heightleft-heightright)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        else if(root != null && root.left == null && root.right == null)
            return 1;
        else
            return 1+ Math.max(getHeight(root.left), getHeight(root.right));
    }
}
