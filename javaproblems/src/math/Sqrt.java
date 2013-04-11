package math;

public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(sqrt(16));
		System.out.println(sqrt(2147395599));
	}
	
	
    public static int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(x==0)
    		return 0;
        double guess = x;
        double lastAttempt = 0;
        do{
        	lastAttempt = guess;
        	guess = (x/guess + guess)/2;
        }while(Math.abs(guess - lastAttempt) > 0.0001);
        return (int) guess;
    }
}
