package string;

import java.util.ArrayList;

public class KMPStringMatcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNextArray("aba")[2]);
	}
	
	
	public static int strStr(String str1, String str2){
		int[] next = getNextArray(str2);
		int index= 0;
		while(index <= str1.length()){
			
		}
		return -1;
	}
	
	public static int[] getNextArray(String pattern){
		int[] res = new int[pattern.length()];
		res[0] = -1;
		for(int i=1; i<pattern.length(); i++){
			int k = res[i-1];
			while(pattern.charAt(i) != pattern.charAt(k+1) && k>=0){
				k = res[k];
			}
			if(pattern.charAt(i) == pattern.charAt(k+1))
				res[i] = k+1;
			else
				res[i] = -1;
		}
		return res;
	}

}
