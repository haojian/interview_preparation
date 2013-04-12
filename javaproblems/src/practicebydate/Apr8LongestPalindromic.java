package practicebydate;

public class Apr8LongestPalindromic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findLongestCommonString(String str1, String str2){
        String dp[][] = new String[str1.length()+1][str2.length()+1];
        String maxStr = "";
        int max = 0;
        for(int i =0;i<str1.length(); i++){
            for(int j =0; j<str2.length(); j++){
                if(dp[i][j] == null)
                    dp[i][j] = "";
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+str1.charAt(i);
                    if( dp[i+1][j+1].length() > max && ifPalindrome(dp[i+1][j+1])){
                     max = dp[i+1][j+1].length();
                     maxStr = dp[i+1][j+1];
                    }
                }
            }
        
        }
        return maxStr;
    }
    
        public static boolean ifPalindrome(String s){
		int si = 0;
    	int ei = s.length()-1;
		while(si < ei){
			if(s.charAt(si) != s.charAt(ei))
				return false;
			si++;
			ei--;
		}
		return true;
	}
    
    public String reversString(String input){
        int si = 0;
        int ei = input.length()-1;
        char[] res = input.toCharArray();
        while(si<ei){
            if(res[si]!=res[ei]){
            res[si] = (char)(res[si]^ res[ei]);
            res[ei] =(char) (res[si]^ res[ei]);
            res[si] = (char)(res[si] ^ res[ei]);
            }
            si++;
            ei--;
        }
        return new String(res);
    }
}
