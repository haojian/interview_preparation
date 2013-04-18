package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumRootToLeaf {

	/**
	 * 
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
  The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.left = n1;
		n0.right = n2;
		System.out.println(sumNumbers(n0));
	}
	
    public static int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode traverseNode = root;
        int tmpnum = 0;
        while(traverseNode!= null || stack.size() != 0){
        	while(traverseNode != null){
        		tmpnum = traverseNode.val + tmpnum*10;
        		stack.push(traverseNode);
        		traverseNode = traverseNode.left;
        	}
        	res += tmpnum;
        	tmpnum /=10;
        	traverseNode = stack.pop();
        	traverseNode = traverseNode.right;
        }
        return res;
    }
    
}
