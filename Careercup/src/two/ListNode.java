package two;

public class ListNode {	
	ListNode next = null;
	int data;
	
	public ListNode(int val)
	{
		data = val;
	}
	
	public void print(){
		ListNode tmp = this;
		while(tmp!=null){
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}
		System.out.println("");
	}
}
