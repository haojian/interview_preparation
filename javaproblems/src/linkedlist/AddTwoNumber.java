package linkedlist;


public class AddTwoNumber {

	/**
	  @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode res = null;
        ListNode end = null;
        int update = 0;
        int val1 = 0;
        int val2 = 0;
        while(l1 != null || l2!= null || update != 0){
        	if(l1 != null){
        		val1 = l1.val;
                l1 = l1.next;
        	}
        	else
        		val1 = 0;
        	if(l2 != null){
        		val2 = l2.val;
        		l2 = l2.next;
        	}
        	else
        		val2 = 0;
            int digit = val1 + val2 + update;
            update = 0;
            if(digit>=10){
                update = 1;
                digit -= 10;
            }
            if(res == null){
            	res = new ListNode(digit);
            	end = res;
            }else{
            	end.next = new ListNode(digit);
            	end = end.next;
            }
        }
        return res;
    }
}
