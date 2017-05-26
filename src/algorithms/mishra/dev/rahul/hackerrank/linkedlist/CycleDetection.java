/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-May-2017 12:04:22 PM
 *
 */
public class CycleDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		LinkedList linkedList = new CycleDetection().new LinkedList();
		Node head = null;
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++) {
			head = linkedList.add(head, scanner.nextInt());
		}
		scanner.close();
		System.out.println(head);
		head = linkedList.addCycle(head);
		System.out.println(linkedList.hasCycle(head));

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
		
		private Node addCycle(Node head) {
			Node cyclePoint = null;
			Node curr = head;
			while(curr.next != null) {
				cyclePoint = curr.data == 2 ? curr : cyclePoint; 
				curr = curr.next;
			}
			
			cyclePoint = curr.data == 2 ? curr : cyclePoint; 
			curr.next = cyclePoint;
			return head;
		}
		
		public boolean hasCycle(Node head) {
			Node slowNode = head;
			Node fastNode = head;
			
			while(fastNode != null && fastNode.next != null) {
				slowNode = slowNode.next;
				fastNode = fastNode.next.next;
				
				if(slowNode == fastNode) {
					return true;
				}
			}
			return false;
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
