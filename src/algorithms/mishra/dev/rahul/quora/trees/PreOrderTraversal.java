/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 9:36:17 AM
 *
 */
public class PreOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new PreOrderTraversal().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		bst.preOrderTraversal(root);
		System.out.println();
		bst.preOrderTraversalIteratively(root);
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

		public void preOrderTraversal(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data + " ");
			if (root.left != null) {
				preOrderTraversal(root.left);
			}

			if (root.right != null) {
				preOrderTraversal(root.right);
			}
		}

		public void preOrderTraversalIteratively(Node root) {
			if (root == null) {
				return;
			}

			Stack<Node> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				Node current = stack.pop();
				System.out.print(current.data + " ");
				if (current.right != null) {
					stack.push(current.right);
				}

				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}
	}

	class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

}
