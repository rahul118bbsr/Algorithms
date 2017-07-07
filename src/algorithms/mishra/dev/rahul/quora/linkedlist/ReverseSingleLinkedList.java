/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 30-Jun-2017 2:57:49 PM
 *
 */
public class ReverseSingleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new ReverseSingleLinkedList().new LinkedList();
		Node head = list.add(null, 1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		head = list.reverse(head);
		System.out.println();
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
			if(head == null) {
				return head;
			}
			
			Node curr = head;
			Node prev = null;
			while(curr != null) {
				Node node = curr;
				curr = node.next;
				node.next = prev;
				prev = node;
			}
			return prev;
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
