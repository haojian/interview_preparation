package graph.advance;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dikstra {

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
	computePath(v0);
    for (Vertex v : vertices)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    ArrayList<Vertex> path = getShortestPathto(v);
	    System.out.println("Path: " + path);
	}
	}
	
	public static void computePath(Vertex source){
		source.minDistance = 0;
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

/*
class Vertex implements Comparable<Vertex>{
	public String name;
	public ArrayList<Edge> adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	public Vertex(String name){
		this.name = name;
		adjacencies = new ArrayList<Edge>();
	}
	
	public int findEdge(Vertex target){
		for(int i=0; i<adjacencies.size(); i++){
			if(adjacencies.get(i).target.name.equals(target.name)){
				return i;
			}
		}
		return -1;
	}
	
	public String toString(){
		return this.name;
	}
	
	public int compareTo(Vertex other){
		return Double.compare(minDistance, other.minDistance);
	}
}

class Edge{
	public Vertex target;
	public double weight;
	public Edge(Vertex argTarget, double argWeight){
		this.target = argTarget;
		this.weight = argWeight;
	}
}
*/