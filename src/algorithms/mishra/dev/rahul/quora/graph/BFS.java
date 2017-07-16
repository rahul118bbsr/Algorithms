/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://algocoding.wordpress.com/2014/08/25/depth-first-search-java-and-python-implementation/
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 08-Jul-2017 12:33:00 PM
 *
 */
public class BFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new BFS().new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 6);
		graph.addEdge(1, 5);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		graph.addEdge(6, 4);
		graph.bfsTraversal(0);
	}
	
	class Graph {
		List<Integer>[] adjList = null;
		
		@SuppressWarnings("unchecked")
		public Graph(int numOfVertices) {
			adjList = new LinkedList[numOfVertices + 1];
			for(int i = 0; i <= numOfVertices; i++) {
				adjList[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int source, int dest) {
			adjList[source].add(dest);
		}
		
		public void bfsTraversal(int source) {
			Queue<Integer> unvisitedNodesQueue = new LinkedList<>();
			Set<Integer> visitedNodesList = new HashSet<>();
			unvisitedNodesQueue.add(source);
			while(!unvisitedNodesQueue.isEmpty()) {
				int node = unvisitedNodesQueue.poll();
				if(visitedNodesList.contains(node)) {
					continue;
				}
				visitedNodesList.add(node);
				System.out.print(node + " ");
				for(int n : adjList[node]) {
					if(!visitedNodesList.contains(n)) {
						unvisitedNodesQueue.add(n);
					}
				}
			}
		}
	}
}
