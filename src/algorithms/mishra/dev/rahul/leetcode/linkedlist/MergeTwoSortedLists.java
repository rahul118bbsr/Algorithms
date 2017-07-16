package algorithms.mishra.dev.rahul.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * <p>
 * Created by aleesha on 14/07/17.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        LinkedList linkedList = new MergeTwoSortedLists().new LinkedList();
        Node root1 = linkedList.add(null, 2);
        Node root2 = linkedList.add(null, 1);
        Node mergeNode = linkedList.merge(root1, root2);
        System.out.println();
    }

    class LinkedList {
        public Node add(Node head, int data) {
            Node end = new Node(data);
            if (head == null) {
                return end;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
            return head;
        }

        public Node merge(Node head1, Node head2) {
            if (head1 == null && head2 == null) {
                return null;
            }
            if (head1 == null) {
                return head2;
            } else if (head2 == null) {
                return head1;
            }
            Node mergeNode = null;
            while (head1 != null || head2 != null) {
                // If head2 is null, then just keep appending head1 to the new linked list, else check which head is smaller
                if (head2 == null || (head1 != null && head1.data <= head2.data)) {
                    mergeNode = add(mergeNode, head1.data);
                    head1 = head1.next;
                } else if (head1 == null || (head2 != null && head2.data < head1.data)) {
                    mergeNode = add(mergeNode, head2.data);
                    head2 = head2.next;
                }
            }
            return mergeNode;
        }
    }

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
