package string;

public class ValiadPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int si = 0;
        int ei = s.length()-1;
        s = s.toLowerCase();
        while(si<ei){
            if(!(s.charAt(si)>= 'a' && s.charAt(si)<='z') && !(s.charAt(si)>='0' &&s.charAt(si)<='9'))
                si++;
            else if(!(s.charAt(ei)>= 'a' && s.charAt(ei)<='z') && !(s.charAt(ei)>='0' &&s.charAt(ei)<='9'))
                ei--;
            else if(s.charAt(ei) == s.charAt(si)){
                si++;
                ei--;
            }else{
                return false;
            }
        }
        return true;
    }
}
