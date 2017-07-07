/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 30-Jun-2017 6:57:51 PM
 *
 */
public class InsertNodeAtHeadOfLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new InsertNodeAtHeadOfLinkedList().new LinkedList();
		Node head = list.add(null, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		
		head = list.addNodeAtHead(head, 1);
		head = list.addNodeAtHead(head, 0);
		
		Node head1 = list.addNodeAtHead(null, 10);
		System.out.println(head1);
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
		
		public Node addNodeAtHead(Node head, int value) {
			Node start = new Node(value);
			if(head == null) {
				return start;
			}
			
			start.next = head;
			return start;
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
