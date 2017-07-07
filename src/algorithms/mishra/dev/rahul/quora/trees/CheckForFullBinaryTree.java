/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

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
