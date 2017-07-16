package algorithms.mishra.dev.rahul.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Created by aleesha on 13/07/17.
 */
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new AverageOfLevelsInBinaryTree().new BinaryTree();
        Node root = binaryTree.createTree();
        System.out.println(binaryTree.findAveragePerLevel(root));
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

        public List<Double> findAveragePerLevel(Node root) {
            List<Double> list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                double sum = 0.0f;
                for(int i = 0; i < n; i++) {
                    Node node = queue.poll();
                    sum += node.data;
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
                list.add(sum / n);
            }
            return list;
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


