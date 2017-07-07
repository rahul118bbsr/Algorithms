/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 20-Jun-2017 10:11:50 AM
 *
 */
public class BSTAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new BST();
		Node root_1 = bst.addRecursively(null, 5);
		root_1 = bst.addRecursively(root_1, 9);
		root_1 = bst.addRecursively(root_1, 3);
		root_1 = bst.addRecursively(root_1, 4);
		root_1 = bst.addRecursively(root_1, 1);
		root_1 = bst.addRecursively(root_1, 10);
		root_1 = bst.addRecursively(root_1, 6);
		root_1 = bst.addRecursively(root_1, 2);
		System.out.println(root_1);

		Node root_2 = bst.addRecursively(null, 5);
		root_2 = bst.addIteratively(root_2, 9);
		root_2 = bst.addIteratively(root_2, 3);
		root_2 = bst.addIteratively(root_2, 4);
		root_2 = bst.addIteratively(root_2, 1);
		root_2 = bst.addIteratively(root_2, 10);
		root_2 = bst.addIteratively(root_2, 6);
		root_2 = bst.addIteratively(root_2, 2);
		System.out.println(root_2);
	}

}

class BST {

	public Node addRecursively(Node root, int data) {
		Node end = new Node(data);
		if (root == null) {
			return end;
		}

		if (data <= root.data) {
			root.left = addRecursively(root.left, data);
		} else if (data > root.data) {
			root.right = addRecursively(root.right, data);
		}
		return root;
	}

	public Node addIteratively(Node root, int data) {
		Node end = new Node(data);
		if (root == null) {
			return end;
		}
		Node current = root;
		while (true) {
			if (data <= current.data) {
				if (current.left == null) {
					current.left = end;
					break;
				} else {
					current = current.left;
				}
			} else if (data > current.data) {
				if (current.right == null) {
					current.right = end;
					break;
				} else {
					current = current.right;
				}
			}
		}
		return root;
	}
}

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Value: " + data + ", Left Child: " + left + ", Right Child: " + right;
	}
}
