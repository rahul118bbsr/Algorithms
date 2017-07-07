/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 01-Jul-2017 9:54:17 AM
 *
 */
public class PrintReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new PrintReverseLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		list.add(head, 6);
		list.printInReverse(head);
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
		
		public void printInReverse(Node head) {
			if(head == null) {
				return;
			}
			printInReverse(head.next);
			System.out.print(head.data + " ");
		}
	}
	
	class Node {
		Node next;
		int data;
		Node(int data) {
			this.data = data;
		}
	}

}
