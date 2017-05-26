/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 24-May-2017 8:40:13 AM
 *
 */
public class CompareTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// For linked list A
		System.out.println("Enter the number of elements for Linked List A: ");
		int nA = scanner.nextInt();
		System.out.println("Enter the elements for A: ");
		LinkedList linkedList = new CompareTwoLinkedLists().new LinkedList();
		Node headA = null;
		for (int i = 0; i < nA; i++) {
			headA = linkedList.add(headA, scanner.nextInt());
		}

		// For linked list B
		System.out.println("Enter the number of elements for Linked List B: ");
		int nB = scanner.nextInt();
		System.out.println("Enter the elements for B: ");
		Node headB = null;
		for (int i = 0; i < nB; i++) {
			headB = linkedList.add(headB, scanner.nextInt());
		}
		scanner.close();
		System.out.println(linkedList.compareTwoLinkedLists(headA, headB));
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

		public int compareTwoLinkedLists(Node headA, Node headB) {
			if (headA == null && headB == null) {
				return 1;
			}

			if (headA == null || headB == null) {
				return 0;
			}

			if (headA.data == headB.data) {
				return compareTwoLinkedLists(headA.next, headB.next);
			}
			return 0;
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
