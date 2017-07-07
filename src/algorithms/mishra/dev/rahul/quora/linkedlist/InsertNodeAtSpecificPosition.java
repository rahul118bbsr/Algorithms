/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 30-Jun-2017 7:10:33 PM
 *
 */
public class InsertNodeAtSpecificPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new InsertNodeAtSpecificPosition().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);

		head = list.insertNode(head, 100, 2);
		head = list.insertNode(head, 200, 0);
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

		public Node insertNode(Node head, int data, int position) {
			Node newNode = new Node(data);
			if (head == null && position == 0) {
				return newNode;
			}

			if (head == null) {
				return head;
			}

			if (position == 0) {
				newNode.next = head;
				return newNode;
			}

			Node curr = head;
			int index = 0;
			while (index + 1 != position && curr != null) {
				curr = curr.next;
				index++;
			}

			if (curr != null) {
				newNode.next = curr.next;
				curr.next = newNode;
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
