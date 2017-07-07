/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 21-Jun-2017 7:07:06 PM
 *
 */
public class CheckIfBST {

	public static void main(String[] args) {
		BST bst = new CheckIfBST().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 2);

		System.out.println(bst.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		bst.modifyTree(root, 2, 10);
		System.out.println(bst.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
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
		
		public void modifyTree(Node root, int currentData, int newData) {
			if(root == null) {
				return;
			}
			
			if(currentData == root.data) {
				root.data = newData;
			} else if(currentData < root.data) {
				modifyTree(root.left, currentData, newData);
			} else if(currentData > root.data) {
				modifyTree(root.right, currentData, newData);
			}
		}

		public boolean checkIfBST(Node root, int low, int high) {
			if(root == null) {
				return true;
			}
			
			if(low > root.data || high < root.data) {
				return false;
			}
			
			return checkIfBST(root.left, low, root.data) && checkIfBST(root.right, root.data, high);
		}
	}
	
	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
}
