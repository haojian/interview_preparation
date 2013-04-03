package string;

public class LongestCommonContiguousIntersection {
	private static char[] inputA = "abcdefghi".toCharArray();
	private static char[] inputB = "fefsfabcddes".toCharArray();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCommonIntersection(inputA, inputB);
	}
	
	public static void getCommonIntersection(char[] lista, char[] listb){
		int max = -1;
		String longestStr = "";
		String longestResults[][] = new String[lista.length+1][listb.length+1];
		for(int i =0; i<listb.length; i++){
			char listbChar = listb[i];
			for(int j = 0; j<lista.length; j++){
				if(longestResults[j][i] == null){
					longestResults[j][i] = "";
				}
				if(listbChar == lista[j]){
					longestResults[j+1][i+1] = longestResults[j][i] + listbChar;
					if(longestResults[j+1][i+1].length() > max){
						max = longestResults[j+1][i+1].length();
						longestStr = longestResults[j+1][i+1];
					}
				}
			}
		}
		System.out.println(max + " : " + longestStr);
	}
}
