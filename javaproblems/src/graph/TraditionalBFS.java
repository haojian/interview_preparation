package graph;

import java.util.LinkedList;
import java.util.Queue;

public class TraditionalBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void BFS(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(queue.isEmpty()){
			queue.poll();
			queue.offer(root.left);
		}
	}
}
