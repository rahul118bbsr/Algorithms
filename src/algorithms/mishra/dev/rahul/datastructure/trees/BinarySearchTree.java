package algorithms.mishra.dev.rahul.datastructure.trees;

import java.util.Objects;

public class BinarySearchTree {
	private Node rootNode = null;
	private static int lh = 0;
	private static int rh = 0;

	public void createBST(int[] values) {
		for (int i : values) {
			rootNode = insert(rootNode, i);
		}
	}

	public void insert(int value) {
		insert(rootNode, value);
	}

	public int findMax(Node node) {
		if (Objects.isNull(node)) {
			throw new RuntimeException("The root node cannot be null!");
		}

		if (Objects.nonNull(node.getRightChildNode())) {
			return findMax(node.getRightChildNode());
		}
		return node.getValue();
	}

	public int findMin(Node node) {
		return findMinNode(node).getValue();
	}

	private Node findMinNode(Node node) {
		if (Objects.isNull(node)) {
			throw new RuntimeException("Root node cannot be null!");
		}

		if (Objects.nonNull(node.getLeftChildNode())) {
			return findMinNode(node.getLeftChildNode());
		}
		return node;
	}

	public int findHeight(Node node) {
		if (Objects.isNull(node)) {
			return 0;
		}
		return 1 + Math.max(findHeight(node.getLeftChildNode()), findHeight(node.getRightChildNode()));
	}

	public boolean contains(Node node, int key) {
		if (Objects.isNull(node)) {
			return false;
		}

		if (key == node.getValue()) {
			return true;
		}

		if (key < node.getValue()) {
			return contains(node.getLeftChildNode(), key);
		} else if (key > node.getValue()) {
			return contains(node.getRightChildNode(), key);
		}
		return false;
	}

	private Node insert(Node node, int value) {
		if (Objects.isNull(node)) {
			return new Node(value);
		}

		if (value <= node.getValue()) {
			node.setLeftChildNode(insert(node.getLeftChildNode(), value));
		} else {
			node.setRightChildNode(insert(node.getRightChildNode(), value));
		}
		return node;
	}

	public Node delete(Node node, int value) {
		if (Objects.isNull(node)) {
			return null;
		}

		if (value < node.getValue()) {
			node.setLeftChildNode(delete(node.getLeftChildNode(), value));
		} else if (value > node.getValue()) {
			node.setRightChildNode(delete(node.getRightChildNode(), value));
		} else if (value == node.getValue()) {
			if (Objects.isNull(node.getLeftChildNode()) && Objects.isNull(node.getRightChildNode())) {
				node = null;
			} else if (Objects.isNull(node.getLeftChildNode())) {
				return node.getRightChildNode();
			} else if (Objects.isNull(node.getRightChildNode())) {
				return node.getLeftChildNode();
			} else {
				node.setValue(findMinNode(node.getRightChildNode()).getValue());
				node.setRightChildNode(delete(node.getRightChildNode(), node.getValue()));
			}
		}
		return node;
	}

	public void preOrderTravsersal(Node node) {
		System.out.println(node.getValue());
		if (node.leftChildNode != null) {
			preOrderTravsersal(node.getLeftChildNode());
		}

		if (node.getRightChildNode() != null) {
			preOrderTravsersal(node.getRightChildNode());
		}
	}

	public void postOrderTraversal(Node node) {
		if (node.leftChildNode != null) {
			postOrderTraversal(node.leftChildNode);
		}

		if (node.rightChildNode != null) {
			postOrderTraversal(node.rightChildNode);
		}

		System.out.print(node.getValue() + " ");
	}

	public void inOrderTraversal(Node node) {
		if (node.leftChildNode != null) {
			inOrderTraversal(node.leftChildNode);
		}

		System.out.print(node.getValue() + " ");

		if (node.rightChildNode != null) {
			inOrderTraversal(node.rightChildNode);
		}
	}

	@Override
	public String toString() {
		String str = "BST: " + rootNode;
		return str;
	}

	public Node getRootNode() {
		return rootNode;
	}
}

class Node {
	private int value;
	public Node leftChildNode;
	public Node rightChildNode;

	public Node(int value) {
		this(value, null, null);
	}

	public Node(int value, Node leftChildNode, Node rightChildNode) {
		this.value = value;
		this.leftChildNode = leftChildNode;
		this.rightChildNode = rightChildNode;
	}

	@Override
	public String toString() {
		String str = "Value: " + value + ", Left Child: " + leftChildNode + ", Right Child: " + rightChildNode;
		return str;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChildNode() {
		return leftChildNode;
	}

	public void setLeftChildNode(Node leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public Node getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(Node rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
}
