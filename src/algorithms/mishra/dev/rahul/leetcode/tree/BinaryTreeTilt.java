package algorithms.mishra.dev.rahul.leetcode.tree;

/**
 * https://leetcode.com/problems/binary-tree-tilt
 * Created by aleesha on 14/07/17.
 */
public class BinaryTreeTilt {

    public static void main(String[] args) {

    }

    class BinaryTree {
        public Node create() {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            return root;
        }

        public int findTreeTilt(Node root) {
            if(root == null) {
                return 0;
            }
            return 0;
        }

        private int findSum(Node root) {
            if(root == null) {
                return 0;
            }
            return 0;
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
