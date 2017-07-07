/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-Jun-2017 3:59:39 PM
 *
 */
public class CheckForCompleteBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new CheckForCompleteBinaryTree().new Tree();
		Node root = tree.createTree();
		System.out.println(tree.isTreeComplete(root));
		System.out.println(tree.isComplete(root, 0, tree.countNodes(root)));
	}

	class Tree {
		public Node createTree() {
			Node root = new Node(1);
			root.left = new Node(2);
			root.left.left = new Node(4);
			root.left.left.right = new Node(7);
			root.left.right = new Node(5);
			root.right = new Node(3);
			 root.right.left = new Node(6);
			 root.right.right = new Node(8);
			return root;
		}

		/**
		 * At each node push both left and right onto the list be traversed (even if they are NULL). After you hit the first NULL there 
		 * should only be NULL objects left to find. If you find a non NULL object after this it is not a complete tree.
		 * 
		 * @param root
		 * @return
		 */
		public boolean isTreeComplete(Node root) {
			if (root == null) {
				return true;
			}
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				if (current == null) {
					break;
				}

				queue.add(current.left);
				queue.add(current.right);
			}

			if (queue.isEmpty()) {
				return true;
			} else {
				for (Node node : queue) {
					if (node != null) {
						return false;
					}
				}
			}
			return true;
		}

		int countNodes(Node root) {
			if (root == null)
				return (0);
			return (1 + countNodes(root.left) + countNodes(root.right));
		}

		/* This function checks if the binary tree is complete or not */
		boolean isComplete(Node root, int index, int number_nodes) {
			// An empty tree is complete
			if (root == null)
				return true;

			// If index assigned to current node is more than
			// number of nodes in tree, then tree is not complete
			if (index >= number_nodes)
				return false;

			// Recur for left and right subtrees
			return (isComplete(root.left, 2 * index + 1, number_nodes)
					&& isComplete(root.right, 2 * index + 2, number_nodes));

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
