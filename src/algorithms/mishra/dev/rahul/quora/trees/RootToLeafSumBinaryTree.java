/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 8:52:36 PM
 *
 */
public class RootToLeafSumBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	class BinaryTree {
		public Node createTree() {
			Node root = new Node(10);
			root.left = new Node(16);
			root.left.right = new Node(-3);
			root.right = new Node(5);
			root.right.left = new Node(6);
			root.right.right = new Node(11);
			return root;
		}
		

	    public boolean pathSumInner(Node root, int sum) {
			if(root == null) {
				return false;
			}
			Stack<Node> stack = new Stack<>();
			Stack<Integer> sumFromRootTillNode = new Stack<>();
			stack.push(root);
			sumFromRootTillNode.push(root.data);
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				int sumSofar = sumFromRootTillNode.pop();
				if(node.left == null && node.right == null) {
					if(sumSofar == sum) {
						return true;
					}
				}
				if(node.right != null) {
					stack.push(node.right);
					sumFromRootTillNode.push(sumSofar + node.right.data);
				}
				if(node.left != null) {
					stack.push(node.left);
					sumFromRootTillNode.push(sumSofar + node.left.data);
				}
			}
			return false;
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
