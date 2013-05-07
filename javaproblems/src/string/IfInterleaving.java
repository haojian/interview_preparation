package string;

public class IfInterleaving {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isInterleave("a", "b", "ab"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
    public static boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null || s2 == null || s3==null)
        	return false;
        return isInterLeave(s1, s2, s3, 0, 0, 0);
    }
    
    public static boolean isInterLeave(String s1, String s2, String s3, int s1i, int s2i, int s3i){
    	if(s3i == s3.length()){
    		if(s2i == s2.length() && s1i == s1.length())
    			return true;
    		else
    			return false;
    	}
    	boolean b13 = false;
    	boolean b23 = false;
    	if(s1i<s1.length() && s1.charAt(s1i) == s3.charAt(s3i)){
    		b13 = isInterLeave(s1, s2, s3, s1i+1, s2i, s3i+1);
    	} 
    	if(s2i <s2.length() && s2.charAt(s2i) == s3.charAt(s3i)){
    		b23 = isInterLeave(s1, s2, s3, s1i, s2i+1, s3i+1);
    	}
    	return b13 || b23;
    }

}
