package basic;

public class IntegerToRoman {

	/**
	 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(9));
	}
	
	
	
	public static String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(num <1 || num >3999)
			return null;
		int ti = 0;
		String res = "";
		while(num != 0){
			int digit = num%10;
			res = digitToStr(ti, digit)+res;
			num /=10;
			ti+=2;
		}
        return res;
    }

	static char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	public static String digitToStr(int ti, int digit){
		String str = "";
		if(digit == 0)
			return "";
		if(digit == 1)
			return str+ symbols[ti];
		if(digit == 2)
			return str+symbols[ti] + symbols[ti];
		if(digit == 3)
			return str+symbols[ti] + symbols[ti]+ symbols[ti];
		if(digit == 4)
			return str+symbols[ti] + symbols[ti+1];
		if(digit == 5)
			return str+ symbols[ti+1];
		if(digit == 6)
			return str+ symbols[ti+1] + symbols[ti];
		if(digit == 7)
			return str+symbols[ti+1] + symbols[ti] + symbols[ti];
		if(digit == 8)
			return str+symbols[ti+1] + symbols[ti]+ symbols[ti] + symbols[ti];
		if(digit == 9)
			return str+symbols[ti] + symbols[ti+2];
		return "error";
	}
}
