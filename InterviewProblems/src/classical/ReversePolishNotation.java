package classical;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcd 123 + 2 - 2";
		System.out.println(calcRPN(input));
		 
	}
	
	 public static boolean nextIsOperator(String next) {
		    return (next.equals("+") || next.equals("-") || next.equals("*") || next
		        .equals("/"));
		  }
	
	public static double calcRPN(String input){
		input = input.trim();
		String next;
		Stack<Double> stack = new Stack<Double>();
		Scanner scan = new Scanner(input);
		while(scan.hasNext()){
			next = scan.next();
			if(nextIsOperator(next)){
				if(stack.size() > 1){
					if(next.equals("+"))
						stack.push(stack.pop() + stack.pop());
					else if(next.equals("-"))
						stack.push(-1* stack.pop() + stack.pop());
					else if(next.equals("*"))
						stack.push(stack.pop() * stack.pop());
					else if (next.equals("/")){
						double divider = stack.pop();
						double num = stack.pop();
						if(divider == 0)
						{
							System.out.println("Divide by zero");
						}else
							stack.push(num/divider);
					}
				}else{
					 System.out.println(" too many operators");
					 return 0;
				}
			}else{
				
			}
		}
		if(stack.size() >1){
			 System.out.println("There too many numbers and not enough mathematical operators with which to evaluate them.");
			 return 0;
		}
		return stack.pop();
	}

}
