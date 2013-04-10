package combinatorics;

import java.util.ArrayList;

public class LetterCombinationPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
	}

    static String[] keymap = {" ", "", "abc", "def", "ghi", "jkl", "mno"
            , "pqrs", "tuv", "wxyz"};
    public static ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String tmp ="";
        ArrayList<String> res = new ArrayList<String>();
        generateCombination(digits, 0, tmp, res);
        return res;
    }
    
    public static void generateCombination(String digits, int deepth, String tmpStr
                            , ArrayList<String> outputlist){
        if(deepth == digits.length()){
            outputlist.add(tmpStr);
            return;
        }
        int index = digits.charAt(deepth)-'0';
        String key = keymap[index];
        for(int i=0; i<key.length() ;i++){
            tmpStr += key.charAt(i); 
            generateCombination(digits, deepth+1, tmpStr, outputlist);
            tmpStr = tmpStr.substring(0, tmpStr.length()-1);
        }
    }
}
