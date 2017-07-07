/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Jun-2017 1:46:52 PM
 *
 */
public class PrintBottomView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new PrintBottomView().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		bst.printBottomView_BFS(root);
		System.out.println("");
		bst.printBottomView_DFS(root);
	}
	
	class BST {
		public Node add(Node root, int data) {
			Node end = new Node(data);
			if(root == null) {
				return end;
			}
			
			if(data <= root.data) {
				root.left = add(root.left, data);
			} else if (data > root.data) {
				root.right = add(root.right, data);
			}
			return root;
		}
		
		public void printBottomView_BFS(Node root) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node current = queue.poll();
				if(current.left == null && current.right == null) {
					System.out.print(current.data + " ");
				} 
				
				if (current.left != null) {
					queue.add(current.left);
				} 
				
				if(current.right != null) {
					queue.add(current.right);
				}
			}
		}
		
		public void printBottomView_DFS(Node root) {
			Stack<Node> stack = new Stack<>();
			stack.add(root);
			while(!stack.isEmpty()) {
				Node current = stack.pop();
				if(current.left == null && current.right == null) {
					System.out.print(current.data + " ");
				} 
				
				if(current.right != null) {
					stack.push(current.right);
				}
				
				if (current.left != null) {
					stack.push(current.left);
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
