package basic;

public class MultiplyString {

	/**
	 * 
	 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("999", "999"));
	}

	
    public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] digits = new int[1000];
    	int[] update = new int[1000];
    	for(int i=0; i<num1.length(); i++){
    		for(int j=0; j<num2.length(); j++){
    			int a = num1.charAt(num1.length()-i-1)-'0';
    			int b = num2.charAt(num2.length()-j-1)-'0';
    			int product = a * b;
    			digits[i+j] += product%10;
    			update[i+j+1] += product/10;
    		}
    	}
    	for(int i=0; i<1000; i++){
    		digits[i] = digits[i]+update[i];
    		int tmp = digits[i];
    		digits[i] = tmp%10;
    		if(tmp>=10){
    			tmp = tmp/10;
    			digits[i+1] += tmp;
    		}
    	}
    	
    	String res = "";
    	boolean ifStarted = false;
    	for(int i=999; i>=0; i--){
    		if(ifStarted == false && digits[i] != 0)
    			ifStarted = true;
    		if(ifStarted)
    			res += digits[i];
    	}
    	if(res.length()==0)
    		return "0";
        return res;
    }
    
    public static void autoUpdate(int[] digits, int index){
    	int tmp = digits[index];
    	while(tmp>0){
        	digits[index] = tmp%10;
        	index++;
        	tmp = tmp/10;
    	}
    }
}
