/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph.kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 09-Jul-2017 10:29:25 AM
 *
 */
public class KruskalsImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 4);
		graph.addEdge("B", "A", 4);
		graph.addEdge("A", "I", 9);
		graph.addEdge("I", "A", 9);
		graph.addEdge("B", "C", 8);
		graph.addEdge("C", "B", 8);
		graph.addEdge("B", "I", 11);
		graph.addEdge("I", "B", 11);
		graph.addEdge("C", "H", 2);
		graph.addEdge("H", "C", 2);
		graph.addEdge("C", "D", 7);
		graph.addEdge("D", "C", 7);
		graph.addEdge("C", "F", 4);
		graph.addEdge("F", "C", 4);
		graph.addEdge("H", "I", 7);
		graph.addEdge("I", "H", 7);
		graph.addEdge("H", "G", 6);
		graph.addEdge("G", "H", 6);
		graph.addEdge("I", "G", 1);
		graph.addEdge("G", "I", 1);
		graph.addEdge("G", "F", 2);
		graph.addEdge("F", "G", 2);
		graph.addEdge("F", "D", 14);
		graph.addEdge("D", "F", 14);
		graph.addEdge("F", "E", 10);
		graph.addEdge("E", "F", 10);
		graph.addEdge("E", "D", 9);
		graph.addEdge("D", "E", 9);
		System.out.println(graph.runKruskalsAlgorithm());
	}
}

class Graph {
	private Map<String, Vertex> verticesMap = new HashMap<>();

	public void addEdge(String src, String dest, int weight) {
		Vertex srcNode = verticesMap.get(src) == null ? new Vertex(src) : verticesMap.get(src);
		Vertex destNode = verticesMap.get(dest) == null ? new Vertex(dest) : verticesMap.get(dest);
		Edge edge = new Edge(srcNode, destNode, weight);
		srcNode.getEdgeList().add(edge);
		verticesMap.put(src, srcNode);
		verticesMap.put(dest, destNode);
	}

	public List<Edge> runKruskalsAlgorithm() {
		DisjointSet<Vertex> disjointSet = new DisjointSet<>();
		List<Edge> allEdgesList = addAllEdges();
		List<Edge> resultList = new ArrayList<>();
		allEdgesList.forEach(edge -> {
			disjointSet.createSet(edge.getSrc());
			disjointSet.createSet(edge.getDest());
		});

		for (Edge edge : allEdgesList) {
			if (disjointSet.union(edge.getSrc(), edge.getDest())) {
				resultList.add(edge);
			}
		}
		return resultList;
	}

	public List<Edge> addAllEdges() {
		List<Edge> allEdgesList = new ArrayList<>();
		for (Vertex node : verticesMap.values()) {
			allEdgesList.addAll(node.getEdgeList());
		}
		allEdgesList.sort(getComparatorBasedOnEdgeWeight());
		return allEdgesList;
	}

	private Comparator<Edge> getComparatorBasedOnEdgeWeight() {
		return Comparator.comparingInt(Edge::getWeight);
	}
}

class Vertex {
	private String name;
	private List<Edge> edgeList;

	public Vertex(String name) {
		this.name = name;
		edgeList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}
}

class Edge {
	private Vertex src;
	private Vertex dest;
	private int weight;

	public Edge(Vertex src, Vertex dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return src + "-->" + dest + "[" + weight + "]";
	}

	public Vertex getSrc() {
		return src;
	}

	public Vertex getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
}

class DisjointSet<T> {
	private Map<T, Node<T>> map = new HashMap<>();

	class Node<E> {
		int rank;
		E name;
		Node<E> parent;

		public Node(E name) {
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

		Node<T> node = new Node<>(data);
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}

	public T findSet(T key) {
		return findSet(map.get(key)).name;
	}

	private Node<T> findSet(Node<T> node) {
		if (node == node.parent) {
			return node;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}

	public boolean union(T data1, T data2) {
		if (map.get(data1) == null || map.get(data2) == null) {
			throw new IllegalArgumentException("Invalid Arguments: [" + data1 + "] and [" + data2 + "]");
		}

		Node<T> parent1 = findSet(map.get(data1));
		Node<T> parent2 = findSet(map.get(data2));
		if (parent1 == parent2) {
			System.out.println(data1 + " and " + data2 + " are in the same set: " + parent1);
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
