package basic;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int fib_iterative(int n){
		if(n == 0){
			return 0;
		}
		int a = 1;
		int b = 1;
		for(int i = 3; i<=n; i++){
			int c = a+b;
			a = b;
			b = c;
		}
		return b;
	}
	
	private static int fibTable[] = new int[46];
	
	public static int fib_recursive(int n){
		if(n == 0)
			return fibTable[0] = 0;
		if(n == 1)
			return fibTable[1] = 1;
		else if(n > 1){
			if(fibTable[n] != 0)
				return fibTable[n];
			else
				return fibTable[n] = fib_recursive(n-1) + fib_recursive(n-2);
		}
		else
			return -1;
	}
}
