package linkedlist;

public class RotateLinkedList {

	/**
	 * 
	 * 
	 * 
	 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

	 * @param args
	 */
	
	
	
	///points: think about null linked list and divide by 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n==0)
    		return head;
    	
    	ListNode tracker1 = head, tracker2 = head;
    	int length = 0;
    	while(tracker1 != null){
    		tracker1=tracker1.next;
    		length++;
    	}
    	if(length == 0 || n %length == 0)
    		return head;
    	int dist = n %length;
    	tracker1 = head;

    	while(dist>0){
    		tracker1 = tracker1.next;
    		dist--;
    	}
    	
    	while(tracker1 != null && tracker1.next!=null && tracker2 !=null && tracker2.next !=null){
    		tracker1 = tracker1.next;
    		tracker2 = tracker2.next;
    	}
    	 
    	tracker1.next = head;
    	head = tracker2.next;
    	tracker2.next = null;
    	return head;
    }
    
}
