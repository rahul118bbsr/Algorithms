package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by aleesha on 14/07/17.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new InvertBinaryTree().new BinaryTree();
        Node root = binaryTree.invertTree(binaryTree.create());
        System.out.println();
    }

    class BinaryTree {
        public Node create() {
//            Node root = new Node(4);
//            root.left = new Node(2);
//            root.left.left = new Node(1);
//            root.left.right = new Node(3);
//            root.right = new Node(7);
//            root.right.left = new Node(6);
//            root.right.right = new Node(9);
            Node root = new Node(1);
            root.left = new Node(2);
            return root;
        }

        public Node invertTree(Node root) {
            if (root == null) {
                return null;
            }

            final Deque<Node> stack = new LinkedList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                final Node node = stack.pop();
                final Node left = node.left;
                node.left = node.right;
                node.right = left;

                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return root;
        }

    }

    class Node {
        Node left;
        Node right;
        Integer data;

        Node(int data) {
            this.data = data;
        }
    }
}
