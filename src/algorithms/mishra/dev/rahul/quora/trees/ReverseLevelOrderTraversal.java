package algorithms.mishra.dev.rahul.quora.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=D2bIbWGgvzI&index=14&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
 *
 * Created by aleesha on 17/07/17.
 */
public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = new ReverseLevelOrderTraversal().new BinaryTree();
        binaryTree.performReverseLevelOrderTraversal(binaryTree.createTree());
    }

    class BinaryTree{
        public Node createTree() {
            Node root = new Node(10);
            root.left = new Node(20);
            root.left.left = new Node(40);
            root.left.right = new Node(50);
            root.left.right.left = new Node(70);
            root.left.right.right = new Node(80);
            root.right = new Node(30);
            root.right.right = new Node(60);
            root.right.right.left = new Node(90);
            return root;
        }

        public void performReverseLevelOrderTraversal(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                stack.add(node);
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
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


