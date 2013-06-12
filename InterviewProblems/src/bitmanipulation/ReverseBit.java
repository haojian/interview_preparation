package bitmanipulation;

public class ReverseBit {

	/**
	 * http://leetcode.com/2011/08/reverse-bits.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reversebitv4(-4));
	}
	
	public static int reversebitv4(int x){
		long b = 0;
		while (x!=0){
			  b<<=1;
			  b|=( x &1);
			  x>>=1;
		}
		return (int)b;
	}
	
	//doesn't work for negative number
	public static int reversebitv3(int in){
		long res = 0;
		while(in!=0){
			int tmp = in%2;
			res = res * 2 + tmp;
			in/=2;
		}
		if(res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
			return (int)res;
	}
	
	//doesn't work for negative number
	public static int reversebitv2(int in){
		long res = 0;
		while(in>0){
			int tmp = in%2;
			res = res * 2 + tmp;
			in/=2;
		}
		if(res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int)res;
	}

	//with problem in overflow
	public static int reversebit(int in){
		int res = 0;
		while(in>0){
			int tmp = in%2;
			res = res * 2 + tmp;
			in/=2;
		}
		return res;
	}
}
