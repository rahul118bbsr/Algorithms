/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-May-2017 9:25:47 PM
 *
 */
public class PrintInReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new PrintInReverse().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
		linkedList.reversePrint(head);
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

		public void reversePrint(Node head) {
			if (head != null) {
				reversePrint(head.next);
				System.out.println(head.data);
			}
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
