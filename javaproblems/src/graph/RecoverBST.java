package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecoverBST {

	/**
	 * 
	 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
  
    //O(n) space

    public void traverseTree(TreeNode root, ArrayList<Integer> valLists, ArrayList<TreeNode> nodesLists){
    	if(root != null){
    		traverseTree(root.left, valLists, nodesLists);
    		nodesLists.add(root);
    		valLists.add(root.val);
    		traverseTree(root.right, valLists, nodesLists);
    	}
    }
    
    public void recoverTreeNSpace(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> nodesLists = new ArrayList<TreeNode>();
        ArrayList<Integer> valLists = new ArrayList<Integer>();
        
    	traverseTree(root, valLists, nodesLists);
    	Integer[] tmp = valLists.toArray(new Integer[0]);
    	Arrays.sort(tmp);
        for(int i=0; i<nodesLists.size(); i++){
        	nodesLists.get(i).val = tmp[i];
        }
    }
    
    public static void test(){
    	Integer[] tmp = {3,2, 1};
    	Arrays.sort(tmp);
    	System.out.println(tmp[0]+"\t" + tmp[1] +"\t"+ tmp[2]);
    }
    
    public TreeNode getConflict(TreeNode root){
    	return null;
    }

}
