package practicebydate;

public class Apr8ZigzagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("A",1));
	}

    public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(nRows == 1){
    		return s;
    	}
        int loopsize = nRows*2-2;
        String res= "";
        for(int i=0; i<nRows;i++){
            int indexTracker = i;
            while(indexTracker < s.length()){
                res += s.charAt(indexTracker);
                if(i!=0 && i!= nRows-1){
                    int secondTracker = indexTracker + loopsize - i*2;
                    if(secondTracker<s.length())
                        res += s.charAt(secondTracker);
                }
                indexTracker += loopsize;
            }
        }
        return res;
    }
}
