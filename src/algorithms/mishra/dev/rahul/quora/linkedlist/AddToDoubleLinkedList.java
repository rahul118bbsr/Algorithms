/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 24-Jun-2017 10:18:53 AM
 *
 */
public class AddToDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList ll = new AddToDoubleLinkedList().new LinkedList();
		Node head = ll.add(null, 1);
		head = ll.add(head, 2);
		head = ll.add(head, 3);
		head = ll.add(head, 4);
		head = ll.add(head, 5);
		head = ll.add(head, 6);
		
		System.out.println("");

	}
	
	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if(head == null) {
				return end;
			}
			
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = end;
			end.prev = current;
			return head;
		}
	}
	
	
	class Node {
		Node prev;
		Node next;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}

}
