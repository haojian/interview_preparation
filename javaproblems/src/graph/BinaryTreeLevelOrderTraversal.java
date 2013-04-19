package graph;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * 
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null)
    		return res;
        ArrayList<TreeNode> lastLayer = new ArrayList<TreeNode>();
        lastLayer.add(root);
        while(!lastLayer.isEmpty()){
        	ArrayList<TreeNode> curLayer = new ArrayList<TreeNode>();
        	ArrayList<Integer> singleRes = new ArrayList<Integer>();
        	for(TreeNode tmpNode:lastLayer){
        		singleRes.add(tmpNode.val);
        		if(tmpNode.left != null)
        			curLayer.add(tmpNode.left);
        		if(tmpNode.right != null)
        			curLayer.add(tmpNode.right);
        	}
        	res.add(singleRes);
        	lastLayer = curLayer;
        }
        return res;
    }
}
