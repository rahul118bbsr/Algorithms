/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=qT65HltK2uE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=10
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 6:11:22 PM
 *
 */
public class PostOrderIterativeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of nodes of the Tree: ");
		int num = scanner.nextInt();
		BST bst = new PostOrderIterativeTraversal().new BST();
		Node root = null;
		System.out.println("Enter the node value: ");
		for (int i = 0; i < num; i++) {
			root = bst.add(root, scanner.nextInt());
		}
		scanner.close();
		bst.postOrderTraversal(root);
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

			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();
			s1.push(root);
			while (!s1.isEmpty()) {
				Node node = s1.pop();
				s2.push(node);

				if (node.left != null) {
					s1.push(node.left);
				}

				if (node.right != null) {
					s1.push(node.right);
				}
			}

			while (!s2.isEmpty()) {
				System.out.print(s2.pop().data + " ");
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
