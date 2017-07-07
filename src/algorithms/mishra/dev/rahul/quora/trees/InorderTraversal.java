/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 10:05:10 AM
 *
 */
public class InorderTraversal {

	public static void main(String[] args) {
		BST bst = new InorderTraversal().new BST();
		Node root = bst.add(null, 10);
		root = bst.add(root, 5);
		root = bst.add(root, 2);
		root = bst.add(root, 9);
		root = bst.add(root, 4);
		root = bst.add(root, 15);
		root = bst.add(root, 12);
		root = bst.add(root, 20);
		root = bst.add(root, 11);
		root = bst.add(root, 14);
		root = bst.add(root, 17);
		root = bst.add(root, 25);

		bst.inOrderTraversal(root);
		System.out.println();
		bst.inOrderTraversalIteratively(root);
		System.out.println();
		bst.inorderTraversal(root);
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

		public void inOrderTraversal(Node root) {
			if (root == null) {
				return;
			}

			if (root.left != null) {
				inOrderTraversal(root.left);
			}

			System.out.print(root.data + " ");

			if (root.right != null) {
				inOrderTraversal(root.right);
			}
		}

		public void inOrderTraversalIteratively(Node root) {
			if (root == null) {
				return;
			}

			Stack<Node> stack = new Stack<>();
			Node current = root;
			while (!stack.isEmpty() || current != null) {
				if (current != null) {
					stack.push(current);
					current = current.left;
				} else {
					current = stack.pop();
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}

		/**
		 * http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
		 * 
		 * @param root
		 */
		public void inorderTraversal(Node root) {
			if (root == null)
				return;

			Stack<Node> stack = new Stack<>();
			Node p = root;

			while (!stack.empty() || p != null) {
				if (p != null) {
					stack.push(p);
					p = p.left;
				} else {
					Node t = stack.pop();
					System.out.print(t.data + " ");
					p = t.right;
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
