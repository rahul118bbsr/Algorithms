package algorithms.mishra.dev.rahul.leetcode.tree;


import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree
 *
 * Created by aleesha on 14/07/17.
 */
public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new ConstructStringFromBinaryTree().new BinaryTree();
        System.out.println(binaryTree.convertTreeToString(binaryTree.createTree()));
    }

    class BinaryTree {
        public Node createTree() {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.right = new Node(4);
            root.right = new Node(3);
            return root;
        }

        // My Solution doesn' work
        public String convertTreeToString(Node root) {
            if (root == null) {
                return "";
            }
            String result = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if(node == root) {
                    result = result + node.data;
                } else if(node.left == null && node.right == null) {
                    result = result + "(" + node.data + ")";
                } else {
                    result = result + "(" + node.data;
                }

                if (node.right == null) {
                    result = result + ")";
                } else {
                    stack.push(node.right);
                }
                if (node.left == null) {
                    result = result + "()";
                } else {
                    stack.push(node.left);
                }
            }
            return result;
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
