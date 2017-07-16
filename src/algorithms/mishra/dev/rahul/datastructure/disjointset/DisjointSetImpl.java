/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.disjointset;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 09-Jul-2017 7:11:30 PM
 *
 */
public class DisjointSetImpl {

	public static void main(String[] args) {
		DisjointSet<String> ds = new DisjointSet<>();
		ds.makeSet("A");
		ds.makeSet("B");
		ds.makeSet("C");
		ds.makeSet("D");
		ds.makeSet("E");
		ds.makeSet("F");
		
		System.out.println("Union A & B: " + ds.union("A", "B"));
		System.out.println("Union B & C: " + ds.union("B", "C"));
		System.out.println("Union A & C: " + ds.union("A", "C"));
		System.out.println(ds.findSet("A"));
		System.out.println(ds.findSet("B"));
		System.out.println(ds.findSet("C"));
		System.out.println("Union D & E: " + ds.union("D", "E"));
		System.out.println("Union D & C: " + ds.union("C", "D"));
		System.out.println("Union C & F: " + ds.union("C", "F"));
		System.out.println("Union D & F: " + ds.union("D", "F"));
		System.out.println(ds.findSet("A"));
		System.out.println(ds.findSet("B"));
		System.out.println(ds.findSet("C"));
		System.out.println(ds.findSet("D"));
		System.out.println(ds.findSet("E"));
		System.out.println(ds.findSet("F"));
	}
}

class DisjointSet<T> {
	private Map<T, Node<T>> map;

	public DisjointSet() {
		map = new HashMap<>();
	}

	public void makeSet(T data) {
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
		Node<T> node1 = map.get(data1);
		Node<T> node2 = map.get(data2);
		if (node1 == null || node2 == null) {
			throw new IllegalArgumentException("Invalid arguments: [" + data1 + "] and [" + data2 + "]");
		}

		Node<T> parent1 = findSet(node1);
		Node<T> parent2 = findSet(node2);
		if (parent1 == parent2) {
			System.out.println(data1 + " and " + data2 + " are in the same set having the parent node as " + parent1);
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

class Node<T> {
	int rank;
	T name;
	Node<T> parent;

	public Node(T name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " Parent: " + parent.name + " Rank: " + rank;
	}
}
