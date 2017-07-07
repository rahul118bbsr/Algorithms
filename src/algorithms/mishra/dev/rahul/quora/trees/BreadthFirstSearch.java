/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 22-Jun-2017 1:13:33 PM
 *
 */
public class BreadthFirstSearch {

	public static void main(String[] args) {
		BST bst = new BreadthFirstSearch().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		bst.breadthFirstTraversal(root);
	}
	
	class BST {
		public Node add(Node root, int data) {
			Node end = new Node(data);
			if(root == null) {
				return end;
			}
			
			if(data <= root.data) {
				root.left = add(root.left, data);
			} else if(data > root.data) {
				root.right = add(root.right, data);
			}
			
			return root;
		}
		
		public void breadthFirstTraversal(Node root) {
			if(root == null) {
				return;
			}
			
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node current = queue.poll();
				System.out.print(current.data + " ");
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
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
