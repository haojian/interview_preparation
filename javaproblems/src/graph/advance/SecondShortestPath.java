package graph.advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SecondShortestPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3= new Vertex("3");
		Vertex v4 = new Vertex("4");

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
		System.out.println("Second shortest path: " + compute2ndShortestPath(v0, v4));
	}
	
	public static Double compute2ndShortestPath(Vertex source, Vertex target){
		computeShortestPath(source, target);
		ArrayList<Vertex> path = getShortestPathto(target);
		Double res = Double.POSITIVE_INFINITY;
		for(int i=0; i<path.size()-1; i++){
			int ei = path.get(i).findEdge(path.get(i+1));
			Edge tmp = path.get(i).adjacencies.get(ei);
			path.get(i).adjacencies.remove(ei);
			//do the computing again.
			resetGraphBFS(source);
			computeShortestPath(source, target);
			res = Math.min(res, target.minDistance);
			path.get(i).adjacencies.add(tmp);
		}
		return res;
	}
	
	public static void resetGraphBFS(Vertex source){
		HashSet<Vertex> visitedlist = new HashSet<Vertex>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(source);
		while(!queue.isEmpty()){
			Vertex node = queue.poll();
			node.previous = null;
			node.minDistance = Double.POSITIVE_INFINITY;
			for(Edge e:node.adjacencies){
				if(!visitedlist.contains(e.target)){
					queue.add(e.target);
				}
			}
			visitedlist.add(node);
		}
	}
	
	public static void computeShortestPath(Vertex source, Vertex target){
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