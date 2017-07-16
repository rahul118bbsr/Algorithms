/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 6:04:32 PM
 *
 */
public class DetectCycleInDirectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new DetectCycleInDirectedGraph().new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(3, 0);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		System.out.println("Has Cycle: " + graph.hasCycle());
	}

	class Graph {
		private List<List<Integer>> adjList;

		public Graph(int numOfVertices) {
			adjList = new ArrayList<>();
			for (int i = 0; i < numOfVertices; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		public void addEdge(int src, int dest) {
			adjList.get(src).add(dest);
		}

		public boolean hasCycle() {
			Set<Integer> visitedNodes = new HashSet<>();
			Set<Integer> currentlyVisitingNodes = new HashSet<>();
			for (int i = 0; i < adjList.size(); i++) {
				if (detectCyclce(i, visitedNodes, currentlyVisitingNodes)) {
					return true;
				}
			}
			return false;
		}

		private boolean detectCyclce(int root, Set<Integer> visitedNodes, Set<Integer> currentlyVisitingNodes) {
			if (currentlyVisitingNodes.contains(root)) {
				return true;
			}
			if (visitedNodes.contains(root)) {
				return false;
			}
			currentlyVisitingNodes.add(root);
			for (int childNode : adjList.get(root)) {
				if (detectCyclce(childNode, visitedNodes, currentlyVisitingNodes)) {
					return true;
				}
			}
			currentlyVisitingNodes.remove(root);
			visitedNodes.add(root);
			return false;
		}
	}

}
