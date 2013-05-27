package linkedlist;

public class ReverseLinkedList2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pseudo = new ListNode(-1);
        pseudo.next = head;
        ListNode preNode = pseudo;
        ListNode mNode = pseudo;
        ListNode tNode = pseudo;
        while(m>0){
            if(m==1)
                preNode = mNode;
            mNode = mNode.next;
            tNode = tNode.next;
            m--;
            n--;
        }
        tNode = tNode.next;
        //n--;
        while(n>0){
            mNode.next = tNode.next;
            tNode.next = preNode.next;
            preNode.next = tNode;
            tNode = mNode.next;
            n--;
        }
        return pseudo.next;
    }
}
