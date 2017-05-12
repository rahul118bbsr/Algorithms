/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.trees;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-May-2017 3:11:12 PM
 *
 */
public class BinarySearchTreeCheck {

	boolean checkBST(Node root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int low, int high) {
		if (root == null) {
			return true;
		}
		if (root.value <= low || root.value >= high) {
			return false;
		}
		return isBinarySearchTree(root.leftChildNode, low, root.value)
				&& isBinarySearchTree(root.rightChildNode, root.value, high);
	}

}
