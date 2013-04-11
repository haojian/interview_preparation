package graph;

import java.util.ArrayList;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree tmp = new SymmetricTree();
		tmp.isSymmetricRecur(new TreeNode(1));
	}
	
    public boolean isSymmetricRecur(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> resList = new ArrayList<Integer>();
    	traverse(root, resList);
    	return isPalindrome(resList);
    }
    
    public void traverse(TreeNode root, ArrayList<Integer> res){
    	if(root != null){
    		traverse(root.left, res);
    		res.add(root.val);
    		traverse(root.right, res);
    	}
    }
    
    public boolean isPalindrome(ArrayList<Integer> input){
    	if(input.size()!= 0 && input.size()%2 == 0)
    		return false;
    	int si = 0;
    	int ei = input.size()-1;
    	while(si<ei){
    		if(input.get(si) == input.get(ei)){
    			si++;
    			ei--;
    		}else
    			return false;
    	}
    	return true;
    }
    
    public boolean isSymmetricIter(TreeNode root){
    	return false;
    }

}
