package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class QuoraNearyby {

	/**
	 * 
	 * 
	 * Sample input:
	 * 
3 6 2
0 0.0 0.0
1 1.0 1.0
2 2.0 2.0
0 1 0
1 2 0 1
2 3 0 1 2
3 0
4 0
5 2 1 2
t 2 0.0 0.0
q 5 100.0 100.0

	 * 
	 * @param args
	 */
	
	
	public static Map<Integer, Topic> topicMap = new HashMap<Integer, Topic>();
	public static Map<Integer, ArrayList<Integer>> questionMap = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
		try {
			line = br.readLine();
			String[] counter = line.split(" ");
			if(counter.length!=3)
				System.out.println("Error in loading");
			int T = Integer.valueOf(counter[0]);
			int Q = Integer.valueOf(counter[1]);
			int N = Integer.valueOf(counter[2]);
			
			for(int i =0; i<T; i++){
				line = br.readLine();
				String[] tdata = line.split(" ");
				int tid = Integer.valueOf(tdata[0]);
				double tx = Double.valueOf(tdata[1]);
				double ty = Double.valueOf(tdata[2]);
				topicMap.put(tid, new Topic(tid, tx, ty));
			}
			for(int i=0; i<Q;i++){
				line = br.readLine();
				String[] qdata = line.split(" ");
				int qid = Integer.valueOf(qdata[0]);
				ArrayList<Integer> curList = new ArrayList<Integer>();
				for(int j=1; j<qdata.length; j++){
					curList.add(Integer.valueOf(qdata[j]));
				}
				questionMap.put(qid, curList);
			}
			for(int i=0; i<N; i++){
				line = br.readLine();
				String[] ndata = line.split(" ");
				int count = Integer.valueOf(ndata[1]);
				double qx = Double.valueOf(ndata[2]);
				double qy = Double.valueOf(ndata[3]);
				if(ndata[0].equals("t")){
					ArrayList<Integer> res = topicSearch(qx, qy, count);
				}else{
					ArrayList<Integer> res = questionSearch(qx, qy, count);
				}
			}                                                                                                            
        } 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> topicSearch(double x, double y, int N){
		PriorityQueue<Distance> vertexQueue = new PriorityQueue<Distance>();
		for(Map.Entry<Integer, Topic> entry: topicMap.entrySet()){
			Distance tmp = new Distance(entry.getValue(), x, y);
			vertexQueue.offer(tmp);
			while(vertexQueue.size() > N){
				vertexQueue.poll();
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Distance di : vertexQueue){
			res.add(di.target.id);
		}
		return res;
	}
	
	public static ArrayList<Integer> questionSearch(double x, double y, int N){
		
		return null;
	}
	
}

class Distance implements Comparable<Distance>{
	double x = -1;
	double y = -1;
	Topic target;
	double dist = -1;

	public Distance(Topic _target, double _x, double _y){
		target = _target;
		x = _x;
		y = _y;
		dist = getdist(x, y, target.x, target.y);
	}
	
	public double getdist(double x1, double y1, double x2, double y2){
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}

	@Override
	public int compareTo(Distance o) {
		// TODO Auto-generated method stub
		return -1 * Double.compare(dist, o.dist) == 0 ? Double.compare(o.target.id, target.id): Double.compare(dist, o.dist);
	}
}

class Questions{
	
}

class Topic  {
	int id = -1;
	double x=-1;
	double y = -1;
	public Topic(int _id, double _x, double _y){
		id = _id;
		x = _x;
		y = _y;
	}
}
