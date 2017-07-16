/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-May-2017 7:56:40 PM
 *
 */
public class DeleteNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements: ");
		LinkedList linkedList = new DeleteNode().new LinkedList();
		Node head = null;
		for (int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		System.out.println(head);
		System.out.println("Enter position number to delete: ");
		head = linkedList.delete(head, scanner.nextInt());
		System.out.println(head);
		scanner.close();
	}

	class LinkedList {

		public Node add(Node head, int value) {
			Node end = new Node(value);
			if (head == null) {
				head = end;
				return head;
			}

			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = end;
			return head;
		}

		public Node delete(Node head, int position) {
			if (position == 0) {
				return head.next;
			}
			
			int index = 0;
			Node curr = head;
			while(index++ != position - 1) {
				curr = curr.next;
			}
			
			curr.next = curr.next.next;
			return head;
		}
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
