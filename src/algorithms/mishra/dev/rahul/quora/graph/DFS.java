/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://algocoding.wordpress.com/2014/08/25/depth-first-search-java-and-python-implementation/
 * http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 10:48:03 AM
 *
 */
public class DFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new DFS().new Graph(6);
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
		graph.dfsTraversal(0);
	}

	class Graph {
		private List<Integer>[] adjList = null;

		@SuppressWarnings("unchecked")
		public Graph(int numOfVertices) {
			adjList = new LinkedList[numOfVertices + 1];
			for (int i = 0; i <= numOfVertices; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int srcVertex, int destVertex) {
			adjList[srcVertex].add(destVertex);
		}

		public void dfsTraversal(int sourceNode) {
			Stack<Integer> unvisitedNodeStack = new Stack<>();
			Set<Integer> visitedNodeList = new HashSet<>();
			unvisitedNodeStack.push(sourceNode);
			while (!unvisitedNodeStack.isEmpty()) {
				int node = unvisitedNodeStack.pop();
				if (visitedNodeList.contains(node)) {
					continue;
				}
				System.out.print(node + " ");
				visitedNodeList.add(node);
				for (int n : adjList[node]) {
					if (!visitedNodeList.contains(n)) {
						unvisitedNodeStack.push(n);
					}
				}
			}
		}
	}
}
