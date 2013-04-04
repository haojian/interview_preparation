package basic;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reversenumber(123));
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
}
