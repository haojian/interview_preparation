package string;

public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"abc", "abcd", "abcdefd", "ab"};
		String[] input1 = {"ac", "bcd", "abcdefd", "ab"};
		System.out.println(longestCommonPrefix(input));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(strs.length == 0)
    		return "";
    	return longestCommonPrefixRecursive(strs, 0, strs.length-1);
    }
    
    public static String longestCommonPrefixRecursive(String[] strs, int si, int ei) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(si == ei)
    		return strs[si];
    	if(ei-si == 1)
    	{
    		int prefixend = 0;
    		while(prefixend<strs[ei].length() && prefixend<strs[si].length()){
    			if(strs[ei].charAt(prefixend) == strs[si].charAt(prefixend)){
    				prefixend++;
    			}
    			else
    				break;
    		}
    		return strs[ei].substring(0, prefixend);
    	}
    	String[] tmp = new String[2];
    	tmp[0] = longestCommonPrefixRecursive(strs, si, (ei+si)/2);
    	tmp[1] = longestCommonPrefixRecursive(strs, (ei+si)/2+1, ei);
        return longestCommonPrefixRecursive(tmp, 0, 1);
    }
	
    public static String longestCommonPrefixBruteForce(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int shortestl = Integer.MAX_VALUE;
    	String proposedStr = "";
    	for(String tmp:strs){
    		if(tmp.length()<shortestl){
    			shortestl = tmp.length();
    			proposedStr = tmp;
    		}
    	}
    	for(int i = 0 ; i< strs.length;i++){
    		if(!strs[i].startsWith(proposedStr)){
    			i=0;
    			proposedStr = proposedStr.substring(0, proposedStr.length()-1);
    		}
    		
    		if(proposedStr.length() == 0)
    			break;
    	}
        return proposedStr;
    }
}
