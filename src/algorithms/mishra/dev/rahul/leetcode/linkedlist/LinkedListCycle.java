package algorithms.mishra.dev.rahul.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Created by aleesha on 14/07/17.
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    class LinkedList {
        public boolean hasCycle(Node head) {
            if(head == null) {
                return false;
            }
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null) {
                if(slow.data == fast.data) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
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
