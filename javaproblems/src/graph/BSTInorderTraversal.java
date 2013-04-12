package graph;

import java.util.ArrayList;
import java.util.Stack;

public class BSTInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	inorderTraversalRecur(root, res);
    	return res;
    }
    
    public void inorderTraversalRecur(TreeNode root, ArrayList<Integer> res ) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root != null){
    		inorderTraversalRecur(root.left, res);
    		res.add(root.val);
    		inorderTraversalRecur(root.right, res);
    	}
    }
    
    public void inorderTraversalIter(TreeNode root, ArrayList<Integer> res ) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode traverseNode = root;
    	while(stack.size() > 0 || traverseNode != null){
    		while(traverseNode != null){
    			stack.push(traverseNode);
    			traverseNode = traverseNode.left;
    		}
    		traverseNode = stack.pop();
    		res.add(traverseNode.val);
    		traverseNode = traverseNode.right;
    	}
    }
}
