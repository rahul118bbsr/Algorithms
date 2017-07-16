package algorithms.mishra.dev.rahul.leetcode.linkedlist;

/**
 * Created by aleesha on 14/07/17.
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    class LinkedList {
        public Node add(Node head, int data) {
            Node end = new Node(data);
            if(head == null) {
                return end;
            }

            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
            return head;
        }

        public Node deleteNode(Node head, Node targetNode) {
            if(head == null || targetNode == null) {
                return head;
            }
            Node curr = head;
            while(curr.next != targetNode) {
                curr = curr.next;
            }
            curr.next = targetNode.next;
            return head;
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
