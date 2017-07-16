package algorithms.mishra.dev.rahul.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Created by aleesha on 14/07/17.
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        System.out.println(new IntersectionOfTwoLinkedLists().new LinkedList().create());
    }

    class LinkedList {
        public int create() {
            Node head1 = new Node(1);
            head1.next = new Node(2);

            Node head2 = new Node(2);
            return getInterSectionNode(head1, head2).data;
        }
        public Node getInterSectionNode(Node head1, Node head2) {
            if(head1 == null || head2 == null) {
                return null;
            }
            Node curr1 = head1;
            Node curr2 = head2;
            int count = 0;
            while (count < 2) {
                if(curr1.data == curr2.data) {
                    return curr1;
                }

                curr1 = curr1.next == null ? head2 : curr1.next;
                curr2 = curr2.next == null ? head1 : curr2.next;
                count = curr1 == head2 ? count + 1 : count;
            }
            return  null;
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
