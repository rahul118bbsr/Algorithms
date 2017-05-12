package algorithms.mishra.dev.rahul.datastructure.trees;

import java.util.Objects;

public class BinarySearchTree_1 {
	
	private class Node {
		private int value;
		private Node leftChildNode;
		private Node rightChildNode;
		
		public Node(int value) {
			this.value = value;
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
	
	private Node rootNode;
	
	public void insertValues(int[] values) {
		for(int value : values) {
			rootNode = insert(rootNode, value);
		}
	}
	
	public Node insert(Node node, int value) {
		if(Objects.isNull(node)) {
			return new Node(value);
		}
		
		if(value <= node.getValue()) {
			node.setLeftChildNode(insert(node.getLeftChildNode(), value));
		} else if(value > node.getValue()) {
			node.setRightChildNode(insert(node.getRightChildNode(), value));
		}
		return node;
	}
	
	public int findMax(Node node) {
		if(Objects.nonNull(node.getRightChildNode())) {
			return findMax(node.getRightChildNode());
		}
		return node.getValue();
	}
	
	public int findMin(Node node) {
		if(Objects.nonNull(node.getLeftChildNode())) {
			return findMin(node.getLeftChildNode());
		}
		return node.getValue();
	}
	
	public boolean contains(Node node, int key) {
		if(Objects.isNull(node)) {
			return false;
		}
		
		if(key == node.getValue()) {
			return true;
		} else if(key < node.getValue()) {
			return contains(node.getLeftChildNode(), key);
		} else if (key > node.getValue()) {
			return contains(node.getRightChildNode(), key);
		}
		return false;
	}
	
	public int findHeight(Node node) {
		if(Objects.isNull(node)) {
			return 0;
		}
		
		return 1 + Math.max(findHeight(node.getLeftChildNode()), findHeight(node.getRightChildNode()));
	}
	
	@Override
	public String toString() {
		String str = "BST_1: " + rootNode;
		return str;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
}