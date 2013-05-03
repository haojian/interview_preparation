package advance;

import graph.advance.BoxTowers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	/**
	 * @param args
	 */
	 public static void main(String args[] ) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        LRUCache cache = new LRUCache();
	        cache.N = Integer.parseInt(line);
	        for (int i = 0; i < cache.N; i++) {
	        	line = br.readLine();
	        	cache.processCommand(line);
	        }
	 }

	 public int N = 0;
	 public Map<String, dlNode> map = new HashMap<String, dlNode>();
	 public dlNode pseudoNode;
	 public int bound = 0;
	 
	 public dlNode endNode = null;
	 
	 public LRUCache(){
		 pseudoNode = new dlNode();
		 pseudoNode.pre = null;
	 }
	 
	 public void processCommand(String line){
		 if(line.startsWith("BOUND ")){
			 String[] boundParams = line.split(" ");
			 SetBound(Integer.valueOf(boundParams[1]));
		 }
		 else if(line.startsWith("SET ")){
			 String[] setParams = line.split(" ");
			 Set(setParams[1], setParams[2]);
		 }else if(line.startsWith("GET ")){
			 String[] getParams = line.split(" ");
			 Get(getParams[1]);
		 }else if(line.startsWith("PEEK ")){
			 String[] peekParams = line.split(" ");
			 Peek(peekParams[1]);
		 }else if(line.startsWith("DUMP")){
			 String[] dumpParams = line.split(" ");
			 Dump();
		 }
	 }
	 
	 //assume size couldn't be 0
	 public void SetBound(int size){
		 bound = size;
	 }
	 
	 public void Set(String key, String val){
		 if(map.containsKey(key)){
			 map.get(key).val = val;
			 if(map.get(key).nxt == null)
				 endNode = map.get(key).pre;
			 
			 map.get(key).pre.nxt = map.get(key).nxt;
			 
			 map.get(key).nxt = pseudoNode.nxt;
			 pseudoNode.nxt.pre = map.get(key);
			 
			 pseudoNode.nxt = map.get(key);
			 map.get(key).pre = pseudoNode;
		 }else{
			if(map.size() < bound){
				map.put(key, new dlNode(key, val));
				
				map.get(key).nxt = pseudoNode.nxt;
				if(pseudoNode.nxt != null)
					pseudoNode.nxt.pre = map.get(key);
				else
					endNode = map.get(key);
				 
				pseudoNode.nxt = map.get(key);
				map.get(key).pre = pseudoNode;
			}else{
				map.put(key, new dlNode(key, val));
				
				map.get(key).nxt = pseudoNode.nxt;
				pseudoNode.nxt.pre = map.get(key);
				 
				pseudoNode.nxt = map.get(key);
				map.get(key).pre = pseudoNode;
				
				if(endNode != null){
					map.remove(endNode.key);
					endNode.pre.nxt = null;
				}
			}
		 }
	 }
	 
	 public void Get(String key){
		 if(map.containsKey(key)){
			 map.get(key).pre.nxt = map.get(key).nxt;
		 
			 map.get(key).nxt = pseudoNode.nxt;
			 pseudoNode.nxt.pre = map.get(key);
		 
			 pseudoNode.nxt = map.get(key);
			 map.get(key).pre = pseudoNode;
			 System.out.println(map.get(key).val);
		 }
		 else{
			 System.out.println("NULL");
		 }
	 }
	 
	 public void Peek(String key){
		 if(map.containsKey(key)){
				System.out.println(map.get(key).val);
		 }
		 else{
			 System.out.println("NULL");
		 }
	 }
	 
	 public void Dump(){
		 String[] keys = (String[])map.keySet().toArray(new String[0]);
		 Arrays.sort(keys);
		 for(String key : keys) {  
	           System.out.println(key + " " + map.get(key).val);  
	     } 
	 }
}

class dlNode{
	public dlNode pre = null;
	public dlNode nxt = null;
	
	public String key;
	public String val;
	
	public dlNode(){
		
	}
	
	public dlNode(String _key, String _val){
		key = _key;
		val = _val;
	}
}
