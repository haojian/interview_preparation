package linkedlist;

public class SortLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		ListNode tracker = head;
		tracker.next = new ListNode(3);
		tracker = tracker.next;
		tracker.next = new ListNode(5);
		tracker = tracker.next;
		tracker.next = new ListNode(1);
		tracker= head;
		while(tracker != null){
			System.out.println(tracker.val);
			tracker = tracker.next;
		}
		System.out.println("-----------------");
		ListNode res = sortListNode(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static ListNode sortListNode(ListNode head){
		ListNode speed2=head, speed1 = head;
		while(speed2!= null && speed2.next != null){
			speed1 = speed1.next;
			speed2 = speed2.next.next;
		}
		if(speed2 != null)
			speed2 = speed2.next;
		return mergeSortedLinkedList(quickSortLinkedList(head, speed1), quickSortLinkedList(speed1, speed2));
	}
	
	public static ListNode quickSortLinkedList(ListNode start, ListNode end){
		if(start==end || start.next == end)
		{
			start.next = null;
			return start;
		}
		ListNode speed2=start, speed1 = start;
		while(speed2!= end && speed2.next != end){
			speed1 = speed1.next;
			speed2 = speed2.next.next;
		}
		if(speed2 != end)
			speed2 = speed2.next;
		
		return mergeSortedLinkedList(quickSortLinkedList(start, speed1), quickSortLinkedList(speed1, end));
	}

	
	public static ListNode mergeSortedLinkedList(ListNode head1, ListNode head2){
		ListNode pesudoNode = new ListNode(0);
		ListNode tracker = pesudoNode;
		while(head1 !=null && head2!=null){
			if(head1.val < head2.val){
				tracker.next = head1;
				tracker = tracker.next;
				head1= head1.next;
			}else{
				tracker.next = head2;
				tracker = tracker.next;
				head2 = head2.next;
			}
		}
		tracker.next = head1!=null? head1: head2;
		return pesudoNode.next;
	}
}
