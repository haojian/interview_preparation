package string;

public class LongestCommonSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestCommonSequenceV2("XMJYAUZ", "MZJAWXU"));
	}
	
	public static String LongestCommonSequenceV2(String a, String b){
		String[][] dp = new String[a.length()+1][b.length()+1];
		for(int i=0; i<=a.length(); i++){
			for(int j=0; j<=b.length(); j++){
				dp[i][j]="";
			}}
		String max = "";
		for(int i=0; i<a.length(); i++){
			for(int j=0; j<b.length(); j++){
				if(a.charAt(i) == b.charAt(j)){
					dp[i+1][j+1] = dp[i][j]+a.charAt(i);
				}else{
					max = dp[i][j+1].length()>dp[i+1][j].length()?dp[i][j+1]:dp[i+1][j];
					dp[i+1][j+1] = max; 
				}
			}
		}
		return dp[a.length()][b.length()];
	}

	public static String LongestCommonSequence(String a, String b){
		String[][] longgestCommonSequences = new String[a.length()+1][b.length()+1];
		int max = 0;
		String maxStr = "";
		for(int i=0; i<a.length(); i++){
			for(int j=0; j<b.length(); j++){
				if(longgestCommonSequences[i][j] == null)
					longgestCommonSequences[i][j]="";
				if(a.charAt(i) == b.charAt(j)){
					longgestCommonSequences[i+1][j+1] = longgestCommonSequences[i][j] + b.charAt(j);
					if(longgestCommonSequences[i+1][j+1].length() > max){
						max = longgestCommonSequences[i+1][j+1].length();
						maxStr= longgestCommonSequences[i+1][j+1];
					}
				}
				else
					longgestCommonSequences[i+1][j+1] = longgestCommonSequences[i+1][j];
				
			}
		}
		return maxStr;
		
	}
}
