package classical;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "beep boop beer!";
		HuffmanCoding hc = new HuffmanCoding();
		String encode = hc.encode(input);
		String decode = hc.decode(encode);
		System.out.println(decode);
	}
	
	public HuffmanCoding(){
		
	}
	Map<Character, String> codetable = new HashMap<Character, String>();
	Map<String, Character> reversecodetable = new HashMap<String, Character>();
	public String decode(String input){
		for(Map.Entry<Character, String> entry:codetable.entrySet()){
			reversecodetable.put(entry.getValue(), entry.getKey());
		}
		int si = 0;
		int ei = 1;
		String res = "";
		while(ei<=input.length()){
			if(reversecodetable.containsKey(input.substring(si, ei))){
				res += reversecodetable.get(input.substring(si, ei));
				si = ei;
				ei = si+1;
			}else{
				ei++;
			}
		}
		if(si != input.length()){
			System.out.println("decoding failed!");
			return "";
					}
		return res;
	}
	
	public String encode(String input){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<HCNode> queue = new PriorityQueue<HCNode>();
		for(int i=0; i<input.length(); i++){
			if(!map.containsKey(input.charAt(i)))
				map.put(input.charAt(i), 1);
			else
				map.put(input.charAt(i), map.get(input.charAt(i))+1);
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			queue.add(new HCNode(entry.getKey(), entry.getValue()));
		}
		HCNode root = buildTrie(queue);
		codetable.clear();
		getCodeTable(root, "", codetable);
		/*
		for(Map.Entry<Character, String> entry:codetable.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}*/
		//System.out.println(codetable.size());
		String res = "";
		for(int i=0; i<input.length(); i++){
			res += codetable.get(input.charAt(i));
		}
		return res;
	}
	
	public void getCodeTable(HCNode root, String s,Map<Character, String> codetable){
		if(root.isLeaf()){
			codetable.put(root.c, s);
		}else{
			getCodeTable(root.left, s+'0', codetable);
			getCodeTable(root.right, s+'1', codetable);
		}
		
	}
	
	public HCNode buildTrie(PriorityQueue<HCNode> queue){
		while(queue.size()>1){
			HCNode left = queue.poll();
			HCNode right = queue.poll();
			HCNode parent = new HCNode('\0', left.weight+right.weight);
			parent.left = left;
			parent.right = right;
			queue.offer(parent);
		}
		return queue.poll();
	}
}

class HCNode implements Comparable<HCNode>{
	public HCNode left = null;
	public HCNode right = null;
	public char c;
	public int weight;
	
	public HCNode(char _c, int _weight){
		c = _c;
		weight = _weight;
	}
	
	@Override
	public int compareTo(HCNode arg0) {
		// TODO Auto-generated method stub
		return this.weight - arg0.weight;
	}
	
	public boolean isLeaf(){
		return left==null && right == null;
	}
	
}
