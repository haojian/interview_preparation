package advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUCachev2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
        LRUCachev2 cache = new LRUCachev2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	        	line = br.readLine();
	        	cache.processCommand(line);
	        }
	}
	
	public LRUQueue queue;
	 public Map<String, dlNode> map;
	 int bound = 0;
	
	public LRUCachev2(){
		map = new HashMap<String, dlNode>();
		queue = new LRUQueue(map);
	}
	
	public void processCommand(String line){
		 if(line.startsWith("BOUND ")){
			 String[] boundParams = line.split(" ");
			 bound = Integer.valueOf(boundParams[1]);
			 queue.SetQueueSize(bound);
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
		 queue.Output();
	 }
	
	 public void Set(String key, String val){
		 if(map.containsKey(key)){
			 queue.AccessNode(map.get(key));
			 map.get(key).val = val;
		 }else{
			 dlNode tmp = new dlNode(key, val);
			 queue.Enqueue(tmp);
			 map.put(key, tmp);
		 }
	 }
	 
	 public void Get(String key){
		 if(map.containsKey(key)){
			 System.out.println(map.get(key).val);
			 queue.AccessNode(map.get(key));
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


class LRUQueue{
	private dlNode pseudoHead = null;
	public dlNode endNode = null;
	private int bound = 0; 
	private int curSize = 0;
	public Map<String, dlNode> map;
	
	public LRUQueue(Map<String, dlNode> _map){
		pseudoHead = new dlNode();
		endNode = pseudoHead;
		map = _map;
	}

	public void Output(){
		dlNode tNode = pseudoHead.nxt;
		while(tNode != null){
			System.out.print(tNode.key + "\t");
			tNode = tNode.nxt;
		}
		System.out.println();
	}
	
	public void SetQueueSize(int N){
		bound = N;
		dlNode tNode = pseudoHead.nxt;
		endNode = pseudoHead;
		while(N>0 && tNode !=null){
			endNode =  tNode;
			tNode = tNode.nxt;
			N--;
		}
		while(tNode != null){
			map.remove(tNode.key);
			tNode = tNode.nxt;
		}
		curSize = Math.min(N, curSize);
		endNode.nxt = null;
	}
	
	public void ResetNode(dlNode node){
		node.nxt = null;
		node.pre = null;
	}
	
	public void AccessNode(dlNode node){
		if(node == endNode){
			endNode = endNode.pre;
			endNode.nxt = null;			
		}else{
			node.pre.nxt = node.nxt;
			node.nxt.pre = node.pre;
		}
		
		node.pre = pseudoHead;
		node.nxt = pseudoHead.nxt;
		pseudoHead.nxt = node;
		
		if(node.nxt != null)
			node.nxt.pre = node;
	}
	
	//return the dequeue node if necessary, otherwise null
	public void Enqueue(dlNode node){
		if(endNode == pseudoHead){
			endNode = node;
		}
		curSize++;
		node.nxt = pseudoHead.nxt;
		if(pseudoHead.nxt != null)
			pseudoHead.nxt.pre = node;
		
		pseudoHead.nxt = node;
		node.pre = pseudoHead;
		
		if(curSize>bound){
			curSize--;
			map.remove(endNode.key);
			endNode = endNode.pre;
			ResetNode(endNode.nxt);
			endNode.nxt = null;
		}
	}
}
