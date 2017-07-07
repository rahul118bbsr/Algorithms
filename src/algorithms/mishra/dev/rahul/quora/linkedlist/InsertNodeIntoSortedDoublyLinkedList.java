/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 11:10:19 AM
 *
 */
public class InsertNodeIntoSortedDoublyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new InsertNodeIntoSortedDoublyLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		head = list.add(head, 2);
		head = list.add(head, 7);
		head = list.add(head, 10);
		head  = list.addInSortedOrder(head, 8);
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
			end.previous = curr;
			return head;
		}

		public Node addInSortedOrder(Node head, int data) {
			Node newNode = new Node(data);
			if (head == null) {
				return newNode;
			}

			Node curr = head;
			while (curr != null && curr.next != null) {
				if (curr.data <= data && data <= curr.next.data) {
					newNode.previous = curr;
					newNode.next = curr.next;
					curr.next = newNode;
					curr.next.previous = newNode;
					return head;
				}
				curr = curr.next;
			}

			if (curr != null && curr.next == null) {
				curr.next = newNode;
				newNode.previous = curr;
			}
			return head;
		}
	}

	class Node {
		Node previous;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
