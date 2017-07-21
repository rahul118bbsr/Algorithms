package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aleesha on 14/07/17.
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new MaximumDepthOfBinaryTree().new BinaryTree();
        System.out.println(binaryTree.calculateMaxDepth(binaryTree.createTree()));
    }

    class BinaryTree {
        public Node createTree() {
            Node root = new Node(3);
            root.left = new Node(9);
            root.right = new Node(20);
            root.right.left = new Node(15);
            root.right.right = new Node(7);
            return root;
        }

        public int calculateMaxDepth(Node root) {
            if (root == null) return 0;
            return Math.max(calculateMaxDepth(root.left) + 1, calculateMaxDepth(root.right) + 1);
        }

        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                count++;
            }
            return count;
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
