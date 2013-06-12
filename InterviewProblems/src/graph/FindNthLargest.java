package graph;

public class FindNthLargest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node findNthLargest(Node root, int n){
		int[] counter = new int[1];
		return findNthLargestRecur(root, n, counter);
	}

	Node findNthLargestRecur(Node root, int n, int[] counter){
		if(root == null)
			return null;
		Node tmp = findNthLargestRecur(root.right, n, counter);
		if(tmp != null)	return tmp;
		if(counter[0] == n){
			return root;	
		}
		counter[0]++;
		tmp = findNthLargestRecur(root.left, n, counter);
		return tmp;
	}

}

class Node{
	int val;
	Node left;
	Node right;
}
