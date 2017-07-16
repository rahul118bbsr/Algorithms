/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 3:35:19 PM
 *
 */
public class TopologicalSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new TopologicalSort().new Graph(9);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 8);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);

		Stack<Integer> result = graph.topologicalSort();
		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}

	class Graph {
		private List<List<Integer>> adjList;

		public Graph(int numOfVertices) {
			adjList = new ArrayList<>(numOfVertices);
			for (int i = 0; i < numOfVertices; i++) {
				adjList.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int src, int dest) {
			adjList.get(src).add(dest);
		}

		public Stack<Integer> topologicalSort() {
			Stack<Integer> resultStack = new Stack<>();
			Set<Integer> visitedNodes = new HashSet<>();
			for (int i = 0; i < adjList.size(); i++) {
				topologicalSortUtil(i, resultStack, visitedNodes);
			}
			return resultStack;
		}

		private void topologicalSortUtil(int root, Stack<Integer> resultStack, Set<Integer> visitedNodes) {
			if (visitedNodes.contains(root)) {
				return;
			}
			visitedNodes.add(root);
			for (int childNode : adjList.get(root)) {
				topologicalSortUtil(childNode, resultStack, visitedNodes);
			}
			resultStack.push(root);
		}
	}
}