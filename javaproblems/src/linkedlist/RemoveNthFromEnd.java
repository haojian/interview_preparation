package linkedlist;

public class RemoveNthFromEnd extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode tmp = new ListNode(1);
		removeNthFromEnd(tmp,1);
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode tracker1 = new ListNode(0);
        ListNode startCpy = tracker1;
        tracker1.next = head;
        ListNode tracker2 = null;
        for(int i=0; i<n+1; i++){
            if(tracker1 == null)
                return head;
            tracker1 = tracker1.next;
        }
        tracker2 = startCpy;
        while(tracker1 != null){
            tracker2 = tracker2.next;
            tracker1 = tracker1.next;
        }
        tracker2.next = tracker2.next.next;
        	
        
        return startCpy.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
