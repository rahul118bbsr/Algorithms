/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

/**
 * https://www.youtube.com/watch?v=TIoCCStdiFo&index=16&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 5:49:08 PM
 *
 */
public class LowestCommonAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new LowestCommonAncestor().new BinaryTree();
		bt.create();
	}

	class BinaryTree {

		public void create() {
			Node root = new Node(10);
			root.left = new Node(-10);
			root.left.right = new Node(8);
			Node node_6 = new Node(6);
			root.left.right.left = node_6;
			Node node_9 = new Node(9);
			root.left.right.right = node_9;
			Node node_30 = new Node(30);
			root.right = node_30;
			root.right.left = new Node(25);
			Node node_28 = new Node(28);
			root.right.left.right = node_28;
			root.right.right = new Node(60);
			Node node_78 = new Node(78);
			root.right.right.right = node_78;
			System.out.println(lowestCommonAncestor(root, node_28, node_78).data);
			System.out.println(lowestCommonAncestor(root, node_6, node_9).data);
			System.out.println(lowestCommonAncestor(root, node_30, node_78).data);
		}

		/**
		 * This is for any binary tree. BST is a special case of binary tree. So
		 * this works for BSt as well
		 * https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby
		 * 
		 * @param root
		 * @param p
		 * @param q
		 * @return
		 */
		public Node lowestCommonAncestor(Node root, Node p, Node q) {
			if (root == null || root == p || root == q)
				return root;
			Node left = lowestCommonAncestor(root.left, p, q);
			Node right = lowestCommonAncestor(root.right, p, q);
			return left == null ? right : right == null ? left : root;
		}

		/**
		 * This solution is for BST
		 **/
		public Node lowestCommonAncestor(Node root, int p, int q) {
			if (root.data > Math.max(p, q)) {
				return lowestCommonAncestor(root.left, p, q);
			} else if (root.data < Math.min(p, q)) {
				return lowestCommonAncestor(root.right, p, q);
			} else {
				return root;
			}
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
