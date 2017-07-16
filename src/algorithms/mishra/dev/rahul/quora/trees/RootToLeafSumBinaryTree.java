/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 8:52:36 PM
 *
 */
public class RootToLeafSumBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class BinaryTree {
		public Node createTree() {
			Node root = new Node(10);
			root.left = new Node(16);
			root.left.right = new Node(-3);
			root.right = new Node(5);
			root.right.left = new Node(6);
			root.right.right = new Node(11);
			return root;
		}
		
		private List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	    
	    public void pathSumInner(Node root, int sum, Stack<Integer>path) {
	        path.push(root.data);
	        if(root.left == null && root.right == null)
	            if(sum == root.data) resultList.add(new ArrayList<Integer>(path));
	        if(root.left!=null) pathSumInner(root.left, sum-root.data, path);
	        if(root.right!=null)pathSumInner(root.right, sum-root.data, path);
	        path.pop();
	    }
	    
	    public List<List<Integer>> pathSum(Node root, int sum) {
	        if(root==null) return resultList;
	        Stack<Integer> path = new Stack<Integer>();
	        pathSumInner(root, sum, path);
	        return resultList;
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
