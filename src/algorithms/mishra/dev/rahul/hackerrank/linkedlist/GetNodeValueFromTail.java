/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 25-May-2017 6:10:12 PM
 *
 */
public class GetNodeValueFromTail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new GetNodeValueFromTail().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		System.out.println(head);
		System.out.println("Enter the index (w.r.t Tail): ");
		System.out.println(linkedList.getNode(head, scanner.nextInt()));
		scanner.close();
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
		
		public int getNode(Node head,int n) {
			Node result = head;
			Node current = head;
			
			while(current != null && n - 1 >= 0) {
				current = current.next;
				n--;
			}
			
			while(current.next != null) {
				result = result.next;
				current = current.next;
			}
			
			return result.data;
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
