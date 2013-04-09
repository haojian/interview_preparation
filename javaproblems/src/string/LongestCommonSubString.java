package string;

public class LongestCommonSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestCommonString("abcdefghi", "fefsfabcddes"));
	}
	
	public static String LongestCommonString(String a, String b){
		String[][] longestStrings = new String[a.length()+1][b.length()+1];
		int max = 0;
		String maxstr = "";
		for(int i=0; i<a.length(); i++){
			for(int j = 0; j<b.length(); j++){
				if(longestStrings[i][j] == null)
					longestStrings[i][j] = "";
				if(a.charAt(i) == b.charAt(j)){
					longestStrings[i+1][j+1] = longestStrings[i][j] + a.charAt(i);
					if(longestStrings[i+1][j+1].length() > max){
						max = longestStrings[i+1][j+1].length();
						maxstr = longestStrings[i+1][j+1];
					}
				}
			}
		}
		return maxstr;
	}
}
