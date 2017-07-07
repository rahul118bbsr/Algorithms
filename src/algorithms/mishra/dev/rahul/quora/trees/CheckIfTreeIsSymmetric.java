/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 24-Jun-2017 2:55:34 PM
 *
 */
public class CheckIfTreeIsSymmetric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new CheckIfTreeIsSymmetric().new Tree();
		System.out.println(tree.checkIfTreeIsSymmetric(tree.createTree()));

	}
	
	class Tree {
		public Node createTree() {
			Node root = new Node(3);
			root.left = new Node(1);
			root.left.left = new Node(0);
			root.left.left.left = new Node(3);	
			root.left.right = new Node(2);
			root.left.right.right = new Node(4);
			
			root.right = new Node(1);
			root.right.left = new Node(2);
			root.right.left.left = new Node(4);
			root.right.right = new Node(0);
			root.right.right.right = new Node(3);
			
			return root;
		}
		
		public boolean checkIfTreeIsSymmetric(Node root) {
			return checkIfTreeIsSymmetric(root.left, root.right);
		}
		
		private boolean checkIfTreeIsSymmetric(Node root1, Node root2) {
			if(root1 == null && root2 == null) {
				return true;
			}
			
			if(root1 == null || root2 == null) {
				return false;
			}
			
			if(root1.data == root2.data) {
				return checkIfTreeIsSymmetric(root1.left, root2.right) && checkIfTreeIsSymmetric(root1.right, root2.left);
			}
			return false;
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
