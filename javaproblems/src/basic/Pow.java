package basic;

public class Pow {

	/**
	 * Points:
	 * 	1. negative number.
	 *  2. boundary of negative number would be over flowy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n<0)
            return 1/(pow(x, -n-1)*x);
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n==2)
            return x*x;
        else{
            if(n%2 == 1){
                double tmp = pow(x, n/2);
                return tmp * tmp *x;
            }
            else{
                double tmp = pow(x, n/2);
                return tmp * tmp;
            }
        }
    }
}
