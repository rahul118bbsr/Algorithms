/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-May-2017 9:53:31 PM
 *
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new ReverseLinkedList().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
		head = linkedList.reverse(head);
		System.out.println(head);
	}

	class LinkedList {
		public Node add(Node head, int value) {
			Node end = new Node(value);
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

		public Node reverse(Node head) {
			if (head == null) {
				return null;
			}

			if (head.next == null) {
				return head;
			}

			Node preNode = null;
			Node currNode = head;
			Node nextNode = null;

			while (currNode != null) {
				nextNode = currNode.next;
				currNode.next = preNode;
				preNode = currNode;
				currNode = nextNode;
			}

			head = preNode;
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
