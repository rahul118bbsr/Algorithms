/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 30-Jun-2017 2:22:03 PM
 *
 */
public class DeleteElementInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new DeleteElementInLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 5);
		list.add(head, 7);
		list.add(head, 11);
		list.add(head, 13);
		list.add(head, 17);

		head = list.delete(head, 11);
		head = list.delete(head, 1);
		head = list.delete(head, 17);
		head = list.delete(head, 17);
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

		public Node delete(Node head, int value) {
			if (head == null) {
				return head;
			}
			
			if(head.data == value) {
				System.out.println("Deleting the head node with value: " + value);
				return head.next;
			}

			Node curr = head;
			while (curr.next != null) {
				if (curr.next.data == value) {
					curr.next = curr.next.next;
					System.out.println("Deleting the node with value: " + value);
					return head;
				}
				curr = curr.next;
			}
			System.out.println("Data " + value + " couldn't be found to delete.");
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
