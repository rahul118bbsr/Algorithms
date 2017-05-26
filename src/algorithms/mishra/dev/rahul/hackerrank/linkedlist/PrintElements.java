/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-May-2017 9:52:01 AM
 *
 */
public class PrintElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int noOfNodes = scanner.nextInt();
		PrintElements pe = new PrintElements();
		MyLinkedList linkedList = pe.new MyLinkedList();
		System.out.println("Enter elements: ");
		for (int i = 0; i < noOfNodes; i++) {
			linkedList.add(scanner.nextInt());
		}
		scanner.close();
		print(linkedList.getHead());
	}

	private static void print(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public class MyLinkedList {
		private Node head;

		public void add(int value) {
			Node end = new Node(value);
			if (head == null) {
				head = end;
				return;
			}

			Node current = head;
			while (current.next != null) {
				current = current.next;
			}

			current.next = end;
		}

		@Override
		public String toString() {
			return head.toString();
		}

		public Node getHead() {
			return head;
		}
	}

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		@Override
		public String toString() {
			return data + " --> " + next;
		}
	}
}


