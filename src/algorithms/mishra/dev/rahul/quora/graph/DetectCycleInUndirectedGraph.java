/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 7:07:41 PM
 *
 */
public class DetectCycleInUndirectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new DetectCycleInUndirectedGraph().new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(0, 5);
		graph.addEdge(5, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		System.out.println(graph.hasCycle());
	}

	class Graph {
		private List<List<Integer>> adjList;

		public Graph(int numofVertices) {
			adjList = new ArrayList<>();
			for (int i = 0; i < numofVertices; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		public void addEdge(int src, int dest) {
			adjList.get(src).add(dest);
		}

		public boolean hasCycle() {
			Set<Integer> visitedNodes = new HashSet<>();
			for (int i = 0; i < adjList.size(); i++) {
				if (detectCycleUtil(i, null, visitedNodes)) {
					return true;
				}
			}
			return false;
		}

		private boolean detectCycleUtil(int node, Integer parentNode, Set<Integer> visitedNodes) {
			if (visitedNodes.contains(node)) {
				return false;
			}
			visitedNodes.add(node);
			for (int childNode : adjList.get(node)) {
				if (visitedNodes.contains(childNode) && !Objects.equals(parentNode, childNode)) {
					return true;
				}
				if (detectCycleUtil(childNode, node, visitedNodes)) {
					return true;
				}
			}
			return false;
		}
	}
}
