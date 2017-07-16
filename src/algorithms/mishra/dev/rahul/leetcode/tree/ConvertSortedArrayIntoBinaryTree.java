package algorithms.mishra.dev.rahul.leetcode.tree;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Created by aleesha on 14/07/17.
 */
public class ConvertSortedArrayIntoBinaryTree {
    public static void main(String[] args) {

    }

    class BinaryTree {
        public Node convertArrayIntoBinarySearchTree(int[] array) {
            return convertUtil(array,0, array.length - 1);
        }

        private Node convertUtil(int[] array, int low, int high) {
            if(low > high) {
                return null;
            }

            int mid = (low + high) / 2;
            Node node = new Node(array[mid]);
            node.left = convertUtil(array, low, mid - 1);
            node.right = convertUtil(array, mid + 1, high);
            return node;
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
