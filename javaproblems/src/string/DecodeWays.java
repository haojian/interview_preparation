package string;

public class DecodeWays {

	/**
	 * 
	 * 
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("110"));
	}

	
    public static int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

    	if(s== null || s.length() == 0 || s.startsWith("0"))
    		return 0;
    	if(s.length() == 1)
    		return checkdigit(s.charAt(0));
    	int fn = 0, fn_1 = 0, fn_2 = 1;
    	fn_1 = checkdigit(s.charAt(0)) * checkdigit(s.charAt(1)) + checktwodigits(s.charAt(0), s.charAt(1));
    	for(int i=2; i<s.length();i++){
    		//if(s.sub)
    		if(checkdigit(s.charAt(i)) != 0) 
    			fn += fn_1;
    		if(checktwodigits(s.charAt(i-1), s.charAt(i)) != 0)
    			fn += fn_2;
    		if(fn == 0)
    			return 0;
    		fn_2 = fn_1;
    		fn_1 = fn;
    		fn=0;
    	}
    	return fn_1;
    }
    
    public static int checkdigit(char one){
    	return one!='0'?1:0;
    }
    
    public static int checktwodigits(char one, char two ){
    	return (one == '1' || (one =='2' && two <='6'))?1:0;
    }
}
