/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 30-Jun-2017 7:52:07 PM
 *
 */
public class MergeTwoSortedSingleLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new MergeTwoSortedSingleLinkedLists().new LinkedList();
		Node head1 = list.add(null, 15);
		// list.add(head1, 3);
		// list.add(head1, 5);
		// list.add(head1, 6);

		Node head2 = list.add(null, 12);
		// list.add(head2, 4);
		// list.add(head2, 7);
		list.merge(head1, head2);
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
			}

			if (head2 == null) {
				return head1;
			}

			Node curr1 = head1;
			Node curr2 = head2;
			Node merge = null;
			while (curr1 != null || curr2 != null) {
				if (curr2 == null || (curr1 != null && curr1.data <= curr2.data)) {
					merge = add(merge, curr1.data);
					curr1 = curr1.next;
				} else if (curr1 == null || (curr2 != null && curr2.data <= curr1.data)) {
					merge = add(merge, curr2.data);
					curr2 = curr2.next;
				}
			}
			return merge;
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
