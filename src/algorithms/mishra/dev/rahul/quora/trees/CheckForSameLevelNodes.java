/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Check if two nodes are on the same level or not
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 8:24:59 AM
 *
 */
public class CheckForSameLevelNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int num = scanner.nextInt();
		BST bst = new CheckForSameLevelNodes().new BST();
		Node root = null;
		System.out.println("Enter the elements: ");
		for (int i = 0; i < num; i++) {
			root = bst.add(root, scanner.nextInt());
		}
		System.out.println("Enter two node value to check: ");
		int data1 = scanner.nextInt();
		int data2 = scanner.nextInt();
		System.out.println(bst.checkIfNodesAreOnSameLevel(root, data1, data2));
		System.out.println(bst.checkIfNodesAreOnSameLevel_2(root, data1, data2));
		System.out.println(bst.checkIfNodesAreOnSameLevel_3(root, data1, data2));
		scanner.close();
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

		public boolean checkIfNodesAreOnSameLevel(Node root, int data1, int data2) {
			if (root == null) {
				return false;
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			int nodesInCurrentLevelCount = 1;
			int nextLevelCount = 0;
			while (!queue.isEmpty()) {
				if (nodesInCurrentLevelCount != 0) {
					Node node = queue.poll();
					nodesInCurrentLevelCount--;
					if (node.left != null) {
						queue.add(node.left);
						nextLevelCount++;
					}
					if (node.right != null) {
						queue.add(node.right);
						nextLevelCount++;
					}
					continue;
				}

				// Once current level count is 0, remaining elements in the queue would belong to the next level and the count of the number of elements in queue would be in nextLevelCount 
				if (checkForSameLevelNodes(queue, data1, data2)) {
					return true;
				}
				nodesInCurrentLevelCount = nextLevelCount;
				nextLevelCount = 0;
			}
			return false;
		}
		
		public boolean checkIfNodesAreOnSameLevel_2(Node root, int data1, int data2) {
			if (root == null) {
				return false;
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			int currentLevelCount = 1;
			while (!queue.isEmpty()) {
				if (currentLevelCount != 0) {
					Node node = queue.poll();
					currentLevelCount--;
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
					continue;
				}

				// Once current level count is 0, remaining elements in the queue would belong to the next level 
				if (checkForSameLevelNodes(queue, data1, data2)) {
					return true;
				}
				currentLevelCount = queue.size();
			}
			return false;
		}

		public boolean checkIfNodesAreOnSameLevel_3(Node root, int data1, int data2) {
			if(root == null) {
				return false;
			}
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				int n = queue.size();
				for(int i = 0; i < n; i++) {
					Node node = queue.poll();
					if(node.left != null) {
						queue.add(node.left);
					}
					if(node.right != null) {
						queue.add(node.right);
					}
				}
				if(checkForSameLevelNodes(queue, data1, data2)) {
					return true;
				}
			}
			return false;
		}

		private boolean checkForSameLevelNodes(Queue<Node> queue, int data1, int data2) {
			boolean b1 = false;
			boolean b2 = false;
			for (Node node : queue) {
				if (node.data == data1) {
					b1 = true;
				} else if (node.data == data2) {
					b2 = true;
				}
				
				if(b1 && b2) {
					return true;
				}
			}
			return b1 && b2;
		}
	}

	class Node {
		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "" + data;
		}
	}

}
