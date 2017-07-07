/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 10:22:17 AM
 *
 */
public class FindMergePointOfTwoSingleLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new FindMergePointOfTwoSingleLinkedLists().new LinkedList();
		Node mergeNode = list.create();
		System.out.println(mergeNode);
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
			return end;
		}
		
		public Node create() {
			Node head1 = new Node(1);
			head1.next = new Node(2);
			head1.next.next = new Node(3);
			head1.next.next.next = new Node(4);
			head1.next.next.next.next = new Node(5);
			Node mergeNode = new Node(6);
			head1.next.next.next.next.next = mergeNode;
			
			Node head2 = new Node(11);
			head2.next = new Node(12);
			head2.next.next = mergeNode;
//			head2.next.next.next = new Node(15);
			
			return findMergeNode(head1, head2);
		}

		public Node findMergeNode(Node head1, Node head2) {
			if (head1 == null && head2 == null) {
				return null;
			}
			if (head1 == null) {
				return null;
			}
			if (head2 == null) {
				return null;
			}

			Node curr1 = head1;
			Node curr2 = head2;

			int count = 0;
			while (count < 2) {
				if (curr1 == curr2) {
					return curr1;
				}

				curr1 = curr1.next == null ? head2 : curr1.next;
				curr2 = curr2.next == null ? head1 : curr2.next;
				count = curr1 == head2 ? count + 1 : count;
			}
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
