package graph;

import java.util.ArrayList;

public class ConstructBinaryTreeFromPreorderandInorder {

	/**
	 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] preorder = {1, 2, 4, 3, 5};
		//int[] inorder = {2, 4, 1, 5, 3};
		int[] preorder = {1, 2};
		int[] inorder = {1, 2};
		TreeNode tmp = buildTree(preorder, inorder);
		System.out.println(tmp.val);
	}

	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(preorder.length != inorder.length || inorder.length == 0)
    		return null;
    	int []preOrderTracker = new int[1];
    	preOrderTracker[0] = 0;
    	TreeNode root = new TreeNode(preorder[preOrderTracker[0]]);
    	int splittingIndex= findIndexByValue(inorder, preorder[0], 0, inorder.length);
    	preOrderTracker[0]++;
    	root.left = buildTreeRecur(preorder, inorder, 0, splittingIndex, preOrderTracker);
    	root.right = buildTreeRecur(preorder, inorder, splittingIndex+1, inorder.length, preOrderTracker);
        return root;
    }
    //static int preOrderTracker = 0;
    public static TreeNode buildTreeRecur(int[] preorder, int[] inorder, int siInorder, int eiInorder, int[] preOrderTracker){
    	if(preOrderTracker[0]>= preorder.length)
    		return null;
    	int split = findIndexByValue(inorder, preorder[preOrderTracker[0]], siInorder, eiInorder);
    	if( split == -1)
    		return null;
    	TreeNode root = new TreeNode(preorder[preOrderTracker[0]]);
    	preOrderTracker[0]++;
    	root.left = buildTreeRecur(preorder, inorder, siInorder, split, preOrderTracker);
    	root.right = buildTreeRecur(preorder, inorder, split+1, eiInorder, preOrderTracker);
    	return root;
    }
    
    public static int findIndexByValue(int[] inorder, int target, int si, int ei){
    	for(int i=si; i<ei; i++){
    		if(inorder[i] == target){
    			return i;
    		}
    	}
    	return -1;
    }
}
