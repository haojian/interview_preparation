package graph;

import java.util.ArrayList;

public class PathSum2 {

	/**
	 * @param args
	 * 
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	 ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return res;
        ArrayList<Integer> singleres = new ArrayList<Integer>();
        pathSumRecur(root, singleres, res, sum);
        return res;
    }

    public void  pathSumRecur(TreeNode root, ArrayList<Integer> singleres, ArrayList<ArrayList<Integer>> res, int sum){
    	if(root != null && root.left == null && root.right == null && root.val == sum ){
    		ArrayList<Integer> tmp =(ArrayList<Integer>)singleres.clone();
    		tmp.add(root.val);
    		res.add(tmp);
    		return;
    	}
    	if(root == null)
    		return;
    	singleres.add(root.val);
    	pathSumRecur(root.left, singleres, res, sum-root.val);
    	pathSumRecur(root.right, singleres, res, sum-root.val);
    	singleres.remove(singleres.size()-1);
    }
}
