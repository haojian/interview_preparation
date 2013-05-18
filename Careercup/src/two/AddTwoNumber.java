package two;

import java.util.Random;

public class AddTwoNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();

		ListNode num1 = new ListNode(0);
		ListNode tmp = num1;
		for(int i=0;i<rand.nextInt(9)+3; i++){
			tmp.next = new ListNode(rand.nextInt(9)+1);
			tmp = tmp.next;
		}
		ListNode num2 = new ListNode(0);
		tmp = num2;
		for(int i=0;i<rand.nextInt(9)+3; i++){
			tmp.next = new ListNode(rand.nextInt(9)+1);
			tmp = tmp.next;
		}
		num1.next.print();
		num2.next.print();
		addNumbersForward(num1.next, num2.next).print();
	}
	
	
	public static ListNode addNumbersReverse(ListNode num1, ListNode num2){
		int update =0;
		ListNode pseudo = new ListNode(0);
		ListNode tmp = pseudo;
		while(num1!=null || num2 != null || update !=0){
			int sum=0;
			if(num1 !=null){
				sum+= num1.data;
				num1 = num1.next;
			}
			if(num2 !=null){
				sum+=num2.data;
				num2= num2.next;
			}
			sum += update;
			update =0;
			if(sum >= 10){
				sum-=10;
				update =1;
			}
			tmp.next = new ListNode(sum);
			tmp = tmp.next;
		}
		return pseudo.next;
	}
	
	public static ListNode addNumbersForward(ListNode num1, ListNode num2){
		int len1 = 0;
		int len2 = 0;
		
		ListNode num1cpy = num1;
		ListNode num2cpy = num2;
		while(num1!=null){
			len1++;
			num1=num1.next;
		}
		while(num2!=null){
			len2++;
			num2=num2.next;
		}
		return addNumbersForwardwithLength(num1cpy, num2cpy, len1, len2);
	}
	
	
	public static ListNode addNumbersForwardwithLength(ListNode num1, ListNode num2, int len1, int len2){
		ListNode pseudo = new ListNode(0);
		ListNode tnode = pseudo;
		if(len1>len2){
			addNumbersForwardwithLength(num2, num1, len2, len1);
		}
		int[] arr1 = new int[len2+1];
		int[] arr2 = new int[len2+1];
		int[] sum = new int[len2+1];

		int counter =0;
		while(num2!=null){
			arr2[counter+1] = num2.data;
			counter++;
			num2= num2.next;
		}
		int dist = len2-len1;
		counter =0;
		while(num1 !=null){
			arr1[counter+dist+1] = num1.data;
			counter++;
			num1 = num1.next;
		}
		int update =0;
		for(int i=len2; i>=0; i--){
			sum[i] = arr1[i]+arr2[i]+update;
			if(sum[i]>=10){
				update = 1;
				sum[i]-=10;
			}
		}

		if(sum[0] != 0){
			tnode.next = new ListNode(sum[0]);
			tnode = tnode.next;
		}
		for(int i=1; i<sum.length;i++){
			tnode.next = new ListNode(sum[i]);
			tnode = tnode.next;
		}
		return pseudo.next;
	}

}
