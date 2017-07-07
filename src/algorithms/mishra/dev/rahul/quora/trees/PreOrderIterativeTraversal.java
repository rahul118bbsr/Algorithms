/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 6:30:51 PM
 *
 */
public class PreOrderIterativeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		int num = scanner.nextInt();
		BST bst = new PreOrderIterativeTraversal().new BST();
		Node root = null;
		System.out.println("Enter node values: ");
		for(int i = 0; i < num; i++) {
			root = bst.add(root, scanner.nextInt());
		}
		scanner.close();
		bst.preOrderTraversal(root);
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
			Stack<Node> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node node = stack.pop();
				System.out.print(node.data + " ");
				if (node.right != null) {
					stack.push(node.right);
				}

				if (node.left != null) {
					stack.push(node.left);
				}
			}

		}
	}

	class Node {
		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
		}
	}

}
