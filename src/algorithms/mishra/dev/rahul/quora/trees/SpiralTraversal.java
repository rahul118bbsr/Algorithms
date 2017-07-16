/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.youtube.com/watch?v=vjt5Y6-1KsQ&index=15&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 5:16:16 PM
 *
 */
public class SpiralTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new SpiralTraversal().new BinaryTree();
		System.out.println(bt.spiralTraversal(bt.createTree()));
		System.out.println();
		System.out.println(bt.spiralTraversal_1(bt.createTree()));

	}

	class BinaryTree {
		public Node createTree() {
			Node root = new Node(3);
			root.left = new Node(9);
			root.right = new Node(20);
			root.right.left = new Node(15);
			root.right.right = new Node(7);
			return root;
		}

		public List<Integer> spiralTraversal(Node root) {
			if (root == null) {
				return null;
			}

			List<Integer> resultList = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			resultList.add(root.data);
			int nodesInCurrentLevelCount = 1;
			int levelCount = 1;

			while (!queue.isEmpty()) {
				if (nodesInCurrentLevelCount != 0) {
					Node node = queue.poll();
					nodesInCurrentLevelCount--;
					if (levelCount % 2 == 0) {
						if (node.left != null) {
							queue.add(node.left);
							resultList.add(node.left.data);
						}
						if (node.right != null) {
							queue.add(node.right);
							resultList.add(node.right.data);
						}
					} else {
						if (node.right != null) {
							queue.add(node.right);
							resultList.add(node.right.data);
						}
						if (node.left != null) {
							queue.add(node.left);
							resultList.add(node.left.data);
						}
					}
					continue;
				}
				levelCount++;
				nodesInCurrentLevelCount = queue.size();
			}
			return resultList;
		}

		public List<Integer> spiralTraversal_1(Node root) {
			if(root == null) {
				return null;
			}
			List<Integer> list = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			int level = 1;
			while(!queue.isEmpty()) {
				int n = queue.size();
				for(int i = 0; i < n; i++) {
					Node node = queue.poll();
					list.add(node.data);
					if(level % 2 == 0) {
						addToQueue(queue, node.left);
						addToQueue(queue, node.right);
					} else {
						addToQueue(queue, node.right);
						addToQueue(queue, node.left);
					}
				}
				level++;
			}
			return list;
		}

		private void addToQueue(Queue<Node> queue, Node node) {
			if(node != null) {
				queue.add(node);
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
