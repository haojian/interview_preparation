package math;

public class IntegerDivide {

	/**
	 * Divide two integers without using multiplication, division and mod operator.


	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, 1));
	}
	
    public static int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	long dividendL = dividend;
    	long divisorL = divisor;
    	if(divisor == 0)
    		return Integer.MAX_VALUE;
    	
    	boolean ifPos = true;
    	if(dividend < 0 && divisor <0 || dividend > 0 && divisor >0)
    		ifPos = true;
    	else
    		ifPos = false;
    	dividendL = Math.abs(dividendL); 
    	divisorL = Math.abs(divisorL);
    	
    	int res = 0;
    	int digitCounter = 0;
    	long num = divisorL;
    	while((num<<1 ) <= dividendL){
    		num = num<<1;
    		digitCounter++;
    	}                      
    	
    	for(int i=digitCounter; i>=0;i--){
    		if( (divisorL << i) <= dividendL){
    			res += 1 << i;
    			dividendL -= divisorL<<i;
    		}
    	}
    	
    	if(ifPos)
    		return res;
    	else
    		return 0-res;
    }

}
