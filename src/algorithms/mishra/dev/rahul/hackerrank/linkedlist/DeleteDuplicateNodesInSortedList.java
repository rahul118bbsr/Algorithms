/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 26-May-2017 10:37:46 AM
 *
 */
public class DeleteDuplicateNodesInSortedList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new DeleteDuplicateNodesInSortedList().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
		System.out.println(linkedList.removeDuplicates(head));
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

		public Node removeDuplicates(Node head) {
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
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
