package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MultipleAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for(String tmp:strs){
            String key = sortString(tmp);
            if(hash.containsKey(key)){
                hash.get(key).add(tmp);
            }else{
                hash.put(key, new ArrayList<String>());
                hash.get(key).add(tmp);
            }
        }
        for(Entry<String, ArrayList<String>> entry:hash.entrySet()){
            if(entry.getValue().size() >=2)
            {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }


    public String sortString(String input){
        char[] tmp = input.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}
