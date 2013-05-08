package basic;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int update =0;
        ListNode pseudoHead = new ListNode(0);
        ListNode curNode = pseudoHead;

        while(l1!=null || l2!= null || update !=0){
            curNode.next = new ListNode(0);
            curNode = curNode.next;
            if(l1!=null){
                curNode.val +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                curNode.val += l2.val;
                l2 = l2.next;
            }
            curNode.val+=update;
            update = 0;
            if(curNode.val >=10){
                curNode.val %=10;
                update =1;
            }
                
        }
        return pseudoHead.next;
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