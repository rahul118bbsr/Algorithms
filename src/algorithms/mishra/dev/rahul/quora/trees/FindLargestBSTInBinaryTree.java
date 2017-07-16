package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * http://www.ideserve.co.in/learn/size-of-largest-bst-in-binary-tree
 * <p>
 * Created by aleesha on 14/07/17.
 */
public class FindLargestBSTInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new FindLargestBSTInBinaryTree().new BinaryTree();
        System.out.println(binaryTree.findSizeOfBST_1(binaryTree.create()));
    }

    class BinaryTree {
        public Node create() {
            Node root = new Node(10);
            root.left = new Node(5);
            root.left.left = new Node(4);
            root.left.right = new Node(7);
            root.right = new Node(12);
            root.right.left = new Node(9);
            root.right.right = new Node(14);
            root.right.right.left = new Node(13);
            root.right.right.right = new Node(16);
            return root;
        }

        private int findSizeOfBST_1(Node root) {
            if (root == null) {
                return 0;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            int maxSize = 0;
            int currentTreeSize = 0;
            /*
             * Check if node' left and right are BST nodes, if yes then increment currentTreeSize by 1. If it violates BST, then check if we have found the largest size of BST tree
             * or not by saving the sub-tree size in maxSize and then reset the currentTreeSize to 0 so that it can start counting the size of next subtree.
             */
            while (!stack.isEmpty()) {
                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    if (node.right.data > node.data) {
                        currentTreeSize++;
                    } else {
                        maxSize = Math.max(currentTreeSize, maxSize);
                        currentTreeSize = 0;
                    }
                }

                if (node.left != null) {
                    stack.push(node.left);
                    if (node.left.data <= node.data) {
                        currentTreeSize++;
                    } else {
                        maxSize = Math.max(currentTreeSize, maxSize);
                        currentTreeSize = 0;
                    }
                }
            }
            // We add 1 to account for parent node count
            return 1 + Math.max(currentTreeSize, maxSize);
        }
    }

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
