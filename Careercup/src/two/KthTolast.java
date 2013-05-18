package two;

public class KthTolast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for(int i=0;i<10; i++){
			tmp.next = new ListNode(i+1);
			tmp = tmp.next;
		}
		head.print();
		System.out.println("\n"+findKthtoLast(head, 11).data);
	}
	
	public static ListNode findKthtoLast(ListNode head, int k){
		ListNode node1 = head;
		ListNode node2 = head;
		while(k>0){
			k--;
			if(node1 == null)
				return null;
			node1 = node1.next;
		}
		while(node1!=null){
			node1 = node1.next;
			node2 = node2.next;
		}
		return node2;
	}

}
