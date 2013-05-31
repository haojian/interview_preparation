package graph;

import java.util.ArrayList;

public class UnqiueBST2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return generateHelper(1, n);
    }
    
    public ArrayList<TreeNode> generateHelper(int si, int ei){
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if(si>ei){
    		res.add(null);
    		return res;
    		}
    	for(int i=si; i<=ei; i++){
    		ArrayList<TreeNode> leftList = generateHelper(si, i-1);
            ArrayList<TreeNode> rightList = generateHelper(i+1, ei);
            for(int j=0; j<leftList.size(); j++){
            	for(int k=0; k<rightList.size(); k++){
            		TreeNode root = new TreeNode(i);
            		root.left = leftList.get(j);
            		root.right = rightList.get(k);
            		res.add(root);
            	}
            }
    	}
    	return res;
    }
    
    

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; left = null; right = null; }
}
