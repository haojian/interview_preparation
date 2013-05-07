package predict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCounter {

	/**
	 * 
	 * Could be solved with Trie as well. 
	 * But the problem didn't contain too much specific description, especially the order of output.
	 * 
	 * I am not sure the order of output.
	 * I assume it's based on the order of words in the sentences
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "la tee da tee da";
		processSentence(input);
		processSentence("la");
		output();
	}
	
	public static Map<String, Integer> map = new LinkedHashMap<String, Integer>(); //to keep the counter.

	
	public static void processSentence(String input){
		String[] words = input.split("[ .?!,]");
		for(String word:words){
			if(!map.containsKey(word)){
				map.put(word, 0);
			}
			map.put(word, map.get(word)+1);
		}
	}
	
	public static void output(){
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

}
