package string;

public class LongestNoRepeatSubstr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(test));
	}
	
    
    //start 9:23
    //end   9:28
    public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s.length() == 0)
    		return 0;
        int[] subStrsiEndHere = new int[s.length()];
        subStrsiEndHere[0] = 0;
        int max = 1;
        for(int i=1; i<s.length(); i++){
            String tmp = s.substring(subStrsiEndHere[i-1], i);
            int ci = tmp.lastIndexOf(s.charAt(i))+subStrsiEndHere[i-1];
            if(ci == -1)
                subStrsiEndHere[i] = subStrsiEndHere[i-1];
            else
            {
                subStrsiEndHere[i] = ci+1;
            }
            max = Math.max(max, i- subStrsiEndHere[i]+1);
        }   
        return max;
    }

}
