/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Implementation of Topological Sort.
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 17-Jun-2017 6:29:33 PM
 *
 */
public class TopologicalSort {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "C");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "E");
		graph.addEdge("D", "F");
		graph.addEdge("E", "H");
		graph.addEdge("E", "F");
		graph.addEdge("F", "G");
		graph.addEdge("X", "B");
		graph.addEdge("A", "B");
		graph.addEdge("Y", "X");

		Stack<Node<String>> stack = graph.performTopologicalSort(graph);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}
}

class Graph {
	private Map<String, Node<String>> map = new HashMap<>();

	public void addEdge(String in, String out) {
		Node<String> inNode = map.get(in) == null ? new Node<String>(in) : map.get(in);
		Node<String> outNode = map.get(out) == null ? new Node<String>(out) : map.get(out);
		inNode.addEdge(outNode);
		map.put(in, inNode);
		map.put(out, outNode);
	}

	public Stack<Node<String>> performTopologicalSort(Graph graph) {
		Stack<Node<String>> stack = new Stack<>();
		Set<Node<String>> visitedNodes = new HashSet<>();
		map.values().stream().forEach(root -> topologicalSortUtil(root, stack, visitedNodes));
		return stack;
	}

	private void topologicalSortUtil(Node<String> root, Stack<Node<String>> stack, Set<Node<String>> visitedNodes) {
		if (visitedNodes.contains(root)) {
			return;
		}
		visitedNodes.add(root);
		root.getChildNodesList().stream().forEach(node -> topologicalSortUtil(node, stack, visitedNodes));
		stack.push(root);
	}
}

class Node<T> {
	private T name;
	private List<Node<T>> childNodesList;

	public Node(T name) {
		this.name = name;
		childNodesList = new ArrayList<>();
	}

	public void addEdge(Node<T> childNode) {
		this.childNodesList.add(childNode);
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
		Node<T> other = (Node<T>) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name.toString();
	}

	public T getName() {
		return name;
	}

	public List<Node<T>> getChildNodesList() {
		return childNodesList;
	}

}