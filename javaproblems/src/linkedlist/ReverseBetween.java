package linkedlist;

public class ReverseBetween {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pseudo = new ListNode(0);
        pseudo.next = head;
        ListNode tNode = pseudo;
        int i=0;
        while(i<m-1){
            i++;
            tNode = tNode.next;
        }
        ListNode mpreNode = tNode;
        ListNode newNcpy = mpreNode.next; 

        while(i<n-1){
            i++;
            tNode = tNode.next;
        }
        ListNode nNxtcpy = tNode.next.next;
        //mpreNode.next = reverseList(mpreNode.next, tNode.next);
        //newNcpy.next = nNextcpy;
        
        return pseudo.next;
    }
	
	public ListNode reverseListInter(ListNode start, ListNode end){
		ListNode pseudo = new ListNode(0);
		pseudo.next = start;
		ListNode tNode = pseudo;
		while(tNode != end){
			ListNode   tCpy = tNode;
			tNode = tNode.next;
		}
		return pseudo.next;
	}

}
