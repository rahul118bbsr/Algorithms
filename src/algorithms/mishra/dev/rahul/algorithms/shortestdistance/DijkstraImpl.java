/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.shortestdistance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 18-Jun-2017 6:22:17 PM
 *
 */
public class DijkstraImpl {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "E", 3);
		graph.addEdge("A", "D", 9);
		graph.addEdge("B", "C", 2);
		graph.addEdge("C", "D", 3);
		graph.addEdge("E", "F", 3);
		graph.addEdge("E", "D", 1);
		graph.addEdge("F", "D", 1);
		graph.addEdge("D", "F", 1);
		
		graph.findShortestPath("A", "F");
	}
}

class Graph {
	// Holds all the nodes and its instances as its values
	private Map<String, Node> nodeMap = new HashMap<>();

	public void addEdge(String source, String destination, int weight) {
		Node sourceNode = nodeMap.get(source) == null ? new Node(source) : nodeMap.get(source);
		Node destinationNode = nodeMap.get(destination) == null ? new Node(destination) : nodeMap.get(destination);
		sourceNode.addEdge(sourceNode, destinationNode, weight);
		nodeMap.put(source, sourceNode);
		nodeMap.put(destination, destinationNode);
	}

	public void findShortestPath(String source, String destination) {
		Node sourceNode = nodeMap.get(source);
		Node destinationNode = nodeMap.get(destination);
		if(source == destination) {
			System.out.println(source);
			return;
		}
		
		// Keep track of the visiting nodes, will be used while backtracking from destination to source
		Map<String, ShortestDistanceNode> visitedNodesMap = new HashMap<>();
		// Holds node based on the priority of smallest running total from source till that node
		Queue<ShortestDistanceNode> priorityQueue = new PriorityQueue<>(getComparatorBasedOnRunningTotal());
		for(Edge edge : sourceNode.getEdgeList()) {
			ShortestDistanceNode sdn = new ShortestDistanceNode(edge, edge.getWeight());
			priorityQueue.add(sdn);
			visitedNodesMap.put(edge.getSrc().getName(), null);
		}
		Node currentNode = sourceNode;
		while(currentNode != destinationNode) {
			ShortestDistanceNode sdn = priorityQueue.poll();
			currentNode = sdn.getEdge().getDest();
			visitedNodesMap.put(currentNode.getName(), sdn);
			for(Edge edge : currentNode.getEdgeList()) {
				ShortestDistanceNode shortestDistanceNode = new ShortestDistanceNode(edge, edge.getWeight() + sdn.getRunningDistance());
				priorityQueue.add(shortestDistanceNode);
			}
		}
		
		printShortestPath(visitedNodesMap, source, destination);
	}
	
	private void printShortestPath(Map<String, ShortestDistanceNode> visitedNodesMap, String source, String destination) {
		Stack<String> pathStack = new Stack<>();
		while(!source.equals(destination)) {
			pathStack.push(destination);
			destination = visitedNodesMap.get(destination).getEdge().getSrc().getName();
		}
		
		pathStack.push(source);
		while(!pathStack.isEmpty()) {
			System.out.print(pathStack.pop() + " ");
		}
		
	}

	private Comparator<ShortestDistanceNode> getComparatorBasedOnRunningTotal() {
		return (ShortestDistanceNode sdn1, ShortestDistanceNode sdn2) -> sdn1.getRunningDistance().compareTo(sdn2.getRunningDistance());  
	}
}

class Node {
	private String name;
	private List<Edge> edgeList = null;

	public Node(String name) {
		this.name = name;
		edgeList = new ArrayList<>();
	}

	public void addEdge(Node source, Node destination, int weight) {
		edgeList.add(new Edge(source, destination, weight));
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
		return name + " Edges: " + edgeList;
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
	private Integer weight;

	public Edge(Node src, Node dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return src.getName() + "-[" + weight + "]->" + dest.getName();
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

class ShortestDistanceNode {
	private Edge edge;
	private int runningDistance;
	
	public ShortestDistanceNode(Edge edge, int runningDistance) {
		this.edge = edge;
		this.runningDistance = runningDistance;
	}
	
	@Override
	public String toString() {
		return edge.toString();
	}

	public Edge getEdge() {
		return edge;
	}

	public Integer getRunningDistance() {
		return runningDistance;
	}

	public void setEdge(Edge edge) {
		this.edge = edge;
	}

	public void setRunningDistance(int runningDistance) {
		this.runningDistance = runningDistance;
	}
}
