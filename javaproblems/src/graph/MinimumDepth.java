package graph;

import java.util.ArrayList;

public class MinimumDepth {

	/**
	 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null)
    		return 0;
    	int left = minDepth(root.left)+1;
    	int right = minDepth(root.right)+1;
    	if(left == 1 || right == 1)
    		return Math.max(left, right);
    	return Math.min(left, right);
    	
    }

    
    public int minDepthBFS(TreeNode root){
    	if(root == null)
    		return 0;
    	ArrayList<TreeNode> last = new ArrayList<TreeNode>();
    	last.add(root);
    	int depth = 1;
    	while(!last.isEmpty()){
            ArrayList<TreeNode> curLayer = new ArrayList<TreeNode>();
            for(TreeNode tmp:last){
            	if(tmp.left == null && tmp.right == null) return depth;
            	if(tmp.left!=null)	curLayer.add(tmp.left);
            	if(tmp.right != null) curLayer.add(tmp.right);
            }
            depth++;
            last = curLayer;
    	}
    	return depth;
    }
}
