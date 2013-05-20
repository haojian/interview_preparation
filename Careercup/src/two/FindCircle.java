package two;

public class FindCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for(int i=0;i<1; i++){
			tmp.next = new ListNode(i+1);
			tmp = tmp.next;
		}
		tmp.next = head.next;
		//head.print();
		System.out.println(findCircular(head).data);
	}

	
	public static ListNode findCircular(ListNode head){
		ListNode node1 = head.next;
		ListNode node2 = head.next.next;
		while( node2!=node1){
			node2 = node2.next.next;
			node1 = node1.next;
		}
		node2 = head;
		while(node2!=node1){
			node2=node2.next;
			node1=node1.next;
		}
		return node1;
	}
}
