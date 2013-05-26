package linkedlist;

public class RemoveDuplicatesfromSortedList2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(head == null)
    		return null;
        ListNode pseduoHead = new ListNode(-1);
        ListNode preNode = pseduoHead;
        ListNode firstDistNode = head;
        while(firstDistNode != null){
        	ListNode curNode = firstDistNode.next;
        	Boolean flag =false;
        	
        	while(curNode != null && curNode.val == firstDistNode.val){
        		curNode = curNode.next;
        		flag = true;
        	}
        	
        	if(flag)
        		firstDistNode = curNode;
        	else
        	{
        		preNode.next = firstDistNode;
        		preNode = preNode.next;
        		firstDistNode = firstDistNode.next;
        	}
        }
        preNode.next = null;    //very important to reset.
        return pseduoHead.next;
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
