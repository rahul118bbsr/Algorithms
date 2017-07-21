/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-Jun-2017 2:24:20 PM
 *
 */
public class CheckIfTreeBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new CheckIfTreeBalanced().new Tree();
		Node root = tree.createTree();
		System.out.println(tree.checkIfTreeIsBalanced(root));
	}

	class Tree {
		public Node createTree() {
			 Node root = new Node(0);
			 root.left = new Node(1);
			 root.left.left = new Node(3);
//			 root.left.left.left = new Node(0);
			 root.left.left.right = new Node(1);
			 root.left.left.right.right = new Node(4);
			 root.left.right = new Node(4);
			 root.right = new Node(2);
			 root.right.left = new Node(5);
			 root.right.left.left = new Node(0);

//			Node root = new Node(3);
//			root.left = new Node(1);
//			root.left.left = new Node(0);
//			root.left.right = new Node(2);
//			root.right = new Node(5);
//			root.right.left = new Node(4);
//			root.right.left.left = new Node(4);
//			root.right.left.left.left = new Node(4);

			return root;
		}

		public boolean checkIfTreeIsBalanced(Node root) {
			if (root == null) {
				return true;
			}

			if (Math.abs(findHeight(root.left) - findHeight(root.right)) > 1) {
				return false;
			}

			if (root.left != null) {
				checkIfTreeIsBalanced(root.left);
			}

			if (root.right != null) {
				checkIfTreeIsBalanced(root.right);
			}
			return true;
		}

		private int findHeight(Node root) {
			if (root == null) {
				return 0;
			}

			return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
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
			return data + "";
		}
	}

}
