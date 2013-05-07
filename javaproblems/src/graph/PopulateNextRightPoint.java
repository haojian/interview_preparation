package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PopulateNextRightPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null)
    		return;
    	ArrayList<TreeLinkNode> curLayer = new ArrayList<TreeLinkNode>();
    	curLayer.add(root);
    	while(!curLayer.isEmpty()){
    		ArrayList<TreeLinkNode> nextLayer = new ArrayList<TreeLinkNode>();
    		for(int i=0; i<curLayer.size(); i++){
    			if(curLayer.get(i).left != null)
    				nextLayer.add(curLayer.get(i).left);
    			if(curLayer.get(i).right != null)
    				nextLayer.add(curLayer.get(i).right);
    		}
    		for(int i=0; i<curLayer.size()-1; i++){
    			curLayer.get(i).next = curLayer.get(i+1);
    		}
    		curLayer.get(curLayer.size()-1).next = null;
    		curLayer = nextLayer;
    	}
    }
    
    //constant space
    public void connectv2(TreeLinkNode root){
    	if(root == null)
    		return;
    	TreeLinkNode next = null;
    	connectv2Recur(root, next);
    }
    
    public void connectv2Recur(TreeLinkNode root, TreeLinkNode next){
    	if(root == null)
    		return;
    	root.next = next;
    	connectv2Recur(root.left, root.right);
    	if(root.next != null)
    		connectv2Recur(root.right, root.next.left);
    	else
        	connectv2Recur(root.right, null);
    }
}

class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
