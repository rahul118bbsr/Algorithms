/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 1:39:08 PM
 *
 */
public class PrintTopView {

	public static void main(String[] args) {
		BST bst = new PrintTopView().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		bst.printTopView(root);
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

		public void printTopView(Node root) {
			if (root == null) {
				return;
			}
			Stack<Node> stack = new Stack<>();
			stack.push(root);
			printLeft(stack);
			stack.push(root.right);
			printRight(stack);
		}

		private void printLeft(Stack<Node> stack) {
			while (!stack.isEmpty()) {
				Node current = stack.pop();
				System.out.print(current.data + " ");
				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}

		private void printRight(Stack<Node> stack) {
			while (!stack.isEmpty()) {
				Node current = stack.pop();
				System.out.print(current.data + " ");
				if (current.right != null) {
					stack.push(current.right);
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
