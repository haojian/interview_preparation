package basic;

public class Atoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("2147483648"));
		System.out.println(Integer.MAX_VALUE);
	}
	
    public static int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int factor = 1;
    	int res = 0;
    	int startIndex = 0;
    	str = str.trim();
    	if(str.startsWith("-")){
    		factor = -1;
    		startIndex++;
    	}
    	else if(str.startsWith("+")){
    		factor = 1;
    		startIndex++;
    	}
    	for(int i=startIndex; i<str.length();i++){
    		if(str.charAt(i) >='0' && str.charAt(i)<='9'){
    			int tmp = str.charAt(i)-'0';
    			if((Integer.MAX_VALUE-tmp)/10 < res )
    				return factor == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
    			res = res * 10 + tmp;
    		}
    		else
    			break;
    	}
        return res*factor;
    }

}
