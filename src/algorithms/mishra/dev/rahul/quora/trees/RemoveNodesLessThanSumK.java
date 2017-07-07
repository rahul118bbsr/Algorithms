/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-Jun-2017 10:09:55 AM
 *
 */
public class RemoveNodesLessThanSumK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new RemoveNodesLessThanSumK().new Tree();
		Node root = tree.createTree();
		System.out.println("Enter the value of K: ");
		Scanner scanner = new Scanner(System.in);
		root = tree.deleteNodeLessThanSumK(root, scanner.nextInt());
		scanner.close();
	}

	class Tree {
		public Node createTree() {
			Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.right.left = new Node(4);
			root.right.left.left = new Node(6);
			root.right.left.left.right = new Node(8);
			root.right.right = new Node(5);
			root.right.right.right = new Node(7);
			root.right.right.right.left = new Node(9);
			root.right.right.right.left.left = new Node(10);
			return root;
		}

		public Node deleteNodeLessThanSumK(Node root, int k) {
			if (root == null) {
				return root;
			}

			Node currentLeft = root.left;
			Node currentRight = root.right;
			Node current = root;

			while (currentLeft != null) {
				int sum = currentLeft.data + findSum(currentLeft.right, 0);
				if (sum < k) {
					if (currentLeft.left != null) {
						currentLeft.right = null;
						currentLeft = currentLeft.left;
						current = currentLeft;
					} else {
						current.left = null;
						currentLeft = null;
					}
				} else {
					currentLeft = currentLeft.left;
					current = currentLeft;
				}
			}

			while (currentRight != null) {
				int sum = currentRight.data + findSum(currentRight.left, 0);
				if (sum < k) {
					if (currentRight.right != null) {
						currentRight.left = null;
						currentRight = currentRight.right;
						current = currentRight;
					} else {
						current.right = null;
						currentRight = null;
					}
				} else {
					currentRight = currentRight.right;
					current = currentRight;
				}
				
			}
			return root;
		}

		private int findSum(Node root, int sum) {
			if (root == null) {
				return 0;
			}
			return root.data + findSum(root.left, sum) + findSum(root.right, sum);
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
