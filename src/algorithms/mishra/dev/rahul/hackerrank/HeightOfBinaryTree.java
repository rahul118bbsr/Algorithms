/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 4:40:12 PM
 *
 */
public class HeightOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new HeightOfBinaryTree().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);

		System.out.println(bst.findHeightOfTree(root));

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
		
		public int findHeightOfTree(Node root) {
			if(root == null) {
				return -1;
			}
			
			return Math.max(findHeightOfTree(root.left) + 1, findHeightOfTree(root.right) + 1);
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
