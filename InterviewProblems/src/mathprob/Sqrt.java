package mathprob;

public class Sqrt {

	/**
	 * 
	 * Computational complexity

Using Newton's method as described above, the time complexity of calculating a root of a function  with -digit precision, provided that a good initial approximation is known, is  where  is the cost of calculating  with -digit precision.
	 * http://en.citizendium.org/wiki/Newton's_method#Computational_complexity
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrtv2(2));
	}

	static double threshold = 0.00000001;

	
	public static double sqrtv2(int n){
		if(n==1 || n==0)
			return n;
		double guess = n;
		double lastattempt = 0;
		do{
			lastattempt = guess;
			guess = (guess+n/guess)/2.0;
		}while(Math.abs(guess - lastattempt) > threshold);   //rember the absolute value
		return guess;
	}
	
	public static double sqrtv1(int n){
		if(n==1 || n==0)
			return n;
		double guess = 2;
		while(guess * guess - n > threshold){
			guess = (guess+((double)n)/guess)/2.0;
		}
		return guess;
	}
}
