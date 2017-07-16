package algorithms.mishra.dev.rahul.leetcode.linkedlist;

import java.util.Stack;

/**
 * Created by aleesha on 14/07/17.
 */
public class AddTwoNumbers {

    class LinkedList {
        public Node add(Node head1, Node head2) {
            if(head1 == null && head2 == null) {
                return null;
            } else if(head1 == null) {
                return head2;
            } else if(head2 == null) {
                return head1;
            }
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while(head1 != null) {
                stack1.push(head1.data);
                head1 = head1.next;
            }
            while(head2 != null) {
                stack2.push(head2.data);
                head2 = head2.next;
            }
            Node addNode = new Node(0);
//            while(stack1 )
            return null;
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
