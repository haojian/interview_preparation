package string;

public class ZigzagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //start 10:07
    //end 10:22
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1)
            return s;
        String res = "";
        int loopsize = 2*nRows-2;
        for(int i=0; i<nRows; i++){
            int index = i;
            if(i == 0 || i == nRows-1){
                while(index<s.length()){
                    res += s.charAt(index);
                    index += loopsize;
                }
            }else{
                while(index < s.length()){
                    res += s.charAt(index);
                    int next = index + loopsize- 2 * index %loopsize;
                    if(next < s.length())
                        res += s.charAt(next);
                    index += 2*nRows-2;
                }
            }
        }
        return res;
    }

}
