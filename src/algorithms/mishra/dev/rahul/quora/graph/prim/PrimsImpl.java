/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.graph.prim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 09-Jul-2017 9:45:21 AM
 *
 */
public class PrimsImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 4);
		graph.addEdge("B", "A", 4);
		graph.addEdge("A", "I", 8);
		graph.addEdge("I", "A", 8);
		graph.addEdge("B", "C", 8);
		graph.addEdge("C", "B", 8);
		graph.addEdge("B", "I", 11);
		graph.addEdge("I", "B", 11);
		graph.addEdge("C", "H", 2);
		graph.addEdge("H", "C", 2);
		graph.addEdge("C", "D", 7);
		graph.addEdge("D", "C", 7);
		graph.addEdge("C", "D", 7);
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
		graph.runPrimsAlgorithm("A");
	}
}

class Graph {
	private Map<String, Node> verticesMap = new HashMap<>();
	
	public void addEdge(String src, String dest, int weight) {
		Node srcNode = verticesMap.get(src) == null ? new Node(src) : verticesMap.get(src);
		Node destNode = verticesMap.get(dest) == null ? new Node(dest) : verticesMap.get(dest);
		Edge edge = new Edge(srcNode, destNode, weight);
		srcNode.getEdgeList().add(edge);
		verticesMap.put(src, srcNode);
		verticesMap.put(dest, destNode);
	}
	
	public void runPrimsAlgorithm(String src) {
		List<Edge> edgeList = new ArrayList<>();
		Set<Node> visitedNodes = new HashSet<>();
		Queue<Edge> priorityQueue = new PriorityQueue<>(getComparatorBasedOnEdgeWeight());
		
		addEdgesToQueue(verticesMap.get(src), priorityQueue);
		visitedNodes.add(verticesMap.get(src));
		primsUtil(edgeList, visitedNodes, priorityQueue);
		System.out.println(edgeList);
	}
	
	private void primsUtil(List<Edge> edgeList, Set<Node> visitedNodes, Queue<Edge> priorityQueue) {
		while(visitedNodes.size() != verticesMap.size()) {
			Edge currentEdge = priorityQueue.poll();
			Node currentNode = currentEdge.getDest();
			if(visitedNodes.contains(currentNode)) {
				continue;
			}
			visitedNodes.add(currentNode);
			addEdgesToQueue(currentNode, priorityQueue);
			edgeList.add(currentEdge);
		}
	}
	
	private void addEdgesToQueue(Node node, Queue<Edge> priorityQueue) {
		priorityQueue.addAll(node.getEdgeList());
	}

	private Comparator<Edge> getComparatorBasedOnEdgeWeight() {
		return (e1, e2) -> Integer.compare(e1.getWeight(), e2.getWeight());
	}
}

class Node {
	private String name;
	private List<Edge> edgeList;

	public Node(String name) {
		this.name = name;
		edgeList = new ArrayList<>();
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
	public String toString() {
		return src + "-->" + dest + "[" + weight + "]";
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
