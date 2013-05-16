package quora;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Nearby {

	static Map<Integer, Topic> topicMap = new HashMap<Integer, Topic>();
	static ArrayList<Question> questionlist = new ArrayList<Question>();
	
	/**
	 * 
	 * 3 6 2
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//generateTestFiles(10000, 1000 ,10000);
        String line;
		long time = System.currentTimeMillis();
        try {
        	BufferedReader br = new BufferedReader(new FileReader("data.txt"));
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
				int num = Integer.valueOf(qdata[1]);
				if(num == 0)
					continue;
				ArrayList<Integer> curList = new ArrayList<Integer>();
				for(int j=2; j<qdata.length; j++){
					curList.add(Integer.valueOf(qdata[j]));
				}
				questionlist.add(new Question(qid, curList, topicMap));
			}
			for(int i=0; i<N; i++){
				line = br.readLine();
				String[] ndata = line.split(" ");
				int count = Integer.valueOf(ndata[1]);
				double qx = Double.valueOf(ndata[2]);
				double qy = Double.valueOf(ndata[3]);
				if(ndata[0].equals("t")){
					topicSearch(qx, qy, count);
				}else{
					questionSearch(qx, qy, count);
				}
			}                                                                                                            
		} 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("time: "+ (System.currentTimeMillis()-time));
	}
	
	public static void generateTestFiles(int T, int Q, int N){
		utils.IOOperator.getInstance().writeToFile("data.txt", T + " " + Q + " " + N + "\n", true);
		Random rand = new Random();
		for(int i=0; i<T;i++){
			utils.IOOperator.getInstance().writeToFile("data.txt", i + " " + rand.nextFloat() * 1000000.0  + " " + rand.nextFloat() * 1000000.0  + "\n", true);
		}
		for(int i=0; i<Q;i++){
			int counter = rand.nextInt(10);
			String content = i+" " + counter + " ";
			for(int j=0; j<counter; j++){
				content += rand.nextInt(T/10) + j*T/10 + " ";
			}
			utils.IOOperator.getInstance().writeToFile("data.txt", content.trim()  + "\n", true);
		}
		
		for(int i=0; i<N; i++){
			utils.IOOperator.getInstance().writeToFile("data.txt",  "q" + " " + rand.nextInt(100) + " " + rand.nextFloat() * 1000000.0  + " " + rand.nextFloat() * 1000000.0  + "\n", true);
		}
	}

	
	public static void topicSearch(double qx, double qy, int count){
		if(count <=0)
			return;
		for(Map.Entry<Integer, Topic> entry:topicMap.entrySet()){
			entry.getValue().setQuery(qx, qy);
		}
		PriorityQueue<Topic> queue = new PriorityQueue<Topic>();
		for(Map.Entry<Integer, Topic> entry:topicMap.entrySet()){
			queue.offer(entry.getValue());
			if(queue.size() > count){
				queue.poll();
			}
		}
		ArrayList<Topic> res = new ArrayList<Topic>();
		while(!queue.isEmpty()){
			res.add(queue.poll());
		}
		Collections.reverse(res);
		//System.out.println(res);
		String output = "";
		for(Topic t:res){
			output+=t.id + " ";
		}
		System.out.println(output.trim());
	}

	public static void questionSearch(double qx, double qy, int count){
		if(count <=0)
			return;
		
		Map<Integer, Double> computingCache = new HashMap<Integer, Double>();
		for(Question ques:questionlist){
			ques.setQuery(qx, qy, computingCache);
		}
		
		PriorityQueue<Question> queue = new PriorityQueue<Question>();
		for(Question ques:questionlist){
			queue.offer(ques);
			if(queue.size() > count){
				queue.poll();
			}
		}
		
		ArrayList<Question> res = new ArrayList<Question>();
		while(!queue.isEmpty()){
			res.add(queue.poll());
		}
		Collections.reverse(res);
		//System.out.println(res);
		String output = "";
		for(Question q:res){
			output+=q.id + " ";
		}
		System.out.println(output.trim());
	}
}


class Question implements Comparable<Question>{
	int id = -1;
	double qx = -1;
	double qy = -1;
	ArrayList<Integer> topiclist;
	Map<Integer, Topic> topicMap;
	Map<Integer, Double> computingCache;
	public double curdist = -1;
	public void setQuery(double _qx, double _qy, Map<Integer, Double> _computingCache){
		qx = _qx;
		qy = _qy;
		computingCache = _computingCache;
		curdist = -1;
	}
	
	
	public Question(int _id, ArrayList<Integer> topics, Map<Integer, Topic> _topicMap){
		id = _id;
		topiclist = topics;
		topicMap = _topicMap;
	}
	
	public double getdistance(){
		if(curdist == -1){
			double min = Double.MAX_VALUE;
			for(Integer tmp:topiclist){
				double dist=0;
				if(computingCache.containsKey(tmp))
					dist = computingCache.get(tmp);
				else{
					Topic t = topicMap.get(tmp);
					dist = (t.x-qx)*(t.x-qx) + (t.y-qy)*(t.y-qy);
					computingCache.put(tmp, dist);
				}
				min = Math.min(min, dist);
			}
			curdist = min;
			return min;
		}else
			return curdist;
	}

	@Override
	public String toString(){
		return Integer.toString(id) + "=" + getdistance();
	}
	
	@Override
	public int compareTo(Question o) {
		// TODO Auto-generated method stub
		double dist1square = this.getdistance();
		double dist2square = o.getdistance();
		if(dist1square == dist2square){
			return Double.compare(id, o.id);
		}
		else
			return Double.compare(dist2square, dist1square);
	}
}

class Topic implements Comparable<Topic>{
	int id = -1;
	double x = -1;
	double y = -1;
	
	double qx = -1;
	double qy = -1;
	
	public Topic(int _id, double _x, double _y){
		id = _id;
		x = _x;
		y = _y;
	}
	
	public void setQuery(double _qx, double _qy){
		qx = _qx;
		qy = _qy;
	}
	
	@Override
	public String toString(){
		double dist = (x-qx)*(x-qx)+(y-qy)*(y-qy);
		return Integer.toString(id) + "=" + dist;
	}
	
	@Override
	public int compareTo(Topic arg0) {
		// TODO Auto-generated method stub
		double dist1square = (x-qx)*(x-qx)+(y-qy)*(y-qy);
		double dist2square = (arg0.x-qx)*(arg0.x-qx)+(arg0.y-qy)*(arg0.y-qy);
		if(dist1square == dist2square){
			return Double.compare(id, arg0.id);
		}
		else
			return Double.compare(dist2square, dist1square);
	}
}