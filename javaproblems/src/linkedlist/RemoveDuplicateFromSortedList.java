package linkedlist;

public class RemoveDuplicateFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode startcpy = head;
        while(head!=null){
            if(head.next != null && head.next.val == head.val){
                head.next = head.next.next;
            }
            else
                head = head.next;
        }
        return startcpy;
    }
}
