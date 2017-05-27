/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-May-2017 10:47:23 AM
 *
 */
public class InsertNodeAtTail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		InsertNodeAtTail insertNodeAtTail = new InsertNodeAtTail();
		LinkedList linkedList = insertNodeAtTail.new LinkedList();
		System.out.println("Enter the elements: ");
		Node head = null;
		for(int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
	}

	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if(head == null) {
				return end;
			}
			
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = end;
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