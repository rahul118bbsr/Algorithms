package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.Stack;

/**
 * Created by aleesha on 14/07/17.
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        BinaryTree binaryTree = new SumOfLeftLeaves().new BinaryTree();
        System.out.println(binaryTree.findSumOfLeftLeaves(binaryTree.create()));
    }

    class BinaryTree {
        public Node create() {
            Node root = new Node(3);
            root.left = new Node(9);
            root.right = new Node(20);
            root.right.left = new Node(15);
            root.right.right = new Node(7);
            return root;
        }

        public int findSumOfLeftLeaves(Node root) {
            if(root == null) {
                return 0;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            int sum = 0;
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                if(node.left != null) {
                    stack.push(node.left);
                    sum = node.left.left == null && node.left.right == null ? sum + node.left.data : sum;
                }
                if(node.right != null) {
                    stack.push(node.right);
                }
            }
            return sum;
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
