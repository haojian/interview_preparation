package graph;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeZigZagLevelOrderTraversal {

	/**
	 * 
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null)
    		return res;
    	ArrayList<TreeNode> lastLayer = new ArrayList<TreeNode>();
    	lastLayer.add(root);
    	int depth = 0;
    	while(!lastLayer.isEmpty()){
    		ArrayList<TreeNode> curLayer = new ArrayList<TreeNode>();
    		ArrayList<Integer> singleRes = new ArrayList<Integer>();
    		depth++;
    		for(TreeNode tmpNode: lastLayer){
    			singleRes.add(tmpNode.val);
    			if(tmpNode.left != null){
    				curLayer.add(tmpNode.left);
    			}
    			if(tmpNode.right != null){
    				curLayer.add(tmpNode.right);
    			}
    		}
    		if(depth %2 == 0)
    			Collections.reverse(singleRes);
    		res.add(singleRes);
    		lastLayer = curLayer;
    	}
    	return res;
    }
}
