package linkedlist;

public class ReverseNodeKGroup {

	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode k0 = new ListNode(1);
		ListNode k1 = new ListNode(2);
		ListNode k2 = new ListNode(3);
		ListNode k3 = new ListNode(4);
		ListNode k4 = new ListNode(5);
		k0.next = k1;
		k1.next= k2;
		//k2.next = k3;
		//k3.next = k4;
		ListNode res = reverseKGroup(k0, 2);
	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(head == null)
    		return null;
    	ListNode pseudoHead = new ListNode(0);
    	pseudoHead.next = head;
    	ListNode preK = pseudoHead;
    	ListNode tracker = head;
    	ListNode[] array = new ListNode[k];
    	while(true){
    		int counter = 0;
    		for(int i=0; i<k; i++){
    			if(tracker==null)
    			{
    				break;
    			}
    			counter++;
    			array[i] = tracker;
    			tracker = tracker.next;
    		}
    		if(counter < k)
    			break;
    		preK.next = array[k-1];
    		ListNode localTracker = array[k-1];
    		for(int i=2; i<=k; i++){
    			localTracker.next = array[k-i];
    			localTracker = localTracker.next;
    		}
    		localTracker.next = tracker;
    		if(tracker == null){
    			break;
    		}
    		preK = localTracker;
    	}
    	return pseudoHead.next;
    }

}


