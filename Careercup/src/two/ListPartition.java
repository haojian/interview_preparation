package two;

import java.util.Random;

public class ListPartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		Random rand = new Random();
		ListNode tmp = head;
		for(int i=0;i<10; i++){
			tmp.next = new ListNode(rand.nextInt(100));
			tmp = tmp.next;
		}
		head.print();
		partition(head, 50);
		head.print();
	}
	
	public static void partition(ListNode head, int x){
		ListNode pseudoHead1 = new ListNode(-1);
		ListNode pseudoHead2 = new ListNode(-1);
		ListNode t1 = pseudoHead1;
		ListNode t2 = pseudoHead2;
		
		while(head !=null){
			if(head.data <x){
				t1.next = head;
				t1 = t1.next;
				head = head.next;
				t1.next = null;   //remember to reset.
			}
			else{
				t2.next = head;
				t2 = t2.next;
				head = head.next;
				t2.next = null;   //remember to reset.
			}
		}
		t1.next = pseudoHead2.next;
		head = pseudoHead1.next;
	}

}
