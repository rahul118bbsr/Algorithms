/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-May-2017 5:03:19 PM
 *
 */
public class ReverseDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new ReverseDoubleLinkedList().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
		System.out.println(linkedList.reverse(head));

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
		
		public Node reverse(Node head) {
			if (head == null){
		        return null;
		    }
		    while(head != null){
		        Node temp = head.next;
		        head.next = head.prev;
		        head.prev = temp;
		        if (head.prev == null){
		            return head;
		        }
		        head = head.prev;
		    }
			return head;
		}
	}
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		Node(){}
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
