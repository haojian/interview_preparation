package basic;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = digits.length-1;
        digits[i]+=1;
        
        while(digits[i]>=10){
            digits[i] %=10;
            i--;
            if(i<0){
                int[] res = new int[digits.length+1];
                res[0] = 1;
                for(int j=0; j<digits.length;j++)
                    res[j+1] = digits[j];
                return res;
            }
            digits[i]+=1;
        }
        return digits;
    }
}
