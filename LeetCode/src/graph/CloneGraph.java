package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandListNode node0 = new RandListNode(1);
		node0.next = new RandListNode(2);
		node0.rand = new RandListNode(3);
		node0.next.next = node0;
		node0.next.rand = node0.next;
		clone(node0);
	}
	
	public static RandListNode clone(RandListNode head){
		Queue<RandListNode> queue = new LinkedList<RandListNode>();
		Map<RandListNode, RandListNode> map = new HashMap<RandListNode, RandListNode>();
		Map<RandListNode, Boolean> updatedmap = new HashMap<RandListNode, Boolean>();
		queue.offer(head);
		RandListNode headCpy = null;
		while(!queue.isEmpty()){
			RandListNode nodetoCpy = queue.poll();
			if(map.containsKey(nodetoCpy))
				continue;
			RandListNode newNode = new RandListNode(nodetoCpy);
			if(map.size() == 0)
				headCpy = newNode;
			map.put(nodetoCpy, newNode);

			if(nodetoCpy.next != null)
				queue.add(nodetoCpy.next);
			if(nodetoCpy.rand != null)
				queue.add(nodetoCpy.rand);
		}
		
		queue.offer(headCpy);
		while(!queue.isEmpty()){
			RandListNode nodetoUpdate = queue.poll();
			if(updatedmap.containsKey(nodetoUpdate))
				continue;
			updatedmap.put(nodetoUpdate, true);
			if(nodetoUpdate.next != null && map.containsKey(nodetoUpdate.next)){
				nodetoUpdate.next = map.get(nodetoUpdate.next);
				queue.offer(nodetoUpdate.next);
			}
			if(nodetoUpdate.rand != null && map.containsKey(nodetoUpdate.rand)){
				nodetoUpdate.rand = map.get(nodetoUpdate.rand);
				queue.offer(nodetoUpdate.rand);
			}
		}
		return headCpy;
	}
}

class RandListNode{
	RandListNode next = null;
	RandListNode rand = null;
	int data = -1;
	
	public RandListNode(int i){
		data = i;
	}
	
	public RandListNode(RandListNode node){
		next = node.next;
		rand = node.rand;
		data = node.data * -1;
	}
}
