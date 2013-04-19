package graph;

import java.util.ArrayList;
import java.util.Collections;

public class BottomUpTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
    			if(tmpNode.left != null)
    				curLayer.add(tmpNode.left);
    			if(tmpNode.right != null)
    				curLayer.add(tmpNode.right);
    			singleRes.add(tmpNode.val);
    		}
    		res.add(singleRes);
    		lastLayer = curLayer;
    	}
    	Collections.reverse(res);
    	return res;
    }
}
