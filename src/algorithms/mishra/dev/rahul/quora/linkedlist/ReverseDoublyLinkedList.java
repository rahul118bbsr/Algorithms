/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 11:33:06 AM
 *
 */
public class ReverseDoublyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new ReverseDoublyLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		list.reversePrint(head);
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
			end.prev = curr;
			return head;
		}

		public Node reverseLinkedList(Node head) {
			if (head == null) {
				return null;
			}
			while (head.next != null) {
				Node i = head.prev;
				head.prev = head.next;
				head.next = i;
				if (head.prev == null) {
					return head;
				}
				head = head.prev;
			}
			return head;
		}

		public void reversePrint(Node head) {
			if (head == null) {
				return;
			}
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.prev;
			}
		}
	}

	class Node {
		Node prev;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
