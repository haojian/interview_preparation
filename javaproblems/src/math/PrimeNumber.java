package math;

import java.util.ArrayList;

public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getPrimeNum(100);
	}
	
	public static void getPrimeNum(int N){
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean[] flags = sieveofEratosthenes(N);
		for(int i=0; i<flags.length; i++){
			if(!flags[i])
				System.out.println(i);
		}
	}
	
	
	public static boolean[] sieveofEratosthenes(int N){
		boolean[] flags = new boolean[N+1];
		flags[0] = true;
		flags[1] = true;
		int count = 0;
		int prime = 2;
		while(prime <= Math.sqrt(N)){
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
			if(prime >= flags.length)
				break;
		}
		return flags;
	}
	
	public static void crossOff(boolean[] flags, int prime){
		for(int i=prime * prime; i<flags.length; i+= prime){
			flags[i] = true;
		}
	}

	public static int getNextPrime(boolean[] flags, int prime){
		int next =prime+1;
		while(next<flags.length && flags[next]){
			next++;
		}
		return next;
	}
}
