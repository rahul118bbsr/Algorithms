/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.ideserve.co.in/learn/check-if-two-nodes-are-cousins-binary-tree
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 20-Jun-2017 6:16:23 PM
 *
 */
public class BSTCheckForCousin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new BSTCheckForCousin().new BST();
		Node root = bst.add(null, 10);
		root = bst.add(root, 5);
		root = bst.add(root, 15);
		root = bst.add(root, 3);
		root = bst.add(root, 8);
		root = bst.add(root, 13);
		root = bst.add(root, 21);
		root = bst.add(root, 2);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 9);
		root = bst.add(root, 12);
		root = bst.add(root, 14);
		root = bst.add(root, 19);
		root = bst.add(root, 25);

		System.out.println(bst.checkIfCousinNodes(root, 25, 19));

	}

	class BST {
		public Node add(Node root, int data) {
			Node end = new Node(data);
			if (root == null) {
				return end;
			}

			if (data <= root.data) {
				root.left = add(root.left, data);
			} else if (data > root.data) {
				root.right = add(root.right, data);
			}
			return root;
		}

		public boolean checkIfCousinNodes(Node root, int data1, int data2) {
			if (root == null) {
				return false;
			}

			CousinSearchModel node1 = search(root, null, data1, 0);
			CousinSearchModel node2 = search(root, null, data2, 0);
			return (node1 != null && node2 != null) && (node1.level == node2.level) && (node1.parent != node2.parent);
		}

		private CousinSearchModel search(Node root, Node parent, int data, int level) {
			if (root.data == data) {
				return new CousinSearchModel(parent, level);
			} else if (data < root.data) {
				return search(root.left, root, data, ++level);
			} else if (data > root.data) {
				return search(root.right, root, data, ++level);
			}
			return new CousinSearchModel(parent, level);
		}
	}

	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Value: " + data + " Left: " + left + " Right" + right;
		}
	}

	class CousinSearchModel {
		Node parent;
		int level;

		public CousinSearchModel(Node parent, int level) {
			this.parent = parent;
			this.level = level;
		}
	}
}