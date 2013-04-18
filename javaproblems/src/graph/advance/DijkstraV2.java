package graph.advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DijkstraV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Vertex v0 = new Vertex("0Redvile");
	Vertex v1 = new Vertex("1Blueville");
	Vertex v2 = new Vertex("2Greenville");
	Vertex v3= new Vertex("3rangeville");
	Vertex v4 = new Vertex("4Purpleville");

	v0.adjacencies.add(new Edge(v1, 5));
	v0.adjacencies.add( new Edge(v2, 10));
	v0.adjacencies.add(new Edge(v3, 8));
	
	
	v1.adjacencies.add(new Edge(v0, 5));
	v1.adjacencies.add(new Edge(v2, 3));
	v1.adjacencies.add(new Edge(v4, 7));

	v2.adjacencies.add(new Edge(v0, 10));
	v2.adjacencies.add(new Edge(v1, 3));

	v3.adjacencies.add(new Edge(v0, 8));
	v3.adjacencies.add(new Edge(v4, 2));
	
	v4.adjacencies.add(new Edge(v1, 7));
	v4.adjacencies.add(new Edge(v1, 7));

	Vertex[] vertices = { v0, v1, v2, v3, v4 };
	computePath(v0, v4);
    
	}
	/*
	public static ArrayList<Vertex> getPath(Vertex source, Vertex target){
		source.minDistance = 0;
		 ArrayList<Vertex> visitedQueue = new ArrayList<Vertex>();
		 PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		 vertexQueue.add(source);
		 while(!vertexQueue.isEmpty()){
			 Vertex u = vertexQueue.poll();
			 
			 for(Edge e:u.adjacencies){
					Vertex v = e.target;
					double weight = e.weight;
					double distanceThroughU = u.minDistance+weight;
					if(distanceThroughU < v.minDistance){
						vertexQueue.remove(v);
						v.minDistance = distanceThroughU;
						v.previous = u;
						vertexQueue.add(v);
					}
				}
		 }
	}*/
	
	public static void computePath(Vertex source, Vertex target){
		source.minDistance = 0;
		ArrayList<Vertex> visitedQueue = new ArrayList<Vertex>();
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);
		
		while(!vertexQueue.isEmpty()){
			Vertex u = vertexQueue.poll();
			if(u == target){
				System.out.println("Distance to " + target + ": " + target.minDistance);
			    ArrayList<Vertex> path = getShortestPathto(target);
			    System.out.println("Path: " + path);
				break;
			}
			for(Edge e:u.adjacencies){
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance+weight;
				if(distanceThroughU < v.minDistance){
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU;
					v.previous = u;
					if(!visitedQueue.contains(v))
						vertexQueue.add(v);
				}
			}
			visitedQueue.add(u);
		}
	}
	
	public static ArrayList<Vertex> getShortestPathto(Vertex target){
		ArrayList<Vertex> res = new ArrayList<Vertex>();
		while(target !=null){
			res.add(target);
			target = target.previous;
		}
		Collections.reverse(res);
		return res;
	}

}
