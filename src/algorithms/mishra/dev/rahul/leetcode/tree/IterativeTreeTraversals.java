package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.Stack;

/**
 * Created by aleesha on 14/07/17.
 */
public class IterativeTreeTraversals {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new IterativeTreeTraversals().new BinarySearchTree();
        Node root = binarySearchTree.add(null, 5);
        binarySearchTree.add(root, 3);
        binarySearchTree.add(root, 9);
        binarySearchTree.add(root, 1);
        binarySearchTree.add(root, 4);
        binarySearchTree.add(root, 6);
        binarySearchTree.add(root, 10);
        binarySearchTree.add(root, 0);
        binarySearchTree.add(root, 2);
        System.out.println("Pre Order: ");
        binarySearchTree.preOrder(root);
        System.out.println();
        System.out.println("In Order: ");
        binarySearchTree.inOrder(root);
        System.out.println();
        System.out.println("Post Order: ");
        binarySearchTree.postOrder(root);
    }


    class BinarySearchTree {
        public Node add(Node root, int data) {
            Node end = new Node(data);
            if(root == null) {
                return end;
            }
            if(data <= root.data) {
                root.left = add(root.left, data);
            } else {
                root.right = add(root.right, data);
            }
            return root;
        }

        public void preOrder(Node root) {
            if(root == null) {
                return;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.data + " ");
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        public void inOrder(Node root) {
            if(root == null) {
                return;
            }
            Stack<Node> stack = new Stack<>();
            Node current = root;
            while(!stack.isEmpty() || current != null) {
                if(current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }

        public void postOrder(Node root) {
            if(root == null) {
                return;
            }
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while(!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.push(node);
                if(node.left != null) {
                    stack1.push(node.left);
                }
                if(node.right != null) {
                    stack1.push(node.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop() + " ");
            }
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
            return "" + data;
        }
    }
}
