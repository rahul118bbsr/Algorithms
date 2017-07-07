/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 30-Jun-2017 10:11:21 PM
 *
 */
public class DeleteDuplicateNodesInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new DeleteDuplicateNodesInLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 1);
		list.add(head, 1);
		list.add(head, 1);
		list.add(head, 3);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		list.add(head, 5);
		list.add(head, 6);
		list.add(head, 6);
		head = list.deleteDuplicateNodes(head);
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

		public Node deleteDuplicateNodes(Node head) {
			if (head == null) {
				return head;
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
	}

}
