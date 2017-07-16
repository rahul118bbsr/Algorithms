/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 10-Jul-2017 9:28:38 AM
 *
 */
public class DetectCycleInDirectedGraphDisjointSet {

	public static void main(String[] args) {
		Graph graph = new DetectCycleInDirectedGraphDisjointSet().new Graph(9);
		graph.addEdge(0, 1);
		graph.addEdge(0, 8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 8);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 6);
		graph.addEdge(6, 5);
		graph.addEdge(6, 7);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 4);
		System.out.println(graph.hasCycle());
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
			DisjointSet<Integer> disjointSet = new DisjointSet<>();
			createSet(disjointSet);
			Set<Integer> visitedNodes = new HashSet<>();
			Set<Integer> currentlyVisitingNodes = new HashSet<>();
			for(int i = 0; i < adjList.size(); i++) {
				if(detectCycleUtil(i, currentlyVisitingNodes, visitedNodes, disjointSet)) {
					return true;
				}
			}
			return false;
		}

		private boolean detectCycleUtil(int node, Set<Integer> currentlyVisitingNodes, Set<Integer> visitedNodes, DisjointSet<Integer> disjointSet) {
			
			return false;
		}

		private void createSet(DisjointSet<Integer> disjointSet) {
			for (int i = 0; i < adjList.size(); i++) {
				disjointSet.createSet(i);
			}

		}
	}

	class DisjointSet<T> {
		private Map<T, Node> map = new HashMap<>();

		class Node {
			int rank;
			T name;
			Node parent;

			Node(T name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "Name: " + name + " Parent: " + parent.name + " Rank: " + rank;
			}
		}

		public void createSet(T data) {
			if (map.get(data) != null) {
				return;
			}
			Node node = new Node(data);
			node.rank = 0;
			node.parent = node;
			map.put(data, node);
		}

		public T findSet(T key) {
			return findSet(map.get(key)).name;
		}

		private Node findSet(Node node) {
			if (node == node.parent) {
				return node;
			}
			node.parent = findSet(node.parent);
			return node.parent;
		}

		public boolean unionSet(T data1, T data2) {
			if (map.get(data1) == null || map.get(data2) == null) {
				throw new IllegalArgumentException("Invalid Arguments: [" + data1 + "] and [" + data2 + "]");
			}
			Node parent1 = map.get(data1).parent;
			Node parent2 = map.get(data2).parent;
			if (parent1 == parent2) {
				System.out.println(data1 + " and " + data2 + " have the same parent: " + parent1);
				return false;
			}

			if (parent1.rank >= parent2.rank) {
				parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
				parent2.parent = parent1;
			} else {
				parent1.parent = parent2;
			}
			return true;
		}
	}
}
