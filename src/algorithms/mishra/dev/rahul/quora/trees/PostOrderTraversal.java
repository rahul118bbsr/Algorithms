/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 9:53:39 AM
 *
 */
public class PostOrderTraversal {

	public static void main(String[] args) {
		BST bst = new PostOrderTraversal().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		bst.postOrderTraversal(root);
		System.out.println();
		bst.postOrderTraversalIteratively(root);
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

		public void postOrderTraversal(Node root) {
			if (root == null) {
				return;
			}

			if (root.left != null) {
				postOrderTraversal(root.left);
			}

			if (root.right != null) {
				postOrderTraversal(root.right);
			}
			System.out.print(root.data + " ");
		}

		public void postOrderTraversalIteratively(Node root) {
			if (root == null) {
				return;
			}

			Stack<Node> stack = new Stack<Node>();
			stack.push(root);

			while (!stack.isEmpty()) {
				Node temp = stack.peek();
				if (temp.left == null && temp.right == null) {
					Node pop = stack.pop();
					System.out.print(pop.data + " ");
				} else {
					if (temp.right != null) {
						stack.push(temp.right);
						temp.right = null;
					}

					if (temp.left != null) {
						stack.push(temp.left);
						temp.left = null;
					}
				}
			}

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
