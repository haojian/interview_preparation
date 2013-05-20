package two;

import java.util.Stack;

public class IfPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(-1);
		ListNode tmp = head;
		for(int i=0;i<10; i++){
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		for(int i=8; i>=0;i--){
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		head.next.print();
		System.out.println(ifPalindrome(head.next));
	}
	
	public static boolean ifPalindrome(ListNode head){
		int length = 0;
		ListNode tmp = head;
		while(tmp != null){
			tmp = tmp.next;
			length++;
		}
		tmp = head;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<length/2;i++){
			stack.push(tmp.data);
			tmp = tmp.next;
		}
		if(length%2==1)
			tmp = tmp.next;
		while(tmp!=null){
			if(stack.pop() != tmp.data)
				return false;
			tmp = tmp.next;
		}
		return true;
	}

}
