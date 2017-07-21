/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Jun-2017 3:35:29 PM
 *
 */
public class CheckForFullBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new CheckForFullBinaryTree().new Tree();
		System.out.println(tree.isTreeFull(tree.createTree()));
		System.out.println(tree.isTreeFullIterative(tree.createTree()));
	}
	
	class Tree {
		public Node createTree() {
			Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.right.left = new Node(6);
			root.right.right = new Node(7);
			return root;
		}
		
		public boolean isTreeFull(Node root) {
			if((root == null)) {
				return true;
			}
			
			if((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
				return false;
			}
			return isTreeFull(root.left) && isTreeFull(root.right);
		}

		public boolean isTreeFullIterative(Node root) {
			if(root == null) {
				return false;
			}

			Stack<Node> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				if((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
					return false;
				}

				if(node.left != null) {
					stack.push(node.left);
				}
				if(node.right != null) {
					stack.push(node.right);
				}
			}
			return true;
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
