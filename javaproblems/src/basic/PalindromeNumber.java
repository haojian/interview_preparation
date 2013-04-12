package basic;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome2(313));
	}
    public static boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int enddigit = x%10;
        //int startdigit 
        return false;
    }
    
    public static int reversenumber(int x){
    	int res = 0;
    	while(x>0){
    		res = res * 10 + x%10;
    		x /=10;
    	}
    	return res;
    }
    
    public static boolean isPalindrome2(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0)
            return false;
        int largestDig = 1;
        int tmp = x;
        while((tmp=tmp/10) > 0){
            largestDig *=10;
        }
        System.out.println(largestDig);
        while(x >= 10){
            int digit1 = x/largestDig;
            int digit2 = x%10;
            if(digit1 != digit2)
                return false;
            x = (x- digit1*largestDig-digit2)/10;
            largestDig/=100;
        }
        return true;
    }
}
