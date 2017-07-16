package algorithms.mishra.dev.rahul.leetcode;

/**
 * Created by aleesha on 13/07/17.
 */
public class ReverseLinkedList {
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

        public Node reverse(Node head) {
            if(head == null) {
                return null;
            }

            Node curr = head;
            Node prev = null;
            while(curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    class Node {
        Node next;
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
