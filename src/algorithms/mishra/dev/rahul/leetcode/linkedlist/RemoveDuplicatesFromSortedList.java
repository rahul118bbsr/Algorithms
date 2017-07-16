package algorithms.mishra.dev.rahul.leetcode.linkedlist;

/**
 * Created by aleesha on 14/07/17.
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        LinkedList linkedList = new RemoveDuplicatesFromSortedList().new LinkedList();
        Node head = linkedList.add(null, 1);
        linkedList.add(head, 1);
        linkedList.add(head, 1);
        linkedList.add(head, 1);
        linkedList.add(head, 1);
        linkedList.add(head, 2);
        linkedList.add(head, 3);
        linkedList.add(head, 3);
        linkedList.add(head, 3);
        linkedList.add(head, 5);
        linkedList.add(head, 5);
        head = linkedList.removeDuplicates(head);
        System.out.println(head);
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

        public Node removeDuplicates(Node head) {
            if (head == null) {
                return null;
            }
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data == curr.next.data) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
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
            return data + "";
        }
    }
}
