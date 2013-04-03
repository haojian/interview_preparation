package string;

public class ZigzagConvertor {

	/**
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
    public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(nRows <= 1)
    		return s;
    	int loopsize = nRows * 2 -2;
    	String res ="";
    	int base = 0;
    	for(int i=0; i<nRows; i++){
    		base = i;
    		while(base<s.length()){
    			res += s.charAt(base);
    			if(i>0 && i<nRows-1){
    				int ti = base + loopsize - 2 *i;
    				if(ti<s.length()){
    					res+=s.charAt(ti);
    				}
    			}
    			base += loopsize;
    		}
    		
    	}
    	
        return res;
    }

}
