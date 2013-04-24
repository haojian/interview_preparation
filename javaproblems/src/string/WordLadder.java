package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	/**
	 * 
	 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		String[] dictArray = {"hot", "dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		for(String tmp: dictArray)
			dict.add(tmp);
		System.out.println(ladderLength(start, end, dict));
	}

	static HashSet<String> processed = new HashSet<String>();

	
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Queue<String> queue = new ArrayDeque<String>();
    	queue.offer(start);
    	int length = 0;
    	while(!queue.isEmpty()){
    		length++;
    		String head = queue.poll();
    		ArrayList<String> adjacencies = getAdjacencies(head, dict);
    		System.out.println(adjacencies);
    		for(String tmp: adjacencies){
    			if(tmp.equals(end))
    				return length;
    			queue.offer(tmp);
    			if(processed.size() == dict.size())
    				return -1;
    		}
    	}
    	return 0;
    }
    
    public static ArrayList<String> getAdjacencies(String start, HashSet<String> dict){
    	ArrayList<String> res = new ArrayList<String>();
    	processed.add(start);
    	for(String tmp:dict){
    		if(measureDistance(tmp, start))
    			res.add(tmp);
    	}
    	return res;
    }
    
    public static boolean measureDistance(String a, String b){
    	if(a.length() != b.length())
    		return false;
    	int counter = 0;
    	for(int i=0; i<a.length(); i++){
    		if(a.charAt(i) != b.charAt(i))
    			counter++;
    		if(counter>1)
    			return false;
    	}
    	if(counter == 1)
    		return true;
    	return false;
    }
}
