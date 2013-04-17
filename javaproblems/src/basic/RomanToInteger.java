package basic;

public class RomanToInteger {

	/**
	 * 
	 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("XI"));
	}
	
    public static int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s==null || s.length()==0)
    		return 0;
    	int pos = s.length()-1;
    	int res = getChar(s.charAt(pos));
    	pos--;
    	while(pos>=0){
    		if(getChar(s.charAt(pos))>=getChar(s.charAt(pos+1)))
    			res += getChar(s.charAt(pos));
    		else
    			res -= getChar(s.charAt(pos));
    		pos--;
    	}
    	return res;
    }
    
    public static int getChar(char c){
    	switch(c){
    	  case 'I': return 1;
          case 'V': return 5;
          case 'X': return 10;
          case 'L': return 50;
          case 'C': return 100;
          case 'D': return 500;
          case 'M': return 1000; 
    	}
    	return 0;
    }
}
