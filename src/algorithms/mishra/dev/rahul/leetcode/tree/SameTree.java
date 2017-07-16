package algorithms.mishra.dev.rahul.leetcode.tree;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * Created by aleesha on 14/07/17.
 */
public class SameTree {

    class BinaryTree {
        public Node create() {
            Node root = new Node(1);

            return root;
        }

        public boolean checkSameTree(Node root1, Node root2) {
            if(root1 == null && root2 == null) {
                return true;
            }
            if(root1 == null || root2 == null) {
                return false;
            }

            if(root1.data == root2.data) {
                return checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right);
            }
            return false;
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
