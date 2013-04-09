package string;

public class LongestCommonSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestCommonSequence("XMJYAUZ", "MZJAWXU"));
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
