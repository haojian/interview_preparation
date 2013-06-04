package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLeafsofSubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getLeafsDFS(new NTreeNode("test"), "test", false, new ArrayList<String>());
	}

	public static void getLeafsDFS(NTreeNode root, String name, boolean iftrue,ArrayList<String> res){
		if(root == null)
			return;
		if(root.children.size() == 0 && iftrue){
			res.add(root.name);
			return;
		}
		if(root.name.equals(name)){
			for(NTreeNode tmp:root.children)
				getLeafsDFS(tmp, name, true, res);
		}else{
			for(NTreeNode tmp:root.children)
				getLeafsDFS(tmp, name, iftrue, res);
		}
	}
	
	public static ArrayList<NTreeNode> getLeafs(NTreeNode root, String name){
		ArrayList<NTreeNode> res =  new ArrayList<NTreeNode>();
		NTreeNode newRoot= getNode(root, name);
		if(newRoot == null)
			return res;
		//traverse to get the leaf node with DFS
		
		
		return res;
	}
	
	public static NTreeNode getNode(NTreeNode root, String name){
		if(root==null)
			return null;
		Queue<NTreeNode> queue = new LinkedList<NTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			NTreeNode tmp = queue.poll();
			if(tmp.name.equals(name)){
				return tmp;
			}
			for(NTreeNode child:tmp.children){
				queue.offer(tmp);
			}
		}
		return null;
	}
}

class NTreeNode{
	String name;
	ArrayList<NTreeNode> children;
	public NTreeNode(String _name){
		name = _name;
		children = new ArrayList<NTreeNode>();
	}
}
