/**
 *
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=TIoCCStdiFo&index=16&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
 *
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 5:49:08 PM
 */
public class LowestCommonAncestor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree bt = new LowestCommonAncestor().new BinaryTree();
        bt.create();
    }

    class BinaryTree {

        public void create() {
//            Node root = new Node(10);
//            root.left = new Node(-10);
//            root.left.right = new Node(8);
//            Node node_6 = new Node(6);
//            root.left.right.left = node_6;
//            Node node_9 = new Node(9);
//            root.left.right.right = node_9;
//            Node node_30 = new Node(30);
//            root.right = node_30;
//            root.right.left = new Node(25);
//            Node node_28 = new Node(28);
//            root.right.left.right = node_28;
//            root.right.right = new Node(60);
//            Node node_78 = new Node(78);
//            root.right.right.right = node_78;
//            System.out.println(lowestCommonAncestor(root, node_28.data, node_78.data));
//            System.out.println(lowestCommonAncestor(root, node_6.data, node_9.data));
//            System.out.println(lowestCommonAncestor(root, node_30.data, node_78.data));
//            System.out.println(lowestCommonAncestor(root, -10, 78));
            Node root = new Node(2);
            root.left = new Node(1);
            System.out.println(lowestCommonAncestor(root, 2, 1));
        }

        /**
         * This is for any binary tree. BST is a special case of binary tree. So
         * this works for BSt as well
         * https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby
         *
         */
        public int lowestCommonAncestor(Node root, int data1, int data2) {
            if (root == null) {
                return -1;
            }
            List<Integer> list1 = tracePath(root, data1);
            List<Integer> list2 = tracePath(root, data2);
            if(list1 == null || list2 == null) {
                return -1;
            }
            int lcaIndex = -1;
            List<Integer> smallList = list1.size() <= list2.size() ? list1 : list2;
            for(int i = 0; i < smallList.size(); i++) {
                if(list1.get(i) == list2.get(i)) {
                    lcaIndex = i;
                }
            }
            return smallList.get(lcaIndex);
        }

        private List<Integer> tracePath(Node root, int data) {
            List<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            list.add(root.data);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (data == node.data) {
                    list.add(data);
                    return list;
                } else if (data < node.data && node.left != null) {
                    list.add(node.data);
                    stack.push(node.left);
                } else if(data > node.data && node.right != null) {
                    list.add(node.data);
                    stack.push(node.right);
                }
            }
            return null;
        }

        // https://discuss.leetcode.com/topic/18381/my-java-solution/2
        // A much better solution than above
        public Node lowestCommonAncestor(Node root, Node p, Node q) {
            while (true) {
                if (root.data > p.data && root.data > q.data)
                    root = root.left;
                else if (root.data < p.data && root.data < q.data)
                    root = root.right;
                else
                    return root;
            }
        }
    }

    class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

}
