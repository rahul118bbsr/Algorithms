/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 24-May-2017 6:44:44 PM
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements for A: ");
		int nA = scanner.nextInt();
		LinkedList linkedList = new MergeTwoSortedLists().new LinkedList();
		Node headA = null;
		System.out.println("Enter the elements for A: ");
		for (int i = 0; i < nA; i++) {
			headA = linkedList.add(headA, scanner.nextInt());
		}

		System.out.println("Enter number of elements for B: ");
		int nB = scanner.nextInt();
		Node headB = null;
		System.out.println("Enter the elements for B: ");
		for (int i = 0; i < nB; i++) {
			headB = linkedList.add(headB, scanner.nextInt());
		}
		scanner.close();
		System.out.println("A: " + headA);
		System.out.println("B: " + headB);
		Node merge = linkedList.mergeLists(headA, headB);
		System.out.println("Merged: " + merge);
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

		public Node mergeLists(Node headA, Node headB) {
			Node merge = null;

			// If we have reached the end, then stop.
			while (headA != null || headB != null) {
				// if B is null then keep appending A, else check if value of A is lesser or equal than B
				if (headB == null || (headA != null && headA.data <= headB.data)) {
					// Add the new node, handle addition separately in a new method.
					merge = add(merge, headA.data);
					// Since A is <= B, Move head of A to next node
					headA = headA.next;
				// if A is null then keep appending B, else check if value of B is lesser than A
				} else if (headA == null || (headB != null && headB.data < headA.data)) {
					// Add the new node, handle addition separately in a new method.
					merge = add(merge, headB.data);
					// Since B is < A, Move head of B to next node
					headB = headB.next;
				}
			}
			return merge;
		}

		Node MergeLists(Node a, Node b) {
			if (a == null) {
				return b;
			} else if (b == null) {
				return a;
			}

			if (a.data < b.data) {
				a.next = MergeLists(a.next, b);
				return a;
			} else {
				b.next = MergeLists(a, b.next);
				return b;
			}
		}
	}

	class Node {
		int data;
		Node next;

		Node() {
		}

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "->" + next;
		}
	}

}
