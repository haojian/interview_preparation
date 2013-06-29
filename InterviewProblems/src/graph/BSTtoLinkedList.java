package graph;

public class BSTtoLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(5);
		root.left.right = new Node(2);
		root.right.left = new Node(4);
		
		traverse(root);
		Node tmp = root;
		while(tmp != null)
		{
			System.out.print(tmp.val + "\t");
			tmp = tmp.left;
		}
		System.out.println();
		tmp = root;
		while(tmp != null)
		{
			System.out.print(tmp.val+ "\t");
			tmp = tmp.right;
		}
	}
	static Node last = null;
	public static void traverse(Node root){
		if(root == null)
			return;
		traverse(root.left);
		root.left = last;
		if(last != null)
			last.right = root;
		last = root;
		traverse(root.right);
	}

}
