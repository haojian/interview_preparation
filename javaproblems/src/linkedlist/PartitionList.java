package linkedlist;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode tmp  = partition(head, 2);
		System.out.println(tmp.val);
		System.out.println(tmp.next.val);
	}

    public static ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pseudoHead1 = new ListNode(0);
        ListNode pseudoHead2 = new ListNode(0);
        ListNode pheadCpy1 = pseudoHead1;
        ListNode pheadCpy2 = pseudoHead2;
        while(head != null){
            if(head.val < x){
            	pseudoHead1.next = head;
            	pseudoHead1 = pseudoHead1.next;
            }
            else{
            	pseudoHead2.next = head;
            	pseudoHead2 = pseudoHead2.next;
            }
            head = head.next;
        }
        pseudoHead1.next = pheadCpy2.next;
        pseudoHead2.next = null;
        return pheadCpy1.next;
    }
}
