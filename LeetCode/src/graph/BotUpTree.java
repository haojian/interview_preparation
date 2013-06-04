package graph;


public class BotUpTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= new int[10];
		for(int i=0; i<10; i++){
			A[i] = i;
		}
		
		
	}

	
	public static TreeNode arrayToTree(int[] A){
		int l = A.length;
		TreeNode root = new TreeNode(A[0]);
		/*
		for(int i=0; i<A.length; i++){
			
		}
		*/
		return null;
	}
}


class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int _val){
		val = _val;
	}
}