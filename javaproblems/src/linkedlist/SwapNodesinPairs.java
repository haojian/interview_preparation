package linkedlist;

public class SwapNodesinPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode curtrack = headNode;
        ListNode oddNode = head;
        ListNode evenNode = head == null?null:head.next;
        while(oddNode != null && evenNode != null){
        	//swap
            curtrack.next = evenNode;
            oddNode.next = evenNode.next;
            evenNode.next = oddNode;
            //update for next iteration
            curtrack = oddNode;
            oddNode = curtrack.next;
            evenNode = oddNode==null?null:oddNode.next;

        }
        return headNode.next;
    }

}

/*
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
	
}*/