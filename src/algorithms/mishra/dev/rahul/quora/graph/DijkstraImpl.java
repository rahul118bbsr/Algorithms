/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 10:06:58 PM
 *
 */
public class DijkstraImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "E", 2);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "D", 9);
		graph.addEdge("C", "D", 3);
		graph.addEdge("E", "D", 6);
		graph.addEdge("E", "F", 3);
		graph.addEdge("F", "D", 2);
		graph.findShortestPath("A", "D");
	}
}

class Graph {
	private Map<String, Node> vertices = new HashMap<>();

	public void addEdge(String src, String dest, int weight) {
		Node srcNode = vertices.get(src) == null ? new Node(src) : vertices.get(src);
		Node destNode = vertices.get(dest) == null ? new Node(dest) : vertices.get(dest);
		Edge edge = new Edge(srcNode, destNode, weight);
		srcNode.getEdgeList().add(edge);
		vertices.put(src, srcNode);
		// Persist dest as well, otherwise, there would be multiple instances of
		// node with same name, which we don't want.
		vertices.put(dest, destNode);
	}

	public void findShortestPath(String src, String dest) {
		Node srcNode = vertices.get(src);
		Node destNode = vertices.get(dest);
		Queue<ShortestDistanceEdge> priorityQueue = new PriorityQueue<>(getComparatorBasedOnCurrentRunningTotal());
		addEdgesToQueue(srcNode, 0, priorityQueue);
		Map<Node, ShortestDistanceEdge> shortestPathMap = shortestPathUtil(srcNode, destNode, priorityQueue);
		printShortestPath(srcNode, destNode, shortestPathMap);
	}

	private Map<Node, ShortestDistanceEdge> shortestPathUtil(Node currentNode, Node destNode,
			Queue<ShortestDistanceEdge> priorityQueue) {
		if (currentNode == destNode) {
			return null;
		}
		Map<Node, ShortestDistanceEdge> shortestPathMap = new HashMap<>();
		while (currentNode != destNode) {
			ShortestDistanceEdge currentEdge = priorityQueue.poll();
			currentNode = currentEdge.getEdge().getDest();
			addEdgesToQueue(currentNode, currentEdge.getCurrentRunningTotal(), priorityQueue);
			shortestPathMap.put(currentEdge.getEdge().getSrc(), currentEdge);
		}
		return shortestPathMap;
	}

	private void printShortestPath(Node srcNode, Node destNode, Map<Node, ShortestDistanceEdge> shortestPathMap) {
		StringBuilder sb = new StringBuilder();
		sb.append(srcNode.getName());
		Node currentNode = shortestPathMap.get(srcNode).getEdge().getDest();
		while (destNode != currentNode) {
			sb.append(currentNode.getName());
			currentNode = shortestPathMap.get(currentNode).getEdge().getDest();
		}
		sb.append(destNode.getName());
		System.out.println(sb.toString() + " - Distance: " + shortestPathMap.get(destNode).getCurrentRunningTotal());
	}

	private void addEdgesToQueue(Node node, int currentTotal, Queue<ShortestDistanceEdge> priorityQueue) {
		for (Edge edge : node.getEdgeList()) {
			priorityQueue.add(new ShortestDistanceEdge(edge, edge.getWeight() + currentTotal));
		}
	}

	private Comparator<ShortestDistanceEdge> getComparatorBasedOnCurrentRunningTotal() {
		return (e1, e2) -> Integer.compare(e1.getCurrentRunningTotal(), e2.getCurrentRunningTotal());
	}
}

class Node {
	private String name;
	private List<Edge> edgeList = new ArrayList<>();

	public Node(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
}

class Edge {
	private Node src;
	private Node dest;
	private int weight;

	public Edge(Node src, Node dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return src.getName() + "-->" + dest.getName();
	}

	public Node getSrc() {
		return src;
	}

	public Node getDest() {
		return dest;
	}

	public Integer getWeight() {
		return weight;
	}
}

class ShortestDistanceEdge {
	private Edge edge;
	private int currentRunningTotal;

	public ShortestDistanceEdge(Edge edge, int currentRunningTotal) {
		this.edge = edge;
		this.currentRunningTotal = currentRunningTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edge == null) ? 0 : edge.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShortestDistanceEdge other = (ShortestDistanceEdge) obj;
		if (edge == null) {
			if (other.edge != null)
				return false;
		} else if (!edge.equals(other.edge))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return edge.toString() + " Current Total: " + currentRunningTotal;
	}

	public Edge getEdge() {
		return edge;
	}

	public int getCurrentRunningTotal() {
		return currentRunningTotal;
	}
}
