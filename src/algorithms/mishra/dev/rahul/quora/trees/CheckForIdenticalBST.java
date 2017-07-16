/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-Jun-2017 3:21:29 PM
 *
 */
public class CheckForIdenticalBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new CheckForIdenticalBST().new BST();
		Node root1 = bst.add(null, 5);
		root1 = bst.add(root1, 3);
		root1 = bst.add(root1, 9);
		root1 = bst.add(root1, 1);
		root1 = bst.add(root1, 4);
		root1 = bst.add(root1, 6);
		root1 = bst.add(root1, 10);
		root1 = bst.add(root1, 0);
		root1 = bst.add(root1, 2);

		Node root2 = bst.add(null, 5);
		root2 = bst.add(root2, 3);
		root2 = bst.add(root2, 9);
		root2 = bst.add(root2, 1);
		root2 = bst.add(root2, 4);
		root2 = bst.add(root2, 6);
		root2 = bst.add(root2, 10);
		root2 = bst.add(root2, 0);
		root2 = bst.add(root2, 2);

		System.out.println(bst.areIdenticalBSTs(root1, root2));
		System.out.println(bst.areIdenticalBSTs_Iterative(root1, root2));
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

		public boolean areIdenticalBSTs(Node root1, Node root2) {
			if (root1 == null && root2 == null) {
				return true;
			}

			if (root1 == null || root2 == null) {
				return false;
			}

			if (root1.data == root2.data) {
				return areIdenticalBSTs(root1.left, root2.left) && areIdenticalBSTs(root1.right, root2.right);
			} 
			return false;
		}

		public boolean areIdenticalBSTs_Iterative(Node root1, Node root2) {
			if (root1 == null && root2 == null) {
				return true;
			}

			if (root1 == null || root2 == null) {
				return false;
			}

			Queue<Node> q1 = new LinkedList<>();
			Queue<Node> q2 = new LinkedList<>();
			q1.add(root1);
			q2.add(root2);

			while (!q1.isEmpty() && !q2.isEmpty()) {
				Node c1 = q1.poll();
				Node c2 = q2.poll();

				if (c1.data != c2.data) {
					return false;
				}

				if (c1.left != null)
					q1.add(c1.left);
				if (c2.left != null)
					q2.add(c2.left);

				if (c1.right != null)
					q1.add(c1.right);
				if (c2.right != null)
					q2.add(c2.right);
			}
			return q1.isEmpty() && q2.isEmpty();
		}
	}

	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
