package com.SimplyFI;
import java.util.*;
/*
 * Data Structure : Directed Graph
 * Algorithm : DFS in Graph
 * 
 * for finding the route using the Graph algorithm
 * And I am using directed graph for the specific route in Europe train
 * 
 * Dfs Algorithm:
 * Depth-First Search (DFS) is a graph traversal algorithm used to explore all the vertices and edges of a 
 * graph or tree structure. It starts at a designated "source" vertex and explores as far as possible along 
 * each branch before backtracking. The main idea behind DFS is to go as deep as possible along one branch 
 * before moving to another branch.
 * DFS is typically implemented using a stack or recursion, 
 *  It can be applied to both directed and undirected graphs and is used for various graph-related problems
 *  such as finding connected components, detecting cycles, and traversing a graph in a specific order.
 * */
class TrainRoute
{
	//creating the Map for connect vertex
	private Map<String,List<String>> adjlist;
	
	public TrainRoute()
	{
		adjlist=new HashMap<>();
	}
	
	
	// Method for adding the vertex 
	// As country visited by son
	
	public void addVertex(String vertex)
	{
		if(!adjlist.containsKey(vertex))
		{
			adjlist.put(vertex,new LinkedList<>());
		}
	}
	
	
	//Method for connecting the Vertex
	// As connect the valid ticket in train
	
	public void addEdge(String from,String to)
	{
		if(!adjlist.containsKey(from))
		{
			throw new IllegalArgumentException();
		}
		if(!adjlist.containsKey(to))
		{
			throw new IllegalArgumentException();
		}
		adjlist.get(from).add(to);
	}
	
	
	// Dfs approach for visit the country
	
	public void dfs(String startVertex) {
		//Create set for not visiting the visited one
        Set<String> visited = new HashSet<>();
        Travel(startVertex, visited);
    }

	// Method for traversal the station
	private void Travel(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            System.out.print(vertex + "->");
            visited.add(vertex);
            List<String> neighbors = adjlist.get(vertex);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    Travel(neighbor, visited);
                }
            }
        }
    }
	
}


//Driver class 
public class TravelTour {

	public static void main(String[] args) {
		
		//creating the object for TrainRoute
		TrainRoute route=new TrainRoute();
		
		//adding the station
		route.addVertex("Amsterdam");
		route.addVertex("Kiev");
		route.addVertex("Zurich");
		route.addVertex("Prague");
		route.addVertex("Berlin");
		route.addVertex("Barcelona");
		
		
		//connecting the stations
		route.addEdge("Kiev","Prague");
		route.addEdge("Prague","Zurich");
		route.addEdge("Zurich","Amsterdam");
		route.addEdge("Barcelona","Berlin");
		route.addEdge("Amsterdam","Barcelona");
		route.addEdge("Barcelona","Kiev");
		
		System.out.println("SON TRAVEL THROUGH EUROPE");
		System.out.print("[");
		route.dfs("Kiev");
		System.out.print("Kiev]");
		
		

	}

}
