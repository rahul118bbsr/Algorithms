package algorithms.mishra.dev.rahul.leetcode.tree;

/**
 * https://leetcode.com/problems/merge-two-binary-trees
 * <p>
 * Created by aleesha on 13/07/17.
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        BinaryTree binaryTree = new MergeTwoBinaryTrees().new BinaryTree();
        Node mergedNode = binaryTree.createTreesAndMerge();
        System.out.println();
    }

    class BinaryTree {
        public Node createTreesAndMerge() {
            Node root1 = new Node(1);
            root1.left = new Node(3);
            root1.left.left = new Node(5);
            root1.right = new Node(2);

            Node root2 = new Node(2);
            root2.left = new Node(1);
            root2.left.right = new Node(4);
            root2.right = new Node(3);
            root2.right.right = new Node(7);

            Node mergedNode = null;
            return merge(root1, root2);
        }

        public Node merge(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            int val = (root1 == null ? 0 : root1.data) + (root2 == null ? 0 : root2.data);
            Node mergeNode = new Node(val);
            mergeNode.left = merge(root1.left, root2.left);
            mergeNode.right = merge(root1.right, root2.right);
            return mergeNode;
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
