/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-May-2017 4:21:32 PM
 *
 */
public class InsertNodeInSortedDoubledLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new InsertNodeInSortedDoubledLinkedList().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements in sorted order: ");
		for(int i = 0; i <= n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		System.out.println(head);
		System.out.println("Enter the element to insert: ");
		System.out.println(linkedList.sortedInsert(head, scanner.nextInt()));
		scanner.close();
	}
	
	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if(head == null) {
				return new Node();
			}
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = end;
			end.prev = curr;
			return head;
		}
		
		public Node sortedInsert(Node head, int data) {
			if(head == null) {
				return head;
			}
			
			Node newNode = new Node();
			newNode.data = data;
			Node curr = head.next;
			Node prev = head;
			while(curr != null) {
				if(prev.data <= data && data < curr.data) {
					prev.next = newNode;
					newNode.next = curr;
					newNode.prev = prev;
					curr.prev = newNode;
					return head;
				}
				prev = curr;
				curr = curr.next;
			}
			
			if(curr == null) {
				prev.next = newNode;
				newNode.prev = prev;
			}
			return head;
		}
	}
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
		
		public Node() {
		}

		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
