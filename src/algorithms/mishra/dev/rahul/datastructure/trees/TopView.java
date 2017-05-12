package algorithms.mishra.dev.rahul.datastructure.trees;

/**
 * https://www.hackerrank.com/challenges/tree-top-view
 *   3
 * /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8
 * Top View : 1 -> 5 -> 3 -> 2 -> 7
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-May-2017 11:33:09 AM
 *
 */
public class TopView {
	public void top_view(Node root) {
		leftNodes(root);
		rightNodes(root.rightChildNode);
	}
	
	private void leftNodes(Node root) {
		if(root == null) {
			return;
		}
		
		if(root.leftChildNode != null) {
			leftNodes(root.leftChildNode);
		}
		System.out.println(root.getValue());
	}
	
	private void rightNodes(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.getValue());
		if(root.rightChildNode != null) {
			rightNodes(root.rightChildNode);
		}
	}
}
