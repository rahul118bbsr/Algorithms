/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-May-2017 6:09:52 PM
 *
 */
public class InsertNodeAtHead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements: ");
		LinkedList linkedList = new InsertNodeAtHead().new LinkedList();
		Node head = null;
		for(int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
	}
	
	class LinkedList {
		
		public Node add(Node head, int x) {
			Node first = new Node();
			first.data = x;
			first.next = head;
			return first;
		}
	}
	
	class Node {
		int data;
		Node next;
		
		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
